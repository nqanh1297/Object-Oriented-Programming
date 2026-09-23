package com.bidfabric.model;

import java.time.LocalDateTime;

public class Electronics extends Item{
    public Electronics(String name, String description, double startingPrice, LocalDateTime endTime) {
        super(name, description, startingPrice, endTime);
    }
}
