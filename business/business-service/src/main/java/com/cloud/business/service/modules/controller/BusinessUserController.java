package com.cloud.business.service.modules.controller;

import java.util.Arrays;
import java.util.Map;

import com.cloud.business.api.common.Response;
import com.cloud.business.api.controller.IBusinessUserController;
import com.cloud.business.api.entity.BusinessUser;
import com.cloud.business.service.modules.service.BusinessUserService;
import com.cloud.common.mybatis.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表
 *
 * @author zdl
 * @email 492587402@qq.com
 * @date 2019-12-07 10:15:52
 */
@RestController
public class BusinessUserController implements IBusinessUserController {

    @Autowired
    private BusinessUserService businessUserService;

    /**
     * 列表
     */
    @Override
    public Response list(@RequestParam Map<String, Object> params){
        PageUtils page = businessUserService.queryPage(params);

        return Response.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Override
    public Response info(@PathVariable("id") Integer id){
		BusinessUser businessUser = businessUserService.getById(id);

        return Response.ok().put("businessUser", businessUser);
    }

    /**
     * 保存
     */
    @Override
    public Response save(@RequestBody BusinessUser businessUser){
		businessUserService.save(businessUser);

        return Response.ok();
    }

    /**
     * 修改
     */
    @Override
    public Response update(@RequestBody BusinessUser businessUser){
		businessUserService.updateById(businessUser);

        return Response.ok();
    }

    /**
     * 删除
     */
    @Override
    public Response delete(@RequestBody Integer[] ids){
		businessUserService.removeByIds(Arrays.asList(ids));

        return Response.ok();
    }

}
