package com.warehouse.app.dao;

import java.util.List;
import java.util.Optional;

public interface DeliveryDao<T> {

    List<T> getAll();

    Optional<T> get(int delivery_id);

    void create(T t);

    void update(T t, int delivery_id);

    int delete(int delivery_id);

}
