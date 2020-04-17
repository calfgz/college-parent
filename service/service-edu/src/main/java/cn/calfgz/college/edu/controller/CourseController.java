package cn.calfgz.college.edu.controller;


import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.edu.entity.Course;
import cn.calfgz.college.common.admin.edu.form.CourseInfoForm;
import cn.calfgz.college.common.admin.edu.form.CoursePublishVo;
import cn.calfgz.college.common.admin.edu.query.CourseQuery;
import cn.calfgz.college.edu.service.CourseService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/edu/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save-course-info")
    public CommonResult saveCourseInfo(@RequestBody CourseInfoForm courseInfoForm){
        String courseId = courseService.saveCourseInfo(courseInfoForm);
        if(!StrUtil.isEmpty(courseId)){
            return CommonResponse.okRsp(courseId);
        }else{
            return CommonResponse.errRsp("保存失败");
        }
    }

    @GetMapping("/course-info/{id}")
    public CommonResult getById(@PathVariable String id){
        return CommonResponse.okRsp(courseService.getCourseInfoFormById(id));
    }

    @PutMapping("/update-course-info/{id}")
    public CommonResult updateCourseInfoById(@RequestBody CourseInfoForm courseInfoForm, @PathVariable String id){
        courseInfoForm.setId(id);
        courseService.updateCourseInfoById(courseInfoForm);
        return CommonResponse.okRsp(courseInfoForm.getId());
    }

    @GetMapping("course-publish-info/{id}")
    public CommonResult getCoursePublishVoById(@PathVariable String id){
        CoursePublishVo courseInfoForm = courseService.getCoursePublishVoById(id);
        return CommonResponse.okRsp(courseInfoForm);
    }

    @PutMapping("publish-course/{id}")
    public CommonResult publishCourseById(@PathVariable String id){
        courseService.publishCourseById(id);
        return CommonResponse.okRsp();
    }

    @GetMapping("{pageNo}/{pageSize}")
    public CommonResult pageQuery(@PathVariable Integer pageNo, @PathVariable Integer pageSize,
        CourseQuery courseQuery){
        Page<Course> page = new Page<>(pageNo, pageSize);
        courseService.pageQuery(page, courseQuery);
        return CommonResponse.okRsp(page);
    }

    @DeleteMapping("{id}")
    public CommonResult removeById(@PathVariable String id){
          boolean result = courseService.removeCourseById(id);
        if(result){
            return CommonResponse.okRsp();
        }else{
            return CommonResponse.errRsp("删除失败");
        }
    }

    //根据课程id查询课程信息
    @GetMapping("getDto/{courseId}")
    public CourseInfoForm getCourseInfoDto(@PathVariable String courseId) {
        CourseInfoForm courseInfoForm = courseService.getCourseInfo(courseId);
        CourseInfoForm courseInfo = new CourseInfoForm();
        BeanUtils.copyProperties(courseInfoForm,courseInfo);
        return courseInfo;
    }
}

