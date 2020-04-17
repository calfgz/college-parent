package cn.calfgz.college.ucenter.controller;

import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.ucenter.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-08 10:47
 */
@RestController
@RequestMapping("/ucenter/member")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping(value = "countregister/{day}")
    public CommonResult registerCount(@PathVariable String day){
        Integer count = memberService.countRegisterByDay(day);
        return CommonResponse.okRsp(count);
    }

}
