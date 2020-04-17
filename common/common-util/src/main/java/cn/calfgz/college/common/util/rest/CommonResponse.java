package cn.calfgz.college.common.util.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 封装结果
 *
 * @author calfgz
 * @create 2018-11-20 13:57
 */
public class CommonResponse {

    public static CommonResult okRsp() {
        return new CommonResult(CommonCode.SUCCSEE, null);
    }

    public static <T> CommonResult<T> okRsp(T data) {
        return new CommonResult(CommonCode.SUCCSEE, data);
    }

    public static CommonResult okRspMsg(String msg) {
        return new CommonResult(CommonCode.SUCCSEE.getCode(), msg);
    }

    public static CommonResult errRsp(String msg) {
        return new CommonResult(CommonCode.ERROR_RESULT.getCode(), msg);
    }

    public static CommonResult validRsp(String msg) {
        return new CommonResult(CommonCode.VALIDATOR_FAILED.getCode(), msg);
    }

    public static CommonResult rsp(CommonCode commonCode) {
        return new CommonResult(commonCode, null);
    }

    public static <T> CommonResult<T> rsp(CommonCode commonCode, T data) {
        return new CommonResult(commonCode, data);
    }

    public static <T> CommonResult<T> rsp(int code, String msg, T data) {
        return new CommonResult(code, msg, data);
    }

    public static CommonResult rsp(int code, String msg) {
        return new CommonResult(code, msg);
    }

    public static void out(HttpServletResponse response, CommonResult result) {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            mapper.writeValue(response.getWriter(), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
