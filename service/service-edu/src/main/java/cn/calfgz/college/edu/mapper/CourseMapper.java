package cn.calfgz.college.edu.mapper;

import cn.calfgz.college.common.admin.edu.form.CoursePublishVo;
import cn.calfgz.college.common.api.edu.vo.CourseWebVo;
import cn.calfgz.college.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author calfgz
 * @since 2020-03-30
 */
public interface CourseMapper extends BaseMapper<Course> {

    CoursePublishVo selectCoursePublishVoById(String id);

    CourseWebVo selectInfoWebById(String courseId);

}
