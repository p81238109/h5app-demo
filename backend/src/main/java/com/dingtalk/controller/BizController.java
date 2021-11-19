package com.dingtalk.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dingtalk.config.AppConfig;
import com.dingtalk.model.RpcServiceResult;
import com.dingtalk.service.BizManager;
import com.taobao.api.ApiException;

/**
 * 主业务Controller，编写你的代码
 */
@RestController
@RequestMapping("/biz")
public class BizController {

    @Autowired
    BizManager bizManager;

    @RequestMapping("/hello")
    public RpcServiceResult hello() {
        String hello = bizManager.hello();
        if (StringUtils.isEmpty(hello)) {
            return RpcServiceResult.getFailureResult("-1", "fail");
        }
        return RpcServiceResult.getSuccessResult(hello);
    }
    
    /**
     * 获取配置文件中的内容
     * @return
     */
    @RequestMapping("/getAppConfig")
    public RpcServiceResult getAppConfig() {
        Map<String, Object> appConfigMap = new HashMap<String, Object>();
        appConfigMap.put("appKey", AppConfig.getAppKey());
        appConfigMap.put("appSecret", AppConfig.getAppSecret());
        appConfigMap.put("corpId", AppConfig.getCorpId());
        appConfigMap.put("agentId", AppConfig.getAgentId());
        
        return RpcServiceResult.getSuccessResult(appConfigMap);
    }
    
    /**
     * 获取第三方企业应用get_corp_token
     * 注意 在使用access_token时，请注意: 
           access_token的有效期为7200秒（2小时），有效期内重复获取会返回新的access_token。
                       开发者需要缓存access_token，用于后续接口的调用。因为每个应用的access_token是彼此独立的，所以进行缓存时需要区分应用来进行存储。
                       不能频繁调用gettoken接口，否则会受到频率拦截。
     * @return
     * @throws ApiException
     */
    @RequestMapping("/getCorpToken")
    public RpcServiceResult getCorpToken() throws ApiException {
        String getCorpToken = bizManager.getCorpToken();
        if (StringUtils.isEmpty(getCorpToken)) {
            return RpcServiceResult.getFailureResult("-1", "fail");
        }
        return RpcServiceResult.getSuccessResult(getCorpToken);
    }
    
    /**
     * 获取企业下的自定义空间
     * @return
     * @throws ApiException
     */
    @RequestMapping("/getCustomSpace")
    public RpcServiceResult getCustomSpace() throws ApiException {
        String getCustomSpace = bizManager.getCustomSpace();
        if (StringUtils.isEmpty(getCustomSpace)) {
            return RpcServiceResult.getFailureResult("-1", "fail");
        }
        return RpcServiceResult.getSuccessResult(getCustomSpace);
    }
    
    /**
     * 授权用户访问企业的自定义空间
     * @return
     * @throws ApiException
     */
    @RequestMapping("/grantCustomSpace")
    public RpcServiceResult grantCustomSpace() throws ApiException {
        String grantCustomSpace = bizManager.grantCustomSpace();
        if (StringUtils.isEmpty(grantCustomSpace)) {
            return RpcServiceResult.getFailureResult("-1", "fail");
        }
        return RpcServiceResult.getSuccessResult(grantCustomSpace);
    }
    
}
