package com.loinguyen1905.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

@Data
@JsonPropertyOrder({ "httpHeaders", "statusCode", "otherParams", "message", "data" })
@SuppressWarnings({ "rawtypes", "unchecked" })
@AllArgsConstructor
public class ApiResponse<T> {

    private final HttpHeaders httpHeaders;
    private final int statusCode;
    private final String message;
    private final T data;
    Map<String, Object> otherParams;

    private ApiResponse(ApiResponseBuilder builder) {
        this.httpHeaders = builder.httpHeaders;
        this.statusCode = builder.statusCode;
        this.message = builder.message;
        this.data = (T) builder.data;
        this.otherParams = builder.otherParams;
    }

    public static class ApiResponseBuilder<T> {

        private HttpHeaders httpHeaders = new HttpHeaders();
        private final int statusCode;
        private final String message;
        private T data;
        private Map<String, Object> otherParams = Collections.emptyMap();
    
    
        public ApiResponseBuilder(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }
    
        public ApiResponseBuilder<T> withHttpHeader(HttpHeaders httpHeader) {
            this.httpHeaders = httpHeader;
            return this;
        }
    
        public ApiResponseBuilder<T> withData(T data) {
            this.data = data;
            return this;
        }
    
        public ApiResponseBuilder<T> withOtherParams(Map<String, Object> otherParams) {
            this.otherParams = otherParams;
            return this;
        }
    
        public ResponseEntity<ApiResponse> build() {
            ApiResponse<T> apiResponse = new ApiResponse<>(this);
            return ResponseEntity.status(apiResponse.getStatusCode()).headers(apiResponse.getHttpHeaders()).body(apiResponse);
        }
    }
}