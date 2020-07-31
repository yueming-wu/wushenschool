package com.wushen.commonutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 @descriptions 统一输出异常信息工具类
 @author wushen
 @create 2020-07-14 11:35
 */
public class ExceptionUtil {
    /**
    * @Description:获取异常信息;静态方法;类可直接调用
    * @Author: wushen
    * @Email:993108679@qq.com
    * @Version: v1.00
    * @Date:  2020/7/14 11:36
    * @Parameters:  * @param e
    * @Return java.lang.String
    * @Throws
    */
    public static String getMessage(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            // 将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }
}
