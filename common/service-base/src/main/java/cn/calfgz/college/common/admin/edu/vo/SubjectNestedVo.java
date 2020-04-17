package cn.calfgz.college.common.admin.edu.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author calfgz
 * @description:
 * @date 2020-03-30 13:37
 */
@Data
public class SubjectNestedVo {
    private String id;
    private String title;
    private List<SubjectVo> children = new ArrayList<>();
}
