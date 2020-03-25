package com.example.administrator.workhappily.UI;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.workhappily.MainActivity;
import com.example.administrator.workhappily.R;
import com.example.administrator.workhappily.utils.SharedUtils;
import com.example.administrator.workhappily.utils.StaticClass;
import com.example.administrator.workhappily.utils.UtilsTools;

/**
 * Created by Administrator on 2020/3/24 0024.
 * 首页闪屏
 * 延时两千毫秒
 * 自定义字体
 * Activity全屏主题
 */

public class SplashActivity extends AppCompatActivity{

    private TextView tv_splash;
    private Handler handler=new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case StaticClass.Handle_SPLASH:
                    //判断程序是否第一次运行
                    if(isFirst()){
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }
    //初始化VIEW
    private void initView(){
        //延时2s
        handler.sendEmptyMessageDelayed(StaticClass.Handle_SPLASH,2000);
            tv_splash=(TextView)findViewById(R.id.tv_splash);
        //设置字体
        UtilsTools.setFont(this,tv_splash);
    }
    //判断程序是否第一次运行
    private boolean isFirst() {
      boolean isFirst = SharedUtils.getBoolean(this,StaticClass.SHARE_IS_FIRST,true);
        if(isFirst){
            //是第一次运行
            SharedUtils.getBoolean(this,StaticClass.SHARE_IS_FIRST,false);
            return true;
        }else{
            return false;
        }
    }
}
