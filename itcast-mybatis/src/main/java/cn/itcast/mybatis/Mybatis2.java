package cn.itcast.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.itcast.mybatis.pojo.User;

public class Mybatis2 {

    public static void main(String[] args) throws Exception {
        // 定义配置文件路径
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过SqlSessionFactoryBuilder构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
        // 通过sqlSessionFactory获得SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        System.out.println(session);

        User user = session.selectOne("cn.itcast.mybatis.user.queryUserByUserName", "zhangsan");
        System.out.println(user);
    }

}
