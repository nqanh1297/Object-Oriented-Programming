package com.bidfabric.model;

import java.time.LocalDateTime;

public class Art extends Item{
    public Art(String name, String description, double startingPrice, LocalDateTime endTime) {
        super(name, description, startingPrice, endTime);
    }

}
