package cn.edu.nwafu.hjpg.service;

import cn.edu.nwafu.hjpg.entity.Zj;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZJService {
    List<Zj> findAll();

    Page<Zj> findByPageLike(String keyword, Pageable pageable);

    int add(Zj zj);

    int update(Zj zj);

    void del(Zj zj);
}
