package project.ipass.application.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void testClient(){
        Client client1 = new Client(2,"Ellen","Elis","ee209","1235");
        String name = client1.getFirstName();

        assertEquals("Ella", name);
    }

}