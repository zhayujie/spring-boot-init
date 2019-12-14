package com.zhayujie.kit.springbootkit.common.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BaseExceptionHandle {
    @ExceptionHandler(Exception.class)
    public String errorHandle(Exception e) {
        log.error(e.getMessage());
        return "error";
    }
}
