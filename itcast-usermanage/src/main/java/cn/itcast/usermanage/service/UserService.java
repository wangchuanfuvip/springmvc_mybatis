package cn.itcast.usermanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.pojo.User;
import cn.itcast.usermanage.vo.EasyUIResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理用户相关的业务逻辑
 * 
 */
@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;

    public EasyUIResult queryUserList(Integer page,Integer rows) {
        PageHelper.startPage(page, rows);//分页
        //执行数据库查询
        List<User> users = this.userMapper.queryList();
        //封装pageinfo对象，获取全面的分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        //封装EasyUIResult并且返回
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 新增用户
     * @param user
     */
    public void saveUser(User user) {
       this.userMapper.save(user);
    }

    public void updateUser(User user) {
        this.userMapper.update(user);
    }

    /**
     * 查询所有用户信息
     * 
     * @return
     */
    public List<User> queryAll() {
        return this.userMapper.queryList();
    }

}
