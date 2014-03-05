package com.ydsp.repository;

import com.ydsp.domain.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author: john
 * @version: 1.0 2014-03-05 上午10:13
 */
@RepositoryRestResource(path = "query", collectionResourceRel = "query")
public interface QueryRepository extends MongoRepository<Query, String> {

    List<Query> findByKeywordLike(@Param("keyword") String keyword);

}