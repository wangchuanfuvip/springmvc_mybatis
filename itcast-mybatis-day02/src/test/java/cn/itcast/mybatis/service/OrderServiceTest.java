package cn.itcast.mybatis.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.mybatis.pojo.Order;

public class OrderServiceTest {
    
    private OrderService orderService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-transaction.xml"});
        this.orderService = context.getBean(OrderService.class);
    }

    @Test
    public void testQueryOrderByOrderNumber() {
        Order order = this.orderService.queryOrderByOrderNumber("20140921001");
        System.out.println(order);
    }

}
