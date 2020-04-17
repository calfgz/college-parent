package cn.calfgz.college.edu.controller;


import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.edu.service.SubjectService;
import cn.calfgz.college.common.admin.edu.vo.SubjectNestedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/edu/subject")
@CrossOrigin
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 导入课程分类
     * @param file
     * @return
     */
    @PostMapping("/import")
    public CommonResult importSubject(MultipartFile file) {
        //1 获取上传的excel文件 MultipartFile
        //返回错误提示信息
        subjectService.importSubjectData(subjectService, file);

        return CommonResponse.okRsp();
    }

    /**
     * 分类嵌套列表
     * @return
     */
    @GetMapping()
    public CommonResult nestedList(){
        List<SubjectNestedVo> list = subjectService.nestedList();
        return CommonResponse.okRsp(list);
    }
}

