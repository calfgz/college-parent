package cn.calfgz.college.common.admin.edu.form;

/**
 * @author calfgz
 * @description:
 * @date 2020-03-30 22:00
 */

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "课程发布信息")
@Data
public class CoursePublishVo  implements Serializable {
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
