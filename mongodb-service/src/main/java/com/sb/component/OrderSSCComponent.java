package com.sb.component;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.sb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sammy
 * @Date: 2018/6/1 01:24
 * @Description:
 */

@Component
public class OrderSSCComponent {
    @Autowired
    MongoTemplate mongoTemplate;

    public void saveDemo(Order order) {
        mongoTemplate.save(order);
    }


    public List<Order> findAllMatch(String game, String kind,String numero,List<String> lines) {

        Criteria gameCriteria = new Criteria("game");
        gameCriteria.is(game);

        Criteria kindCriteria = new Criteria("kind");
        kindCriteria.is(kind);

        Criteria numeroCriteria = new Criteria("numero");
        numeroCriteria.is(numero);

        List<Order> list = new ArrayList<>();

        list.addAll(findMatchLine0(gameCriteria,kindCriteria,numeroCriteria,lines));
        list.addAll(findMatchLine01(gameCriteria,kindCriteria,numeroCriteria,lines));
        list.addAll(findMatchLine02(gameCriteria,kindCriteria,numeroCriteria,lines));
        list.addAll(findMatchLine03(gameCriteria,kindCriteria,numeroCriteria,lines));
        list.addAll(findMatchLine04(gameCriteria,kindCriteria,numeroCriteria,lines));


        return list;
    }

    private List<Order>  findMatchLine0(Criteria game,Criteria kind,Criteria numero,List<String> lines){
        Criteria oneMatch = new Criteria();
        oneMatch.andOperator(Criteria.where("line0").in(lines.get(0)),Criteria.where("line1").size(0),
                Criteria.where("line2").size(0),Criteria.where("line3").size(0),Criteria.where("line4").size(0));

        Query query = new Query();
        query.addCriteria(game);
        query.addCriteria(kind);
        query.addCriteria(numero);
        query.addCriteria(oneMatch);

        List<Order> list = mongoTemplate.find(query, Order.class);
        return list;

    }

    private List<Order>  findMatchLine01(Criteria game,Criteria kind,Criteria numero,List<String> lines){
        Criteria twoMatch = new Criteria();
        twoMatch.andOperator(Criteria.where("line0").in(lines.get(0)),Criteria.where("line1").in(lines.get(1)),
                Criteria.where("line2").size(0),Criteria.where("line3").size(0),Criteria.where("line4").size(0));


        Query query = new Query();
        query.addCriteria(game);
        query.addCriteria(kind);
        query.addCriteria(numero);
        query.addCriteria(twoMatch);

        List<Order> list = mongoTemplate.find(query, Order.class);
        return list;

    }

    private List<Order> findMatchLine02(Criteria game,Criteria kind,Criteria numero,List<String> lines){
        Criteria threeMatch = new Criteria();
        threeMatch.andOperator(Criteria.where("line0").in(lines.get(0)),Criteria.where("line1").in(lines.get(1)),
                Criteria.where("line2").in(lines.get(2)),Criteria.where("line3").size(0),Criteria.where("line4").size(0));

        Query query = new Query();
        query.addCriteria(game);
        query.addCriteria(kind);
        query.addCriteria(numero);
        query.addCriteria(threeMatch);

        List<Order> list = mongoTemplate.find(query, Order.class);
        return list;

    }

    private List<Order> findMatchLine03(Criteria game,Criteria kind,Criteria numero,List<String> lines){
        Criteria fourMatch = new Criteria();
        fourMatch.andOperator(Criteria.where("line0").in(lines.get(0)),Criteria.where("line1").in(lines.get(1)),
                Criteria.where("line2").in(lines.get(2)),Criteria.where("line3").in(lines.get(3)),Criteria.where("line4").size(0));

        Query query = new Query();
        query.addCriteria(game);
        query.addCriteria(kind);
        query.addCriteria(numero);
        query.addCriteria(fourMatch);

        List<Order> list = mongoTemplate.find(query, Order.class);
        return list;

    }

    private List<Order> findMatchLine04(Criteria game,Criteria kind,Criteria numero,List<String> lines){
        Criteria fiveMatch = new Criteria();
        fiveMatch.andOperator(Criteria.where("line0").in(lines.get(0)),Criteria.where("line1").in(lines.get(1)),
                Criteria.where("line2").in(lines.get(2)),Criteria.where("line3").in(lines.get(3)),Criteria.where("line4").in(lines.get(4)));

        Query query = new Query();
        query.addCriteria(game);
        query.addCriteria(kind);
        query.addCriteria(numero);
        query.addCriteria(fiveMatch);

        List<Order> list = mongoTemplate.find(query, Order.class);
        return list;

    }

}
