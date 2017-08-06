package cn.itcast.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.mybatis.mapper.OrderMapper;
import cn.itcast.mybatis.pojo.Order;

@Service
public class OrderService {
    
    //在Service中注入mapper
    @Autowired
    private OrderMapper orderMapper;
    
    public Order queryOrderByOrderNumber(String orderNumber){
        return this.orderMapper.queryOrderAndUserByOrderNumber2(orderNumber);
    }

}
