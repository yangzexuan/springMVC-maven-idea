package com.tiku.spring.bean;

/**
 * Created by yangzxa on 2017/12/25.
 */
public class ExcmpleVO {
    private String fname;
    private String lname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "ExcmpleVO{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    public ExcmpleVO(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public ExcmpleVO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExcmpleVO)) return false;

        ExcmpleVO excmpleVO = (ExcmpleVO) o;

        if (getFname() != null ? !getFname().equals(excmpleVO.getFname()) : excmpleVO.getFname() != null) return false;
        return getLname() != null ? getLname().equals(excmpleVO.getLname()) : excmpleVO.getLname() == null;
    }

    @Override
    public int hashCode() {
        int result = getFname() != null ? getFname().hashCode() : 0;
        result = 31 * result + (getLname() != null ? getLname().hashCode() : 0);
        return result;
    }
}
