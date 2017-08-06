package com.taotao.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.cart.mapper.CartMapper;
import com.taotao.cart.pojo.Cart;
import com.taotao.common.vo.TaotaoResult;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    public TaotaoResult saveItem(Cart newCart) {
        // 判断商品是否存在购物车中，如果存在，数量+1
        Cart cart = this.cartMapper.queryCartByUserIdAndItemId(newCart.getUserId(), newCart.getItemId());
        if (cart == null) {
            // 不存在
            this.cartMapper.save(newCart);
            return TaotaoResult.ok(newCart.getId());
        } else {
            // 存在
            cart.setNum(cart.getNum() + 1);
            this.cartMapper.updateCartNum(cart);
            return TaotaoResult.build(202, "该商品已经存在购物车中!商品数量+1", null);
        }
    }

    public TaotaoResult queryCartList(Long userId) {
        List<Cart> carts = this.cartMapper.queryCartList(userId);
        return TaotaoResult.ok(carts);
    }

    /**
     * 修改购物车数量
     * 
     * @param userId
     * @param itemId
     * @param num
     * @return
     */
    public TaotaoResult updateNum(Long userId, Long itemId, Integer num) {
        Integer count = this.cartMapper.updateCartNumByUserIdAndItemId(userId, itemId, num);
        if (count == null || count.intValue() == 0) {
            return TaotaoResult.build(201, "该商品不存在购物车中!");
        }
        return TaotaoResult.ok();
    }

    /**
     * 删除商品
     * 
     * @param userId
     * @param itemId
     * @return
     */
    public TaotaoResult delete(Long userId, Long itemId) {
        Integer count = this.cartMapper.delete(userId, itemId);
        if (count == null || count.intValue() == 0) {
            return TaotaoResult.build(201, "该商品不存在购物车中!");
        }
        return TaotaoResult.ok();
    }

}