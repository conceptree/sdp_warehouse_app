package com.warehouse.app.controllers;

import com.warehouse.app.dao.DeliveryDaoImp;
import com.warehouse.app.dao.DepositDaoImp;
import com.warehouse.app.dao.ItemDaoImp;
import com.warehouse.app.model.Delivery;
import com.warehouse.app.model.Deposit;
import com.warehouse.app.model.Item;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private DeliveryDaoImp deliveryDaoImp;
    private DepositDaoImp depositDaoImp;
    private ItemDaoImp itemDaoImp;

    public MainController(ItemDaoImp itemDaoImp, DepositDaoImp depositDaoImp, DeliveryDaoImp deliveryDaoImp) {
        this.deliveryDaoImp = deliveryDaoImp;
        this.itemDaoImp = itemDaoImp;
        this.depositDaoImp = depositDaoImp;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/items")
    public List<Item> getItems() {
        return this.itemDaoImp.getAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/deposits")
    public List<Deposit> getDeposits() {
        return this.depositDaoImp.getAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/deliveries")
    public List<Delivery> getDeliveries() {
        return this.deliveryDaoImp.getAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/items")
    public void createItem(@RequestBody Item item) {
        this.itemDaoImp.create(item);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/deposits")
    public void createDeposit(@RequestBody Deposit deposit) {
        this.depositDaoImp.create(deposit);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/deliveries")
    public void createDelivery(@RequestBody Delivery delivery) {
        this.deliveryDaoImp.create(delivery);
    }

    @DeleteMapping("/items/{item_id}")
    public int deleteItem(@PathVariable int item_id) {
        return this.itemDaoImp.delete(item_id);
    }

    @DeleteMapping("/deposits/{deposits_id}")
    public int deleteDeposit(@PathVariable int deposits_id) {
        return this.depositDaoImp.delete(deposits_id);
    }

    @DeleteMapping("/deliveries/{delivery_id}")
    public int deleteDelivery(@PathVariable int delivery_id) {
        return this.deliveryDaoImp.delete(delivery_id);
    }

}