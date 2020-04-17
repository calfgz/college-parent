package cn.calfgz.college.edu.service;

import cn.calfgz.college.common.admin.edu.form.CourseInfoForm;
import cn.calfgz.college.common.admin.edu.form.CoursePublishVo;
import cn.calfgz.college.common.admin.edu.query.CourseQuery;
import cn.calfgz.college.common.api.edu.vo.CourseQueryVo;
import cn.calfgz.college.common.api.edu.vo.CourseWebVo;
import cn.calfgz.college.edu.entity.Course;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author calfgz
 * @since 2020-03-30
 */
public interface CourseService extends IService<Course> {
    /**
     * 保存课程和课程详情信息
     * @param courseInfoForm
     * @return 新生成的课程id
     */
    String saveCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoFormById(String id);

    void updateCourseInfoById(CourseInfoForm courseInfoForm);

    CoursePublishVo getCoursePublishVoById(String id);

    Boolean publishCourseById(String id);

    void pageQuery(Page<Course> page, CourseQuery query);

    Boolean removeCourseById(String id);

    List<Course> selectByTeacherId(String id);

    Page<Course> pageListWeb(Page<Course> pager, CourseQueryVo courseQuery);

    CourseWebVo selectInfoWebById(String id);

    void updatePageViewCount(String id);
}
