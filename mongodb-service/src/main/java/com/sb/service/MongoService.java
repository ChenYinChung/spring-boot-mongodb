package com.sb.service;


import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import com.sb.model.User;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @Auther: sammy
 * 不使用repository ,改由template來執行
 * @Date: 2018/5/22 11:44
 * @Description:
 */

@Service
public class MongoService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MongoTemplate mongoTemplate;

    public void insert(User user){

        try {

//            MongoClient mongoClient = new MongoClient("localhost", 27017);
//            MongoDatabase db = mongoClient.getDatabase("local");
//
//
////        MongoCredential testAuth = MongoCredential.createPlainCredential("app", "test", "1qaz2wsx".toCharArray());
//
//            MongoCollection<Document> collection = db.getCollection("test");


//            user.set_id("1234567");
//            user.setName("Sammy");
//            user.setCompany("Unistar");
//            user.setSchool("Private Culture University");

//            createUniqueIndex();
            mongoTemplate.insert(user);

//            Gson gson = new Gson();
//            String json = gson.toJson(user);
//
//            Document document = Document.parse(json);

//            collection.insertOne(document);
        }catch(Exception e){
            logger.error("error",e);
        }

//
//        collection.find(filter);
//
//        collection.updateOne(filter, update);
//
//        collection.deleteOne(filter);

    }

    private void createUniqueIndex() {
        try {
            MongoCollection<Document> collection = mongoTemplate.getCollection("test");
            Document index = new Document("name", 1);
            collection.createIndex(index, new IndexOptions().unique(true));
        }catch(MongoCommandException mce){
            logger.info("index already created");
        }

    }
}
