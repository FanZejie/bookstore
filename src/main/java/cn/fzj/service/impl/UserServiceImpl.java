package cn.fzj.service.impl;

import cn.fzj.mapper.UserMapper;
import cn.fzj.pojo.User;
import cn.fzj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String email, String password) {
        return userMapper.queryUserByEmailAndPwd(email,password);
    }

    @Override
    public boolean CheckUserExist(String email) {
        if (userMapper.queryUserByEmail(email)!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int register(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        int flag = userMapper.addUser(user);
        return flag;
    }
}
