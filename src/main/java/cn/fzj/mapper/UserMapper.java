package cn.fzj.mapper;

import cn.fzj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();
    User queryUserById(int id);
    String queryUsernameById(int id);
    User queryUserByEmailAndPwd(String email,String password);
    User queryUserByEmail(String email);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
