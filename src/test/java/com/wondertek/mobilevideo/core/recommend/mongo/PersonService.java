package com.wondertek.mobilevideo.core.recommend.mongo;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class PersonService {
	 @Autowired  
	 MongoTemplate mongoTemplate;
	 
	 public void insert(int count) {
//		  
//	        if (mongoTemplate.collectionExists(Person.class)) {  
//	            mongoTemplate.dropCollection(Person.class);  
//	        }  
//	  
//	        mongoTemplate.createCollection(Person.class);  
	  
	        for (int i = 0; i < count; i++) {  
	            Person p = new Person();  
	            p.setAge(i);
	            p.setFirstName("firstName" + i);
	            p.setId(null);
	            p.setLastName("lastName" + i);
	            mongoTemplate.insert(p);
	        }  
	  
	    } 
	 
	 public void alert(int age) {
        // 根据age查询，更新查询到的age字段为随机数  
		 mongoTemplate.updateMulti(new Query(new Criteria("age").is(age)),  
                new Update().inc("age", new Random().nextInt()), Person.class);  
    } 
	 
	 public void query(int age) {  
	        // 根据age查询  
	        List<Person> persons = mongoTemplate.find(new Query(new Criteria(  
	                "age").is(age)), Person.class);  
	        for (Person p : persons) {  
	            System.out.println(p.toString());  
	        }  
	  
	        // ===========================jdbc原生的类  
	        DBCollection personColl = mongoTemplate.getCollection(mongoTemplate.getCollectionName(Person.class));  
	        BasicDBObject parameter = new BasicDBObject();  
	        parameter.put("age", age);  
	        DBCursor item = personColl.find(parameter);  
	        while (item.hasNext()) {  
	            System.out.println(item.next());  
	        }  
	  
	    }

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}  
	  
}
