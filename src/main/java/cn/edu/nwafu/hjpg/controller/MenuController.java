package cn.edu.nwafu.hjpg.controller;

import cn.edu.nwafu.hjpg.common.HttpResult;
import cn.edu.nwafu.hjpg.entity.Role;
import cn.edu.nwafu.hjpg.entity.User;
import cn.edu.nwafu.hjpg.service.MenuService;
import cn.edu.nwafu.hjpg.service.RoleService;
import cn.edu.nwafu.hjpg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Johnny
 * @title: MenuController
 * @projectName hjpg
 * @description: 菜单Controller, type:游客:1,普通用户:2管理员:3
 * @date 8/17/20204:57 PM
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController {
    Logger log = LoggerFactory.getLogger(MenuController.class);
    final MenuService menuService;
    final UserService userService;
    final RoleService roleService;

    public MenuController(MenuService menuService, UserService userService, RoleService roleService) {
        this.menuService = menuService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "findNavTree")
    @ResponseBody
    public HttpResult findNavTree(String userName) {
        User user = userService.findByName(userName);
        Role role = roleService.findRoleByUser(user);
        return HttpResult.ok(menuService.findMenuByRole(role));
    }
}
