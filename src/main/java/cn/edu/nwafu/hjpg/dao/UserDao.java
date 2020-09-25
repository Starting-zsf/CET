package cn.edu.nwafu.hjpg.dao;

import cn.edu.nwafu.hjpg.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,Long> {
    User findUserByUsername(String username);

    Page<User> findAllByUsernameLike(String username, Pageable pageable);
    Page<User> findAllByRoleAndUsernameLike(int role,String username, Pageable pageable);
}
