package com.wushen.eduservice.controller;

import com.wushen.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 @descriptions 后台系统登录控制器
 @author wushen
 @create 2020-07-15 7:46
 */
@Api(value = "用户登录",tags = "登录管理")
@RestController
//此处必须包含user
@RequestMapping("/eduservice/user")
@CrossOrigin //解决跨域问题
public class EduLoginController {
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")//必须对应login
    /**
    * @Description: 用户前端Vue要调用的api接口请求login;处理Vue的login登录请求;axios异步请求
    * @Author: wushen
    * @Email:993108679@qq.com
    * @Version: v1.00
    * @Date:  2020/7/15 7:51
    * @Parameters:  * @param
    * @Return com.wushen.commonutils.R;必须返回的是token
    * @Throws
    */
    public R login(){
        return R.ok().data("token","admin");
    }
    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")//必须对应info
    /**
    * @Description:用户前端Vue要调用的api接口请求info;处理Vue的info信息返回请求;axios异步请求
    * @Author: wushen
    * @Email:993108679@qq.com
    * @Version: v1.00
    * @Date:  2020/7/15 7:54
    * @Parameters:  * @param
    * @Return com.wushen.commonutils.R;必须返回的是roles,name,avatar
    * @Throws
    */
    public R info(){
        return R.ok().data("roles","[admin]").data("name","wushen").data("avatar",
                "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
