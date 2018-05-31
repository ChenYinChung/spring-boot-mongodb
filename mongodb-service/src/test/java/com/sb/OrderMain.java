package com.sb;

import com.google.gson.Gson;
import com.sb.model.Order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: sammy
 * @Date: 2018/5/31 00:05
 * @Description:
 */
public class OrderMain {

    static final Logger logger = LoggerFactory.getLogger(TestMain.class);

    static ExecutorService executorService = Executors.newFixedThreadPool(500);

    public static void main(String arg[]) {

        long  begin = System.currentTimeMillis();

        for (var i = 0; i < 100; i++) {
            Runnable task2 = () -> {
                RestTemplate restTemplate = new RestTemplate();


                try {
                    String url = "http://localhost:8080/order/insert";


                    Order order = new Order();
                    order.setBetting_slip("2000~0123456789_0123456789_0123456789~1000~1~21~");
                    order.setAborting(true);
                    order.setSelected(Arrays.asList("01","23","45"));
                    order.setCustomer_id("sammy");


                    Gson gson = new Gson();
                    String json = gson.toJson(order);


                    HttpHeaders headers = new HttpHeaders();
                    MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
                    headers.setContentType(type);
                    HttpEntity<String> entity = new HttpEntity<>(json, headers);
                    String result = restTemplate.postForObject(url, entity, String.class);

                    logger.info("response :{}",result);
                } catch (Exception e) {
                    logger.error("error",e);
                }

            };
            executorService.execute(task2);
        }

        while(executorService.isTerminated()){
            logger.info( "time[{}]",(System.currentTimeMillis()-begin)/1000);
            executorService.shutdown();
        }


    }
}
