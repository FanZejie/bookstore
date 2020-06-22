package cn.fzj.service;

import cn.fzj.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User login(String email,String password);
    boolean CheckUserExist(String email);
    int register(String username,String password,String email);
}
