package com.capgemini.opleidingsplatform.Data;

import com.capgemini.opleidingsplatform.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends MongoRepository<Item,UUID> {
    @Query("{'_id': ?0 }")
    Optional<Item> findByItemId(UUID id);

    @Query("{'name': ?0 }")
    Optional<Item> findByItemName(String name);

}
