package com.capgemini.opleidingsplatform.Presentation.dto;

import com.capgemini.opleidingsplatform.domain.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
public class SubCategoryDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private String categoryId;

}
