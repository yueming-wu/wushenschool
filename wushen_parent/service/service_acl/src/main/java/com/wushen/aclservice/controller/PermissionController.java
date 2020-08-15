package com.wushen.aclservice.controller;



import com.wushen.aclservice.entity.Permission;
import com.wushen.aclservice.service.PermissionService;
import com.wushen.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限 菜单管理
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Api(tags = "后端菜单管理")
@RestController
@RequestMapping("/admin/acl/permission")
//@CrossOrigin
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //获取全部菜单
    @ApiOperation(value = "显示列表",notes = "递归查询所有菜单")
    @GetMapping
    public R indexAllPermission() {
        List<Permission> list =  permissionService.queryAllMenuGuli();
        /*children表示下级List<Permission> children,此处相当于把查询的数据一致递归放入下级操作*/
        return R.ok().data("children",list);
    }

    @ApiOperation(value = "删除菜单",notes = "递归删除菜单")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        permissionService.removeChildByIdGuli(id);
        return R.ok();
    }

    @ApiOperation(value = "分配权限",notes = "给角色分配权限")
    @PostMapping("/doAssign")
    /*一个角色可以看到多个菜单,多个菜单可以对应一个角色;一个菜单对应只能对应一个角色;即多对一*/
    public R doAssign(String roleId,String[] permissionId) {
        permissionService.saveRolePermissionRealtionShipGuli(roleId,permissionId);
        return R.ok();
    }

    @ApiOperation(value = "获取菜单",notes = "根据角色id获取菜单")
    @GetMapping("toAssign/{roleId}")
    public R toAssign(@PathVariable String roleId) {
        List<Permission> list = permissionService.selectAllMenu(roleId);
        return R.ok().data("children", list);
    }
    @ApiOperation(value = "新增菜单",notes = "新增菜单")
    @PostMapping("save")
    public R save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return R.ok();
    }

    @ApiOperation(value = "修改菜单",notes = "修改菜单")
    @PutMapping("update")
    public R updateById(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return R.ok();
    }

}

