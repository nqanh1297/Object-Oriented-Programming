package com.bidfabric.model;

public abstract class User extends Entity{
    private String username;
    private String password;
    private String fullName;

    public User(String username, String password, String fullName) {
        super();
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public abstract String getRole();
}
