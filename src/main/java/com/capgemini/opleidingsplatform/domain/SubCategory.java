package com.capgemini.opleidingsplatform.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document
public class SubCategory {

    @Id
    private UUID subCategoryId;
    private String name;
    private String description;
    @DBRef
    private Category category;

    public SubCategory(String name, String description, Category category) {
        this.subCategoryId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
