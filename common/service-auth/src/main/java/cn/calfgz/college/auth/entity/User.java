package cn.calfgz.college.auth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-16 14:02
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String nickName;

    private String salt;

    private String token;

}


