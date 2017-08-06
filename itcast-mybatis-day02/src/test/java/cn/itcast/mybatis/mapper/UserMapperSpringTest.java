package cn.itcast.mybatis.mapper;

import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.mybatis.pojo.User;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class UserMapperSpringTest {

    private UserMapper userMapper;
    
    private SqlSession sqlSession;
    
    private  SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        //初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.userMapper = context.getBean(UserMapper.class);
    }

    @Test
    public void testQueryUserByUserName() {
        User user = this.userMapper.queryUserByUserName("zhangsan");
        System.out.println(user);
    }
    
    /**
     * 一级缓存
     */
    @Test
    public void testQueryUserByUserNameCache() {
        User user = this.userMapper.queryUserByUserName("zhangsan");
        System.out.println(user);
        
        //清空缓存
//        sqlSession.clearCache();
        
        //更新数据
        user.setAge(20);
        this.userMapper.updateUser(user);
        
        user = this.userMapper.queryUserByUserName("zhangsan");
        System.out.println(user);
    }
    
    /**
     * 二级缓存
     */
    @Test
    public void testQueryUserByUserNameCache2() {
        User user = this.userMapper.queryUserByUserName("zhangsan");
        System.out.println(user);
        this.sqlSession.close();
        
        //重新打开session
        this.sqlSession = this.sqlSessionFactory.openSession(true);
        //由于之前的session已经关闭所以必须重新获取mapper的实现类
        this.userMapper = this.sqlSession.getMapper(UserMapper.class);
        user = this.userMapper.queryUserByUserName("zhangsan");
        System.out.println(user);
    }
        

    @Test
    public void testSaveUser() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateUser() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteUserById() {
        fail("Not yet implemented");
    }

    @Test
    public void testQueryByTabkeName() {
        fail("Not yet implemented");
    }

    @Test
    public void testQueryUserByUserNameAndPassword() {
        fail("Not yet implemented");
    }

    @Test
    public void testQueryUserCount() {
        Integer count = this.userMapper.queryUserCount();
        System.out.println(count);
    }
    
    /**
     * 测试动态sql
     * 查询男性用户，如果输入了姓名，进行模糊查找。
     */
    @Test
    public void testQueryUserLikeName() {
//        List<User> users = this.userMapper.queryUserLikeName("%张%");
        List<User> users = this.userMapper.queryUserLikeName("张");
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    /**
     * 测试分页助手
     */
    @Test
    public void testQueryUserLikeNamePage() {
        // 设置分页数据，第2页，5条数据
        PageHelper.startPage(2, 5);
        List<User> users = this.userMapper.queryUserLikeName(null);
        
        // 封装页面信息
        PageInfo<User> page = new PageInfo<User>(users);
        
        for (User user : page.getList()) {
            System.out.println(user);
        }
        
        System.out.println("数据总条数：" + page.getTotal());
        System.out.println("数据总页数：" + page.getPages());
        System.out.println("最后一页：" + page.getLastPage());
        
        // 不支持分页
        users = this.userMapper.queryUserLikeName(null);
    }
    
    @Test
    public void testQueryUserLikeNameOrAge() {
        List<User> users = this.userMapper.queryUserLikeNameOrAge(null,null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    @Test
    public void testQueryAllUserLikeName() {
        List<User> users = this.userMapper.queryAllUserLikeName("张");
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    @Test
    public void testQueryUserByIds() {
        List<User> users = this.userMapper.queryUserByIds(new Long[]{1L,2L,3L});
        for (User user : users) {
            System.out.println(user);
        }
    }
    

}