package com.loftblog.moneytracker;

/**
 * Created by macbook on 02.11.17.
 */

public class Item {


    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName() {
        this.name = name;
    }

    public void setPrice() {
        this.price = price;
    }

}
