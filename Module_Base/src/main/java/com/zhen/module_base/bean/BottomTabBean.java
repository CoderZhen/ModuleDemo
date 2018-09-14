package com.zhen.module_base.bean;

public class BottomTabBean {

    String titleCN;
    String titleEN;

    public BottomTabBean(String titleCN, String titleEN) {
        this.titleCN = titleCN;
        this.titleEN = titleEN;
    }

    public String getTitleCN() {
        return titleCN;
    }

    public String getTitleEN() {
        return titleEN;
    }
}
