package com.warehouse.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int item_id;

    private String typeName;
    private String description;

    public Item() {

    }

    public Item(int item_id, String typeName, String description) {
        this.item_id = item_id;
        this.typeName = typeName;
        this.description = description;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", typeName='" + typeName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
