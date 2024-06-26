package com.spittr.model;

import java.util.List;

public class Spitter {


    private int id;

    // Variable to store the username of the Spitter
    private String username;

    // Variable to store the password of the Spitter
    private String password;


    private String fullName;

    private List<Spittle> spittles;

    public Spitter() {
    }

    public Spitter(int id, String username, String password, String fullName, List<Spittle> spittles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.spittles = spittles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(List<Spittle> spittles) {
        this.spittles = spittles;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Spitter{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", spittles=").append(spittles);
        sb.append('}');
        return sb.toString();
    }
}
