package cn.edu.nwafu.hjpg.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Johnny
 * @title: GrantedAuthorityImpl
 * @projectName hjpg
 * @description: TODO
 * @date 8/17/20208:20 PM
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String authority;
    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
