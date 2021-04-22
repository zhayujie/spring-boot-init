package {{packageName}}.common.exception;

/**
 * @author yujiezha
 * @description 应用异常
 * @date 2021/4/22
 */
public class AppException extends RuntimeException {
    public AppException() {
        super();
    }

    public AppException(String msg) {
        super(msg);
    }

    public AppException(String msg, Throwable t) {
        super(msg, t);
    }
}
