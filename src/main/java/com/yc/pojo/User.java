package com.yc.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;

    private String uname;

    private String gender;

    private String pwd;

    private String email;

    private Integer jid;

    private Integer age;

    private Integer score;

    private String phone;

    private String address;

    private String idcard;

    private Integer uissys;

    private String regtime;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", gender='" + gender + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", jid=" + jid +
                ", age=" + age +
                ", score=" + score +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", idcard='" + idcard + '\'' +
                ", uissys=" + uissys +
                ", regtime=" + regtime +
                '}';
    }

    public User(Integer uid, String uname, String gender, String pwd, String email, Integer jid, Integer age, Integer score, String phone, String address, String idcard, Integer uissys, String regtime) {
        this.uid = uid;
        this.uname = uname;
        this.gender = gender;
        this.pwd = pwd;
        this.email = email;
        this.jid = jid;
        this.age = age;
        this.score = score;
        this.phone = phone;
        this.address = address;
        this.idcard = idcard;
        this.uissys = uissys;
        this.regtime = regtime;
    }

    public User() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getUissys() {
        return uissys;
    }

    public void setUissys(Integer uissys) {
        this.uissys = uissys;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }
}
