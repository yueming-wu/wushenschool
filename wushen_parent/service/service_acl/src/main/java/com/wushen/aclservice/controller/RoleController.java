package com.wushen.aclservice.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wushen.aclservice.entity.Role;
import com.wushen.aclservice.service.RoleService;
import com.wushen.commonutils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/admin/acl/role")
//@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "角色列表",notes = "分页显示角色列表")
    @GetMapping("{page}/{limit}")
    public R index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            Role role) {
        Page<Role> pageParam = new Page<>(page, limit);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(role.getRoleName())) {
            wrapper.like("role_name",role.getRoleName());
        }
        roleService.page(pageParam,wrapper);
        return R.ok().data("items", pageParam.getRecords()).data("total", pageParam.getTotal());
    }

    @ApiOperation(value = "获取角色",notes = "根据id获取角色信息")
    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        Role role = roleService.getById(id);
        return R.ok().data("item", role);
    }

    @ApiOperation(value = "新增角色",notes ="添加角色信息")
    @PostMapping("save")
    public R save(@RequestBody Role role) {
        roleService.save(role);
        return R.ok();
    }

    @ApiOperation(value = "修改角色",notes = "修改角色信息")
    @PutMapping("update")
    public R updateById(@RequestBody Role role) {
        roleService.updateById(role);
        return R.ok();
    }

    @ApiOperation(value = "删除角色",notes = "删除角色信息")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        roleService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "批量删除",notes = "根据id列表批量删除角色信息")
    @DeleteMapping("batchRemove")
    public R batchRemove(@RequestBody List<String> idList) {
        roleService.removeByIds(idList);
        return R.ok();
    }
}

