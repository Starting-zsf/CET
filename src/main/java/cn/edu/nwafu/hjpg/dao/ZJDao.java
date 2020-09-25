package cn.edu.nwafu.hjpg.dao;

import cn.edu.nwafu.hjpg.entity.Zj;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZJDao extends MongoRepository<Zj,String> {
    Page<Zj> findAllByCasNoLikeOrDisplayNameLike(String casNo, String displayName, Pageable pageable);
}
