package com.jyyx.example.springbootdemo.entity.treasure;

import java.io.Serializable;
import java.util.Date;

public class CbtUser implements Serializable {
    private Long id;

    private String username;

    private String userimg;

    private String occupation;

    private String telephone;

    private String photo;

    private Date createtime;

    private Date updatetime;

    private Byte isdel;

    private Integer totalintegral;

    private Integer residualintegral;

    private Integer lockintegral;

    private String openid;

    private Byte type;

    private Byte state;

    private Integer charge;

    private Byte recommend;

    private Integer loginstatus;

    private Double timediff;

    private Date namechangedate;

    private Integer onlinequest;

    private Integer underlinequest;

    private String city;

    private String areas;

    private String workingplace;

    private Long shareid;

    private String introduce;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg == null ? null : userimg.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Byte getIsdel() {
        return isdel;
    }

    public void setIsdel(Byte isdel) {
        this.isdel = isdel;
    }

    public Integer getTotalintegral() {
        return totalintegral;
    }

    public void setTotalintegral(Integer totalintegral) {
        this.totalintegral = totalintegral;
    }

    public Integer getResidualintegral() {
        return residualintegral;
    }

    public void setResidualintegral(Integer residualintegral) {
        this.residualintegral = residualintegral;
    }

    public Integer getLockintegral() {
        return lockintegral;
    }

    public void setLockintegral(Integer lockintegral) {
        this.lockintegral = lockintegral;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Byte getRecommend() {
        return recommend;
    }

    public void setRecommend(Byte recommend) {
        this.recommend = recommend;
    }

    public Integer getLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(Integer loginstatus) {
        this.loginstatus = loginstatus;
    }

    public Double getTimediff() {
        return timediff;
    }

    public void setTimediff(Double timediff) {
        this.timediff = timediff;
    }

    public Date getNamechangedate() {
        return namechangedate;
    }

    public void setNamechangedate(Date namechangedate) {
        this.namechangedate = namechangedate;
    }

    public Integer getOnlinequest() {
        return onlinequest;
    }

    public void setOnlinequest(Integer onlinequest) {
        this.onlinequest = onlinequest;
    }

    public Integer getUnderlinequest() {
        return underlinequest;
    }

    public void setUnderlinequest(Integer underlinequest) {
        this.underlinequest = underlinequest;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas == null ? null : areas.trim();
    }

    public String getWorkingplace() {
        return workingplace;
    }

    public void setWorkingplace(String workingplace) {
        this.workingplace = workingplace == null ? null : workingplace.trim();
    }

    public Long getShareid() {
        return shareid;
    }

    public void setShareid(Long shareid) {
        this.shareid = shareid;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}