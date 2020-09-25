package cn.edu.nwafu.hjpg.utils;

import java.util.UUID;

/**
 * @author Johnny
 * @title: PasswordUtils
 * @projectName hjpg
 * @description: 密码工具类
 * @date 8/17/20208:24 PM
 */
public class PasswordUtils {
    /**
     * 匹配密码
     * @param salt 盐
     * @param rawPass 明文
     * @param encPass 密文
     * @return
     */
    public static boolean matches(String salt, String rawPass, String encPass) {
        return new PasswordEncoder(salt).matches(encPass, rawPass);
    }

    /**
     * 明文密码加密
     * @param rawPass 明文
     * @param salt
     * @return
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }

    /**
     * 获取加密盐
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
