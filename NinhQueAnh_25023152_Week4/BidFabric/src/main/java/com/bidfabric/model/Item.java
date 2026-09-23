package com.bidfabric.model;

import java.time.LocalDateTime;

public class Item extends Entity {
    private String name;
    private String description;
    private double startingPrice;
    private double currentPrice;
    private String highestBidderId;
    private LocalDateTime endTime;
    private boolean isActive;

    public Item(String name, String description, double startingPrice, LocalDateTime endTime) {
        super();
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentPrice = startingPrice;
        this.endTime = endTime;
        this.isActive = true;
    }


    public String getName() { return name; }
    public double getCurrentPrice() { return currentPrice; }
    public void setCurrentPrice(double currentPrice) { this.currentPrice = currentPrice; }
    public String getHighestBidderId() { return highestBidderId; }
    public void setHighestBidderId(String highestBidderId) { this.highestBidderId = highestBidderId; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public LocalDateTime getEndTime() { return endTime; }
}