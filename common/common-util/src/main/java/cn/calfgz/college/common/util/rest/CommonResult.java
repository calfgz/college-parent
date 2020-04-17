package cn.calfgz.college.common.util.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author calfgz
 * @description: 通用结果
 * @date 2020-03-07 14:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }

    public CommonResult(CommonCode code, T data) {
        this(code.getCode(), code.getMsg(), data);
    }
}
