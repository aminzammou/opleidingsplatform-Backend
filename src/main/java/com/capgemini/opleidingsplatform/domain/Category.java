package com.capgemini.opleidingsplatform.domain;
import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;
        import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document
public class Category {
    @Id
    private UUID categoryId;
    private String name;

    public Category(String name) {
        this.categoryId = UUID.randomUUID();
        this.name = name;
    }

    public void update(String name){
        this.name = name;
    }
}