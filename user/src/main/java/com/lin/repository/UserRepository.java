package com.lin.repository;


import com.lin.entity.User;
import java.util.List;

public interface UserRepository {
    List<User> findAll(int index, int limit);
    User findById(long id);
    int count();
    void save(User user);
    void update(User user);
    void deleteById(long id);
}
