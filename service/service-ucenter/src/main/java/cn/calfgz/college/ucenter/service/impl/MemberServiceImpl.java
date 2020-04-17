package cn.calfgz.college.ucenter.service.impl;

import cn.calfgz.college.common.util.exception.CustomException;
import cn.calfgz.college.common.util.jwt.JwtUtils;
import cn.calfgz.college.ucenter.entity.Member;
import cn.calfgz.college.ucenter.mapper.MemberMapper;
import cn.calfgz.college.ucenter.service.MemberService;
import cn.calfgz.college.common.api.ucenter.vo.LoginInfoVo;
import cn.calfgz.college.common.api.ucenter.vo.LoginVo;
import cn.calfgz.college.common.api.ucenter.vo.RegisterVo;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author calfgz
 * @since 2020-04-02
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String login(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        //校验参数
        if(StrUtil.isEmpty(mobile) || StrUtil.isEmpty(password)) {
            throw new CustomException(20001,"账号密码不能为空");
        }
        //获取会员
        Member member = baseMapper.selectOne(new QueryWrapper<Member>().eq("mobile", mobile));
        if(null == member) {
            throw new CustomException(20001,"用户不存在");
        }
        //校验密码
        if(!SecureUtil.md5(password).equals(member.getPassword())) {
            throw new CustomException(20001,"验证码错误");
        }
        //校验是否被禁用
        if(member.getIsDisabled()) {
            throw new CustomException(20001,"账号被禁用");
        }
        //使用JWT生成token字符串
        String token = JwtUtils.getJwtToken(member.getId(), member.getNickname());
        return token;
    }

    @Override
    public boolean register(RegisterVo registerVo) {
        //获取注册信息，进行校验
        String nickname = registerVo.getNickname();
        String mobile = registerVo.getMobile();
        String password = registerVo.getPassword();
        String code = registerVo.getCode();
        //校验参数
        if(StrUtil.isEmpty(mobile) || StrUtil.isEmpty(password) || StrUtil.isEmpty(code)) {
            throw new CustomException(20001,"数据不能为空");
        }
        //校验校验验证码
        //从redis获取发送的验证码
        String mobleCode = redisTemplate.opsForValue().get(mobile);
        if(!code.equals(mobleCode)) {
            throw new CustomException(20001,"验证码错误");
        }
        //查询数据库中是否存在相同的手机号码
        Integer count = baseMapper.selectCount(new QueryWrapper<Member>().eq("mobile", mobile));
        if(count.intValue() > 0) {
            throw new CustomException(20001,"手机已注册");
        }
        //添加注册信息到数据库
        Member member = new Member();
        member.setNickname(nickname);
        member.setMobile(registerVo.getMobile());
        member.setPassword(SecureUtil.md5(password));
        member.setIsDisabled(false);
        member.setAvatar("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132");
        return this.save(member);
    }

    @Override
    public LoginInfoVo getLoginInfo(String memberId) {
        Member member = baseMapper.selectById(memberId);
        LoginInfoVo loginInfoVo = new LoginInfoVo();
        BeanUtils.copyProperties(member, loginInfoVo);
        return loginInfoVo;
    }

    @Override
    public Member getByOpenid(String openid) {
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("openid", openid);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public Integer countRegisterByDay(String day) {
        return baseMapper.selectRegisterCount(day);
    }
}
