package com.devsuperior.bds04.controller.handlers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant now, int value, String validationException, String message, String requestURI) {
        super(now, value, validationException, message, requestURI);
    }


    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String errorMessage){
        errors.add(new FieldMessage(fieldName, errorMessage));
    }
}
