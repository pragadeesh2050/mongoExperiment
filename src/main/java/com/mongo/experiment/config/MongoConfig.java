package com.mongo.experiment.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "myFirstDatabase";
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString
                = new ConnectionString("mongodb+srv://avacadodev2050:PxQnNKlJrTj0YdqQ@cluster0.8pnwi.mongodb.net/myFirstDatabase?authSource=admin");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}