package cn.calfgz.college.edu.client;

import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-01 15:33
 */
@Component
public class VodFileDegradeFeignClient implements VodClient {
    @Override
    public CommonResult removeVideo(String videoId) {
        return CommonResponse.errRsp("time out");
    }

    @Override
    public CommonResult removeVideoList(List<String> videoIdList) {
        return CommonResponse.errRsp("time out");
    }
}
