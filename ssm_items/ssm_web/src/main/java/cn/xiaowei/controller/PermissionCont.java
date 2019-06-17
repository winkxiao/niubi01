package cn.xiaowei.controller;

import cn.xiaowei.domain.Permission;
import cn.xiaowei.domain.Role;
import cn.xiaowei.domain.UserInfo;
import cn.xiaowei.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 权限控制类
 * @author: winkxiao
 * @date: 2019/3/29 18:05
 */
@Controller
@RequestMapping("/permission")
public class PermissionCont {

    @Autowired
    private PermissionService permissionService;


    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(){

        List<Permission> p = permissionService.findAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",p);
        mv.setViewName("permission-list");
        return mv;
    }


    // 根据权限id查询，未有权限的所有角色信息
    @RequestMapping("findByIdAndAllPermission")
//    @Secured("ROLE_ADMIN") // 全称
    public ModelAndView findByIdAndAllPermission(String id){

        // 先查询信息
        Permission p = permissionService.findById(id);
        // 再查询权限id，查未有的该权限的角色集合
        List<Role> otherRole =permissionService.findOtherRole(id);

        ModelAndView mv = new ModelAndView();
        // 存入request域对象中
        mv.addObject("permission",p);
        mv.addObject("roles",otherRole);
        // 跳转页面,指定视图
        mv.setViewName("permission-role-add");
        return mv;
    }


    @RequestMapping("addRoleToPermission")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")//仅ADMIN能访问
//    @PreAuthorize("authentication.principal.username=='xiaowei'")//仅用户名为xiaowei的能访问
    public String addRoleToPermission(@RequestParam(name = "permissionId",required = true)String permissionId,@RequestParam(name = "ids",required = true)String[] ids){

        System.out.println(permissionId+"......"+ Arrays.toString(ids));
        permissionService.addRoleToPermission(permissionId,ids);

        return "redirect:findAll.do";
    }
}
