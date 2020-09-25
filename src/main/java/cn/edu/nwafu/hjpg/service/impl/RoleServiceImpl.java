package cn.edu.nwafu.hjpg.service.impl;

import cn.edu.nwafu.hjpg.dao.RoleDao;
import cn.edu.nwafu.hjpg.entity.Role;
import cn.edu.nwafu.hjpg.entity.User;
import cn.edu.nwafu.hjpg.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author Johnny
 * @title: RoleServiceImpl
 * @description: TODO
 * @date 8/19/20208:21 PM
 */
@Service
public class RoleServiceImpl implements RoleService {
    final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role findRoleByUser(User user) {

        return roleDao.findRoleByRoleId(user.getRole());
    }
}
