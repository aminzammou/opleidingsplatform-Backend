package com.capgemini.opleidingsplatform;

import com.capgemini.opleidingsplatform.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends MongoRepository<Category,UUID> {
    @Query("{'_id._id': ?0 }")
    Optional<Category> findByCategoryId(UUID id);

    @Query("{'name': ?0 }")
    Optional<Category> findByCategoryName(String name);

}
