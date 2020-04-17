package cn.calfgz.college.common.admin.edu.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author calfgz
 * @description:
 * @date 2020-03-30 17:43
 */
@Data
public class VideoVo implements Serializable {
    private String id;
    private String title;
    private Boolean free;
    private String videoOriginalName;
}
