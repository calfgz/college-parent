package cn.calfgz.college.acl.service;

import cn.calfgz.college.acl.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author calfgz
 * @since 2020-04-16
 */
public interface RoleService extends IService<Role> {

    List<Role> selectRoleByUserId(String id);

    //根据用户获取角色数据
    Map<String, Object> findRoleByUserId(String userId);

    //根据用户分配角色
    void saveUserRoleRealtionShip(String userId, String[] roleId);
}
