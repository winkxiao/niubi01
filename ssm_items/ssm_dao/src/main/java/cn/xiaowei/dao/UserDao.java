package cn.xiaowei.dao;


import cn.xiaowei.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @Description: 用户dao
 * @author: winkxiao
 * @date: 2019/3/27 16:09
 */
public interface UserDao {

    /**
     * 功能描述:
     * 〈根据id查询用户，+用户角色信息+权限信息〉
     *
     * @param username 1
     * @return : cn.xiaowei.domain.UserInfo
     * @author : WinkXiao
     * @date : 2019/3/27 16:10
     */
    @Select("select * from users where username=#{username}")
    @Results({@Result(id = true,property = "id",column = "id"),
            @Result(property = "eamil",column = "eamil"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.RoleDao.findByUserId"))
    })
    public UserInfo findByUsername(String username);



    @Select("select * from users")
    List<UserInfo> findAll();


    /**
     * 功能描述:
     * 〈根据id查询用户，顺带查询角色信息〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.UserInfo
     * @author : WinkXiao
     * @date : 2019/3/28 9:52
     */
    @Select("select * from users where id in (select userid from users_role where roleId = #{id})")
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
    @Insert("insert into users(email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    public void saveUser(UserInfo userInfo);

    /**
     * 功能描述:
     * 〈根据ID查询用户，+角色〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.UserInfo
     * @author : WinkXiao
     * @date : 2019/3/28 16:33
     */
    @Select("select * from users where id = #{id}")
    @Results({@Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.RoleDao.findByUserId"))
    })
    UserInfo findById(String id);

    /**
     * 功能描述:
     * 〈根据角色id 查询所有用户〉
     *
     * @param roleid 1
     * @return : java.util.List<org.springframework.security.core.userdetails.User>
     * @author : WinkXiao
     * @date : 2019/3/28 21:14
     */
    @Select("select * from users where id in (select userId from users_role where roleId =#{roleid})")
    List<UserInfo> findUserByRoleId(String roleid);

    /**
     * 功能描述:
     * 〈给指定用户添加权限〉
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/29 16:31
     */
    @Insert("insert into users_role(userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

}
