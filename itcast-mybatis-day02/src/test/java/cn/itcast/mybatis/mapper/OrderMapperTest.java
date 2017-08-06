package cn.itcast.mybatis.mapper;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.pojo.Order;
import cn.itcast.mybatis.pojo.OrderUser;

public class OrderMapperTest {

    private OrderMapper orderMapper;

    @Before
    public void setUp() throws Exception {
        // 初始化UserMapper
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        this.orderMapper = sqlSession.getMapper(OrderMapper.class);
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
