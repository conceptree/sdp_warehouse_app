package com.warehouse.app;

import com.warehouse.app.controllers.MainController;
import com.warehouse.app.dao.*;
import com.warehouse.app.model.Delivery;
import com.warehouse.app.model.Deposit;
import com.warehouse.app.model.Item;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AppApplication {

    private static ItemDaoImp itemDaoImp;
    private static DepositDaoImp depositsDaoImp;
    private static DeliveryDaoImp deliveryDaoImp;
    private static MainController mainController;
    private static JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);

        itemDaoImp = new ItemDaoImp(jdbcTemplate);
        depositsDaoImp = new DepositDaoImp(jdbcTemplate);
        deliveryDaoImp = new DeliveryDaoImp(jdbcTemplate);
        mainController = new MainController(itemDaoImp, depositsDaoImp, deliveryDaoImp);

    }

}
