package cn.calfgz.college.edu.controller.api;

import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.edu.entity.Course;
import cn.calfgz.college.edu.entity.Teacher;
import cn.calfgz.college.edu.service.CourseService;
import cn.calfgz.college.edu.service.TeacherService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-03 12:03
 */
@RestController
@RequestMapping("/api/edu/teacher")
@CrossOrigin
public class TeacherApiController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "{page}/{limit}")
    public CommonResult pageList(@PathVariable Long page, @PathVariable Long limit){
        Page<Teacher> pager = new Page<>(page, limit);
        pager = teacherService.pageListWeb(pager);
        return CommonResponse.okRsp(pager);
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping(value = "{id}")
    public CommonResult getById(@PathVariable String id){
        //查询讲师信息
        Teacher teacher = teacherService.getById(id);
        //根据讲师id查询这个讲师的课程列表
        List<Course> courseList = courseService.selectByTeacherId(id);
        JSONObject json = new JSONObject(4)
                .fluentPut("teacher", teacher)
                .fluentPut("courseList", courseList);
        return CommonResponse.okRsp(json);
    }
}
