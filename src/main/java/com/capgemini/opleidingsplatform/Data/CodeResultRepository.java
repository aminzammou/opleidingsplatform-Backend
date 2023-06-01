package com.capgemini.opleidingsplatform.Data;

import com.capgemini.opleidingsplatform.Presentation.dto.CodeResultDTO;

import java.util.Optional;

public interface CodeResultRepository {
    Optional<CodeResultDTO> getResult(String Code, int Time);
}
