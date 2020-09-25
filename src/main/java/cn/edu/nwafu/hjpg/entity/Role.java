package cn.edu.nwafu.hjpg.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Role")
@Data
public class Role {
  @Id
  private String id;
  private String menus;
  private String name;
  private long roleId;


}
