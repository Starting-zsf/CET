package cn.edu.nwafu.hjpg.service.impl;

import cn.edu.nwafu.hjpg.dao.RoleDao;
import cn.edu.nwafu.hjpg.dao.UserDao;
import cn.edu.nwafu.hjpg.entity.Role;
import cn.edu.nwafu.hjpg.entity.User;
import cn.edu.nwafu.hjpg.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    final UserDao userDao;
    final RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public String addUser(User user) {
        return userDao.insert(user).getId();
    }

    @Override
    public String updateUser(User user) {
        return userDao.save(user).getId();
    }

    @Override
    public void delUser(User user) {
        userDao.delete(user);
    }

    @Override
    public int batchDelUser(List<User> records) {
        for(User user:records){
            delUser(user);
        }
        return 1;
    }

    @Override
    public User findByName(String name) {
        return userDao.findUserByUsername(name);
    }

    @Override
    public Page<?> findByNamePage(String usename, Pageable pageable) {
        return userDao.findAllByRoleAndUsernameLike(2,usename, pageable);
    }
}

