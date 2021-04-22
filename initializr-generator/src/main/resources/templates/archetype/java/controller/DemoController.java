package {{packageName}}.controller;

import {{packageName}}.model.base.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yujiezha
 * @description 测试控制器
 * @date 2021/4/16
 */
@RestController
public class DemoController {
    @GetMapping("test")
    public ApiResult<String> test() {
        return ApiResult.success("success");
    }
}
