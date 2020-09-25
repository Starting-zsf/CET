package cn.edu.nwafu.hjpg.service;

import cn.edu.nwafu.hjpg.entity.Role;
import cn.edu.nwafu.hjpg.entity.User;

/**
 * @author Johnny
 * @title: RoleService
 * @description: TODO
 * @date 8/19/20208:21 PM
 */
public interface RoleService {
    Role findRoleByUser(User user);
}
