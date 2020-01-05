package com.zhayujie.kit.springbootkit.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhayujie
 * @description 文件读写工具类
 * @date 2019/12/14
 */
@Slf4j
public class FileUtil {
    /**
     * 读取json文件
     * @return 文件内容字符串
     */
    public static String read(String url) {
        try (BufferedReader in = new BufferedReader(new FileReader(url))) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
    }
}
