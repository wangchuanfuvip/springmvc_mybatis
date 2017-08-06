package cn.itcast.mybatis.fx;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.itcast.mybatis.fx.pojo.User;

public class MybatisTest2 {

    public static void main(String[] args) throws Exception {
        
        //如何获取SqlSessionFactory
        
        String mybatisConfig = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfig);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        
        User user = sqlSession.selectOne("my.test.queryUserById", 1L);
        System.out.println(user);
    }

}
