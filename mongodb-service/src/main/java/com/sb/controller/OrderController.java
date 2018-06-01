package com.sb.controller;

import com.sb.model.Order;
import com.sb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * http://localhost:8080/order/find/1/2/3/4/5
     * @param i0
     * @param i1
     * @param i2
     * @param i3
     * @param i4
     * @return
     */
    @RequestMapping(value = "/find/{game}/{kind}/{numero}/{i0}/{i1}/{i2}/{i3}/{i4}", method = {RequestMethod.GET})
    public List<Order> find(@PathVariable("game") String game, @PathVariable("kind") String kind,
                            @PathVariable("numero") String numero,
                            @PathVariable("i0") String i0, @PathVariable("i1") String i1,
                            @PathVariable("i2") String i2,
                            @PathVariable("i3") String i3, @PathVariable("i4") String i4) {
        List<Order> list = orderService.find(game,kind,numero,i0,i1,i2,i3,i4);
        return list;
    }


    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public String delete() {
        orderService.delete();
        return "OK";
    }


}
