package com.warehouse.app.dao;

import com.warehouse.app.model.Delivery;
import com.warehouse.app.model.Deposit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DeliveryDaoImp implements DeliveryDao<Delivery> {

    private JdbcTemplate jdbcTemplate;

    public DeliveryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Delivery> getAll() {
        String sql = "SELECT * FROM deliveries";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Delivery delivery = new Delivery();
            delivery.setDelivery_id(rs.getInt("delivery_id"));
            delivery.setItem_id(rs.getInt("item_id"));
            delivery.setAddress(rs.getString("address"));
            delivery.setQuantity(rs.getInt("quantity"));
            return delivery;
        });
    }

    @Override
    public Optional<Delivery> get(int delivery_id) {
        return Optional.empty();
    }

    @Override
    public void create(Delivery delivery) {
        String sql = "INSERT INTO deliveries(item_id, address, quantity) VALUES(?, ?, ?)";
        int insert = jdbcTemplate.update(sql, delivery.getItem_id(), delivery.getAddress(), delivery.getQuantity());
        if (insert == 1) {
            System.out.printf("Delivery Successfully added!");
        }
    }

    @Override
    public void update(Delivery t, int delivery_id) {

    }

    @Override
    public int delete(int delivery_id) {
        String sql = "DELETE FROM items WHERE delivery_id = ?";
        int insert = 0;
        try {
            insert = jdbcTemplate.update(sql, delivery_id);
            System.out.println(insert);
            if (insert == 1) {
                System.out.printf("Delivery Successfully deleted!");
            }
            return insert;
        } catch (Exception ex) {
            System.out.println("cannot delete!");
            return insert;
        }
    }
}
