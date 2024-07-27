package com.rentmarket.backend.common.exception;

import com.rentmarket.backend.common.error.ErrorCodeIfs;

public interface ApiExceptionIfs {

    ErrorCodeIfs getErrorCodeIfs();
    String getErrorDescription();
}