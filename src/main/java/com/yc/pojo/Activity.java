package com.yc.pojo;

import java.io.Serializable;

public class Activity implements Serializable {
    private Integer aid;

    private Integer types;

    private String title;

    private String problem;

    private String createtime;

    private String starttime;

    private String endtime;

    private Integer status;

    private String gname;

    private Integer maxnum;

    private Integer signnum;

    private String img;

    public Activity(Integer aid, Integer types, String title, String problem, String createtime, String starttime, String endtime, Integer status, String gname, Integer maxnum, Integer signnum, String img) {
        this.aid = aid;
        this.types = types;
        this.title = title;
        this.problem = problem;
        this.createtime = createtime;
        this.starttime = starttime;
        this.endtime = endtime;
        this.status = status;
        this.gname = gname;
        this.maxnum = maxnum;
        this.signnum = signnum;
        this.img = img;
    }
    public Activity(Integer types, String title, String problem, String createtime, String starttime, String endtime, Integer status, String gname, Integer maxnum, Integer signnum, String img) {
        this.types = types;
        this.title = title;
        this.problem = problem;
        this.createtime = createtime;
        this.starttime = starttime;
        this.endtime = endtime;
        this.status = status;
        this.gname = gname;
        this.maxnum = maxnum;
        this.signnum = signnum;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "aid=" + aid +
                ", types=" + types +
                ", title='" + title + '\'' +
                ", problem='" + problem + '\'' +
                ", createtime=" + createtime +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", status=" + status +
                ", gname='" + gname + '\'' +
                ", maxnum=" + maxnum +
                ", signnum=" + signnum +
                ", img='" + img + '\'' +
                '}';
    }

    public Activity() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
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
        this.gname = gname == null ? null : gname.trim();
    }

    public Integer getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(Integer maxnum) {
        this.maxnum = maxnum;
    }

    public Integer getSignnum() {
        return signnum;
    }

    public void setSignnum(Integer signnum) {
        this.signnum = signnum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}
