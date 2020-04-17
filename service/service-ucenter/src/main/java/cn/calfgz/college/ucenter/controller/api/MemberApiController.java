package cn.calfgz.college.ucenter.controller.api;


import cn.calfgz.college.common.api.ucenter.vo.LoginInfoVo;
import cn.calfgz.college.common.api.ucenter.vo.LoginVo;
import cn.calfgz.college.common.api.ucenter.vo.MemberOrder;
import cn.calfgz.college.common.api.ucenter.vo.RegisterVo;
import cn.calfgz.college.common.util.exception.CustomException;
import cn.calfgz.college.common.util.jwt.JwtUtils;
import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.ucenter.entity.Member;
import cn.calfgz.college.ucenter.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-04-02
 */
@RestController
@RequestMapping("/api/ucenter/member")
@CrossOrigin
public class MemberApiController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "会员登录")
    @PostMapping("login")
    public CommonResult<String> login(@RequestBody LoginVo loginVo) {
        String token = memberService.login(loginVo);
        return CommonResponse.okRsp(token);
    }

    @ApiOperation(value = "会员注册")
    @PostMapping("register")
    public CommonResult register(@RequestBody RegisterVo registerVo){
        boolean registed = memberService.register(registerVo);
        if (registed) {
            return CommonResponse.okRsp();
        } else {
            return CommonResponse.errRsp("注册失败");
        }
    }

    @ApiOperation(value = "根据token获取登录信息")
    @GetMapping("auth/getLoginInfo")
    public CommonResult getLoginInfo(HttpServletRequest request){
        try {
            String memberId = JwtUtils.getMemberIdByJwtToken(request);
            LoginInfoVo loginInfoVo = memberService.getLoginInfo(memberId);
            return CommonResponse.okRsp(loginInfoVo);
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException(20001,"error");
        }
    }

    //根据用户id获取用户信息
    @PostMapping("getUserInfoOrder/{id}")
    public MemberOrder getUserInfoOrder(@PathVariable String id) {
        Member member = memberService.getById(id);
        //把member对象里面值复制给UcenterMemberOrder对象
        MemberOrder memberOrder = new MemberOrder();
        BeanUtils.copyProperties(member, memberOrder);
        return memberOrder;
    }

}

