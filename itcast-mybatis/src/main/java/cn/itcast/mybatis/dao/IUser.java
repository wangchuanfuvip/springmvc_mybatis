package cn.itcast.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.mybatis.pojo.User;

public interface IUser {
    
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    public User queryUserByUserName(@Param("userName")String userName);
    
    /**
     * 新增用户数据
     * 
     * @param user
     */
    public void saveUser(User user);
    
    /**
     * 更新用户数据U
     * @param user
     */
    public void updateUser(User user);
    
    /**
     * 根据id删除用户数据
     * @param id
     */
    public void deleteUserById(Long id);
    
    /**
     * 通用查询实现
     * 
     * @param tableName
     * @return
     */
    public List<HashMap<String, Object>> queryByTabkeName(String tableName);
    
    /**
     * 根据用户密码查询
     * 
     * @param userName
     * @param password
     * @return
     */
//    public User queryUserByUserNameAndPassword(HashMap<String, Object> map);
    
    public User queryUserByUserNameAndPassword(@Param("userName")String userName, @Param("password")String password);

}
