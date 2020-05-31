package project.ipass.application.model;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class User implements Principal {
    private static List<User> allUsers = new ArrayList<>();
    private static int userId = 0;
    private static String firstName;
    private String lastName;
    private String username;
    private String plainpassword;
    private String role;


    public User(String firstName, String lastName, String username, String password){
        userId = userId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.plainpassword = password;
        role = "user";

        if (!allUsers.contains(this)){
            allUsers.add(this);
        }

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
    public static User getUserByName(String uname){
        return allUsers.stream()
                .filter(e -> e.username.equals(uname)) // als de username gelijk is aan de username die binnen komt
                .findFirst() // dan wil ik dat je het vind
                .orElse(null); //anders return null
    }

    public static String validateLogin(String username, String password){
        User found = getUserByName(username);
        if (found!=null){
            return password.equals(found.plainpassword) ? found.getRole() : null;
        }
        return null;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return plainpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.plainpassword = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

