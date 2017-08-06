package cn.itcast.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.mybatis.pojo.User;

public interface UserMapper {
    
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
    
    /**
     * 查询用户数据总数
     * 
     * @return
     */
    public Integer queryUserCount();
    
    /**
     * 查询男性用户，如果输入了姓名，进行模糊查找。
     * 
     * @param name
     * @return
     */
    public List<User> queryUserLikeName(@Param("name")String name);
    
    
    /**
     * 需求2：查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找。
     * @param name
     * @param age
     * @return
     */
    public List<User> queryUserLikeNameOrAge(@Param("name")String name,@Param("age")Integer age);
    
    /**
     * 查询所有用户，如果输入了姓名，进行模糊查找。
     * @param name
     * @return
     */
    public List<User> queryAllUserLikeName(@Param("name")String name);
    
    /**
     * 按照多个ID查询用户信息。
     * @param ids
     * @return
     */
    public List<User> queryUserByIds(@Param("ids")Long[] ids);

}
