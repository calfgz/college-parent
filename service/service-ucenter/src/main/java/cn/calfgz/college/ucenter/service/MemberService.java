package cn.calfgz.college.ucenter.service;

import cn.calfgz.college.ucenter.entity.Member;
import cn.calfgz.college.common.api.ucenter.vo.LoginInfoVo;
import cn.calfgz.college.common.api.ucenter.vo.LoginVo;
import cn.calfgz.college.common.api.ucenter.vo.RegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author calfgz
 * @since 2020-04-02
 */
public interface MemberService extends IService<Member> {

    String login(LoginVo loginVo);

    boolean register(RegisterVo registerVo);

    LoginInfoVo getLoginInfo(String memberId);

    Member getByOpenid(String openid);

    Integer countRegisterByDay(String day);
}
