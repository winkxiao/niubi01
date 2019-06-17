package cn.xiaowei.controller;

import cn.xiaowei.domain.Role;
import cn.xiaowei.domain.sysLog;
import cn.xiaowei.service.sysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/30 19:27
 */
@Controller
@RequestMapping("/sysLog")
public class sysLogCont {

    @Autowired
    private sysLogService syice;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1", required = true) Integer page, @RequestParam(name = "size", defaultValue = "100", required = true) Integer size) {

        // 查询
        List<sysLog> all = syice.findAll(page, size);

        ModelAndView mv = new ModelAndView();

        // pageInfo 就是一个分页bean
        PageInfo info = new PageInfo(all);

        // 存入request域
        mv.addObject("sysLogs", info);
        // 跳转页面,指定视图
        mv.setViewName("syslog-list");

        return mv;
    }
}
