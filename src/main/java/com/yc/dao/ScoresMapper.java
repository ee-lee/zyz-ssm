package com.yc.dao;


import com.yc.pojo.ActivityAndScores;
import com.yc.pojo.Scores;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface ScoresMapper {


    /**
     * 根据活动id 查询有哪些志愿者参加
     */
    @Select("select * FROM scores where aid = #{aid}  limit  #{tag}, #{rows}")
    List<Scores> scoresfindToactivity(@Param("tag") int tag, @Param("rows") int rows, @Param("aid") int aid);


    /**
     * 修改用户活动进行状态1 录取  2 完成
     *
     * @param sid
     * @param ustatus
     * @return
     */

    @Update("update scores set ustatus=#{ustatus} where sid =#{sid}")
    int updateUstatus(@Param("sid") int sid, @Param("ustatus") int ustatus);

    @Select("select uid FROM scores where sid = #{sid}")
    int findUidBySid(@Param("sid") int sid);


    /**
     * root：查看活动有多少人参加
     *
     * @param ustatus
     * @return
     */

    @Select("select activity.title,COUNT(*) as 人数 " +
            "FROM scores " +
            "inner JOIN  activity on activity.aid =scores.aid " +
            "where ustatus=#{ustatus} " +
            "group BY scores.aid")
    List<HashMap<String, String>> selectByactivityAndscores(int ustatus);


/**
 * 以下为用户的操作方法
 */


    /**
     * 添加 此时活动状态为 1待审核
     *
     * @param scores
     * @return
     */
    @Insert("insert into scores(aid,jid,uid,ustatus) " +
            "values(#{aid},#{jid},#{uid},#{ustatus})")
    int insert(Scores scores);


    /**
     * user 查询自己参加的活动
     *
     * @param uid
     * @param tag
     * @param rows
     * @return
     */
    @Select("select scores.*,activity.*  from scores left  JOIN activity on scores.aid =activity.aid WHERE activity.TYPEs=1 " +
            " and scores.uid= #{uid}" +
            " limit #{tag},#{rows}")
    List<ActivityAndScores> findByactivity(@Param("uid") int uid, @Param("tag") int tag, @Param("rows") int rows);

    /**
     * user 查询自己参加的活动个数
     *
     * @param uid
     * @return
     */
    @Select("select count(sid) from scores WHERE uid =#{uid}")
    long findByUid(@Param("uid") int uid);


    @Select("select count(sid)  from scores where aid =#{aid}")
    long getTotalScores(int aid);

    /**
     * 取消报名的活动
     *
     * @param sid
     * @return
     */
    @Delete("delete from scores where sid = #{sid}")
    int deleteByPrimaryKey(int sid);
}
