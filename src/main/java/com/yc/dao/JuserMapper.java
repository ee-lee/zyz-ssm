package com.yc.dao;

import com.yc.pojo.Juser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface JuserMapper {
    /**
     * 登录
     * */
    @Select("select * from juser where email=#{email} and pwd=#{pwd} limit 1 ")
    Juser login(Juser juser);

    /**
     *
     * @param tag
     * @param rows
     * @return
     */
    @Select("select * from juser  limit #{tag},#{rows} ")
    List<Juser> findJusers(@Param("tag") int tag, @Param("rows")int rows);

    @Select("select * from juser where jname like '%${jname}%' limit #{tag},#{rows}  ")
    List<Juser> findJusersByjname(@Param("jname")String jname,@Param("tag") int tag, @Param("rows")int rows);

    @Insert("insert into juser(pwd,jname,age, email,phone, gender,jissys) " +
            " values(#{pwd},#{jname},#{age},#{email},#{phone},#{gender},#{jissys})")
    int insert(Juser juser);


    /**
     * 改用户信息
     * @param juser
     * @return
     */
    @Update("update juser set jname=#{jname},gender=#{gender},age=#{age},phone=#{phone}" +
            " where jid=#{jid}")
    int updateByJuser(Juser juser);

    /**
     * 改密码
     * @param pwd
     * @param jid
     * @return
     */
    @Update("update juser set pwd =#{pwd2} where jid=#{jid} and pwd=#{pwd}")
    int updatePwd(@Param("pwd") String pwd, @Param("pwd2") String pwd2,@Param("jid") int jid);

    /**
     * juser 0 封禁
     * @param jissys
     * @param jid
     * @return
     */
    @Update("update juser set  jissys=#{jissys} where jid=#{jid}")
    int updateUissys(@Param("jissys") int jissys,@Param("jid") int jid);




    @Delete("delete from juser where jid =#{jid}")
    int deleteByPrimaryKey(int jid);


    @Select("select count(jid) from juser")
    long getTotalJuser();

    /**
     * 模糊查询 rname
     * @param jname
     * @return
     */
    @Select("select count(jid) from juser where  jname like '%${jname}%' ")
    long getTotalJuserByjname(@Param("jname") String jname);

}
