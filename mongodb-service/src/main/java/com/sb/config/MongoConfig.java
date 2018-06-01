package com.sb.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @Auther: sammy
 * @Date: 2018/5/23 11:48
 * @Description:
 */
@Configuration
public class MongoConfig {


    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {


        ServerAddress serverAddress= new ServerAddress(host,port);

        MongoClientOptions options = MongoClientOptions.builder().writeConcern(WriteConcern.MAJORITY)
                .connectTimeout(30000)
                .connectionsPerHost(128)
                .heartbeatConnectTimeout(15000)
                .heartbeatFrequency(10000)
                .maxConnectionIdleTime(60000)
                .maxWaitTime(10000).build();
        MongoClient mongoClient = new MongoClient(serverAddress,options);



        return new SimpleMongoDbFactory(mongoClient, database);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }
}
