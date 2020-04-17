package cn.calfgz.college.acl.controller;


import cn.calfgz.college.acl.entity.Permission;
import cn.calfgz.college.acl.service.PermissionService;
import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/acl/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //获取全部菜单
    @ApiOperation(value = "查询所有菜单")
    @GetMapping
    public CommonResult indexAllPermission() {
        List<Permission> list =  permissionService.queryAllMenu();
        return CommonResponse.okRsp(new JSONObject().fluentPut("children", list));
    }

    @ApiOperation(value = "递归删除菜单")
    @DeleteMapping("remove/{id}")
    public CommonResult remove(@PathVariable String id) {
        permissionService.removeChildById(id);
        return CommonResponse.okRsp();
    }

    @ApiOperation(value = "给角色分配权限")
    @PostMapping("/doAssign")
    public CommonResult doAssign(String roleId,String[] permissionId) {
        permissionService.saveRolePermissionRealtionShip(roleId,permissionId);
        return CommonResponse.okRsp();
    }

    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("toAssign/{roleId}")
    public CommonResult toAssign(@PathVariable String roleId) {
        List<Permission> list = permissionService.selectAllMenu(roleId);
        return CommonResponse.okRsp(new JSONObject().fluentPut("children", list));
    }



    @ApiOperation(value = "新增菜单")
    @PostMapping("save")
    public CommonResult save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return CommonResponse.okRsp();
    }

    @ApiOperation(value = "修改菜单")
    @PutMapping("update")
    public CommonResult updateById(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return CommonResponse.okRsp();
    }


}

