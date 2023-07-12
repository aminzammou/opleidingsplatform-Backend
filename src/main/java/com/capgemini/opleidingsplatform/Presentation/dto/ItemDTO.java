package com.capgemini.opleidingsplatform.Presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ItemDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private String code;
    private String subCategoryId;

    private Boolean inplace;

    private Boolean stable;

}
