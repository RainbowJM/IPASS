package project.ipass.application.security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class MyUser implements Principal {
    private static List<MyUser> allMyUsers = new ArrayList<>();
    private String username;
    private String plainpassword;
    private String role;

    public MyUser(String name, String ppwd){
        username = name;
        plainpassword = ppwd;
        role = "user";
        if (!allMyUsers.contains(this)) allMyUsers.add(this);
    }

    public void setAdmin(){
        role = "admin";
    }

    @Override
    public String getName() {
        return username;
    }

    public String getRole() {
        return role;
    }
    public static MyUser getUserByName(String uname){
        return allMyUsers.stream()
                .filter(e -> e.username.equals(uname)) // als de username gelijk is aan de username die binnen komt
                .findFirst() // dan wil ik dat je het vind
                .orElse(null); //anders return null
    }

    public static String validateLogin(String username, String password){
        MyUser found = getUserByName(username);
        if (found!=null){
            return password.equals(found.plainpassword) ? found.getRole() : null;
        }
        return null;
    }
}
