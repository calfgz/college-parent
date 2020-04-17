package cn.calfgz.college.common.handler;

import cn.calfgz.college.common.util.exception.CustomException;
import cn.calfgz.college.common.util.rest.CommonCode;
import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author calfgz
 * @description: 统一异常处理
 * @date 2020-03-28 10:33
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public CommonResult exceptionHandler(HttpServletRequest request, CustomException e) {
        log.error("GlobalException CustomException, uri:{}, method:{}, params:{}, error:{}",
                request.getRequestURI(), request.getMethod(), JSON.toJSONString(request.getParameterMap()), e.getMessage());
        return CommonResponse.rsp(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult exceptionHandler(HttpServletRequest request, NoHandlerFoundException e) {
        log.error("GlobalException NoHandlerFoundException, uri:{}, method:{}, params:{}, error:{}",
                request.getRequestURI(), request.getMethod(), JSON.toJSONString(request.getParameterMap()), e.getMessage());
        return CommonResponse.rsp(CommonCode.NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult exceptionHandler(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        log.error("GlobalException HttpRequestMethodNotSupportedException, uri:{}, method:{}, params:{}, error:{}",
                request.getRequestURI(), request.getMethod(), JSON.toJSONString(request.getParameterMap()), e.getMessage());
        return CommonResponse.rsp(CommonCode.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult exceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("GlobalException MethodArgumentNotValidException, uri:{}, method:{}, params:{}, error:{}",
                request.getRequestURI(), request.getMethod(), JSON.toJSONString(request.getParameterMap()), e.getMessage());
        return CommonResponse.rsp(CommonCode.BAD_PARAM);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public CommonResult exceptionHandler(HttpServletRequest request, MissingServletRequestParameterException e) {
        log.error("GlobalException MissingServletRequestParameterException, uri:{}, method:{}, params:{}, error:{}",
                request.getRequestURI(), request.getMethod(), JSON.toJSONString(request.getParameterMap()), e.getMessage());
        return CommonResponse.rsp(CommonCode.MISS_PARAM);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public CommonResult exceptionHandler(HttpServletRequest request,MethodArgumentTypeMismatchException e) {
        log.error("GlobalException MethodArgumentTypeMismatchException, uri:{}, method:{}, params:{}, error:{}",
                request.getRequestURI(), request.getMethod(), JSON.toJSONString(request.getParameterMap()), e.getMessage());
        return CommonResponse.rsp(CommonCode.BAD_PARAM);
    }

    @ExceptionHandler(Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("GlobalException, uri:{}, method:{}, params:{}, error:{}",
                request.getRequestURI(), request.getMethod(), JSON.toJSONString(request.getParameterMap()), e.getMessage());
        return CommonResponse.rsp(CommonCode.SERVER_ERROR);
    }

    /**
    @ExceptionHandler(DataAccessException.class)
    public CommonResult argNotValidHandler(HttpServletRequest request, DataAccessException e) {
        log.error("GlobalException DataAccessException, uri:{}, method:{}, params:{}, error:{}",
                request.getRequestURI(), request.getMethod(), JSON.toJSONString(request.getParameterMap()), e.getMessage());
        return CommonResponse.rsp(CommonCode.BAD_PARAM);
    }
     **/

}
