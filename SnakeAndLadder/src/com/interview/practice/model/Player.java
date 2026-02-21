package com.interview.practice.model;

import java.util.UUID;

public class Player {

    private String name;
    private String id;
    private int position;

    Player(String name,String id,String position){
       this.name = name;
       this.id = UUID.randomUUID().toString();
       this.position = 0;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
