package cn.calfgz.college.auth.security;


import cn.calfgz.college.common.util.rest.CommonCode;
import cn.calfgz.college.common.util.rest.CommonResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 未授权的统一处理方式
 * </p>
 *
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        CommonResponse.out(response, CommonResponse.rsp(CommonCode.NOT_ACCEPTABLE));
    }
}
