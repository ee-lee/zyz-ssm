package com.yc.service.impl;

import com.yc.dao.JuserMapper;
import com.yc.dao.UserMapper;
import com.yc.pojo.Juser;
import com.yc.pojo.User;
import com.yc.service.JuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuserServiceImpl implements JuserService {

    @Autowired
    private JuserMapper juserMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Juser login(Juser juser) {
        return juserMapper.login(juser);
    }

    @Override
    public List<Juser> findJuser(int tag, int rows) {
        return juserMapper.findJusers(tag,rows);
    }

    @Override
    public List<Juser> findJuserByjname(String jname, int tag, int rows) {
        return juserMapper.findJusersByjname(jname,tag,rows);
    }


    @Override
    public int addJuser(Juser juser) {
        if (juserMapper.insert(juser) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePwd(String pwd, String pwd2, int rid) {
        if (juserMapper.updatePwd(pwd,pwd2,rid) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateByJuser(Juser juser) {
      if( juserMapper.updateByJuser(juser)> 0)
          return 1;
      return 0;
    }

    @Override
    public int updateUissys(int jissys, int jid) {
        if( juserMapper.updateUissys(jissys,jid)> 0)
            return 1;
        return 0;
    }

    @Override
    public int deleteJuser(int jid) {
        if (juserMapper.deleteByPrimaryKey(jid) > 0) {
        return 1;
    }
        return 0;
    }


    @Override
    public List<User> selectByjid(int jid,int tag,int rows) {
        return userMapper.selectByjid(jid,tag,rows);
    }

    @Override
    public long getTotalJuser() {
        return juserMapper.getTotalJuser();
    }

    @Override
    public long getTotalJuserByjname(String jname) {
        return juserMapper.getTotalJuserByjname(jname);
    }
}
