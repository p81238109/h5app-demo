package com.dingtalk.service;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiV2UserGetuserinfoRequest;
import com.dingtalk.api.response.OapiV2UserGetuserinfoResponse;
import com.dingtalk.constant.UrlConstant;
import org.springframework.stereotype.Service;

/**
 * 主业务service，编写你的代码
 */
@Service
public class BizManager {

    public String hello(){
        return "HelloWorld";
    }

}
