package com.dingtalk.controller;

import com.dingtalk.model.RpcServiceResult;
import com.dingtalk.service.BizManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主业务Controller，编写你的代码
 */
@RestController
@RequestMapping("/biz")
public class BizController {

    @Autowired
    BizManager bizManager;

    @RequestMapping("/hello")
    public RpcServiceResult hello(){
        String hello = bizManager.hello();
        if(StringUtils.isEmpty(hello)){
            return RpcServiceResult.getFailureResult("-1", "fail");
        }
        return RpcServiceResult.getSuccessResult(hello);
    }
}
