package com.eatable.app.repository;

import com.eatable.app.mongoEntity.UrlModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlModelRepository extends MongoRepository<UrlModel,String> {
}
