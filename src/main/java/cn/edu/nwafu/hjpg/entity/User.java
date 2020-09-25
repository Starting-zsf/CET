package cn.edu.nwafu.hjpg.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "User")
@Data
public class User {
  @Id
  private String id;
  private String password;
  private int role;
  @Indexed
  private String username;
  private String nickname;
  private String salt;
  private String mobile;
  private String email;
  private String department;
  private Date gmtCreate;
  private Date gmtModified;
}
