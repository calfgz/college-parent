package cn.calfgz.college.order.controller;


import cn.calfgz.college.common.util.jwt.JwtUtils;
import cn.calfgz.college.common.util.rest.CommonCode;
import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.order.entity.Order;
import cn.calfgz.college.order.service.OrderService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/api/order/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     *根据课程id和用户id创建订单，返回订单id
     */
    @PostMapping("createOrder/{courseId}")
    public CommonResult save(@PathVariable String courseId, HttpServletRequest request) {
        String orderId = orderService.saveOrder(courseId, JwtUtils.getMemberIdByJwtToken(request));

        return CommonResponse.okRsp(new JSONObject(2).fluentPut("orderId", orderId));
    }

    /**
     *  根据订单id查询订单信息
     * @param orderId
     * @return
     */
    @GetMapping("getOrderInfo/{orderId}")
    public CommonResult getOrderInfo(@PathVariable String orderId) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderId);
        Order order = orderService.getOne(wrapper);
        if (order != null) {
            return CommonResponse.okRsp(order);
        } else {
            return CommonResponse.rsp(CommonCode.DATA_EMPTY);
        }
    }

    //根据课程id和用户id查询订单表中订单状态
    @GetMapping("isBuyCourse/{courseId}/{memberId}")
    public boolean isBuyCourse(@PathVariable String courseId,@PathVariable String memberId) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        wrapper.eq("member_id",memberId);
        wrapper.eq("status",1);
        //支付状态 1代表已经支付
        int count = orderService.count(wrapper);
        if(count>0) {
            //已经支付
            return true;
        } else {
            return false;
        }
    }

}

