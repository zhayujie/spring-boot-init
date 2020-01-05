package {{packageName}}.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhayujie
 * @description 响应前端的数据结构
 * @date 2019/12/14
 */
@Data
public class ResultDTO implements Serializable {
    private Boolean flag;

    private Integer code;

    private String message;

    private Object data;

    public ResultDTO(Boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultDTO(Boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}