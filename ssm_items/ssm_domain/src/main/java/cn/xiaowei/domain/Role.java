package cn.xiaowei.domain;

import java.util.List;

/**
 * @Description: 角色实体类
 * @author: winkxiao
 * @date: 2019/3/27 16:22
 */
public class Role {

    private String id;
    private String roleName;
    private String roleDesc;

    // 一个角色有多个权限
    private List<Permission> permissions;
    // 一个角色能被多个用户拥有
    private List<UserInfo> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
