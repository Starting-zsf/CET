package cn.edu.nwafu.hjpg.controller;

import cn.edu.nwafu.hjpg.common.HttpResult;
import cn.edu.nwafu.hjpg.common.SystemConstants;
import cn.edu.nwafu.hjpg.entity.User;
import cn.edu.nwafu.hjpg.service.UserService;
import cn.edu.nwafu.hjpg.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    @ResponseBody
    public Page<?> findAll(@RequestParam(required = false, defaultValue = "1") int pageNumber,
                           @RequestParam(required = false, defaultValue = "10") int pageSize, @RequestParam(required = false, defaultValue = "") String username) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return userService.findByNamePage(username, pageable);
    }


    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public HttpResult addUser(@RequestBody User user) {
        if (userService.findByName(user.getUsername()) != null) {
            return HttpResult.error("用户名已存在!");
        }
        String salt = PasswordUtils.getSalt();
        String password = PasswordUtils.encode(user.getPassword(), salt);
        user.setPassword(password);
        user.setSalt(salt);
        return HttpResult.ok(userService.addUser(user));
    }


    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public HttpResult updateUser(@RequestBody User user) {
        return HttpResult.ok(userService.updateUser(user));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public HttpResult delUser(User user) {
        userService.delUser(user);
        return HttpResult.ok();

    }
    @DeleteMapping(value="/")
    public HttpResult delete(@RequestBody List<User> records) {

        return HttpResult.ok(userService.batchDelUser(records));
    }

}
