package cn.edu.nwafu.hjpg.security;

import cn.edu.nwafu.hjpg.entity.User;
import cn.edu.nwafu.hjpg.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Johnny
 * @title: UserDetailsServiceImpl
 * @projectName hjpg
 * @description: TODO
 * @date 8/17/20208:40 PM
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        return new JwtUserDetails(user.getUsername(), user.getPassword(), user.getSalt(), null);
    }
}
