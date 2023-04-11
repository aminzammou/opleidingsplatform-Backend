package com.capgemini.opleidingsplatform.domain;

import com.capgemini.opleidingsplatform.domain.Category;
import com.capgemini.opleidingsplatform.domain.SubCategory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.UUID;

public class Item {

    @Id
    private UUID itemId;
    private String name;
    private String description;
    @DBRef
    private SubCategory subCategory;

    public Item(String name, String description, SubCategory category) {
        this.itemId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.subCategory = category;
    }
}
