package cn.calfgz.college.common.admin.edu.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author calfgz
 * @description:
 * @date 2020-03-30 17:42
 */
@Data
public class ChapterVo implements Serializable {
    private String id;
    private String title;
    private List<VideoVo> children = new ArrayList<>();
}
