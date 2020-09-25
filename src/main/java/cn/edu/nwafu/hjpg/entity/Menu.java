package cn.edu.nwafu.hjpg.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Menu")
public class Menu {
  @Id
  private String id;
  private String children;
  private String icon;
  private long level;
  private long menuId;
  private String name;
  private long orderNum;
  private long parentId;
  private String parentName;
  private String perms;
  private long type;
  private String url;


}
