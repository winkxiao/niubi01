package cn.xiaowei.service.Impl;

import cn.xiaowei.dao.PermissionDao;
import cn.xiaowei.domain.Permission;
import cn.xiaowei.domain.Role;
import cn.xiaowei.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/29 18:10
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return permissionDao.findOtherRole(id);
    }

    @Override
    public void addRoleToPermission(String permissionId, String[] ids) {
        for (int i = 0; i < ids.length; i++) {

            permissionDao.addRoleToPermission(permissionId,ids[i]);
        }
    }
}
