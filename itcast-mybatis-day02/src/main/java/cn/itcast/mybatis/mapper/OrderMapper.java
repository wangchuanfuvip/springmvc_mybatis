package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Order;
import cn.itcast.mybatis.pojo.OrderUser;

public interface OrderMapper {

    /**
     * 根据订单号查询订单并且查询出下单人的信息
     * 
     * @param orderNumber
     * @return
     */
    public OrderUser queryOrderAndUserByOrderNumber(String orderNumber);
    
    /**
     * 根据订单号查询订单并且查询出下单人的信息,第二种实现
     * 
     * @param orderNumber
     * @return
     */
    public Order queryOrderAndUserByOrderNumber2(String orderNumber);
    
    /**
     * 查询订单，查询出下单人信息并且查询出订单详情。
     * @param orderNumber
     * @return
     */
    public Order queryOrderAndUserAndOrderDetailByOrderNumber(String orderNumber);
    
    /**
     * 查询订单，查询出下单人信息并且查询出订单详情中的商品数据。
     * 
     * @param orderNumber
     * @return
     */
    public Order queryOrderAndUserAndOrderDetailAndItemByOrderNumber(String orderNumber);
    
    /**
     * 延迟加载
     * @param orderNumber
     * @return
     */
    public Order queryOrderAndLazyUserByOrderNumber(String orderNumber);

}
