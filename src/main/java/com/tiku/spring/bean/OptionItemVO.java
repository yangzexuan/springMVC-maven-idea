package com.tiku.spring.bean;

/**
 * Created by yangzxa on 2018/1/1.
 */
public class OptionItemVO extends SuperVO {
    public String getTableName() {
        return "vo_options_b";
    }

    private String itemname;

    private String option;

    private int id;



    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
