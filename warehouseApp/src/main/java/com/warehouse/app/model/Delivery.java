package com.warehouse.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int delivery_id;

    private String address;
    private int item_id;
    private int quantity;

    public Delivery() {
    }

    public Delivery(int delivery_id, String address, int item_id, int quantity) {
        this.delivery_id = delivery_id;
        this.address = address;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "delivery_id=" + delivery_id +
                ", address='" + address + '\'' +
                ", item_id=" + item_id +
                ", quantity=" + quantity +
                '}';
    }
}
