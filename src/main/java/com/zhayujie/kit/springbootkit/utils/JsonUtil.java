package com.zhayujie.kit.springbootkit.utils;
import com.alibaba.fastjson.JSON;
import com.zhayujie.kit.springbootkit.model.dto.ResultDTO;

import java.util.List;

/**
 * @author zhayujie
 * @description 基于fastjson实现的json转换工具类
 * @date 2019/12/14
 */
public class JsonUtil {
    /**
     * Json序列化
     * @param obj 对象
     * @return 序列化后的字符串
     */
    public static String marshal(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 字符串转对象
     */
    public static <T> T parseToObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    /**
     * 字符串转集合
     */
    public static <T> List<T> parseToList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }


    public static void main(String[] args) {
        ResultDTO dto = new ResultDTO(true, 200, "success");
        String res = JsonUtil.marshal(dto);
        System.out.println(res);

        ResultDTO newDto = JsonUtil.parseToObject(res, ResultDTO.class);
        System.out.println(newDto.getMessage());

        String listDto = "[{\"code\":200,\"message\":\"success\"}]";
        List<ResultDTO> dtos = JsonUtil.parseToList(listDto, ResultDTO.class);
        System.out.println(dtos.get(0).getMessage());
    }
}
