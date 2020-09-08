package com.yc.pojo;

import java.io.Serializable;

public class Root  implements Serializable {
    private Integer rid;

    private String pwd;

    private String rname;

    private String email;

    private String phone;

    public Root(Integer rid, String pwd, String rname, String email, String phone) {
        this.rid = rid;
        this.pwd = pwd;
        this.rname = rname;
        this.email = email;
        this.phone = phone;
    }

    public Root() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
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

    @Override
    public String toString() {
        return "Root{" +
                "rid=" + rid +
                ", pwd='" + pwd + '\'' +
                ", rname='" + rname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
