package com.wushen.ucenservice.controller;


import com.wushen.commonutils.JwtUtils;
import com.wushen.commonutils.R;
import com.wushen.ucenservice.entity.UcenterMember;
import com.wushen.ucenservice.entity.query.RegisterVo;
import com.wushen.ucenservice.service.UcenterMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-04
 */
@Api(tags = "用户中心")
@RestController
@RequestMapping("/ucenservice/member")
@CrossOrigin
@Slf4j
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService ucenterMemberService;
    @ApiOperation(value = "用户登录",notes = "根据手机号和密码登录")
    @PostMapping("/login")
    public R login(@ApiParam(name = "ucenterMember",value = "用户表单",required = true)
                   @RequestBody UcenterMember ucenterMember){
        String jwt = ucenterMemberService.login(ucenterMember);
        return R.ok().data("token",jwt);
    }
    @ApiOperation(value = "用户注册",notes = "根据注册VO进行用户注册")
    @PostMapping("/register")
    public R register(@ApiParam(name = "registerVo",value = "注册VO",required = true)
                      @RequestBody RegisterVo registerVo){
        ucenterMemberService.register(registerVo);
        return R.ok();
    }
    @ApiOperation(value = "获取用户",notes = "根据登录成功之后的token获取用户信息")
    @GetMapping("/getMemberInfo")
    public R getMemberInfo(HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember member = ucenterMemberService.getById(memberId);
        log.info(member.toString());
        return R.ok().data("member",member);
    }

}

