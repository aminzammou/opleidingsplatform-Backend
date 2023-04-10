package com.capgemini.opleidingsplatform.Presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class CategoryDTO {
    @NotBlank
    private String name;

}
