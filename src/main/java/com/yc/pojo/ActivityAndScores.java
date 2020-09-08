package com.yc.pojo;

import java.io.Serializable;

/**
 * 数据库没有对应的表
 * 用来接收activity和scores 用在user查询自己参加的活动
 */
public class ActivityAndScores implements Serializable {

    private Integer sid;

    private Integer aid;

    private String title;

    private String problem;

    private String createtime;

    private String starttime;

    private String endtime;

    //活动状态0为结束 1为开始
    private Integer status;

    private String gname; //活动发布者

    private String img;

    // private Integer uid;

    //0为待审核,1为已录取,2已完成(已签到)
    private Integer ustatus;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getUstatus() {
        return ustatus;
    }

    public void setUstatus(Integer ustatus) {
        this.ustatus = ustatus;
    }


    @Override
    public String toString() {
        return "ActivityAndScores{" +
                "sid=" + sid +
                ", aid=" + aid +
                ", title='" + title + '\'' +
                ", problem='" + problem + '\'' +
                ", createtime='" + createtime + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", status=" + status +
                ", gname='" + gname + '\'' +
                ", img='" + img + '\'' +
                ", ustatus=" + ustatus +
                '}';
    }
}
