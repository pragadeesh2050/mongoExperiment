package com.mongo.experiment;

import com.mongo.experiment.model.User;
import com.mongo.experiment.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.mongo.experiment")
public class ExperimentApplication implements CommandLineRunner {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ExperimentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("Jon"));
		User user = this.mongoTemplate.findOne(query,User.class);
		System.out.println(user);
	}
}
