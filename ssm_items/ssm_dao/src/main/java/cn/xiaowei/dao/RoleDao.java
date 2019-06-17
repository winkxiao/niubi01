package cn.xiaowei.dao;

import cn.xiaowei.domain.Role;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/27 20:46
 */
public interface RoleDao {

    /**
     * 功能描述:
     * 〈根据id查询用户+对应角色〉
     *
     * @param userid 1
     * @return : cn.xiaowei.domain.Role
     * @author : WinkXiao
     * @date : 2019/3/27 20:50
     */
    @Select("select * from role where id in (select roleId from  users_role where  userId= #{userid})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.PermissionDao.findPermissionByRoleId")),
            @Result(property = "users",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.UserDao.findById"))
    })
    public List<Role> findByUserId(String userid);


    @Select("select *from role")
    public List<Role> findAll();


    /**
     * 功能描述:
     * 〈根据角色id查询角色〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.Role
     * @author : WinkXiao
     * @date : 2019/3/29 13:43
     */
    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.PermissionDao.findPermissionByRoleId")),
            @Result(property = "users",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.UserDao.findUserByRoleId"))
    })
    public Role findById(String id);


    /**
     * 功能描述:
     * 〈插入一个角色〉
     * @param role 1
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/29 14:16
     */
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void saveRole(Role role);

    /**
     * 功能描述:
     * 〈根据用户id查询不属于他的所有角色〉
     * @param userid 1
     * @return : java.util.List<cn.xiaowei.domain.Role>
     * @author : WinkXiao
     * @date : 2019/3/29 15:17
     */
    @Select("select * from role where id not in (select roleId from  users_role where  userId= #{userid})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.PermissionDao.findPermissionByRoleId")),
            @Result(property = "users",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.UserDao.findById"))
    })
    List<Role> findOtherRole(String userid);


    /**
     * 功能描述:
     * 〈权限id，查对应有该权限的角色〉
     * @param  1
     * @return : java.util.List<cn.xiaowei.domain.Role>
     * @author : WinkXiao
     * @date : 2019/3/29 18:20
     */
    @Select("select * from role where id in (select roleId from role_permission where permissionId = #{id})")
    List<Role> findRoleByPermId();


    @Delete("delete from role where id = #{id}")
    void deleteRole(String id);

    /**
     * 功能描述:
     * 〈删除角色对应的用户关系〉
     * @param id 1
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/30 20:50
     */
    @Delete("delete from users_role where roleId = #{id}")
    void deleteRoleInRo_Per(String id);
}
