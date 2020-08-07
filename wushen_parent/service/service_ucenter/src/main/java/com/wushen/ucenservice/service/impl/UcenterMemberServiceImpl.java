package com.wushen.ucenservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wushen.baseservice.exception.WuShenException;
import com.wushen.commonutils.JwtUtils;
import com.wushen.commonutils.MD5;
import com.wushen.ucenservice.entity.UcenterMember;
import com.wushen.ucenservice.entity.query.RegisterVo;
import com.wushen.ucenservice.mapper.UcenterMemberMapper;
import com.wushen.ucenservice.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-04
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public String login(UcenterMember ucenterMember) {
        String mobile = ucenterMember.getMobile();
        String password = ucenterMember.getPassword();
        /*前端传来的判断手机号是否为空*/
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            throw new WuShenException(20001,"登录失败,请输入用户名和密码");
        }
        /*根据前端的手机号判断该手机号是否正确*/
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        UcenterMember member = baseMapper.selectOne(wrapper);
        if (member == null) {
            throw new WuShenException(20001,"手机号不正确,请重新输入");
        }
        /*判断该手机号下的用户密码是否正确*/
        /*注意:一般存储在数据的密码肯定是加密过的,此处也应该将密码加密后再跟数据库比较*/
        if(!MD5.encrypt(password).equals(member.getPassword())){
            throw new WuShenException(20001,"密码不正确,请重新输入");
        }
        /*判断该用户是否是激活状态*/
        if(member.getIsDisabled()){
            throw  new WuShenException(20001,"请先激活您的账户");
        }
        /*登录成功后生成JWT*/
        String jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());
        return jwtToken;
    }

    @Override
    public void register(RegisterVo registerVo) {
        /*获取主要注册数据*/
        String code = registerVo.getCode();
        String mobile = registerVo.getMobile();
        String nickname = registerVo.getNickname();
        String password = registerVo.getPassword();
        /*判断当前主要数据是否为‘’*/
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(mobile) ||
           StringUtils.isEmpty(nickname) || StringUtils.isEmpty(password)){
            throw new WuShenException(20001,"请输入注册数据");
        }
        /*判断验证码是否有效即正确*/
        String redisCode = redisTemplate.opsForValue().get(mobile);
        if (!code.equals(redisCode)) {
            throw new WuShenException(20001,"验证码不正确请重新输入");
        }
        /*判断手机号是否重复即是否允许注册;默认手机号不允许重复*/
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        if(baseMapper.selectCount(wrapper) > 0){
            throw new WuShenException(20001,"该手机号以注册,请重新输入手机号");
        }
        /*注册成功将数据添加到数据库当中*/
        UcenterMember ucenterMember = new UcenterMember();
        ucenterMember.setPassword(MD5.encrypt(password));
        ucenterMember.setMobile(mobile);
        ucenterMember.setNickname(nickname);
        ucenterMember.setAvatar("https://wushen-edu.oss-cn-beijing.aliyuncs.com/2020/07/18/495e32c5a30d4b009c5dea458c8ab12ffile.png");
        ucenterMember.setIsDisabled(false);
        /*记住千万别忘记插入到数据库中*/
        baseMapper.insert(ucenterMember);
    }

    @Override
    public UcenterMember getByOpenid(String openid) {
        QueryWrapper<UcenterMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", openid);
        UcenterMember ucenterMember = baseMapper.selectOne(queryWrapper);
        return ucenterMember;
    }

    @Override
    public Integer countRegisterByDay(String day) {
        return baseMapper. countRegisterByDay(day);
    }
}
