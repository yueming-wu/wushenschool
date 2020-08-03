package com.wushen.cmsservice.service;

import com.wushen.cmsservice.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-03
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> selectAll();
}
