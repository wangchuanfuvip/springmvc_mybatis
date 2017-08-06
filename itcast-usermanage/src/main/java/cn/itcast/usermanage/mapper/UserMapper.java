package cn.itcast.usermanage.mapper;

import java.util.List;

import cn.itcast.usermanage.pojo.User;

public interface UserMapper {

    /**
     * 查询用户数据列表
     * @return
     */
    public List<User> queryList();

    /**
     * 新增用户
     * @param user
     */
    public void save(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void update(User user);

}
