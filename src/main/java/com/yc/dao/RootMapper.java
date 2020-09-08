package com.yc.dao;

import com.yc.pojo.Root;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RootMapper {

    /**
     * 登录
     */
    @Select("select * from root where email=#{email} and pwd=#{pwd} limit 1 ")
    Root login(Root root);

    /**
     * 所有的root
     *
     * @param tag
     * @param rows
     * @return
     */
    @Select("select * from root  limit #{tag} , #{rows}")
    List<Root> findRoot(@Param("tag") int tag, @Param("rows") int rows);


    @Select("select count(rid) from root ")
    long getTotalRoot();

    /**
     * 增加root
     *
     * @param root
     * @return
     */
    @Insert("insert into root( pwd, rname,email,phone) " +
            " values(#{pwd},#{rname},#{email},#{phone})")
    int insertRoot(Root root);


    /**
     * 改密码
     *
     * @param pwd
     * @param rid
     * @return
     */
    @Update("update root set pwd =#{pwd2} where rid=#{rid} and pwd=#{pwd}")
    int updatePwd(@Param("pwd") String pwd, @Param("pwd2") String pwd2, @Param("rid") int rid);

    /**
     * 删除
     *
     * @param rid
     * @return
     */
    @Delete("delete from root where rid =#{rid}")
    int deleteByPrimaryKey(int rid);

    /**
     * 模糊查询 rname
     *
     * @param rname
     * @return
     */
    @Select("select * from root where rname like  '%${jname}%' ")
    List<Root> selectByrname(String rname);

}
