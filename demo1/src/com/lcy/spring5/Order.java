package com.lcy.spring5;

public class Order {
    private String id;
    private Double price;
    private  String address;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order(String id, Double price) {
        this.id = id;
        this.price = price;
    }

    public Order() {
    }
}
