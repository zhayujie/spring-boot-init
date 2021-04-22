package {{packageName}}.model.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhayujie
 * @description 标准响应结构
 * @date 2019/12/14
 */
@Data
public class ApiResult<T> implements Serializable {
    public static final Integer DEFAULT_SUCCESS_CODE = 200;
    public static final Integer DEFAULT_ERROR_CODE = 500;

    private boolean success;

    private Integer code;

    private String msg;

    private T data;

    public static <T> ApiResult<T> success() {
        return new ApiResult<>(true, DEFAULT_SUCCESS_CODE, "", null);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, DEFAULT_SUCCESS_CODE, "", data);
    }

    public static <T> ApiResult<T> success(String msg, T data) {
        return new ApiResult<>(true, DEFAULT_SUCCESS_CODE, msg, data);
    }

    public static <T> ApiResult<T> error(String msg) {
        return new ApiResult<>(false, DEFAULT_ERROR_CODE, msg, null);
    }

    public static <T> ApiResult<T> error(Integer code, String msg) {
        return new ApiResult<>(false, code, msg, null);
    }

    public ApiResult(boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.msg = message;
        this.data = data;
    }
}
