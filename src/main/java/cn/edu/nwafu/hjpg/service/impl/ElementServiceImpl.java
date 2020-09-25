package cn.edu.nwafu.hjpg.service.impl;

import cn.edu.nwafu.hjpg.dao.RLDao;
import cn.edu.nwafu.hjpg.dao.ZJDao;
import cn.edu.nwafu.hjpg.entity.Rl;
import cn.edu.nwafu.hjpg.entity.User;
import cn.edu.nwafu.hjpg.entity.Zj;
import cn.edu.nwafu.hjpg.dto.Element;
import cn.edu.nwafu.hjpg.service.ElementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ElementServiceImpl implements ElementService {
    Logger logger = LoggerFactory.getLogger(ElementService.class);
    final ZJDao zjDao;
    final RLDao rlDao;

    public ElementServiceImpl(ZJDao zjDao,RLDao rlDao) {
        this.zjDao = zjDao;
        this.rlDao = rlDao;
    }

    @Override
    public List<Object> findAll(String type) {
        List<Object> array = new ArrayList<>();
        if ("rl".equals(type)){
            array.addAll(rlDao.findAll());
        } else if("zj".equals(type)){
            array.addAll(zjDao.findAll());
        } else {
            array.addAll(rlDao.findAll());
            array.addAll(zjDao.findAll());
        }
        logger.info(String.valueOf(array.size()));
        return array;
    }

    @Override
    public Page<?> findByPageLike(String type, String keyword, Pageable pageable) {
        if("rl".equals(type)){
            return rlDao.findAllByCasNoLikeOrDisplayNameLike(keyword,keyword,pageable);
        }else if("zj".equals(type)){
            return zjDao.findAllByCasNoLikeOrDisplayNameLike(keyword,keyword,pageable);
        }
        return null;
    }

    @Override
    public String addElement(String type, Element element) {
        String result = "";
        if("rl".equals(type)){
            Rl rl = new Rl();
            BeanUtils.copyProperties(element,rl);
            result = rlDao.insert(rl).getId();
        }else if("zj".equals(type)) {
            Zj zj = new Zj();
            BeanUtils.copyProperties(element,zj);
            result = zjDao.insert(zj).getId();
        }
        return result;
    }

    @Override
    public String updateElement(String type, Element element) {
        String result = "";
        if("rl".equals(type)){
            Rl rl = new Rl();
            BeanUtils.copyProperties(element,rl);
            result = rlDao.save(rl).getId();
        }else if("zj".equals(type)) {
            Zj zj = new Zj();
            BeanUtils.copyProperties(element,zj);
            result = zjDao.save(zj).getId();
        }
        return result;
    }

    @Override
    public void delElement(String type, Element element) {
        if("rl".equals(type)){
            Rl rl = new Rl();
            BeanUtils.copyProperties(element,rl);
            rlDao.delete(rl);
        }else if("zj".equals(type)) {
            Zj zj = new Zj();
            BeanUtils.copyProperties(element,zj);
            zjDao.delete(zj);
        }
    }


}
