package cn.xiaowei.service;

import cn.xiaowei.domain.Permission;
import cn.xiaowei.domain.Role;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/29 18:08
 */
public interface PermissionService {

    /**
     * 功能描述:
     * 〈查询所有权限信息〉
     * @param  1
     * @return : java.util.List<cn.xiaowei.domain.Permission>
     * @author : WinkXiao
     * @date : 2019/3/29 18:10
     */
    List<Permission> findAll();

    /**
     * 功能描述:
     * 〈权限id查权限〉
     * @param id 1
     * @return : cn.xiaowei.domain.Permission
     * @author : WinkXiao
     * @date : 2019/3/29 19:44
     */
    Permission findById(String id);


    /**
     * 功能描述:
     * 〈根据权限id，未有改权限的所有角色〉
     * @param id 1
     * @return : java.util.List<cn.xiaowei.domain.Role>
     * @author : WinkXiao
     * @date : 2019/3/29 19:59
     */
    List<Role> findOtherRole(String id);

    /**
     * 功能描述:
     * 〈给权限，添加对应的橘色〉
     * @param permissionId 1
     * @param ids 2
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/29 20:40
     */
    void addRoleToPermission(String permissionId, String[] ids);
}
