package com.taotao.manage.mapper;

import com.taotao.manage.base.mapper.TaotaoMapper;
import com.taotao.manage.pojo.ItemParamItem;

public interface ItemParamItemMapper extends TaotaoMapper<ItemParamItem>{

    /**
     * 更加商品id更新规格参数数据
     * @param itemParamItem
     */
    void updateParamByItemId(ItemParamItem itemParamItem);

}
