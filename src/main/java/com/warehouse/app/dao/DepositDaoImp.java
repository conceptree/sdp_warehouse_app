package com.warehouse.app.dao;

import com.warehouse.app.model.Deposit;
import com.warehouse.app.model.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepositDaoImp implements DepositDao<Deposit> {

    private JdbcTemplate jdbcTemplate;

    public DepositDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Deposit> getAll() {
        String sql = "SELECT * FROM deposits";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Deposit deposit = new Deposit();
            deposit.setDeposit_id(rs.getInt("deposits_id"));
            deposit.setItem_id(rs.getInt("item_id"));
            deposit.setQuantity(rs.getInt("quantity"));
            return deposit;
        });
    }

    @Override
    public Optional<Deposit> get(int deposit_id) {
        return Optional.empty();
    }

    @Override
    public void create(Deposit deposit) {
        String sql = "INSERT INTO deposits(item_id, quantity) VALUES(?, ?)";
        int insert = jdbcTemplate.update(sql, deposit.getItem_id(), deposit.getQuantity());
        if (insert == 1) {
            System.out.printf("Deposit Successfully added!");
        }
    }

    @Override
    public void update(Deposit deposit, int deposits_id) {
        String sql = "UPDATE deposits SET item_id=?, quantity=? WHERE deposits_id=?";
        int insert = jdbcTemplate.update(sql, deposit.getItem_id(), deposit.getQuantity(), deposits_id);
        if(insert == 1){
            System.out.printf("Deposit Successfully updated!");
        }
    }

    @Override
    public int delete(int deposit_id) {
        String sql = "DELETE FROM items WHERE deposit_id = ?";
        int insert = 0;
        try {
            insert = jdbcTemplate.update(sql, deposit_id);
            System.out.println(insert);
            if (insert == 1) {
                System.out.printf("Deposit Successfully deleted!");
            }
            return insert;
        } catch (Exception ex) {
            System.out.println("cannot delete!");
            return insert;
        }
    }
}
