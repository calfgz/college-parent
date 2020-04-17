package cn.calfgz.college.edu.service;

import cn.calfgz.college.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author calfgz
 * @since 2020-03-27
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> pageListWeb(Page<Teacher> pager);
}
