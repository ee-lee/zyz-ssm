package com.yc.service.impl;


import com.yc.dao.ActivityMapper;
import com.yc.pojo.Activity;
import com.yc.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;


    @Override
    public List<Activity> findActivity(int tag, int rows) {
        return this.activityMapper.findActivity(tag, rows);
    }

    @Override
    public List<Activity> findActivityBytitle(String title, int tag, int rows) {
        return activityMapper.findActivityBytitle(title, tag, rows);
    }

    @Override
    public Long getTotalActivity() {
        return this.activityMapper.getTotalActivity();
    }

    @Override
    public Long getActivityToWelcome(int types) {
        return activityMapper.getActivityToWelcome(types);
    }

    @Override
    public Long getActivityToWelcomeEnds(int types, int status) {
        return activityMapper.getActivityToWelcomeEnds(types, status);
    }

    @Override
    public Long getTotalActivityBytitle(String title) {
        return activityMapper.getTotalActivityBytitle(title);
    }

    @Override
    public int addActivity(Activity activity) {
        if (activityMapper.insert(activity) > 0) {

            return 1;
        }
        return 0;
    }

    @Override
    public int updateActivity(Activity activity) {
        if (this.activityMapper.updateByPrimaryKey(activity) > 0) {

            return 1;
        }
        return 0;
    }

    @Override
    public int deleteActivity(int aid) {

        return this.activityMapper.deleteByPrimaryKey(aid);

    }

    @Override
    public int joinActivity(int aid) {
        long maxnum = activityMapper.getActivityByMaxnum(aid);
        long signnum = activityMapper.getActivityBysignnum(aid);
        if (signnum < maxnum) {
            if (this.activityMapper.updateBySignnumAdd(aid) > 0) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int outActivity(int aid) {
        if (this.activityMapper.updateBySignnumLess(aid) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateByStatus(int aid, int status) {
        return activityMapper.updateByStatus(aid, status);
    }

    @Override
    public Activity findById(String id) {
        return null;
    }

    @Override
    public List<Activity> findVolByAct(Map searchCriteria) {
        return null;
    }

    @Override
    public Long findVolByActTotal(Map searchCriteria) {
        return null;
    }

    @Override
    public int updateVolActStatus(int volActId, int status, String handleStaff) {
        return 0;
    }

    @Override
    public Activity findByIdFromDb(String id) {
        return null;
    }

    @Override
    public Map getMainSummary() {
        return null;
    }

    @Override
    public int saveimg(int aid, String img) {
        return activityMapper.updateByimg(aid, img);
    }

    @Override
    public List<Activity> findActivityByzyz(int i, int tag, int rows) {
        return activityMapper.findActivityByzyz(i, tag, rows);
    }

    @Override
    public long getTotalActivityByzyz(int i) {
        return activityMapper.getTotalActivityByzyz(i);
    }

    @Override
    public long getActivityByMaxnum(int aid) {
        return activityMapper.getActivityByMaxnum(aid);
    }
}
