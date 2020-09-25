package cn.edu.nwafu.hjpg.service;

import cn.edu.nwafu.hjpg.dto.Element;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ElementService {
    List<Object> findAll(String type);
    Page<?> findByPageLike(String type,String keyword, Pageable pageable);
    String addElement(String type,Element element);
    String updateElement(String type,Element element);
    void delElement(String type,Element element);
}
