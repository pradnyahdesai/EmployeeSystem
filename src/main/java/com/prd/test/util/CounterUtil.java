package com.prd.test.util;


import javax.annotation.Resource;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.prd.test.vo.mongo.Counter;

public class CounterUtil {
	
	@Resource(name = "mongoOperations")
	private MongoOperations mongoOperations;

	  public int getNextSequence(String collectionName) {
	   /* Counter counter = mongoOperations.findAndModify(
	      query(where("_id").is(collectionName)), 
	      new Update().inc("seq", 1),
	      options().returnNew(true),
	      Counter.class);*/
	    
	    	Query query = new Query(Criteria.where("_id").is(collectionName));

		  Update update = new Update();
		  update.inc("seq", 1);

	
		  FindAndModifyOptions options = new FindAndModifyOptions();
		  options.returnNew(true);


		  Counter counter =
				  mongoOperations.findAndModify(query, update, options, Counter.class);
		  if(counter == null){
			  counter = new Counter();
			  counter.setId("EmpId");
			  counter.setSeq(1);
			  mongoOperations.save(counter);
		  }
	
	    return counter.getSeq();
	  }
}
