package cn.calfgz.college.msm.controller;

import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.msm.service.MsmService;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-02 15:25
 */
@RestController
@RequestMapping("/msm/api")
@CrossOrigin
public class MsmController {

    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping(value = "/send/{phone}")
    public CommonResult code(@PathVariable String phone) {
        String code = redisTemplate.opsForValue().get(phone);
        if(!StrUtil.isEmpty(code)) {
            return CommonResponse.okRsp();
        }
        code = RandomUtil.randomNumbers(5);
        Map<String,Object> param = new HashMap<>();
        param.put("code", code);
        boolean isSend = msmService.send(phone, param);
        if(isSend) {
            redisTemplate.opsForValue().set(phone, code,5, TimeUnit.MINUTES);
            return CommonResponse.okRsp();
        } else {
            return CommonResponse.errRsp("发送短信失败");
        }
    }
}
