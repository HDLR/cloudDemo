package com.cloud.business.service.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.business.api.entity.BusinessUser;
import com.cloud.business.service.modules.dao.BusinessUserDao;
import com.cloud.business.service.modules.service.BusinessUserService;
import com.cloud.common.mybatis.PageUtils;
import com.cloud.common.mybatis.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("businessUserService")
public class BusinessUserServiceImpl extends ServiceImpl<BusinessUserDao, BusinessUser> implements BusinessUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BusinessUser> page = this.page(
                new Query<BusinessUser>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}