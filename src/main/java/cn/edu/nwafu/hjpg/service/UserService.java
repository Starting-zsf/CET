package cn.edu.nwafu.hjpg.service;

import cn.edu.nwafu.hjpg.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll();
    String addUser(User user);
    String updateUser(User user);
    void delUser(User user);
    int batchDelUser(List<User> records);
    User findByName(String name);

    Page<?> findByNamePage(String username, Pageable pageable);
}
