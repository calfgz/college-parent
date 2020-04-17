package cn.calfgz.college.edu.controller;


import cn.calfgz.college.common.util.exception.CustomException;
import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.edu.entity.Teacher;
import cn.calfgz.college.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-03-26
 */
@RestController
@RequestMapping("/edu/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public CommonResult save(@RequestBody Teacher teacher) {
        boolean save = teacherService.save(teacher);
        if (save) {
            return CommonResponse.okRsp();
        } else {
            return CommonResponse.errRsp("创建失败。");
        }
    }

    @GetMapping("/{id}")
    public CommonResult findById(@PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        if (teacher != null) {
            return CommonResponse.okRsp(teacher);
        } else {
            return CommonResponse.errRsp("data not found.");
        }
    }

    @PutMapping("/{id}")
    public CommonResult updateById(@PathVariable String id,
                                   @RequestBody Teacher teacher) {
        teacher.setId(id);
        boolean update = teacherService.updateById(teacher);
        if (update) {
            return CommonResponse.okRsp();
        } else {
            return CommonResponse.errRsp("更新失败");
        }
    }

    @GetMapping("/find-all")
    public CommonResult findAllTeacher() {
        return CommonResponse.okRsp(teacherService.list());
    }

    @DeleteMapping("/{id}")
    public CommonResult deleteById(@PathVariable("id") String id) {
        return CommonResponse.okRsp(teacherService.removeById(id));
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public CommonResult getPager(@PathVariable("pageNo") int pageNo,
                                 @PathVariable(name = "pageSize") int pageSize) {
        Page<Teacher> page = new Page<Teacher>(pageNo, pageSize);
        teacherService.page(page);
        return CommonResponse.okRsp(page);
    }

    @GetMapping("/exception")
    public Integer test() {
        try {
            return  10 / 0;
        } catch (Exception e) {
            throw new CustomException(1, "代码异常");
        }
    }

}

