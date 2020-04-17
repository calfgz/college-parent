package cn.calfgz.college.cms.service.impl;

import cn.calfgz.college.cms.entity.Banner;
import cn.calfgz.college.cms.mapper.BannerMapper;
import cn.calfgz.college.cms.service.BannerService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author calfgz
 * @since 2020-04-02
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Override
    public void pageBanner(Page<Banner> pager, Object object) {
        baseMapper.selectPage(pager, null);
    }

    @Override
    public Banner getBannerById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public boolean saveBanner(Banner banner) {
        int insert = baseMapper.insert(banner);
        return insert > 0 ? true : false;
    }

    @Override
    public boolean updateBannerById(Banner banner) {
        int update = baseMapper.updateById(banner);
        return update > 0 ? true : false;
    }

    @Override
    public boolean removeBannerById(String id) {
        int delete = baseMapper.deleteById(id);
        return delete > 0 ? true : false;
    }

    @Cacheable(value = "banner", key = "'selectIndexList'")
    @Override
    public List<Banner> selectIndexList() {
        return baseMapper.selectList(null);
    }
}
