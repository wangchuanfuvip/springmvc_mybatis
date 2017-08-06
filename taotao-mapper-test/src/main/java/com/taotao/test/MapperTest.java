package com.taotao.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.abel533.mapper.Mapper;
import com.github.abel533.mapperhelper.MapperHelper;
import com.taotao.test.base.mapper.TaotaoMapper;
import com.taotao.test.mapper.UserMapper;
import com.taotao.test.pojo.User;

public class MapperTest {

    public static void main(String[] args) throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession(true);

        // 创建一个MapperHelper
        MapperHelper mapperHelper = new MapperHelper();
        // 主键自增回写方法,默认值MYSQL,详细说明请看文档
        mapperHelper.setIDENTITY("MYSQL");
        // 注册通用Mapper接口
        mapperHelper.registerMapper(TaotaoMapper.class);
        // 配置完成后，执行下面的操作
        mapperHelper.processConfiguration(session.getConfiguration());
        // OK - mapperHelper的任务已经完成，可以不管了
        
        UserMapper mapper = session.getMapper(UserMapper.class);
        
        User user = new User();
        user.setUserName("zhangsan");
        user.setPassword("123");
        List<User> users = mapper.select(user);
        for (User u : users) {
            System.out.println(u);
        }
        
        mapper.deleteByIDS(new Object[]{81L,82L,83L});
        
        
        User user2 = mapper.selectByPrimaryKey(1L);
        System.out.println(user2);
        
        User user3 = new User();
        user3.setAge(20);
        user3.setUserName("user3");
        
//        mapper.insert(user3);//
//        
//        mapper.insertSelective(user3);
        

    }

}
