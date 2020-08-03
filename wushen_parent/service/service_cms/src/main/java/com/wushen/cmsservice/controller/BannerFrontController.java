package com.wushen.cmsservice.controller;

import com.wushen.cmsservice.entity.CrmBanner;
import com.wushen.cmsservice.service.CrmBannerService;
import com.wushen.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-03 16:49
 */
@Api(tags = "前台Banner显示")
@RestController
@RequestMapping("/cmsservice/alluserbanner")
@CrossOrigin
public class BannerFrontController {
    @Resource
    private CrmBannerService bannerService;
    @ApiOperation(value = "显示banner",tags = "查询banner列表")
    @Cacheable(value = "banner",key = "'selectIndexList'")
    @GetMapping("/getBannerList")
    public R getBannerList(){
        List<CrmBanner> bannerList = bannerService.selectAll();
        return R.ok().data("bannerList",bannerList);
    }
}
