package com.cloud.business.api.controller;

import java.util.Map;

import com.cloud.business.api.FeignClientConfig;
import com.cloud.business.api.common.Response;
import com.cloud.business.api.entity.BusinessUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import io.swagger.annotations.ApiOperation;

/**
 * 用户表
 *
 * @author zdl
 * @email xxxxx@qq.com
 * @date 2019-12-07 10:15:52
 */
@FeignClient(contextId = "business_user",
        name = FeignClientConfig.NAME, configuration = FeignClientsConfiguration.class)
@RequestMapping("/business/user")
public interface IBusinessUserController {

    /**
     * 列表
     */
    @ApiOperation(value = "用户表列表")
    @GetMapping("/list")
    Response list(@RequestParam Map<String, Object> params);


    /**
     * 详细信息
     */
    @ApiOperation(value = "用户表详细信息")
    @GetMapping("/info/{id}")
    public Response info(@PathVariable("id") Integer id);

    /**
     * 保存
     */
    @ApiOperation(value = "用户表保存")
    @PostMapping("/save")
    public Response save(@RequestBody BusinessUser businessUser);

    /**
     * 修改
     */
    @ApiOperation(value = "用户表修改")
    @PostMapping("/update")
    public Response update(@RequestBody BusinessUser businessUser);

    /**
     * 删除
     */
    @ApiOperation(value = "用户表删除")
    @DeleteMapping("/delete")
    public Response delete(@RequestBody Integer[] ids);

}
