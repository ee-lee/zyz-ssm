package com.yc.service;





import com.yc.pojo.Root;

import java.util.List;



public interface RootService {

    /**
     * Root登录
     */
    Root login(Root root);


    /**
     * 查询所有用户
     */
    public List<Root> findRoot(int tag, int rows);

    /**
     *添加一个用户
     */
    public int addRoot(Root root);

    /**
     * 修改密码
     */
    int updatePwd( String pwd, String pwd2,  int rid);

    /**
     * 删除用户
     */
    public int deleteRoot(int rid);


    /**
     *查询rname
     */
    List<Root> selectByrname(String rname);



    long getTotalRoot();



}
