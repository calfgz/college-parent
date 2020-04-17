package cn.calfgz.college.order.client;

import cn.calfgz.college.common.api.edu.vo.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-06 15:17
 */
@Component
@FeignClient("service-edu")
public interface EduClient {

    /**
     *根据课程id查询课程信息
     */
    @PostMapping("/api/edu/course/getCourseInfoOrder/{id}")
    CourseWebVoOrder getCourseInfoOrder(@PathVariable("id") String id);

}
