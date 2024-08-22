package com.devsuperior.bds04.controller.handlers;

public class FieldMessage {


    private String fieldName;
    private String message;

    public FieldMessage() {

    }

    public FieldMessage(String fielName, String message) {
        this.fieldName = fielName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}