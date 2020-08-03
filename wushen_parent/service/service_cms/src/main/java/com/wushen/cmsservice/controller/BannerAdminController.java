package com.wushen.cmsservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wushen.cmsservice.entity.CrmBanner;
import com.wushen.cmsservice.service.CrmBannerService;
import com.wushen.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-03
 */
@Api(tags = "后台Banner管理")
@RestController
@RequestMapping("/cmsservice/adminbanner")
@CrossOrigin
public class BannerAdminController {
    @Resource
    private CrmBannerService bannerService;
    @ApiOperation(value = "添加banner",notes = "添加banner信息")
    @PostMapping("/save")
    public R addBanner(@ApiParam(name = "crmBanner",value = "轮播图实体",required = true)
                        @RequestBody CrmBanner crmBanner){
        bannerService.save(crmBanner);
        return R.ok();
    }
    @ApiOperation(value = "删除banner",notes = "根据id删除banner信息")
    @DeleteMapping("/remove/{id}")
    public R deleteBanner(@ApiParam(name = "id",value = "轮播图id",required = true)
                           @PathVariable String id){
        bannerService.removeById(id);
        return R.ok();
    }
    @ApiOperation(value = "修改banner",notes = "根据banner的实体和id修改banner")
    @PutMapping("/update")
    public R updateBanner(@ApiParam(name = "crmBanner",value = "轮播图实体",required = true)
                           @RequestBody CrmBanner crmBanner){
        bannerService.updateById(crmBanner);
        return R.ok();
    }
    @ApiOperation(value = "分页banner",notes = "分页查询banner信息")
    @GetMapping("/{page}/{limit}")
    public R selectBannerByPage(@ApiParam(name = "page",value = "当前页",required = true) @PathVariable Long page,
                                 @ApiParam(name = "limit",value = "页容量",required = true) @PathVariable Long limit){
        Page<CrmBanner> bannerPage = new Page<>(page,limit);
        bannerService.page(bannerPage,null);
        return R.ok().data("items",bannerPage.getRecords()).data("total",bannerPage.getTotal());
    }
    @ApiOperation(value = "获取banner",notes = "根据id获取banner")
    @GetMapping("get/{id}")
    public R get(@ApiParam(name = "id",value = "轮播图id",required = true)
                 @PathVariable String id) {
        CrmBanner banner = bannerService.getById(id);
        return R.ok().data("item", banner);
    }
}

