package project.ipass.application.model;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User implements Principal {
    private static List<User> allUsers = new ArrayList<>();
    private static int nrUser = 1;
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String plainpassword;
    private String role;


    public User(String firstName, String lastName, String username, String password){
        userId = nrUser++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.plainpassword = password;
        role = "user";

        if (!allUsers.contains(this)){
            allUsers.add(this);
        }
    }

    public static String validateLogin(String username, String password){
        User found = getUserByName(username);
        if (found!=null){
            return password.equals(found.plainpassword) ? found.getRole() : null;
        }
        return null;
    }

    // getters
    public static User getUser(int userId){
        return allUsers.stream()
                .filter(e -> e.userId == userId)
                .findFirst()
                .orElse(null);
    }
    public static User getUserByName(String uname){
        return allUsers.stream()
                .filter(e -> e.username.equals(uname)) // als de username gelijk is aan de username die binnen komt
                .findFirst() // dan wil ik dat je het vind
                .orElse(null); //anders return null
    }

    public static List<User> getAllUsers(){
        return Collections.unmodifiableList(allUsers);
    }
    @Override
    public String getName() {
        return username;
    }

    public String getRole() {
        return role;
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

    // setters
    public void setAdmin(){
        role = "admin";
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

