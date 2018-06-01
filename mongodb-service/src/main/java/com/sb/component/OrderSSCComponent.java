package com.sb.component;

import com.sb.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: sammy
 * @Date: 2018/6/1 01:24
 * @Description:
 */

@Component
public class OrderSSCComponent {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MongoTemplate mongoTemplate;

    ExecutorService executorService = Executors.newFixedThreadPool(20);

    public void saveDemo(Order order) {
        mongoTemplate.save(order);
    }

    public List<Order> findAllMatch(String game, String kind, String numero, List<String> lines) {

        List<Future<List<Order>>> futures = new ArrayList<>();
        List<Order> orders = new ArrayList<>();


        Criteria gameCriteria = new Criteria("game").is(game);
        Criteria kindCriteria = new Criteria("kind").is(kind);
        Criteria numeroCriteria = new Criteria("numero").is(numero);


        futures.add(findMatchLine0(gameCriteria, kindCriteria, numeroCriteria, lines)); // 符合一星
        futures.add(findMatchLine01(gameCriteria, kindCriteria, numeroCriteria, lines));// 符合二星
        futures.add(findMatchLine02(gameCriteria, kindCriteria, numeroCriteria, lines));// 符合三星
        futures.add(findMatchLine03(gameCriteria, kindCriteria, numeroCriteria, lines));// 符合四星
        futures.add(findMatchLine04(gameCriteria, kindCriteria, numeroCriteria, lines));// 符合五星


        while(true){

            for (Iterator<Future<List<Order>>> iterator = futures.iterator(); iterator.hasNext(); ) {
                Future<List<Order>> future = iterator.next();
                if(future.isDone()){
                    try {
                        orders.addAll(future.get());
                    } catch (InterruptedException | ExecutionException e) {
                        logger.error("future interrupted",e);
                    }
                    iterator.remove();
                }
            }

            if(futures.size()==0){
                break;
            }
        }

        return orders;
    }

    private Future<List<Order>> findMatchLine0(Criteria game, Criteria kind, Criteria numero, List<String> lines) {
        Callable callable = () -> {
            String line0 = lines.get(0);
            Criteria oneMatch = new Criteria();
            oneMatch.andOperator(Criteria.where("line0").in(line0), Criteria.where("line1").size(0),
                    Criteria.where("line2").size(0), Criteria.where("line3").size(0), Criteria.where("line4").size(0));

            Query query = new Query();
            query.addCriteria(game);
            query.addCriteria(kind);
            query.addCriteria(numero);
            query.addCriteria(oneMatch);

            return mongoTemplate.find(query, Order.class);
        };

        return executorService.submit(callable);

    }


    private Future<List<Order>> findMatchLine01(Criteria game, Criteria kind, Criteria numero, List<String> lines) {

        Callable callable = () -> {
            String line0 = lines.get(0);
            String line1 = lines.get(1);

            Criteria twoMatch = new Criteria();
            twoMatch.andOperator(Criteria.where("line0").in(line0), Criteria.where("line1").in(line1),
                    Criteria.where("line2").size(0), Criteria.where("line3").size(0), Criteria.where("line4").size(0));


            Query query = new Query();
            query.addCriteria(game);
            query.addCriteria(kind);
            query.addCriteria(numero);
            query.addCriteria(twoMatch);

            return mongoTemplate.find(query, Order.class);
        };


        return executorService.submit(callable);

    }

    private Future<List<Order>> findMatchLine02(Criteria game, Criteria kind, Criteria numero, List<String> lines) {
        Callable callable = () -> {
            String line0 = lines.get(0);
            String line1 = lines.get(1);
            String line2 = lines.get(2);


            Criteria threeMatch = new Criteria();
            threeMatch.andOperator(Criteria.where("line0").in(line0), Criteria.where("line1").in(line1),
                    Criteria.where("line2").in(line2), Criteria.where("line3").size(0), Criteria.where("line4").size(0));

            Query query = new Query();
            query.addCriteria(game);
            query.addCriteria(kind);
            query.addCriteria(numero);
            query.addCriteria(threeMatch);
            return mongoTemplate.find(query, Order.class);
        };

        return executorService.submit(callable);

    }

    private Future<List<Order>> findMatchLine03(Criteria game, Criteria kind, Criteria numero, List<String> lines) {
        Callable callable = () -> {
            String line0 = lines.get(0);
            String line1 = lines.get(1);
            String line2 = lines.get(2);
            String line3 = lines.get(3);

            Criteria fourMatch = new Criteria();
            fourMatch.andOperator(Criteria.where("line0").in(line0), Criteria.where("line1").in(line1),
                    Criteria.where("line2").in(line2), Criteria.where("line3").in(line3), Criteria.where("line4").size(0));

            Query query = new Query();
            query.addCriteria(game);
            query.addCriteria(kind);
            query.addCriteria(numero);
            query.addCriteria(fourMatch);

            return mongoTemplate.find(query, Order.class);
        };
        return executorService.submit(callable);

    }

    private Future<List<Order>> findMatchLine04(Criteria game, Criteria kind, Criteria numero, List<String> lines) {
        Callable callable = () -> {
            String line0 = lines.get(0);
            String line1 = lines.get(1);
            String line2 = lines.get(2);
            String line3 = lines.get(3);
            String line4 = lines.get(4);

            Criteria fiveMatch = new Criteria();
            fiveMatch.andOperator(Criteria.where("line0").in(line0), Criteria.where("line1").in(line1),
                    Criteria.where("line2").in(line2), Criteria.where("line3").in(line3), Criteria.where("line4").in(line4));

            Query query = new Query();
            query.addCriteria(game);
            query.addCriteria(kind);
            query.addCriteria(numero);
            query.addCriteria(fiveMatch);

            return mongoTemplate.find(query, Order.class);
        };
        return executorService.submit(callable);
    }
}
