package cn.edu.nwafu.hjpg.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Johnny
 * @title: JwtAuthenticatioToken
 * @projectName hjpg
 * @description: TODO
 * @date 8/17/20208:27 PM
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = 1L;

    private String token;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public JwtAuthenticationToken(Object principal, Object credentials){
        super(principal, credentials);
    }

    public JwtAuthenticationToken(Object principal, Object credentials, String token){
        super(principal, credentials);
        this.token = token;
    }

    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, authorities);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
