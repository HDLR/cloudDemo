package com.cloud.business.service.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.business.api.entity.BusinessUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户表
 * 
 * @author zdl
 * @email 492587402@qq.com
 * @date 2019-12-07 10:15:52
 */
@Repository
@Mapper
public interface BusinessUserDao extends BaseMapper<BusinessUser> {
	
}
