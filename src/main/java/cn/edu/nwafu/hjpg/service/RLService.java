package cn.edu.nwafu.hjpg.service;

import cn.edu.nwafu.hjpg.entity.Rl;
import cn.edu.nwafu.hjpg.entity.Zj;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RLService {
    List<Rl> findAll();

    int add(Rl rl);

    Page<Rl> findByPageLike(String keyword, Pageable pageable);

    int update(Rl rl);
    void del(Rl rl);

}
