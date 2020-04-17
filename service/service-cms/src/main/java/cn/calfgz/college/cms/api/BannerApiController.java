package cn.calfgz.college.cms.api;

import cn.calfgz.college.cms.entity.Banner;
import cn.calfgz.college.cms.service.BannerService;
import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-02 11:10
 */
@RestController
@RequestMapping("/cms/api/banner")
@CrossOrigin
public class BannerApiController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("getAllBanner")
    public CommonResult index() {
        List<Banner> list = bannerService.selectIndexList();
        return CommonResponse.okRsp(list);
    }
}
