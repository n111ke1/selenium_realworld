package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class User {

    private long id;

    private String token;
    private String bio;
    private String username;
    private String email;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private String image;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

//    public User () {
//        this.username = "userTest" + new Random().nextInt(10000);
//        this.email = username + "@mail.com";
//        this.password = "qwerty12345";
//    }
//    public User defaultUser() {
//        return new User("niktest","niktest@email.com","qwerty12345");
//    }



}
