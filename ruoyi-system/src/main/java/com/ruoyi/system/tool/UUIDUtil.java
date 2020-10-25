package com.ruoyi.system.tool;

import java.util.UUID;

/**
 * @Author 文欢
 * @Description TODO
 * @Date 2020/09/15 0015 15:42
 * @ClassName UUID
 **/
public class UUIDUtil {
    public static String UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
