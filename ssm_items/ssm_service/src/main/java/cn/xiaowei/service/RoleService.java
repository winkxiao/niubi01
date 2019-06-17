package cn.xiaowei.service;

import cn.xiaowei.domain.Role;


import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/29 0:01
 */
public interface RoleService {

    /**
     * 功能描述:
     * 〈查询所有角色〉
     *
     * @param page 1
     * @param size 2
     * @return : java.util.List<cn.xiaowei.domain.Orders>
     * @author : WinkXiao
     * @date : 2019/3/27 22:33
     */
    public List<Role> findAll(int page, int size);

    /**
     * 功能描述:
     * 〈根据角色id查询角色信息〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.Role
     * @author : WinkXiao
     * @date : 2019/3/29 13:35
     */
    Role findById(String id);

    /**
     * 功能描述:
     * 〈插入一个角色〉
     * @param role 1
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/29 14:16
     */
    public void saveRole(Role role);

    /**
     * 功能描述:
     * 〈根据用户id查询不属于他的所有角色〉
     * @param userid 1
     * @return : java.util.List<cn.xiaowei.domain.Role>
     * @author : WinkXiao
     * @date : 2019/3/29 15:17
     */
    List<Role> findOtherRole(String userid);

    /**
     * 功能描述:
     * 〈删除一个角色〉
     * @param id 1
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/30 20:28
     */
    void deleteRole(String id);
}
