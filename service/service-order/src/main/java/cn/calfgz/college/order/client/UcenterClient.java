package cn.calfgz.college.order.client;

import cn.calfgz.college.common.api.ucenter.vo.MemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("service-ucenter")
public interface UcenterClient {
    /**
     * 根据用户id获取用户信息
     */
    @PostMapping("/api/ucenter/member/getUserInfoOrder/{id}")
    MemberOrder getUserInfoOrder(@PathVariable("id") String id);
}
