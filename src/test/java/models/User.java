package models;

import java.util.Random;

public class User {

    private String userName;
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User() {
        this.userName = "userTest" + new Random().nextInt(10000);
        this.email =userName + "@mail.com";
        this.password = "qwerty12345";
    }



}
