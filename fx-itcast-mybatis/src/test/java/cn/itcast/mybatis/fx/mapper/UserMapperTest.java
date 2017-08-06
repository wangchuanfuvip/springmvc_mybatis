package cn.itcast.mybatis.fx.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.fx.pojo.User;

public class UserMapperTest {
    
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        String mybatisConfig = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfig);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testQueryUserById() {
        User user = this.userMapper.queryUserById(1L);
        System.out.println(user);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("user_2015_03");
        user.setPassword("123456");
        user.setSex(true);
        user.setUserName("username_2015_03");
        
        this.userMapper.saveUser(user);
        
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = this.userMapper.queryUserById(83L);
        user.setPassword("abc");
        this.userMapper.updateUser(user);
    }

    @Test
    public void testDeleteUserById() {
        this.userMapper.deleteUserById(83L);
    }

}
