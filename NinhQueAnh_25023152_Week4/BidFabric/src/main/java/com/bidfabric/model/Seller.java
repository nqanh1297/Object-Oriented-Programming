package com.bidfabric.model;

public class Seller extends User{
    public Seller(String username, String password, String fullName) {
        super(username, password, fullName);
    }

    public String getRole() {return "SELLER";}
}
