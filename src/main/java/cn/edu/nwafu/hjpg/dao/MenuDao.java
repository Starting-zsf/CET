package cn.edu.nwafu.hjpg.dao;

import cn.edu.nwafu.hjpg.entity.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Johnny
 * @title: MenuDao
 * @projectName hjpg
 * @description: TODO
 * @date 8/17/20204:48 PM
 */
public interface MenuDao extends MongoRepository<Menu,String> {
    Menu findMenuByMenuId(int id);
}
