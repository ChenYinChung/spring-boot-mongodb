package com.sb.service;

import com.sb.model.Order;
import com.sb.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

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

    public String insert(Order order){

        orderRepository.insert(order);

        return "OK";
    }


    public String find(){



        return "OK";
    }

    public String delete(){



        return "OK";
    }

}
