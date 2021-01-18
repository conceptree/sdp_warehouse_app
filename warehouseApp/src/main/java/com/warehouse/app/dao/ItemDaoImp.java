package com.warehouse.app.dao;

import com.warehouse.app.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemDaoImp implements ItemDao<Item> {

    private JdbcTemplate jdbcTemplate;

    public ItemDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Item> getAll() {
        String sql = "SELECT * FROM items";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Item item = new Item();
            item.setItem_id(rs.getInt("item_id"));
            item.setTypeName(rs.getString("typeName"));
            item.setDescription(rs.getString("description"));
            return item;
        });
    }

    @Override
    public Optional<Item> get(int item_id) {
        return Optional.empty();
    }

    @Override
    public void create(Item item) {
        String sql = "INSERT INTO items(typeName, description) VALUES(?, ?)";
        int insert = jdbcTemplate.update(sql, item.getTypeName(), item.getDescription());
        if (insert == 1) {
            System.out.printf("Item Successfully added!");
        }
    }

    @Override
    public void update(Item item, int item_id) {

    }

    @Override
    public int delete(int item_id) {
        String sql = "DELETE FROM items WHERE item_id = ?";
        int insert = 0;
        try {
            insert = jdbcTemplate.update(sql, item_id);
            System.out.println(insert);
            if (insert == 1) {
                System.out.printf("Item Successfully deleted!");
            }
            return insert;
        } catch (Exception ex) {
            System.out.println("cannot delete!");
            return insert;
        }
    }
}
