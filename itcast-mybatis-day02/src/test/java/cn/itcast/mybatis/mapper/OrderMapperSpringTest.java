package cn.itcast.mybatis.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.mybatis.pojo.Order;
import cn.itcast.mybatis.pojo.OrderUser;

public class OrderMapperSpringTest {

    private OrderMapper orderMapper;

    @Before
    public void setUp() throws Exception {
        //初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.orderMapper = context.getBean(OrderMapper.class);
    }

    /**
     * 一对一的第一种实现
     */
    @Test
    public void testQueryOrderAndUserByOrderNumber() {
        OrderUser orderUser = this.orderMapper.queryOrderAndUserByOrderNumber("20140921001");
        System.out.println(orderUser);
    }
    
    /**
     * 一对一的第二种实现
     */
    @Test
    public void testQueryOrderAndUserByOrderNumber2() {
        Order order = this.orderMapper.queryOrderAndUserByOrderNumber2("20140921001");
        System.out.println(order);
    }
    
    /**
     * 一对多
     */
    @Test
    public void testQueryOrderAndUserAndOrderDetailByOrderNumber() {
        Order order = this.orderMapper.queryOrderAndUserAndOrderDetailByOrderNumber("20140921001");
        System.out.println(order);
    }
    
    /**
     * 多对多
     */
    @Test
    public void testQueryOrderAndUserAndOrderDetailAndItemByOrderNumber() {
        Order order = this.orderMapper.queryOrderAndUserAndOrderDetailAndItemByOrderNumber("20140921001");
        System.out.println(order);
    }
    
    /**
     * 测试延迟加载
     */
    @Test
    public void testQueryOrderAndLazyUserByOrderNumber() {
        Order order = this.orderMapper.queryOrderAndLazyUserByOrderNumber("20140921001");
        System.out.println(order.getUser());
        System.out.println(order);
    }
    
}
