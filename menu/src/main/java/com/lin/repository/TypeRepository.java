package com.lin.repository;

import com.lin.entity.Type;
import java.util.List;

public interface TypeRepository {
    Type findById(long id);
    List<Type> findAll();
}
