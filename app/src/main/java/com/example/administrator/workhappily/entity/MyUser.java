package com.example.administrator.workhappily.entity;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2020/3/24 0024.
 * 用户属性
 */

public class MyUser extends BmobUser{
    private int age;
    private boolean post;
    private String desc;
    private String company;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
