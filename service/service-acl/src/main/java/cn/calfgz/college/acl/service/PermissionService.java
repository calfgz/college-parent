package cn.calfgz.college.acl.service;

import cn.calfgz.college.acl.entity.Permission;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author calfgz
 * @since 2020-04-16
 */
public interface PermissionService extends IService<Permission> {

    List<Permission> queryAllMenu();

    boolean removeChildById(String id);

    boolean saveRolePermissionRealtionShip(String roleId, String[] permissionId);

    List<Permission> selectAllMenu(String roleId);

    //根据用户id获取用户菜单
    List<String> selectPermissionValueByUserId(String id);

    List<JSONObject> selectPermissionByUserId(String id);

    //获取全部菜单
    List<Permission> recursiveQueryAllMenu();

    //递归删除菜单
    boolean recursiveRemoveChildById(String id);

    //给角色分配权限
    boolean recursiveSaveRolePermissionRealtionShip(String roleId, String[] permissionId);
}
