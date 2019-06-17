package cn.xiaowei.controller;

import cn.xiaowei.domain.Orders;
import cn.xiaowei.domain.Product;
import cn.xiaowei.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description: 订单处理器
 * @author: winkxiao
 * @date: 2019/3/25 22:48
 */
@Controller
@RequestMapping("/orders")
public class OrdersCont {

    @Autowired
    private OrdersService ordersService;

    /*  查询所有未分页版
    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        // 查询
        List<Orders> all = ordersService.findAll();

        ModelAndView mv = new ModelAndView();

        // 存入request域
        mv.addObject("ordersList",all);
        // 跳转页面,指定视图
        mv.setViewName("orders-list");

        return mv;
    }*/

    @RequestMapping("/findAll")
    //  @RequestParam(name = "请求的key",defaultValue = "默认值" ,required =true【需要】)-->绑定给 int page
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1" ,required =true) Integer page,@RequestParam(name = "size",defaultValue = "4",required = true) Integer size){

        // 查询
        List<Orders> all = ordersService.findAll(page,size);

        ModelAndView mv = new ModelAndView();

        // pageInfo 就是一个分页bean
        PageInfo info = new PageInfo(all);

        // 存入request域
        mv.addObject("pageInfo",info);
        // 跳转页面,指定视图
        mv.setViewName("orders-page-list");

        return mv;
    }


    @RequestMapping("/findById")
    public ModelAndView findById(String id){

        // 查询
        Orders byId = ordersService.findById(id);

        ModelAndView mv = new ModelAndView();


        // 存入request域
        mv.addObject("orders",byId);
        // 跳转页面,指定视图
        mv.setViewName("orders-show");

        return mv;
    }
}
