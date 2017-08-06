package com.taotao.manage.mapper;

import com.taotao.manage.base.mapper.TaotaoMapper;
import com.taotao.manage.pojo.ItemCat;

public interface ItemCatMapper extends TaotaoMapper<ItemCat>{

    /**
     * 根据ID查询商品类目数据，parentId = id(参数)
     * 
     * @param id
     * @return
     */
//    List<ItemCat> queryListById(@Param("id") Long id);

}
