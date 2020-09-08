package com.yc.service;

import com.yc.pojo.ActivityAndScores;
import com.yc.pojo.Scores;
import java.util.HashMap;
import java.util.List;


public interface ScoresService {


    List<Scores> scoresfindToactivity(int tag, int rows,int aid);



    /**
     * 添加
     */
    int addScores(Scores scores);


    /**
     *修改活动进行状态 2 录取
     * @param sid
     * @param ustatus
     * @return
     */

    int updateUstatus(int sid ,  int ustatus);


    /**
     * user 查询自己参加的活动
     * @param uid
     * @param tag
     * @param rows
     * @return
     */
    List<ActivityAndScores> findByactivity( int uid, int tag,int rows);


    /**
     * root查看活动有多少人参加
     * @param ustatus
     * @return
     */
    List<HashMap<String,String>> selectByactivityAndscores(int ustatus);

    long getTotalScores(int aid);

    int deleteScores(int sid);

    long findByUid(int uid);

    int deleteByPrimaryKey(int sid);

    int findUidBySid(int sid);
}
