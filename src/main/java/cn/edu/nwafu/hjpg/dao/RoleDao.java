package cn.edu.nwafu.hjpg.dao;

import cn.edu.nwafu.hjpg.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Johnny
 * @title: RoleDao
 * @description: TODO
 * @date 8/19/20208:18 PM
 */
public interface RoleDao extends MongoRepository<Role, String> {
    Role findRoleByRoleId(int id);
}
