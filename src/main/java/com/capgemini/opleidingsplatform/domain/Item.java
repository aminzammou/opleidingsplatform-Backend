package com.capgemini.opleidingsplatform.domain;

import com.capgemini.opleidingsplatform.domain.Category;
import com.capgemini.opleidingsplatform.domain.SubCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document
public class Item {

    @Id
    private UUID itemId;
    private String name;
    private String description;
    private String code;

    private Boolean inplace;

    private Boolean stable;
    @DBRef
    private SubCategory subCategory;

    public Item(String name, String description,String code , SubCategory subCategory, boolean inplace ,boolean stable) {
        this.itemId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.code = code;
        this.subCategory = subCategory;
        this.inplace = inplace;
        this.stable = stable;
    }
}
