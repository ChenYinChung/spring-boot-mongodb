package com.sb.repository;

import com.sb.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;

/**
 * @Auther: sammy
 * @Date: 2018/5/30 23:57
 * @Description:
 */
public interface OrderRepository extends MongoRepository<Order,String> {

    List<Order> findOrdersByCustomerId(String customerId);

    @Query("{'$and':[{'selected.line0':?0},{'selected.line1':?1},{'selected.line2':?2},{'selected.line3':?3},{'selected.line4':?4}]}")
    List<Order> findOrdersBySelected(String i0,String i1,String i2,String i3,String i4);
}
