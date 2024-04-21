package com.loinguyen1905.ecommerce.models;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@SuppressWarnings("rawtypes")
public class ResponseBuilder {
    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int statusCode, String message, Object data, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (statusCode, message).withHttpHeader(httpHeader)
                .withData(data).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int statusCode, String message, Object data, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (statusCode, message)
                .withData(data).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int statusCode, String message, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (statusCode, message)
                .withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int statusCode, String message, Object data) {
        return new ApiResponse.ApiResponseBuilder <> (statusCode, message)
                .withHttpHeader(httpHeader).withData(data).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int statusCode, String message, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (statusCode, message)
                .withHttpHeader(httpHeader).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int statusCode, String message) {
        return new ApiResponse.ApiResponseBuilder <> (statusCode, message)
                .withHttpHeader(httpHeader).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int statusCode, String message, Object data) {
        return new ApiResponse.ApiResponseBuilder <> (statusCode, message)
                .withData(data).build();
    }
}