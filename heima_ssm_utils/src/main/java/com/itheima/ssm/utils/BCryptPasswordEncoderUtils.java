package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author liuxingxing
 * @date 2020-01-27 21:31
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String passwoed = "123";
        String s = encodePassword(passwoed);
        System.out.println(s.length());
        System.out.println(s);//此时需要将数据库中的密码字段改为60以上
    }
}
