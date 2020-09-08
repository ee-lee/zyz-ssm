package com.yc.pojo;


import java.io.Serializable;


public class Scores implements Serializable {
    private Integer sid;

    private Integer aid;

    private Integer jid;

    private Integer uid;

    private Integer ustatus;


    private Activity activity;

    public Scores(Integer sid, Integer aid, Integer jid, Integer uid, Integer ustatus) {
        this.sid = sid;
        this.aid = aid;
        this.jid = jid;
        this.uid = uid;
        this.ustatus = ustatus;
    }

    public Scores(Integer sid, Integer aid, Integer jid, Integer uid, Integer ustatus,Activity activity) {
        this.sid = sid;
        this.aid = aid;
        this.jid = jid;
        this.uid = uid;
        this.ustatus = ustatus;
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "sid=" + sid +
                ", aid=" + aid +
                ", jid=" + jid +
                ", uid=" + uid +
                ", ustatus=" + ustatus +
                '}';
    }

    public Scores() {
        super();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUstatus() {
        return ustatus;
    }

    public void setUstatus(Integer ustatus) {
        this.ustatus = ustatus;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }


}
