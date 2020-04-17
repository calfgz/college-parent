package cn.calfgz.college.statistics.controller.api;

import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.statistics.service.DailyService;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-08 11:00
 */
@RestController
@RequestMapping("/api/statistics/daily")
public class DailyApiController {

    @Autowired
    private DailyService dailyService;

    @GetMapping("show-chart/{begin}/{end}/{type}")
    public CommonResult showChart(@PathVariable String begin, @PathVariable String end, @PathVariable String type){
        Map<String, Object> map = dailyService.getChartData(begin, end, type);
        return CommonResponse.okRsp(map);
    }
}
