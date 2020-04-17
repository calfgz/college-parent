package cn.calfgz.college.edu.controller.api;

import cn.calfgz.college.common.admin.edu.vo.ChapterVo;
import cn.calfgz.college.common.admin.edu.vo.SubjectNestedVo;
import cn.calfgz.college.common.api.edu.vo.CourseQueryVo;
import cn.calfgz.college.common.api.edu.vo.CourseWebVo;
import cn.calfgz.college.common.api.edu.vo.CourseWebVoOrder;
import cn.calfgz.college.common.util.jwt.JwtUtils;
import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.edu.client.OrdersClient;
import cn.calfgz.college.edu.entity.Course;
import cn.calfgz.college.edu.service.ChapterService;
import cn.calfgz.college.edu.service.CourseService;
import cn.calfgz.college.edu.service.SubjectService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-03 14:28
 */
@RestController
@RequestMapping("/api/edu/course")
@CrossOrigin
public class CourseApiController {

    @Autowired
    private OrdersClient ordersClient;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ChapterService chapterService;

    @ApiOperation(value = "分页课程列表")
    @PostMapping(value = "{page}/{limit}")
    public CommonResult pageList(
        @ApiParam(name = "page", value = "当前页码", required = true)
        @PathVariable Long page,
        @ApiParam(name = "limit", value = "每页记录数", required = true)
        @PathVariable Long limit,
        @ApiParam(name = "courseQuery", value = "查询对象", required = false)
        @RequestBody(required = false) CourseQueryVo courseQuery){
        Page<Course> pager = new Page<>(page, limit);
        pager = courseService.pageListWeb(pager, courseQuery);
        return CommonResponse.okRsp(pager);
    }

    @GetMapping("/nestedList")
    public CommonResult nestedList(){
        List<SubjectNestedVo> list = subjectService.nestedList();
        return CommonResponse.okRsp(list);
    }

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping(value = "{courseId}")
    public CommonResult getById(
            @ApiParam(name = "courseId", value = "课程ID", required = true)
        @PathVariable String courseId, HttpServletRequest request){
        //查询课程信息和讲师信息
        CourseWebVo courseWebVo = courseService.selectInfoWebById(courseId);
        //查询当前课程的章节信息
        List<ChapterVo> chapterVoList = chapterService.nestedList(courseId);

        boolean isBuy = ordersClient.isBuyCourse(courseId, JwtUtils.getMemberIdByJwtToken(request));
        JSONObject json = new JSONObject(5)
                .fluentPut("course", courseWebVo)
                .fluentPut("chapterVoList", chapterVoList)
                .fluentPut("isBuy", isBuy);
        return CommonResponse.okRsp(json);
    }

    //根据课程id查询课程信息
    @PostMapping("getCourseInfoOrder/{id}")
    public CourseWebVoOrder getCourseInfoOrder(@PathVariable String id) {
        CourseWebVo courseWebVo = courseService.selectInfoWebById(id);
        CourseWebVoOrder courseWebVoOrder = new CourseWebVoOrder();
        BeanUtils.copyProperties(courseWebVo,courseWebVoOrder);
        return courseWebVoOrder;
    }

}
