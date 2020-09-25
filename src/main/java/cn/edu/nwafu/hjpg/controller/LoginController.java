package cn.edu.nwafu.hjpg.controller;

import cn.edu.nwafu.hjpg.common.HttpResult;
import cn.edu.nwafu.hjpg.entity.User;
import cn.edu.nwafu.hjpg.dto.LoginBean;
import cn.edu.nwafu.hjpg.security.JwtAuthenticationToken;
import cn.edu.nwafu.hjpg.service.UserService;
import cn.edu.nwafu.hjpg.utils.PasswordUtils;
import cn.edu.nwafu.hjpg.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class LoginController {
    Logger log = LoggerFactory.getLogger(LoginController.class);
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public LoginController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();

        // 用户信息
        User user = userService.findByName(username);

        // 账号不存在、密码错误
        if (user == null) {
            log.info("账号不存在");
            return HttpResult.error("账号不存在");
        }

        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }



        // 系统登录认证
        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        token.setNickname(user.getNickname());
        token.eraseCredentials();
        return HttpResult.ok(token);
    }

}
