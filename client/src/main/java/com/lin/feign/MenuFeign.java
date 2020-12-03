package com.lin.feign;

import com.lin.entity.Menu;
import com.lin.entity.MenuVO;
import com.lin.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//调用服务提供者menu在注册中心注册的名字，menu-dev里spring.application.name
//FeignClient里面的value相当于关联到menu模块的handler，但是所有方法的调用必须要加“/menu/...”
@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")//调用服务提供者menu的接口
    MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}") //调用的menu handler里面的deleteById方法
    void deleteById(@PathVariable("id") long id);

    @GetMapping("/menu/findTypes")
    List<Type> findTypes();

    @PostMapping("/menu/save")
    void save(Menu menu);

    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id") long id);

    @PutMapping("/menu/update")
    void update(Menu menu);
}
