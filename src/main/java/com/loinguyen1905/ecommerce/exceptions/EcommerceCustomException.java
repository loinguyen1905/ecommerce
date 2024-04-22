package com.loinguyen1905.ecommerce.exceptions;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "statusCode", "message", "description", "timestamp" })
public class EcommerceCustomException {
    private int statusCode;
    private String timestamp;
    private String message;
    private String description;

    public EcommerceCustomException(EcommerceCustomExceptionBuilder builder) {
        this.statusCode = builder.statusCode;
        this.timestamp = builder.timestamp;
        this.message = builder.message;
        this.description = builder.description;
    }

    public static class EcommerceCustomExceptionBuilder {

        private int statusCode;
        private String timestamp;
        private String message;
        private String description;
        
        public EcommerceCustomExceptionBuilder withStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }
        
        public EcommerceCustomExceptionBuilder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }
        
        public EcommerceCustomExceptionBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public EcommerceCustomExceptionBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public EcommerceCustomException build() {
            EcommerceCustomException ecommerceCustomException = new EcommerceCustomException(this);
            return ecommerceCustomException;
        }
    }
}