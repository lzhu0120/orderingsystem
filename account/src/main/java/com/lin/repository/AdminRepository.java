package com.lin.repository;

import com.lin.entity.Admin;

public interface AdminRepository {
    Admin login(String username, String password);
}
