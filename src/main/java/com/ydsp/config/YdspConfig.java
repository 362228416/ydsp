package com.ydsp.config;

import com.mongodb.Mongo;
import com.ydsp.event.QueryRepositoryEventListener;
import com.ydsp.event.UserRepositoryEventListener;
import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.cloudfoundry.runtime.env.MongoServiceInfo;
import org.cloudfoundry.runtime.service.document.MongoServiceCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @author: john
 * @version: 1.0 2014-02-28 下午10:43
 */
@Configuration
@EnableSpringDataWebSupport
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = {"com.ydsp.repository"})
@ComponentScan({"com.ydsp.util","com.ydsp.event"})
@Import(RepositoryRestMvcConfiguration.class)
public class YdspConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Mongo mongo() throws Exception {
        return new Mongo("localhost");
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        try {
            CloudEnvironment environment = new CloudEnvironment();
            MongoDbFactory mongo = new MongoServiceCreator().createService(environment.getServiceInfo("my-mongo", MongoServiceInfo.class));
            return mongo;
        } catch (Exception e) {
            return null;
        }
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate;
        MongoDbFactory mongoDbFactory = mongoDbFactory();
        if (mongoDbFactory == null) {
            // local
            mongoTemplate = new MongoTemplate(mongo(), "db");
        } else {
            // cloud foundry
            mongoTemplate = new MongoTemplate(mongoDbFactory);
        }
        return mongoTemplate;
    }

    @Bean
    public UserRepositoryEventListener userRepositoryEventListener() {
        return new UserRepositoryEventListener();
    }

    @Bean
    public QueryRepositoryEventListener searchRepositoryEventListener() {
        return new QueryRepositoryEventListener();
    }

}
