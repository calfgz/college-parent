package cn.calfgz.college.edu.service;

import cn.calfgz.college.edu.entity.Chapter;
import cn.calfgz.college.common.admin.edu.vo.ChapterVo;
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
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> nestedList(String courseId);

    boolean removeChapterById(String id);

    Boolean removeByCourseId(String id);
}
