package com.yc.service;


import com.yc.pojo.Juser;
import com.yc.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JuserService {

    /**
     * Juser登录
     */
    Juser login(Juser juser);


    /**
     * 查询所有用户
     * root 权限
     */
    public List<Juser> findJuser(int  tag, int  rows);

    /**
     * 查询所有用户
     * root 权限
     */
    public List<Juser> findJuserByjname(String jname,int  tag, int  rows);
    /**
     *添加一个用户
     */
    public int addJuser(Juser juser);

    /**
     * 修改密码
     */
    int updatePwd(String pwd, String pwd2, int rid);

    /**
     * 更改用户信息
     */
    int updateByJuser(Juser juser);
    /**
     * 更改用户状态
     */
    int updateUissys(int jissys, int jid);

    /**
     * 删除用户
     */
    public int deleteJuser(int jid);




    /**
     * 查询该地区的志愿者 和积分
     */
    List<User> selectByjid(int jid, int tag,int rows);



    long getTotalJuser();

    /**
     *查询rname
     */
    long getTotalJuserByjname(String jname);



}
