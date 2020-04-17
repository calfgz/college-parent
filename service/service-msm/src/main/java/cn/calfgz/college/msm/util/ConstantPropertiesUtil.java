package cn.calfgz.college.msm.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-01 12:09
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean {

    @Value("${aliyun.sms.file.keyid}")
    private String keyId;

    @Value("${aliyun.sms.file.keysecret}")
    private String keySecret;

    @Value("${aliyun.sms.file.template_code}")
    private String templateCode;

    @Value("${aliyun.sms.file.sign_name}")
    private String signName;

    public static String ACCESS_KEY_ID;

    public static String ACCESS_KEY_SECRET;

    public static String SMS_TEMPLATE_CODE;

    public static String SMS_SIGN_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
        SMS_TEMPLATE_CODE = templateCode;
        SMS_SIGN_NAME = signName;
    }
}
