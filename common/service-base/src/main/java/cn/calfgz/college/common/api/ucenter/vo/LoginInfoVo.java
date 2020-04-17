package cn.calfgz.college.common.api.ucenter.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-02 16:54
 */
@Data
public class LoginInfoVo implements Serializable {
    private String id;

    private String openid;

    private String mobile;

    private String nickname;

    private Integer sex;

    private Integer age;

    private String avatar;

    private String sign;
}
