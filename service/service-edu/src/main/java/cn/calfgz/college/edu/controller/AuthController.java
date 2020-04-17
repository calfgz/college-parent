package cn.calfgz.college.edu.controller;

import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author calfgz
 * @description:
 * @date 2020-03-29 09:16
 */
@Slf4j
@RestController
@RequestMapping("/edu/auth")
@CrossOrigin
public class AuthController {

    @PostMapping("/login")
    public CommonResult login() {
        JSONObject json = new JSONObject(2);
        json.put("token", "admin");
        return CommonResponse.okRsp(json);
    }

    @GetMapping("/info")
    public CommonResult info() {
        JSONObject json = new JSONObject();
        json.put("roles", Arrays.asList("admin"));
        json.put("introduction", "super administrator");
        json.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        json.put("name", "admin");
        return CommonResponse.okRsp(json);
    }

    @PostMapping("/logout")
    public CommonResult logout() {
        return CommonResponse.okRsp("success");
    }
}
