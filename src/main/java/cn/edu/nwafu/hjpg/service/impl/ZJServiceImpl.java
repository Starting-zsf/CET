package cn.edu.nwafu.hjpg.service.impl;

import cn.edu.nwafu.hjpg.dao.ZJDao;
import cn.edu.nwafu.hjpg.entity.Zj;
import cn.edu.nwafu.hjpg.service.ZJService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ZJServiceImpl implements ZJService {
    final
    ZJDao zjDao;

    public ZJServiceImpl(ZJDao zjDao) {
        this.zjDao = zjDao;
    }

    @Override
    public List<Zj> findAll() {
        return zjDao.findAll();
    }

    @Override
    public Page<Zj> findByPageLike(String keyword,Pageable pageable) {
        return zjDao.findAllByCasNoLikeOrDisplayNameLike(keyword,keyword,pageable);
    }

    @Override
    public int add(Zj zj) {
        return 0;
    }

    @Override
    public int update(Zj zj) {
        return 0;
    }

    @Override
    public void del(Zj zj) {

    }
}
