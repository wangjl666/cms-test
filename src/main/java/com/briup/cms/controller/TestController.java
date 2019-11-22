package com.briup.cms.controller;

import com.briup.cms.bean.Customer;
import com.briup.cms.service.CustomerServiceImpl;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Api(description = "客户相关接口")
public class TestController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("test")
    public String test(){
        return "jj";
    }

    @GetMapping("/find")
    @ApiOperation("根据id查询")
    @ApiImplicitParam(name = "id",value = "客户id",paramType = "query",dataType = "int",required = true)
    public Customer findById(int id) {

        return customerService.findById(id);
    }
    @PatchMapping("/queryH")
    @ApiOperation("测试两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "客户id",required = true,paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "name",value = "客户名字",paramType = "query",dataType = "string")
    })
    public String queryH(int id,String name){
        return "傻子哦";
    }

    @GetMapping("/query")
    @ApiOperation("测试一个参数对象")
    @ApiImplicitParam
    public Customer query(Customer customer){
        return customer;
    }

    @GetMapping("/queryL")
    @ApiOperation("测试响应结构")
    public Message<Customer> queryL(Customer customer){
        /*return new Message<>(200,"success",customer,new Date().getTime());*/
        return MessageUtil.success(customer);
    }
}
