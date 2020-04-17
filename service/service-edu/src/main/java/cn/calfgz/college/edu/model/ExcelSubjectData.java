package cn.calfgz.college.edu.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author calfgz
 * @description:
 * @date 2020-03-30 12:13
 */
@Data
public class ExcelSubjectData {

    @ExcelProperty(index = 0)
    private String parentName;

    @ExcelProperty(index = 1)
    private String subjectName;
}
