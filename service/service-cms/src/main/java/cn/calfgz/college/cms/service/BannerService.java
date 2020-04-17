package cn.calfgz.college.cms.service;

import cn.calfgz.college.cms.entity.Banner;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author calfgz
 * @since 2020-04-02
 */
public interface BannerService extends IService<Banner> {

    void pageBanner(Page<Banner> pager, Object object);

    Banner getBannerById(String id);

    boolean saveBanner(Banner banner);

    boolean updateBannerById(Banner banner);

    boolean removeBannerById(String id);

    List<Banner> selectIndexList();
}
