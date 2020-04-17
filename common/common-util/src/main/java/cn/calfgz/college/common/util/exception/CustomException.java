package cn.calfgz.college.common.util.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author calfgz
 * @description: 自定义异常
 * @date 2020-03-28 10:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException {

    private Integer code;
    
    private String message;
}
