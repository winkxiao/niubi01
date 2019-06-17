package cn.xiaowei.service.Impl;

import cn.xiaowei.dao.OrdersDao;
import cn.xiaowei.dao.UserDao;
import cn.xiaowei.domain.Orders;
import cn.xiaowei.domain.Role;
import cn.xiaowei.domain.UserInfo;
import cn.xiaowei.service.userService;
import cn.xiaowei.utils.BCryptPasswordEncoderUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/27 15:31
 */
@Service("userService")
@Transactional//添加事务的注解
public class userServiceImpl implements userService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询数据库
        UserInfo info = userDao.findByUsername(username);

        List<Role> list = info.getRoles();

        // 判断账户是否可以用
            //  userService 实现了UserDetails接口，把自己的用户对象封装成UserDetails
            User user = new User(info.getUsername(),info.getPassword(),info.getStatus()!=0,true,true,true,getA(info.getRoles()));


        return user;
    }

    // 作用就是返回一个List集合,集合中装的是用户的角色描述
    public List<SimpleGrantedAuthority> getA(List<Role> roles){

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }




    @Override
    public List<UserInfo> findAll(int page, int size) {
        // 参数pageNum    页码值，pagesize 每页显示条数
        PageHelper.startPage(page,size);

        return userDao.findAll();
    }

    @Override
    public UserInfo findUserByIdAndAllRole(String id) {
        return null;
    }


    @Override
    public void saveUser(UserInfo userInfo) {

        // 对密码加密,
        String pwd = BCryptPasswordEncoderUtils.encoding(userInfo.getPassword());

        userInfo.setPassword(pwd);

        userDao.saveUser(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void addRoleToUser(String userId,String[] roleIds) {
        // 循环调用执行
        for (int i = 0; i < roleIds.length; i++) {
            userDao.addRoleToUser(userId,roleIds[i]);
        }
    }
}

