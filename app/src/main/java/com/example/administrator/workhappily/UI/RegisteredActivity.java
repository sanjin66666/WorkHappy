package com.example.administrator.workhappily.UI;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.workhappily.R;
import com.example.administrator.workhappily.entity.MyUser;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2020/3/24 0024.
 */

public class RegisteredActivity extends BaseActivity implements View.OnClickListener{
    private EditText et_user;
    private EditText et_age;
    private EditText et_desc;
    private EditText et_company;
    private RadioGroup mRadioGroup;
    private EditText et_password;
    private EditText et_email;
    private Button btnRegistered;
    private EditText et_pass;
    private boolean isAdmin;//true是主管
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        initView();

    }

    private void initView() {
        et_user=(EditText)findViewById(R.id.et_user);
        et_age=(EditText)findViewById(R.id.et_age);
        et_desc=(EditText)findViewById(R.id.et_desc);
        et_company=(EditText)findViewById(R.id.et_company);
        et_password=(EditText)findViewById(R.id.et_password);
        et_pass=(EditText)findViewById(R.id.et_pass);
        et_email=(EditText)findViewById(R.id.et_email);
        mRadioGroup=(RadioGroup)findViewById(R.id.mRadioGroup);
        btnRegistered=(Button)findViewById(R.id.btnRegistered);
        btnRegistered.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnRegistered:
                //获取输入框的值
                String name=et_user.getText().toString().trim();//trim是去空格
                String age=et_age.getText().toString().trim();
                String desc=et_desc.getText().toString().trim();
                String company=et_company.getText().toString().trim();
                String email=et_email.getText().toString().trim();
                String pass=et_pass.getText().toString().trim();
                String password=et_password.getText().toString().trim();
                //判断是否为空
                if(!TextUtils.isEmpty(name)&!TextUtils.isEmpty(age)&
                        !TextUtils.isEmpty(company)&!TextUtils.isEmpty(email)&
                        !TextUtils.isEmpty(pass)&!TextUtils.isEmpty(password)){
                    //判断两次输入密码是否一致
                    if (pass.equals(password)) {
                        //先把性别判断一下
                        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                if(checkedId == R.id.rb_admin){
                                    isAdmin=true;
                                }else if(checkedId==R.id.rb_staff){
                                    isAdmin=false;
                                }
                            }
                        });
                        //判断简介是否为空
                        if(TextUtils.isEmpty(desc)){
                            desc="这个人很懒，什么都没有留下";
                        }
                        //注册
                        MyUser user=new MyUser();
                        user.setUsername(name);
                        user.setPassword(password);
                        user.setEmail(email);
                        user.setAge(Integer.parseInt(age));
                        user.setCompany(company);
                        user.setPost(isAdmin);
                        user.setDesc(desc);
                        user.signUp(new SaveListener<MyUser>() {
                            @Override
                            public void done(MyUser myUser, BmobException e) {
                                if (e == null) {
                                    Toast.makeText(RegisteredActivity.this,"注册成功",Toast.LENGTH_SHORT);
                                    finish();
                                } else {
                                    Toast.makeText(RegisteredActivity.this,"注册失败"+e.toString(),Toast.LENGTH_SHORT);
                                }
                            }
                        });

                    }else{
                        Toast.makeText(this,"两次输入密码不一致",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(this,"输入框不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
