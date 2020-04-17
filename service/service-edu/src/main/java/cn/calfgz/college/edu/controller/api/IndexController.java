package cn.calfgz.college.edu.controller.api;

import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.edu.entity.Course;
import cn.calfgz.college.edu.entity.Teacher;
import cn.calfgz.college.edu.service.CourseService;
import cn.calfgz.college.edu.service.TeacherService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-02 11:24
 */
@RestController
@RequestMapping("/api/edu/index")
@CrossOrigin
public class IndexController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    //查询前8条热门课程，查询前4条名师
    @GetMapping()
    public CommonResult index() {
        //查询前8条热门课程
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 8");
        List<Course> eduList = courseService.list(wrapper);

        //查询前4条名师
        QueryWrapper<Teacher> wrapperTeacher = new QueryWrapper<>();
        wrapperTeacher.orderByDesc("id");
        wrapperTeacher.last("limit 4");
        List<Teacher> teacherList = teacherService.list(wrapperTeacher);
        JSONObject json = new JSONObject(4)
                .fluentPut("courseList", eduList)
                .fluentPut("teacherList", teacherList);
        return CommonResponse.okRsp(json);
    }
}
