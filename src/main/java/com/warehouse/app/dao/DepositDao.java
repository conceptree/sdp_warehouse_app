package com.warehouse.app.dao;

import java.util.List;
import java.util.Optional;

public interface DepositDao<T> {

    List<T> getAll();

    Optional<T> get(int deposit_id);

    void create(T t);

    void update(T t, int deposit_id);

    int delete(int deposit_id);

}
