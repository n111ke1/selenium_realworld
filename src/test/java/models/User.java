package models;

import java.util.Random;

public class User {


    private String username;
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User () {
        this.username = "userTest" + new Random().nextInt(10000);
        this.email = username + "@mail.com";
        this.password = "qwerty12345";
    }
    public User defaultUser() {
        return new User("niktest","niktest@email.com","qwerty12345");
    }



}
