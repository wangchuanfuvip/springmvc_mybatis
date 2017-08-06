package cn.itcast.mybatis.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.pojo.User;

public class UserDAOTest {

    private IUser userDAO = null;

    @Before
    public void init() {
        try {
            // 构造SqlSessionFactory
            // 定义配置文件路径
            String resource = "mybatis-config.xml";
            // 读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 通过SqlSessionFactoryBuilder构建一个SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            this.userDAO = new UserDAO(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByUserName() {
        User user = this.userDAO.queryUserByUserName("zhangsan");
        System.out.println(user);
    }

    @Test
    public void testSaveUser() {
       User user = new User();
       user.setAge(20);
       user.setBirthday(new Date());
       user.setName("test_name_4");
       user.setPassword("123456");
       user.setSex(true);
       user.setUserName("test_username_4");
       
       this.userDAO.saveUser(user);
       
       System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("test_name_1");
        user.setPassword("123qwe");
        user.setSex(true);
        user.setId(63L);
        
        this.userDAO.updateUser(user);
    }

    @Test
    public void testDeleteUserById() {
        this.userDAO.deleteUserById(63L);
    }

}
