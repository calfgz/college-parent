package cn.calfgz.college.edu.controller;


import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.common.admin.edu.form.VideoInfoForm;
import cn.calfgz.college.edu.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/edu/video")
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("save-video-info")
    public CommonResult save(@RequestBody VideoInfoForm videoInfoForm){
        videoService.saveVideoInfo(videoInfoForm);
        return CommonResponse.okRsp();
    }

    @ApiOperation(value = "根据ID查询课时")
    @GetMapping("video-info/{id}")
    public CommonResult getVideInfoById(@PathVariable String id){
        VideoInfoForm videoInfoForm = videoService.getVideoInfoFormById(id);
        return CommonResponse.okRsp(videoInfoForm);
    }

    @PutMapping("update-video-info/{id}")
    public CommonResult updateCourseInfoById(@RequestBody VideoInfoForm videoInfoForm, @PathVariable String id){
        videoService.updateVideoInfoById(videoInfoForm);
        return CommonResponse.okRsp();
    }

    @DeleteMapping("{id}")
    public CommonResult removeById(@PathVariable String id){
        boolean result = videoService.removeVideoById(id);
        if(result){
            return CommonResponse.okRsp();
        }else{
            return CommonResponse.errRsp("删除失败");
        }
    }

}

