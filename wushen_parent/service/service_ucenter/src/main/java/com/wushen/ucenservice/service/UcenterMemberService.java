package com.wushen.ucenservice.service;

import com.wushen.ucenservice.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wushen.ucenservice.entity.query.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-04
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember ucenterMember);

    void register(RegisterVo registerVo);

    UcenterMember getByOpenid(String openid);

    Integer countRegisterByDay(String day);
}
