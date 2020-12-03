package com.lin.repository;


import com.lin.entity.User;

import java.util.List;

public interface UserRepository {
    User findById(long id);
}
