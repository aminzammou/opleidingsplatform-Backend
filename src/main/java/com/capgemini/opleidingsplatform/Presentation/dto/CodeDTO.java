package com.capgemini.opleidingsplatform.Presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CodeDTO {

    @NotBlank
    private String Code;
    @NotBlank
    private int Time;
}
