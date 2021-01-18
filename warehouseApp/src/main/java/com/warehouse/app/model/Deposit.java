package com.warehouse.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int deposits_id;

    private int item_id;
    private int quantity;

    public Deposit() {

    }

    public Deposit(int deposits_id, int item_id, int quantity) {
        this.deposits_id = deposits_id;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public int getDeposit_id() {
        return deposits_id;
    }

    public void setDeposit_id(int deposits_id) {
        this.deposits_id = deposits_id;
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
        return "Deposit{" +
                "deposits_id=" + deposits_id +
                ", item_id=" + item_id +
                ", quantity=" + quantity +
                '}';
    }
}
