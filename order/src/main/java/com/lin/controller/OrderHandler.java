package com.lin.controller;

import com.lin.entity.Order;
import com.lin.entity.OrderVO;
import com.lin.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid ){
        List<Order> list = orderRepository.findAllByUid(index, limit, uid);
        return new OrderVO(0, "", orderRepository.countByUid(uid), list);
    }

    /*@GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }*/

    @GetMapping("/findAllByState/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable("index") int index, @PathVariable("limit") int limit){
        List<Order> list = orderRepository.findAllByState(index, limit);
        return new OrderVO(0, "", orderRepository.count(), list);
    }

    @PutMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") long id){
        orderRepository.updateState(id);
    }

}
