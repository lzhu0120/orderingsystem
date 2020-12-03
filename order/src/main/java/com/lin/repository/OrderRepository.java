package com.lin.repository;

import com.lin.entity.Order;
import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAllByUid(int index, int limit, long uid);
    int countByUid(long uid);
    List<Order> findAllByState(int index, int limit); // find all not-solved orders
    void updateState(long id);
    int count(); // find all state = 0 orders
}
