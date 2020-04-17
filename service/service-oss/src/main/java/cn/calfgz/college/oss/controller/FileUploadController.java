package cn.calfgz.college.oss.controller;

import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.oss.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author calfgz
 * @description:
 * @date 2020-03-29 20:38
 */
@Slf4j
@RestController
@RequestMapping("/oss/file")
@CrossOrigin
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    /**
     * 文件上传
     * @param file
     */
    @PostMapping("upload")
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        String uploadUrl = fileUploadService.upload(file);
        //返回r对象
        return CommonResponse.okRsp(uploadUrl);
    }
}
