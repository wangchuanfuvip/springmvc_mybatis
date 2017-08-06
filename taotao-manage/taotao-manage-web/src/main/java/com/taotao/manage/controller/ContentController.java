package com.taotao.manage.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.vo.EasyUIResult;
import com.taotao.common.vo.TaotaoResult;
import com.taotao.manage.pojo.Content;
import com.taotao.manage.service.ContentService;

@RequestMapping("content")
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("query/list")
    @ResponseBody
    public EasyUIResult queryList(@RequestParam("categoryId") Long categoryId,
            @RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        return this.contentService.queryList(categoryId, page, rows);
    }

    /**
     * 新增内容数据
     * 
     * @param content
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public TaotaoResult save(Content content) {
        // 设置实体数据
        content.setCreated(new Date());
        content.setUpdated(content.getCreated());
        this.contentService.save(content);
        return TaotaoResult.ok();
    }

}
