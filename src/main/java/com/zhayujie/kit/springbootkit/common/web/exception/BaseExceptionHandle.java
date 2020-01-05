package com.zhayujie.kit.springbootkit.common.web.exception;

import com.zhayujie.kit.springbootkit.model.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BaseExceptionHandle {
    @ExceptionHandler(Exception.class)
    public ResultDTO errorHandle(Exception e) {
        log.error(e.getMessage());
        return new ResultDTO(true, 500, "服务器错误");
    }
}
