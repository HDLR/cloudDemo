package com.cloud.business.service.modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.business.api.entity.BusinessUser;
import com.cloud.common.mybatis.PageUtils;

import java.util.Map;

/**
 * 用户表
 *
 * @author zdl
 * @email xxxxx@qq.com
 * @date 2019-12-07 10:15:52
 */
public interface BusinessUserService extends IService<BusinessUser> {

    PageUtils queryPage(Map<String, Object> params);
}

