package com.warehouse.app.dao;

import java.util.List;
import java.util.Optional;

public interface ItemDao<T> {

    List<T> getAll();
    Optional<T> get(int item_id);
    void create(T t);
    void update(T t, int item_id);
    int delete(int item_id);

}
