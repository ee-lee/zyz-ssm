package com.yc.service;


import com.yc.pojo.User;
import java.util.List;


public interface UserService {
    /**
     * User 登录
     */
    User login(User user);

    /**
     *查询用户User
     */
    public List<User> findUser(int tag, int  rows);
    /**
     *查询用户User
     */
    public List<User> findUserByuname( String uanme,int tag, int  rows);
    /**
     *查询用户总数
     */
    public long getTotalUserByuname(String uname);
    /**
     *查询用户
     */
    public long getUserToWelcome(int uissys );


    /**
     * 修改密码
     */
    public int updatePwd(String pwd,String pwd2,int uid);

    /**
     * 修改积分
     */
    public int updateScore(int uid);

    /**
     * 修改用户，一般是 用户身份信息是否通过审核
     */
    public int updateUissys(int uissys,int uid);

    /**
     *添加一个用户
     */
    public int addUser(User user);

    /**
     * 删除用户
     */
    public int deleteUser(Integer id);

    long getTotalUser();


    /**
     * 注册 查询表单是否注册过
     * @param email
     * @return
     */
    int findemail(String email);

    List<User> selectByJid(int jid, int tag, int rows);
}
