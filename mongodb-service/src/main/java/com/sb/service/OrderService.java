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


    public List<Order> find(String game, String kind,String numero,String i0, String i1, String i2, String i3,String i4){

        List<String> selected = new ArrayList<>();
        selected.add(i0);
        selected.add(i1);
        selected.add(i2);
        selected.add(i3);
        selected.add(i4);

        List<Order> list = orderSSCComponent.findAllMatch(game,kind,numero,selected);



        return list;
    }

    public String delete(){



        return "OK";
    }

}
