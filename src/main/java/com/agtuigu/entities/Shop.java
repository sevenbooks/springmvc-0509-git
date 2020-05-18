package com.agtuigu.entities;

import org.springframework.stereotype.Component;

@Component
public class Shop {
    private String name;
    private String[] stuffName;

//    public Shop(String name, String[] stuffName) {
//        this.name = name;
//        this.stuffName = stuffName;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getStuffName() {
        return stuffName;
    }

    public void setStuffName(String[] stuffName) {
        this.stuffName = stuffName;
    }
}
