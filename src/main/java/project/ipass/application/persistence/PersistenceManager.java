package project.ipass.application.persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import project.ipass.application.model.Calendar;

import java.io.*;

public class PersistenceManager {
    private final static String ENDPOINT = "https://ipassappblobstorage.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2019-10-10&ss=b&srt=sco&sp=rwdlacx&se=2020-12-31T19:29:29Z&st=2020-06-23T10:30:00Z&spr=https&sig=XWfDITOeFCNKVmFqkVMxhp%2B4VWaTpWkYrCBiX4KD%2B%2F4%3D";
    private final static String CONTAINER = "applicationcontainer";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();

    public static void saveApplicationToAzure() throws IOException {
        if (!blobContainer.exists()){
            blobContainer.create();
        }
        BlobClient blob = blobContainer.getBlobClient("application_blob");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(Calendar.getTheCalendar());

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blob.upload(bais, bytez.length, true);

        baos.close();
        oos.close();
        bais.close();
    }

    public static void loadApplicationFromAzure() throws IOException, ClassNotFoundException {
        if (blobContainer.exists()) {
            BlobClient blob = blobContainer.getBlobClient("application_blob");
            if (blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);

                byte[] bytez = baos.toByteArray();

                ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
                ObjectInputStream ois = new ObjectInputStream(bais);

                Object obj = ois.readObject();
                if (obj instanceof Calendar){
                    Calendar loadC = (Calendar) obj;
                    Calendar.setTheCalendar(loadC);
                }
                baos.close();
                bais.close();
                ois.close();
            }

        }
    }
}
