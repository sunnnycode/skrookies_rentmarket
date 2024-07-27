package com.rentmarket.backend.common.error;

public interface ErrorCodeIfs {

    Integer getHttpStatusCode();

    Integer getErrorCode();

    String getDescription();
}