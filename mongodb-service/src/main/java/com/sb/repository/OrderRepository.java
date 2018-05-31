package com.sb.repository;

import com.sb.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Auther: sammy
 * @Date: 2018/5/30 23:57
 * @Description:
 */
public interface OrderRepository extends MongoRepository<Order,String> {
}
