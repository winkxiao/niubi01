package cn.xiaowei.service.Impl;

import cn.xiaowei.dao.PermissionDao;
import cn.xiaowei.dao.RoleDao;
import cn.xiaowei.domain.Role;
import cn.xiaowei.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/29 0:03
 */

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Role> findAll(int page, int size) {
       // / 参数pageNum    页码值，pagesize 每页显示条数
        PageHelper.startPage(page,size);

        return roleDao.findAll();
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public List<Role> findOtherRole(String userid) {
        return roleDao.findOtherRole(userid);
    }

    @Override
    public void deleteRole(String id) {
        // 从中间表删除对应关系
        roleDao.deleteRoleInRo_Per(id);
        permissionDao.deletRoleInPer_Ro(id);

        roleDao.deleteRole(id);
    }
}
