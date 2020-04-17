package cn.calfgz.college.edu.service;

import cn.calfgz.college.edu.entity.Video;
import cn.calfgz.college.common.admin.edu.form.VideoInfoForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author calfgz
 * @since 2020-03-30
 */
public interface VideoService extends IService<Video> {

    boolean getCountByChapterId(String id);

    void saveVideoInfo(VideoInfoForm videoInfoForm);

    VideoInfoForm getVideoInfoFormById(String id);

    void updateVideoInfoById(VideoInfoForm videoInfoForm);

    boolean removeVideoById(String id);

    Boolean removeByCourseId(String id);
}
