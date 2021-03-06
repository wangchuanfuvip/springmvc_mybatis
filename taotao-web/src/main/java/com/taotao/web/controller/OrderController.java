package com.taotao.web.controller;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.common.vo.TaotaoResult;
import com.taotao.web.pojo.Cart;
import com.taotao.web.pojo.Order;
import com.taotao.web.pojo.User;
import com.taotao.web.service.CartService;
import com.taotao.web.service.ItemService;
import com.taotao.web.service.OrderService;
import com.taotao.web.service.UserService;
import com.taotao.web.threadlocal.UserThreadLocal;

@RequestMapping("order")
@Controller
public class OrderController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @RequestMapping("{itemId}")
    public ModelAndView create(@PathVariable("itemId") Long itemId) {
        ModelAndView mv = new ModelAndView("order");
        mv.addObject("item", this.itemService.queryItemById(itemId));
        return mv;
    }

    @RequestMapping("create")
    public ModelAndView createOrder() {
        User user = UserThreadLocal.get();
        // 查询该用户的购物车
        List<Cart> carts = this.cartService.queryCartByUser(user);
        ModelAndView mv = new ModelAndView("order-cart");
        mv.addObject("carts", carts);
        return mv;
    }

    /**
     * 创建订单
     * 
     * @param order
     * @param ticket
     * @return
     */
    @RequestMapping("submit")
    @ResponseBody
    public TaotaoResult create(Order order) {
        User user = UserThreadLocal.get();
        order.setUserId(user.getId());
        order.setBuyerNick(user.getUsername());
        String orderNo = this.orderService.createOrder(order);
        return TaotaoResult.ok(orderNo);
    }

    /**
     * 下单成功页
     * 
     * @param id
     * @return
     */
    @RequestMapping("success")
    public ModelAndView success(@RequestParam("id") String id) {
        ModelAndView mv = new ModelAndView("success");
        Order order = this.orderService.queryOrderById(id);
        mv.addObject("order", order);
        mv.addObject("date", new DateTime().plusDays(2).toString("MM月dd日"));
        return mv;

    }

}
