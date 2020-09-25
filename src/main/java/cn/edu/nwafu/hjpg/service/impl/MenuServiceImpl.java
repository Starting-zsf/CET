package cn.edu.nwafu.hjpg.service.impl;

import cn.edu.nwafu.hjpg.dao.MenuDao;
import cn.edu.nwafu.hjpg.dao.RoleDao;
import cn.edu.nwafu.hjpg.entity.Menu;
import cn.edu.nwafu.hjpg.entity.Role;
import cn.edu.nwafu.hjpg.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny
 * @title: MenuServiceImpl
 * @projectName hjpg
 * @description: TODO
 * @date 8/17/20204:53 PM
 */
@Service
public class MenuServiceImpl implements MenuService {
    final MenuDao menuDao;
    final RoleDao roleDao;

    public MenuServiceImpl(MenuDao menuDao, RoleDao roleDao) {
        this.menuDao = menuDao;
        this.roleDao = roleDao;
    }


    @Override
    public List<Menu> findMenuByRole(Role role) {
        String[] menus = role.getMenus().split(",");
        List<Menu> result = new ArrayList<>();
        for (String str : menus) {
            result.add(menuDao.findMenuByMenuId(Integer.parseInt(str)));
        }
        return result;
    }
}
