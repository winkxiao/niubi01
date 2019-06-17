package cn.xiaowei.service;

import cn.xiaowei.domain.Orders;
import cn.xiaowei.domain.Role;
import cn.xiaowei.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/27 15:30
 */
public interface userService extends UserDetailsService {

    /**
     * 功能描述:
     * 〈查询所有用户〉
     *
     * @param page 1
     * @param size 2
     * @return : java.util.List<cn.xiaowei.domain.Orders>
     * @author : WinkXiao
     * @date : 2019/3/27 22:33
     */
    public List<UserInfo> findAll(int page, int size);

    /**
     * 功能描述:
     * 〈根据id查询用户，顺带查询角色信息〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.UserInfo
     * @author : WinkXiao
     * @date : 2019/3/28 9:46
     */
    public UserInfo findUserByIdAndAllRole(String id);


    /**
     * 功能描述:
     * 〈保存用户〉
     *
     * @param userInfo 1
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/28 10:10
     */
    public void saveUser(UserInfo userInfo);

    /**
     * 功能描述:
     * 〈id查询用户，+角色信息〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.UserInfo
     * @author : WinkXiao
     * @date : 2019/3/28 16:31
     */
    UserInfo findById(String id);

    /**
     * 功能描述:
     * 〈给用户添加角色〉
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/29 16:20
     */
    void addRoleToUser(String userId,String[] roleIds);

}
