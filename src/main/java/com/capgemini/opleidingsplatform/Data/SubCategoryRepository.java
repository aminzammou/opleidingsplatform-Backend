package com.capgemini.opleidingsplatform.Data;

import com.capgemini.opleidingsplatform.domain.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface SubCategoryRepository extends MongoRepository<SubCategory,UUID> {
    @Query("{'_id._id': ?0 }")
    Optional<SubCategory> findBySubCategoryId(UUID id);

    @Query("{'name': ?0 }")
    Optional<SubCategory> findBySubCategoryName(String name);

}
