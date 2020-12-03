package com.lin.repository;

import com.lin.entity.User;

public interface UserRepository {
    User login(String username, String password);
}
