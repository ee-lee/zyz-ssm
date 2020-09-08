package com.yc.dao;

import com.yc.pojo.Activity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ActivityMapper {

    @Delete("delete from activity where aid=#{aid}")
    int deleteByPrimaryKey(Integer aid);


    @Insert("insert into activity(TYPEs,title,problem,createtime,starttime,endtime,STATUS,gname,maxnum,signnum,img)" +
            " values(#{types},#{title},#{problem},#{createtime},#{starttime},#{endtime},#{status},#{gname},#{maxnum},#{signnum},#{img})")
    @Options(useGeneratedKeys = true, keyProperty = "aid")
        //外面使用activity.getAid() 获取
    int insert(Activity activity);

    /*
     * 结束活动状态
     * */
    @Update("update activity set STATUS=#{STATUS} where aid=#{aid}")
    int updateByStatus(@Param("aid") int aid, @Param("STATUS") int STATUS);

    /*
     * 录取人数改变 加add 减less
     * */
    @Update("update activity set signnum=signnum+1 where aid=#{aid}")
    int updateBySignnumAdd(@Param("aid") int aid);

    @Update("update activity set signnum=signnum-1 where aid=#{aid}")
    int updateBySignnumLess(@Param("aid") int aid);


    /*
     * 根据id 更改活动内容 因暂时用不到 sql没写
     * */
    @Update("update activity set signnum=signnum+1 where aid=#{aid}")
    int updateByPrimaryKey(Activity activity);

    /*
     * 根据id 存储照片地址
     * */
    @Update("update activity set img = #{img} where aid=#{aid}")
    int updateByimg(@Param("aid") int aid, @Param("img") String img);


    @Select("select * from activity  limit #{tag},#{rows}")
    List<Activity> findActivity(@Param("tag") int tag, @Param("rows") int rows);

    @Select("select * from activity where  title like '%${title}%'  limit #{tag},#{rows}")
    List<Activity> findActivityBytitle(@Param("title") String title, @Param("tag") int tag, @Param("rows") int rows);


    /**
     * 查看当前活动aid 最多多少人参加
     */
    @Select("select maxnum from activity where aid =#{aid}")
    public Long getActivityByMaxnum(int aid);

    /**
     * 查看当前活动aid 参加了多少人
     */
    @Select("select signnum from activity where aid =#{aid}")
    long getActivityBysignnum(int aid);

    /**
     * 数据数目
     */
    @Select("select count(aid) from activity ")
    public Long getTotalActivity();

    /**
     * 数据数目
     */
    @Select("select count(aid) from activity  where TYPEs =#{types}")
    public Long getActivityToWelcome(@Param("types") int types);


    /**
     * 数据数目
     */
    @Select("select count(aid) from activity  where TYPEs =#{types} and STATUS =#{status}")
    public Long getActivityToWelcomeEnds(@Param("types") int types, @Param("status") int status);

    /**
     * 数据数目 根据标题
     */
    @Select("select count(aid) from activity  where  title like '%${title}%' ")
    public Long getTotalActivityBytitle(@Param("title") String title);


    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Activity record);

    @Select("select * from activity where TYPEs=#{TYPEs} limit #{tag},#{rows}")
    List<Activity> findActivityByzyz(@Param("TYPEs") int TYPEs, @Param("tag") int tag, @Param("rows") int rows);


    /**
     * 数据数目
     */
    @Select("select count(aid) from activity  where TYPEs=#{TYPEs} ")
    long getTotalActivityByzyz(int TYPEs);


}
