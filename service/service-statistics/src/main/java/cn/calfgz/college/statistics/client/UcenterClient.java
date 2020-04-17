package cn.calfgz.college.statistics.client;

import cn.calfgz.college.common.util.rest.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("service-ucenter")
public interface UcenterClient {

    @GetMapping(value = "/ucenter/member/countregister/{day}")
    CommonResult registerCount(@PathVariable String day);

}
