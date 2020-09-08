package com.yc.dao;

import com.yc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 登录
     */
    @Select("select * from user where email=#{email} and pwd=#{pwd} limit 1 ")
    User login(User user);

    /**
     * @param tag
     * @param rows
     * @return
     */
    @Select("select * from user  limit #{tag},#{rows} ")
    List<User> findUsers(@Param("tag") int tag, @Param("rows") int rows);

    @Insert("insert into user(uname, gender, pwd, email, jid, age,phone,address,idcard,regtime) " +
            " values(#{uname},#{gender},#{pwd},#{email},#{jid},#{age},#{phone},#{address},#{idcard},#{regtime})")
    int insert(User user);

/*    @Update("update user set uname=#{uname},gender=#{gender},jid=#{jid},age=#{age},phone=#{phone},address=#{address},idcard=#{idcard}" +
            "  where uid=#{uid}")
    int updateByPrimaryKey(User user);*/

    /**
     * 改密码
     *
     * @param pwd
     * @param uid
     * @return
     */
    @Update("update user set pwd =#{pwd2} where uid=#{uid} and pwd=#{pwd}")
    int updatePwd(@Param("pwd") String pwd, @Param("pwd2") String pwd2, @Param("uid") int uid);

    /**
     * 增加得分 每次加一分
     *
     * @param uid
     * @return
     */
    @Update("update user set  score=score+1 where uid=#{uid}")
    int updateScore(@Param("uid") int uid);

    /**
     * 志愿者身份审核 1 通过
     *
     * @param uissys
     * @param uid
     * @return
     */
    @Update("update user set  uissys=#{uissys} where uid=#{uid}")
    int updateUissys(@Param("uissys") int uissys, @Param("uid") int uid);


    @Delete("delete from user where uid =#{uid}")
    int deleteByPrimaryKey(int uid);


    /**
     * 查询用户所属的街道积分
     *
     * @param jid
     * @return
     */
    @Select("select uname, gender, email, age, score,phone,address from user where jid =#{jid} " +
            "  limit #{tag},#{rows}")
    List<User> selectByjid(int jid, @Param("tag") int tag, @Param("row") int rows);


    @Select("select count(uid) from user")
    long getTotalUser();

    @Select("select count(uid) from user where uissys =#{uissys} ")
    long getUserToWelcome(@Param("uissys") int uissys);

    @Select("select count(uid) from user where uname like '%${uname}%'  ")
    long getTotalUserByuname(@Param("uname") String uname);

    /**
     * @param tag
     * @param rows
     * @return
     */
    @Select("select * from user where uname like  '%${uname}%'  limit #{tag},#{rows} ")
    List<User> findUsersByuname(@Param("uname") String uname, @Param("tag") int tag, @Param("rows") int rows);


    /**
     * @param email
     * @return
     */

    @Select("select count(uid) from user where email = #{email} limit 1 ")
    int findemail(@Param("email") String email);


    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);


    @Select("select * from user where jid =  #{jid}  limit #{tag},#{rows} ")
    List<User> selectByJid(@Param("jid") int jid, @Param("tag") int tag, @Param("rows") int rows);

}
