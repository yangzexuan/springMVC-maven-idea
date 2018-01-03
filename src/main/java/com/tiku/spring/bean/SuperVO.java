package com.tiku.spring.bean;

import java.util.Date;

/**
 * Created by yangzxa on 2018/1/1.
 */
public abstract class SuperVO {
    /** 创建人 */
    private String creater;
    /** */
    private Date createdtime;
    /** */
    private String modifier;
    /** */
    private Date modifiedtime;

    private Date ts;
    private short dr = 0;

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public short getDr() {
        return dr;
    }

    public void setDr(short dr) {
        this.dr = dr;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public SuperVO() {
    }

    @Override
    public String toString() {
        return "SuperVO{" +
                "creater='" + creater + '\'' +
                ", createdtime=" + createdtime +
                ", modifier='" + modifier + '\'' +
                ", modifiedtime=" + modifiedtime +
                ", ts=" + ts +
                ", dr=" + dr +
                '}';
    }

    public abstract String getTableName();
}
