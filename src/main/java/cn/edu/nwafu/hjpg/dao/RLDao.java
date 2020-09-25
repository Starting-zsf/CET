package cn.edu.nwafu.hjpg.dao;

import cn.edu.nwafu.hjpg.entity.Rl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RLDao extends MongoRepository<Rl,String> {

    Page<Rl> findAllByCasNoLikeOrDisplayNameLike(String casNo, String displayName, Pageable pageable);
}
