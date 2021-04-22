package {{packageName}}.common.exception;

import {{packageName}}.model.base.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BaseExceptionHandle {
    @ExceptionHandler(Exception.class)
    public ApiResult<String> errorHandle(Exception e) {
        log.error(e.getMessage());
        return ApiResult.error(e.getMessage());
    }
}