package cn.edu.nwafu.hjpg.controller;


import cn.edu.nwafu.hjpg.common.HttpResult;
import cn.edu.nwafu.hjpg.dto.Element;
import cn.edu.nwafu.hjpg.service.ElementService;
import cn.edu.nwafu.hjpg.service.RLService;
import cn.edu.nwafu.hjpg.service.ZJService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/element")
public class ElementController {
    final RLService rlService;
    final ZJService zjService;
    final ElementService elementService;
    public ElementController(RLService rlService, ZJService zjService, ElementService elementService) {
        this.rlService = rlService;
        this.zjService = zjService;
        this.elementService = elementService;
    }


    @GetMapping(value = "/" )
    @ResponseBody
    public List<Object> findAll(@RequestParam  String type) {
        if(type == null) {
            type = "all";
        }
        return elementService.findAll(type);
    }
    /**
     * 根据一个或者多个属性分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/{type}/{pageNumber}/{pageSize}")
    @ResponseBody
    public Page<?> queryElemByPage(@PathVariable("type") String type, @PathVariable("pageNumber") int pageNumber,
                                       @PathVariable("pageSize") int pageSize, @RequestParam(value = "keyword",required = false) String keyword) {
        if (keyword == null) {
            keyword = "";
        }
        //withIgnorePaths 要忽略的属性
        if (pageNumber < 1) {
            pageNumber = 1;
        } else if (pageSize == 0) {
            pageSize = 20;
        }
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        return elementService.findByPageLike(type,keyword,pageable);
    }
    @PostMapping(value = "/")
    @ResponseBody
    public HttpResult addElement(@RequestParam String type, Element element) {
        if(type==null){
            type = "rl";
        }
        return HttpResult.ok(elementService.addElement(type, element));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public HttpResult updateElement(@RequestParam String type,Element element) {
        if(type==null){
            type = "rl";
        }
        return HttpResult.ok(elementService.updateElement(type,element));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public HttpResult delElement(@RequestParam String type,Element element) {
        if(type==null){
            type = "rl";
        }
        elementService.delElement(type, element);
        return HttpResult.ok();
    }

}
