package com.wushen.aclservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.wushen.aclservice.service.IndexService;
import com.wushen.commonutils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/acl/index")
//@CrossOrigin
public class IndexController {

    @Autowired
    private IndexService indexService;
    @ApiOperation(value = "获取用户",notes = "根据token获取用户信息")
    @GetMapping("info")
    public R info(){
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = indexService.getUserInfo(username);
        return R.ok().data(userInfo);
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "获取菜单",notes = "根据用户名获取菜单")
    @GetMapping("menu")
    public R getMenu(){
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<JSONObject> permissionList = indexService.getMenu(username);
        return R.ok().data("permissionList", permissionList);
    }
    @ApiOperation(value = "登出",notes = "用户退出应用")
    @PostMapping("logout")
    public R logout(){
        return R.ok();
    }

}
