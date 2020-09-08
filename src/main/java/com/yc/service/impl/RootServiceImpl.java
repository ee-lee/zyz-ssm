package com.yc.service.impl;

import com.yc.dao.RootMapper;
import com.yc.pojo.Root;
import com.yc.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RootServiceImpl implements RootService {

    @Autowired
    private RootMapper rootMapper;


    @Override
    public Root login(Root root) {
        return rootMapper.login(root);
    }

    @Override
    public List<Root> findRoot(int tag, int rows) {
        return rootMapper.findRoot(tag,rows);
    }

    @Override
    public int addRoot(Root root) {
        if (rootMapper.insertRoot(root) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePwd(String pwd, String pwd2, int rid) {
        if (rootMapper.updatePwd(pwd,pwd2,rid) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteRoot(int rid) {
        if (rootMapper.deleteByPrimaryKey(rid) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public List<Root> selectByrname(String rname) {
        return rootMapper.selectByrname(rname) ;
    }

    @Override
    public long getTotalRoot() {
        return rootMapper.getTotalRoot();
    }
}
