package com.yc.service;

import com.yc.pojo.Activity;

import java.util.List;
import java.util.Map;



public interface ActivityService {

    /**
     * 返回相应的数据集合
     * 查询所有的活动
     * @return
     */
    public List<Activity> findActivity( int tag , int rows);


    public List<Activity> findActivityBytitle(String title, int tag , int rows);

    /**
     * 数据总数目
     * @return
     */
    public Long getTotalActivity();

    /**
     * 数据数目
     * @return
     */
    public Long getActivityToWelcome(int types);
    /**
     * 数据数目
     * @return
     */
    public Long getActivityToWelcomeEnds(int types,int status);
    /**
     * 数据总数目 根据标题
     * @return
     */
    public Long getTotalActivityBytitle(String title);
    /**
     * 添加
     *
     * @return
     */
    public int addActivity(Activity activity);

    /**
     * 修改
     */
    public int updateActivity(Activity activity);

    /**
     * 删除
     */
    public int deleteActivity(int id);

    /**
    * 参加活动
    *
     * */
    public  int  joinActivity(int aid);

    /**
    * 退出活动
    * */
    public  int  outActivity(int aid);

    /**
     * 管理员结束和启用活动
     * @param aid
     * @return
     */
    int updateByStatus(int aid,int status);


    public Activity findById(String id);

    public List<Activity> findVolByAct(Map searchCriteria);
    public Long findVolByActTotal(Map searchCriteria);
    public int updateVolActStatus(int volActId,int status,String handleStaff);
    public Activity findByIdFromDb(String id) ;
    public Map getMainSummary();

    int saveimg(int aid, String savedataimg);

    List<Activity> findActivityByzyz(int i, int tag, int rows);

    long getTotalActivityByzyz(int i);

    long getActivityByMaxnum(int  aid);
}
