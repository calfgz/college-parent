package cn.calfgz.college.edu.client;

import cn.calfgz.college.common.util.rest.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-vod", fallback = VodFileDegradeFeignClient.class)
@Component
public interface VodClient {

    @DeleteMapping(value = "/vod/video/{videoId}")
    public CommonResult removeVideo(@PathVariable("videoId") String videoId);

    @DeleteMapping(value = "/vod/video/delete-batch")
    public CommonResult removeVideoList(@RequestParam("videoIdList") List<String> videoIdList);

}
