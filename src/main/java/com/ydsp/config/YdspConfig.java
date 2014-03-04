package com.ydsp.config;

import com.mongodb.Mongo;
import com.ydsp.event.UserRepositoryEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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
@ComponentScan({"com.ydsp.event", "com.ydsp.util"})
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
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "db");
    }

    @Bean
    public UserRepositoryEventListener userRepositoryEventListener() {
        return new UserRepositoryEventListener();
    }

}
