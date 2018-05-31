package com.sb.controller;

import com.sb.model.Order;
import com.sb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: sammy
 * @Date: 2018/5/30 23:47
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public String insert(@RequestBody Order order) {
        orderService.insert(order);
        return "OK";
    }

    @RequestMapping(value = "/find", method = {RequestMethod.GET})
    public String find() {
        orderService.find();
        return "OK";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public String delete() {
        orderService.delete();
        return "OK";
    }


}
