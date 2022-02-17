package com.example.restapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String resourceName;
    private String fieldName;
    private Object fielsValue;



    public ResourceNotFoundException( String resourceName, String fieldName, Object fielsValue) {
        super(String.format("%s not found with %s : '%s'", resourceName,fieldName,fielsValue ));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fielsValue = fielsValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFielsValue() {
        return fielsValue;
    }
}
