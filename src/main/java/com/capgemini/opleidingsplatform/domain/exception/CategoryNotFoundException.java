package com.capgemini.opleidingsplatform.domain.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class CategoryNotFoundException extends ChangeSetPersister.NotFoundException {

    public CategoryNotFoundException(String msg) {
        super();
    }
}
