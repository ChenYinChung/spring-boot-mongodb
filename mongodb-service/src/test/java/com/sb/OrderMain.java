package com.sb;

import com.google.gson.Gson;
import com.sb.model.Order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.*;
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

    public static void order() {
        for (int i = 0; i < 1000; i++) {
            send(selectLine0());
            send(selectLine01());
            send(selectLine02());
            send(selectLine03());
            send(selectLine04());
        }

    }


    private static void send(Order order) {
        //for testing remove when test done
        order.setNumero("test-12345");


        Runnable task2 = () -> {
            RestTemplate restTemplate = new RestTemplate();

            try {
                String url = "http://localhost:8080/order/insert";
                Gson gson = new Gson();
                String json = gson.toJson(order);

                HttpHeaders headers = new HttpHeaders();
                MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
                headers.setContentType(type);
                HttpEntity<String> entity = new HttpEntity<>(json, headers);
                String result = restTemplate.postForObject(url, entity, String.class);

                logger.info("response :{}", result);
            } catch (Exception e) {
                logger.error("error", e);
            }

        };

        executorService.execute(task2);

    }

    private static Order selectLine0() {

        List<String> line0 = selected(5);
        List<String> line1 = selected(0);
        List<String> line2 = selected(0);
        List<String> line3 = selected(0);
        List<String> line4 = selected(0);


        Order order = new Order();
        order.setBetting_slip("2000~" + line0 + "_" + line1 + "_" + line2 + "_" + line3 + "_" + line4 + "~1000~1~21~");
        order.setAborting(true);


        order.setLine0(line0);
        order.setLine1(line1);
        order.setLine2(line2);
        order.setLine3(line3);
        order.setLine4(line4);
        order.setCustomerId("sammy");
        order.setOrderNum(genSequence(16));
        order.setGame("SSC");
        order.setKind("CQSSC");
        order.setNumero("Test-" + genSequence(3));

        return order;
    }

    private static Order selectLine01() {

        List<String> line0 = selected(5);
        List<String> line1 = selected(6);
        List<String> line2 = selected(0);
        List<String> line3 = selected(0);
        List<String> line4 = selected(0);


        Order order = new Order();
        order.setBetting_slip("2000~" + line0 + "_" + line1 + "_" + line2 + "_" + line3 + "_" + line4 + "~1000~1~21~");
        order.setAborting(true);


        order.setLine0(line0);
        order.setLine1(line1);
        order.setLine2(line2);
        order.setLine3(line3);
        order.setLine4(line4);
        order.setCustomerId("sammy");
        order.setOrderNum(genSequence(16));
        order.setGame("SSC");
        order.setKind("CQSSC");
        order.setNumero("Test-" + genSequence(3));
        return order;
    }

    private static Order selectLine02() {

        List<String> line0 = selected(5);
        List<String> line1 = selected(6);
        List<String> line2 = selected(7);
        List<String> line3 = selected(0);
        List<String> line4 = selected(0);


        Order order = new Order();
        order.setBetting_slip("2000~" + line0 + "_" + line1 + "_" + line2 + "_" + line3 + "_" + line4 + "~1000~1~21~");
        order.setAborting(true);


        order.setLine0(line0);
        order.setLine1(line1);
        order.setLine2(line2);
        order.setLine3(line3);
        order.setLine4(line4);
        order.setCustomerId("sammy");
        order.setOrderNum(genSequence(16));
        order.setGame("SSC");
        order.setKind("CQSSC");
        order.setNumero("Test-" + genSequence(3));

        return order;
    }

    private static Order selectLine03() {

        List<String> line0 = selected(5);
        List<String> line1 = selected(6);
        List<String> line2 = selected(7);
        List<String> line3 = selected(6);
        List<String> line4 = selected(0);


        Order order = new Order();
        order.setBetting_slip("2000~" + line0 + "_" + line1 + "_" + line2 + "_" + line3 + "_" + line4 + "~1000~1~21~");
        order.setAborting(true);


        order.setLine0(line0);
        order.setLine1(line1);
        order.setLine2(line2);
        order.setLine3(line3);
        order.setLine4(line4);
        order.setCustomerId("sammy");
        order.setOrderNum(genSequence(16));
        order.setGame("SSC");
        order.setKind("CQSSC");
        order.setNumero("Test-" + genSequence(3));

        return order;
    }

    private static Order selectLine04() {

        List<String> line0 = selected(6);
        List<String> line1 = selected(7);
        List<String> line2 = selected(8);
        List<String> line3 = selected(7);
        List<String> line4 = selected(6);


        Order order = new Order();
        order.setBetting_slip("2000~" + line0 + "_" + line1 + "_" + line2 + "_" + line3 + "_" + line4 + "~1000~1~21~");
        order.setAborting(true);


        order.setLine0(line0);
        order.setLine1(line1);
        order.setLine2(line2);
        order.setLine3(line3);
        order.setLine4(line4);
        order.setCustomerId("sammy");
        order.setOrderNum(genSequence(16));
        order.setGame("SSC");
        order.setKind("CQSSC");
        order.setNumero("Test-" + genSequence(3));

        return order;
    }

    public static String genSequence(int len) {
        final String alphabet = "0123456789ABCDE";
        final int length = alphabet.length();

        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(alphabet.charAt(random.nextInt(length)));
        }

        return sb.toString();
    }

    public static List<String> selected(int genLen) {
        final String alphabet = "0123456789";
        final int length = alphabet.length();

        Random random = new Random();
        Set<String> unique = new HashSet<>();
        List<String> data = new ArrayList<>();

        while (true) {

            if (unique.size() == genLen) {
                break;
            }

            String gen = String.valueOf(alphabet.charAt(random.nextInt(length)));
            if (unique.add(gen)) {
                data.add(gen);
            }

        }

        Collections.sort(data);

        return data;
    }


    public static void main(String arg[]) {

        order();
    }
}
