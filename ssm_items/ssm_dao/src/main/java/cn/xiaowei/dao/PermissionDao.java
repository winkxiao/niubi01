package cn.xiaowei.dao;

import cn.xiaowei.domain.Permission;
import cn.xiaowei.domain.Role;
import org.apache.ibatis.annotations.*;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/28 20:26
 */
public interface PermissionDao {


    /**
     * 功能描述:
     * 〈根据角色id，查询权限〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.Permission
     * @author : WinkXiao
     * @date : 2019/3/28 20:26
     */
    @Select("select * from permission where id in (select permissionid from role_permission where roleId = #{id})")
    public List<Permission> findPermissionByRoleId(String id);


    /**
     * 功能描述:
     * 〈查询所有权限信息〉
     * @return : java.util.List<cn.xiaowei.domain.Permission>
     * @author : WinkXiao
     * @date : 2019/3/29 18:11
     */
    @Select("select * from Permission")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissionName",column = "permissionName"),
            @Result(property = "url",column = "url"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.RoleDao.findRoleByPermId")),
    })
    List<Permission> findAll();

    /**
     * 功能描述:
     * 〈id查权限，+该权限下的角色〉
     * @param id 1
     * @return : cn.xiaowei.domain.Permission
     * @author : WinkXiao
     * @date : 2019/3/29 19:45
     */
    @Select("select * from permission where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissionName",column = "permissionName"),
            @Result(property = "url",column = "url"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "cn.xiaowei.dao.RoleDao.findRoleByPermId"))
    })
    Permission findById(String id);

    /**
     * 功能描述:
     * 〈权限id，查未有改权限的角色〉
     * @param id 1
     * @return : java.util.List<cn.xiaowei.domain.Role>
     * @author : WinkXiao
     * @date : 2019/3/29 20:06
     */
    @Select("select * from role where id not in (select roleId from role_permission where permissionId = #{id})")
    List<Role> findOtherRole(String id);

    /**
     * 功能描述:
     * 〈给权限添加对应角色〉
     * @param permissionId 1
     * @param id 2
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/29 20:45
     */

    @Insert("insert into role_permission(permissionId,roleId) values (#{permissionId},#{id})")
    void addRoleToPermission(@Param("permissionId") String permissionId,@Param("id") String id);

    /**
     * 功能描述:
     * 〈根据角色id，删除与权限的对应关系〉
     * @param id 1
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/30 21:01
     */
    @Delete("delete from role_permission where roleId = #{id}")
    void deletRoleInPer_Ro(String id);
}
