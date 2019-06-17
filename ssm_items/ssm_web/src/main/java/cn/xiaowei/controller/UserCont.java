package cn.xiaowei.controller;


import cn.xiaowei.domain.Role;
import cn.xiaowei.domain.UserInfo;
import cn.xiaowei.service.RoleService;
import cn.xiaowei.service.userService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:    用户类
 * @author: winkxiao
 * @date: 2019/3/27 22:26
 */
@Controller
@RequestMapping("/user")
public class UserCont {

    @Autowired
    private userService userSerice;
    @Autowired
    private RoleService roleService;

    // 查询所有
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1" ,required =true)Integer page, @RequestParam(name = "size",defaultValue = "4",required = true)Integer size){

        // 查询
        List<UserInfo> all = userSerice.findAll(page,size);

        ModelAndView mv = new ModelAndView();

        // pageInfo 就是一个分页bean
        PageInfo info = new PageInfo(all);

        // 存入request域
        mv.addObject("userList",info);
        // 跳转页面,指定视图
        mv.setViewName("user-list");

        return mv;
    }


    // 根据用户id查询未有所有角色信息
    @RequestMapping("findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id){

        // 先查询用户信息
        UserInfo u = userSerice.findById(id);
        // 再查询用户id未有的权限
        List<Role> otherRole =roleService.findOtherRole(id);

        ModelAndView mv = new ModelAndView();
        // 存入request域对象中
        mv.addObject("user",u);
        mv.addObject("roles",otherRole);
        // 跳转页面,指定视图
        mv.setViewName("user-role-add");
        return mv;
    }

    // 保存一个用户
    @RequestMapping("save")
    public String saveUser(UserInfo userInfo){

        // 执行插入
        try {
            userSerice.saveUser(userInfo);
            // 重定向: 会加本类的映射路径"/user/findAll
            return "redirect:findAll.do";
        } catch (Exception e) {
            e.printStackTrace();
            // 错误跳转
            // 默认是转发，地址栏不变得
            return "error";
        }

    }

    // 用户id查用户
    @RequestMapping("findById")
    public ModelAndView findById(String id){

        // 查询
        UserInfo u = userSerice.findById(id);
        System.out.println(u);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", u);
        mv.setViewName("user-show1");
        return mv;
    }


    @RequestMapping("addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String id,@RequestParam(name = "ids",required = true)String[] ids){

        System.out.println(id+"......"+ Arrays.toString(ids));
        userSerice.addRoleToUser(id,ids);

        return "redirect:findAll.do";
    }
}
