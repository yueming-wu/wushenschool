package com.wushen.baseservice.exception;

import com.wushen.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 @descriptions 统一全局异常处理
 @author wushen
 @create 2020-07-14 9:58
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    /**
    * @Description:Exception异常出错方法
    * @Author: wushen
    * @Email:993108679@qq.com
    * @Version: v1.00
    * @Date:  2020/7/14 10:11  
    * @Parameters:  * @param e 抛出的异常对象
    * @Return com.wushen.commonutils.R
    * @Throws
    */
     public R error(Exception e){
        e.printStackTrace();
         return R.error().message("执行了Exception异常");
     }
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    /**
     * @Description:ArithmeticException异常出错方法
     * @Author: wushen
     * @Email:993108679@qq.com
     * @Version: v1.00
     * @Date:  2020/7/14 10:11
     * @Parameters:  * @param e 抛出的异常对象
     * @Return com.wushen.commonutils.R
     * @Throws
     */
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常");
    }
    @ExceptionHandler(WuShenException.class)
    @ResponseBody
    /**
     * @Description:ArithmeticException异常出错方法
     * @Author: wushen
     * @Email:993108679@qq.com
     * @Version: v1.00
     * @Date:  2020/7/14 10:11
     * @Parameters:  * @param e 抛出的异常对象
     * @Return com.wushen.commonutils.R
     * @Throws
     */
    public R error(WuShenException e){
        log.error(e.getMsg());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
