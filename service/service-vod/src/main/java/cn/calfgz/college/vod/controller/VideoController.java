package cn.calfgz.college.vod.controller;

import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.vod.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-01 12:16
 */
@Slf4j
@RestController
@RequestMapping("/vod/video")
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("upload")
    public CommonResult uploadVideo(@RequestParam("file") MultipartFile file) throws Exception {
        String videoId = videoService.uploadVideo(file);
        return CommonResponse.okRsp(videoId);
    }

    @DeleteMapping("{videoId}")
    public CommonResult removeVideo(@PathVariable String videoId){
        videoService.removeVideo(videoId);
        return CommonResponse.okRsp("视频删除成功");
    }
    /**
     * 批量删除视频
     * @param videoIdList
     * @return
     */
    @DeleteMapping("delete-batch")
    public CommonResult removeVideoList(@RequestParam("videoIdList") List videoIdList){
        videoService.removeVideoList(videoIdList);
        return CommonResponse.okRsp();
    }
}
