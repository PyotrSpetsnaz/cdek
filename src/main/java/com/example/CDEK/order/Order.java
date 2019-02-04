package com.example.CDEK.order;

public class Order {

    private int id;
    private String time;


    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public Order(int id, String time) {
       this.id = id;
       this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
