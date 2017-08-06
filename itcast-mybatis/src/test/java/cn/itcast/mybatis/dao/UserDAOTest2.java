package cn.itcast.mybatis.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.pojo.User;

public class UserDAOTest2 {

    private IUser userDAO = null;
    
    private SqlSession sqlSession = null;

    @Before
    public void init() {
        try {
            // 构造SqlSessionFactory
            // 定义配置文件路径
            String resource = "mybatis-config.xml";
            // 读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 通过SqlSessionFactoryBuilder构建一个SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"test");
            this.sqlSession = sqlSessionFactory.openSession(false);
            this.userDAO = sqlSession.getMapper(IUser.class);
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
    public void testQueryByTabkeName() {
        List<HashMap<String, Object>> list = this.userDAO.queryByTabkeName("tb_item");
        for (HashMap<String, Object> hashMap : list) {
            System.out.println(hashMap);
        }
    }
    
    @Test
    public void testQueryUserByUserNameAndPassword() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "zhangsan");
        map.put("password", "123456");
//        User user = this.userDAO.queryUserByUserNameAndPassword(map);
        User user = this.userDAO.queryUserByUserNameAndPassword("zhangsan","123456");
        System.out.println(user);
    }

    @Test
    public void testSaveUser() {
       User user = new User();
       user.setAge(20);
       user.setBirthday(new Date());
       user.setName("test_name_9");
       user.setPassword("123456");
       user.setSex(true);
       user.setUserName("test_username_9");
       
       this.userDAO.saveUser(user);
       
       System.out.println(user);
       // 提交
       this.sqlSession.commit();
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
