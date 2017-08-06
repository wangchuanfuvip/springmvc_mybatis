package cn.itcast.mybatis.fx.mapper;

import cn.itcast.mybatis.fx.pojo.User;

public interface UserMapper {
    
    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(Long id);
    
    /**
     * 新增用户数据
     * @param user
     */
    public void saveUser(User user);
    
    /**
     * 更新用户数据
     * @param user
     */
    public void updateUser(User user);
    
    /**
     * 根据ID删除用户数据
     * @param id
     */
    public void deleteUserById(Long id);
    

}
