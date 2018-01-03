package com.tiku.spring.bean;

/**
 * Created by yangzxa on 2018/1/1.
 */
public class MultChoiceVO extends SuperVO{

    /** 主键 */
    private int id ;
    /** 题目标题 */
    private String title ;
    /** 题目内容 */
    private String subject ;
    /** 是否多选 */
    private boolean ismult = false ;
    /** 题目解析 */
    private String analysis ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean getIsmult() {
        return ismult;
    }

    public void setIsmult(boolean ismult) {
        this.ismult = ismult;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public MultChoiceVO() {
    }

    @Override
    public String toString() {
        return "MultChoiceVO{" +
                super.toString()+
                "id=" + id +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", ismult=" + ismult +
                ", analysis='" + analysis + '\'' +
                '}';
    }

    public String getTableName() {
        return "vo_multiple_choice";
    }
}
