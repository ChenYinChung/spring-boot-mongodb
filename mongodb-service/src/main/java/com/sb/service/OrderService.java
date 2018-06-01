package com.sb.service;

import com.sb.component.OrderSSCComponent;
import com.sb.model.Order;
import com.sb.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sammy
 * @Date: 2018/5/30 23:52
 * @Description:
 */
@Service
public class OrderService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderSSCComponent orderSSCComponent;

    public String insert(Order order){

        orderRepository.insert(order);

        return "OK";
    }


    public List<Order> find(String game, String kind,String numero,String line0, String line1, String line2, String line3,String line4){

        List<String> selected = new ArrayList<>();
        selected.add(line0);
        selected.add(line1);
        selected.add(line2);
        selected.add(line3);
        selected.add(line4);

        List<Order> list = orderSSCComponent.findAllMatch(game,kind,numero,selected);



        return list;
    }

    public String delete(){



        return "OK";
    }

}
