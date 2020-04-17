package cn.calfgz.college.acl.controller;


import cn.calfgz.college.acl.entity.Role;
import cn.calfgz.college.acl.service.RoleService;
import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/acl/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取角色分页列表")
    @GetMapping("{page}/{limit}")
    public CommonResult index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            Role role) {
        Page<Role> pageParam = new Page<>(page, limit);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if(!StrUtil.isEmpty(role.getRoleName())) {
            wrapper.like("role_name",role.getRoleName());
        }
        roleService.page(pageParam,wrapper);
        return CommonResponse.okRsp(new JSONObject()
                .fluentPut("items", pageParam.getRecords())
                .fluentPut("total", pageParam.getTotal()));
    }

    @ApiOperation(value = "获取角色")
    @GetMapping("get/{id}")
    public CommonResult get(@PathVariable String id) {
        Role role = roleService.getById(id);
        return CommonResponse.okRsp(new JSONObject().fluentPut("item", role));
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("save")
    public CommonResult save(@RequestBody Role role) {
        roleService.save(role);
        return CommonResponse.okRsp();
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("update")
    public CommonResult updateById(@RequestBody Role role) {
        roleService.updateById(role);
        return CommonResponse.okRsp();
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("remove/{id}")
    public CommonResult remove(@PathVariable String id) {
        roleService.removeById(id);
        return CommonResponse.okRsp();
    }

    @ApiOperation(value = "根据id列表删除角色")
    @DeleteMapping("batchRemove")
    public CommonResult batchRemove(@RequestBody List<String> idList) {
        roleService.removeByIds(idList);
        return CommonResponse.okRsp();
    }
}

