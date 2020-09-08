package com.yc.pojo;

import java.io.Serializable;

public class Juser implements Serializable {
    private Integer jid;

    private String pwd;

    private String jname;

    private Integer age;

    private String email;

    private String phone;

    private String gender;

    private Integer jissys;

    public Juser(Integer jid, String pwd, String jname, Integer age, String email, String phone, String gender, Integer jissys) {
        this.jid = jid;
        this.pwd = pwd;
        this.jname = jname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.jissys = jissys;
    }

    public Juser() {
        super();
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname == null ? null : jname.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getJissys() {
        return jissys;
    }

    public void setJissys(Integer jissys) {
        this.jissys = jissys;
    }

    @Override
    public String toString() {
        return "Juser{" +
                "jid=" + jid +
                ", pwd='" + pwd + '\'' +
                ", jname='" + jname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", jissys=" + jissys +
                '}';
    }
}
