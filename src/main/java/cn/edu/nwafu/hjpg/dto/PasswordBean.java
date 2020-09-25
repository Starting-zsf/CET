package cn.edu.nwafu.hjpg.dto;

import lombok.Data;

@Data
public class PasswordBean {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;


}
