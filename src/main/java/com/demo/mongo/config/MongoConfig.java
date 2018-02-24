package com.demo.mongo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.demo")
@PropertySource(value = {"classpath:application.properties"})
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;

    @Override
    public MongoMappingContext mongoMappingContext()
            throws ClassNotFoundException {
        return super.mongoMappingContext();
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        //    return new MongoClient("127.0.0.1", 27017); we can specify ip and port
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return mongoDB;
    }


}
