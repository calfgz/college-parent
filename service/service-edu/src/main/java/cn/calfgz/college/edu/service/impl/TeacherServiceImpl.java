package cn.calfgz.college.edu.service.impl;

import cn.calfgz.college.edu.entity.Teacher;
import cn.calfgz.college.edu.mapper.TeacherMapper;
import cn.calfgz.college.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author calfgz
 * @since 2020-03-27
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public Page<Teacher> pageListWeb(Page<Teacher> pager) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        baseMapper.selectPage(pager, queryWrapper);
        return pager;
    }
}
