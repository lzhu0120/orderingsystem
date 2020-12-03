package com.lin.feign;

import com.lin.entity.Order;
import com.lin.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    void save(@RequestBody Order order);

    @GetMapping("/order/findAllByUid/{index}/{limit}/{uid}")
    OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid );

    @GetMapping("/order/findAllByState/{index}/{limit}")
    OrderVO findAllByState(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @PutMapping("/order/updateState/{id}")
    String updateState(@PathVariable("id") long id);
}
