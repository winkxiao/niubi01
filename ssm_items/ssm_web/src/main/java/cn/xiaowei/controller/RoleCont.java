package cn.xiaowei.controller;

import cn.xiaowei.domain.Role;
import cn.xiaowei.domain.UserInfo;
import cn.xiaowei.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description: 角色控制类
 * @author: winkxiao
 * @date: 2019/3/28 22:33
 */
@Controller
@RequestMapping("/role")
public class RoleCont {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1", required = true) Integer page, @RequestParam(name = "size", defaultValue = "4", required = true) Integer size) {

        // 查询
        List<Role> all = roleService.findAll(page, size);

        ModelAndView mv = new ModelAndView();

        // pageInfo 就是一个分页bean
        PageInfo info = new PageInfo(all);

        // 存入request域
        mv.addObject("roleList", info);
        // 跳转页面,指定视图
        mv.setViewName("role-list");

        return mv;
    }


    @RequestMapping("findById")
    public ModelAndView findById(String id){

        // 查询
        Role u = roleService.findById(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("role", u);
        mv.setViewName("role-show1");
        return mv;
    }

    @RequestMapping("save")
    public String saveUser(Role role){

        // 执行插入
        try {
            roleService.saveRole(role);
            // 重定向: 会加本类的映射路径"/user/findAll
            return "redirect:findAll.do";
        } catch (Exception e) {
            e.printStackTrace();
            // 错误跳转
            // 默认是转发，地址栏不变得
            return "error";
        }

    }


    @RequestMapping("delete")
    public String delete(String id){

        // 执行插入

            roleService.deleteRole(id);
            // 重定向: 会加本类的映射路径"/user/findAll
            return "redirect:findAll.do";





    }
}
