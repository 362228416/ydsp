package com.ydsp.repository;


import com.ydsp.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author: john
 * @version: 1.0 2014-02-28 下午11:06
 */
@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByNameLike(@Param("name") String name);

}
