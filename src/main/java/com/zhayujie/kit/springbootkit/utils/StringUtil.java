package com.zhayujie.kit.springbootkit.utils;

/**
 * @author zhayujie
 * @description 字符串工具类
 * @date 2019/12/14
 */
public final class StringUtil {
    public static boolean isEmpty(String str) {
        return (str == null || str.length() <= 0);
    }

    public static void main(String[] args) {
        System.out.println(isEmpty("zyj"));
        System.out.println(isEmpty(""));
        System.out.println(isEmpty(null));
    }
}