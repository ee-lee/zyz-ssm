package com.yc.service.impl;

import com.yc.dao.ScoresMapper;
import com.yc.pojo.ActivityAndScores;
import com.yc.pojo.Scores;
import com.yc.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ScoresServiceImpl implements ScoresService {

    @Autowired
    private ScoresMapper scoresMapper;

    @Override
    public List<Scores> scoresfindToactivity(int tag, int rows, int aid) {
        return scoresMapper.scoresfindToactivity(tag, rows, aid);
    }

    @Override
    public int addScores(Scores scores) {
        if (scoresMapper.insert(scores) > 0)
            return 1;
        return 0;
    }

    @Override
    public int updateUstatus(int sid, int ustatus) {
        if (scoresMapper.updateUstatus(sid, ustatus) > 0)
            return 1;
        return 0;
    }

    @Override
    public List<ActivityAndScores> findByactivity(int uid, int tag, int rows) {
        return scoresMapper.findByactivity(uid, tag, rows);
    }

    @Override
    public List<HashMap<String, String>> selectByactivityAndscores(int ustatus) {
        return scoresMapper.selectByactivityAndscores(ustatus);
    }

    @Override
    public long getTotalScores(int aid) {
        return scoresMapper.getTotalScores(aid);
    }

    @Override
    public int deleteScores(int sid) {
        return scoresMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public long findByUid(int uid) {
        return scoresMapper.findByUid(uid);
    }

    @Override
    public int deleteByPrimaryKey(int sid) {
        return scoresMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public int findUidBySid(int sid) {
        return scoresMapper.findUidBySid(sid);
    }
}
