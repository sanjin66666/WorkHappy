package com.example.administrator.workhappily.application;

import android.app.Application;

import com.example.administrator.workhappily.utils.StaticClass;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2020/3/24 0024.
 * 描述：AppilicationS
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {

        super.onCreate();
        //Bomb初始化
        Bmob.initialize(this, StaticClass.BMOB_APP_ID);
    }
}
