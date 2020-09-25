package cn.edu.nwafu.hjpg.service;

import cn.edu.nwafu.hjpg.entity.Menu;
import cn.edu.nwafu.hjpg.entity.Role;

import java.util.List;

/**
 * @author Johnny
 * @title: MenuService
 * @projectName hjpg
 * @description: TODO
 * @date 8/17/20204:50 PM
 */
public interface MenuService {
    List<Menu> findMenuByRole(Role role);
}
