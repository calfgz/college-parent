package cn.calfgz.college.edu.service;

import cn.calfgz.college.edu.entity.Subject;
import cn.calfgz.college.common.admin.edu.vo.SubjectNestedVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author calfgz
 * @since 2020-03-30
 */
public interface SubjectService extends IService<Subject> {

    void importSubjectData(SubjectService subjectService, MultipartFile file);

    List<SubjectNestedVo> nestedList();
}
