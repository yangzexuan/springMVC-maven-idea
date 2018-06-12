package com.com.dome.mybatis.mock;


public class UserVO {
    private int pk;
    private String username;
    private String cuserid;
    private String usercode;

    public UserVO(int pk, String username, String cuserid, String usercode) {
        this.pk = pk;
        this.username = username;
        this.cuserid = cuserid;
        this.usercode = usercode;
    }

    public UserVO() {
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCuserid() {
        return cuserid;
    }

    public void setCuserid(String cuserid) {
        this.cuserid = cuserid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "pk=" + pk +
                ", username='" + username + '\'' +
                ", cuserid='" + cuserid + '\'' +
                ", usercode='" + usercode + '\'' +
                '}';
    }


}
