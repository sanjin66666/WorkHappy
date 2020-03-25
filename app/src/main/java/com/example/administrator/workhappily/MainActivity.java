package com.example.administrator.workhappily;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.workhappily.UI.SettingActivity;
import com.example.administrator.workhappily.fragment.ButlerFragment;
import com.example.administrator.workhappily.fragment.CheckFragment;
import com.example.administrator.workhappily.fragment.LeaveFragment;
import com.example.administrator.workhappily.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout mTabLayout;
    //ViewPager
    private ViewPager mViewPager;
    //Title
    private java.util.List<String>mTiTle;
    //Fragment
    private List<Fragment> mfragment;
    //悬浮窗
    private FloatingActionButton fab_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //去掉阴影
        getSupportActionBar().setElevation(0);
        iniData();
        initView();
    }
    //初始化数据
    private void iniData(){
        mTiTle =new ArrayList<>();
        mTiTle.add("WorkHappy");
        mTiTle.add("Check");
        mTiTle.add("Leave");
        mTiTle.add("UserInfo");
        mfragment=new ArrayList<>();
        mfragment.add(new ButlerFragment());
        mfragment.add(new CheckFragment());
        mfragment.add(new LeaveFragment());
        mfragment.add(new UserFragment());
    }
    //初始化View
    private void initView(){
        fab_setting=(FloatingActionButton) findViewById(R.id.fab_setting);
        fab_setting.setOnClickListener(this);
       // 默认隐藏
        fab_setting.setVisibility(View.GONE);
        mTabLayout=(TabLayout)findViewById(R.id.mTabLayout);
        mViewPager=(ViewPager)findViewById(R.id.mViewPager);
        //预加载
        mViewPager.setOffscreenPageLimit(mfragment.size());
        //ViewPager的滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("TAG","posision:"+position);
                if(position==0){
                    fab_setting.setVisibility(View.GONE);
                }else{
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置适配器（容器需要适配器）
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选择的item
            @Override
            public Fragment getItem(int position) {
                return mfragment.get(position);
            }
            //返回的item的个数
            @Override
            public int getCount() {
                return mfragment.size();
            }
            //设置标题
            public  CharSequence getPageTitle(int posotion){
                return mTiTle.get(posotion);
            }
        });
        //绑定
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab_setting:
                startActivity(new Intent(this,SettingActivity.class));
                break;
        }
    }
}
