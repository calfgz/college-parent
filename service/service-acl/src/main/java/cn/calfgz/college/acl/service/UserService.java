package cn.calfgz.college.acl.service;

import cn.calfgz.college.acl.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author calfgz
 * @since 2020-04-16
 */
public interface UserService extends IService<User> {

    User selectByUsername(String username);
}
