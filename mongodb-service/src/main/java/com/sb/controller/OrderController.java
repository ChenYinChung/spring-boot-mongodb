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
     * http://localhost:8080/order/find/SSC/CQSSC/test-12345/1/2/3/4/5
     * @param game
     * @param kind
     * @param numero
     * @param line0
     * @param line1
     * @param line2
     * @param line3
     * @param line4
     * @return
     */
    @RequestMapping(value = "/find/{game}/{kind}/{numero}/{line0}/{line1}/{line2}/{line3}/{line4}", method = {RequestMethod.GET})
    public List<Order> find(@PathVariable("game") String game, @PathVariable("kind") String kind,
                            @PathVariable("numero") String numero,
                            @PathVariable("line0") String line0, @PathVariable("line1") String line1,
                            @PathVariable("line2") String line2,
                            @PathVariable("line3") String line3, @PathVariable("line4") String line4) {
        List<Order> list = orderService.find(game,kind,numero,line0,line1,line2,line3,line4);
        return list;
    }


    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public String delete() {
        orderService.delete();
        return "OK";
    }


}
