package com.yc.service.impl;

import com.yc.dao.UserMapper;
import com.yc.pojo.User;
import com.yc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> findUser(int tag, int rows) {
        return userMapper.findUsers(tag, rows);
    }

    @Override
    public List<User> findUserByuname(String uanme, int tag, int rows) {
        return userMapper.findUsersByuname(uanme, tag, rows);
    }

    @Override
    public long getTotalUserByuname(String uname) {
        return userMapper.getTotalUserByuname(uname);
    }

    @Override
    public long getUserToWelcome(int uissys) {
        return userMapper.getUserToWelcome(uissys);
    }

    @Override
    public int updatePwd(String pwd, String pwd2, int uid) {
        if (userMapper.updatePwd(pwd, pwd2, uid) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateScore(int uid) {
        if (userMapper.updateScore(uid) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateUissys(int uissys, int uid) {
        if (userMapper.updateUissys(uissys, uid) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int addUser(User user) {
        try {
            userMapper.insert(user);
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

    @Override
    public int deleteUser(Integer id) {
        if (userMapper.deleteByPrimaryKey(id) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public long getTotalUser() {
        return userMapper.getTotalUser();
    }

    @Override
    public int findemail(String email) {
        return userMapper.findemail(email);
    }

    @Override
    public List<User> selectByJid(int jid, int tag, int rows) {
        return userMapper.selectByJid(jid,tag,rows);
    }


}
