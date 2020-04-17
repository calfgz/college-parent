package cn.calfgz.college.edu.service.impl;

import cn.calfgz.college.edu.entity.Comment;
import cn.calfgz.college.edu.mapper.CommentMapper;
import cn.calfgz.college.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author calfgz
 * @since 2020-03-30
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
