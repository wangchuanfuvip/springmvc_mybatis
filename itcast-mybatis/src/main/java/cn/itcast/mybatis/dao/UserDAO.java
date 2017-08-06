package cn.itcast.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.pojo.User;

public class UserDAO implements IUser {

    private SqlSessionFactory sqlSessionFactory = null;

    public UserDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User queryUserByUserName(String userName) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession.selectOne("cn.itcast.mybatis.user.queryUserByUserName", userName);
    }

    @Override
    public void saveUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.insert("cn.itcast.mybatis.user.saveUser", user);
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.update("cn.itcast.mybatis.user.updateUser", user);
    }

    @Override
    public void deleteUserById(Long id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.delete("cn.itcast.mybatis.user.deleteUserById", id);
    }

}
