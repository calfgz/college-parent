package cn.calfgz.college.msm.service.impl;

import cn.calfgz.college.msm.service.MsmService;
import cn.calfgz.college.msm.util.AliyunSmsUtils;
import cn.calfgz.college.msm.util.ConstantPropertiesUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-02 15:14
 */
@Slf4j
@Service
public class MsmServiceImpl implements MsmService {

    @Override
    public boolean send(String phone, Map<String, Object> param) {
        if(StrUtil.isEmpty(phone)) {
            return false;
        }
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName",  ConstantPropertiesUtil.SMS_SIGN_NAME);
        request.putQueryParameter("TemplateCode", ConstantPropertiesUtil.SMS_TEMPLATE_CODE);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));
        try {
            IAcsClient client = AliyunSmsUtils.initVodClient(ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
