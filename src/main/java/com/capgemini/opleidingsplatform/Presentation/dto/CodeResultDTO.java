package com.capgemini.opleidingsplatform.Presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CodeResultDTO {

    @NotBlank
    private double executionTime;
    @NotBlank
    private double memoryUsage;
}
