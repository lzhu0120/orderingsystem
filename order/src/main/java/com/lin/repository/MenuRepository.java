package com.lin.repository;

import com.lin.entity.Menu;

import java.util.List;


public interface MenuRepository {
    Menu findById(long id);
}
