package cn.calfgz.college.cms.controller;


import cn.calfgz.college.cms.entity.Banner;
import cn.calfgz.college.cms.service.BannerService;
import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-04-02
 */
@RestController
@RequestMapping("/cms/banner")
@CrossOrigin
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("{page}/{limit}")
    public CommonResult index(@PathVariable Long page, @PathVariable Long limit) {
        Page<Banner> pager = new Page<>(page, limit);
        bannerService.pageBanner(pager,null);
        return CommonResponse.okRsp(pager);
    }

    @GetMapping("get/{id}")
    public CommonResult get(@PathVariable String id) {
        Banner banner = bannerService.getBannerById(id);
        return CommonResponse.okRsp(banner);
    }

    @PostMapping("save")
    public CommonResult save(@RequestBody Banner banner) {
        bannerService.saveBanner(banner);
        return CommonResponse.okRsp();
    }

    @PutMapping("update")
    public CommonResult updateById(@RequestBody Banner banner) {
        bannerService.updateBannerById(banner);
        return CommonResponse.okRsp();
    }

    @DeleteMapping("remove/{id}")
    public CommonResult remove(@PathVariable String id) {
        bannerService.removeBannerById(id);
        return CommonResponse.okRsp();
    }

}

