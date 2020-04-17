package cn.calfgz.college.common.util.rest;


/**
 * 返回结果类型
 *
 * @author calfgz
 * @create 2018-11-20 11:46
 */
public enum CommonCode {
    SUCCSEE(20000, "OK"),
    DATA_EMPTY(20003, "空数据"),
    VALIDATOR_FAILED(20001, "验证失败"),
    ERROR_RESULT(20002, "服务异常"),
    BAD_REQUEST(20400, "错误请求"),
    UNAUTHORIZED(20401, "授权失败"),
    NOT_FOUND(20404, "数据不存在"),
    METHOD_NOT_ALLOWED(20405, "请求方法有误"),
    NOT_ACCEPTABLE(20406, "Not Acceptable"),
    SERVER_ERROR(20500, "服务异常"),
    UNKNOW_ERROR(20512,"未知异常"),
    MISS_PARAM(20400, "缺少请求参数"),
    UNEXPECTED(20999, "异常"),
    BAD_PARAM(20400, "请求参数类型有误");

    private int code;
    private String msg;

    CommonCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
