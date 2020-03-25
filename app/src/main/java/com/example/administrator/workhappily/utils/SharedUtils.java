package com.example.administrator.workhappily.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2020/3/24 0024.
 * sharePrefrence的封装
 */

public class SharedUtils {
    public static final String NAME="config";
    //键值
    public static void putString(Context mcontext,String key,String value){
        SharedPreferences sp=mcontext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }
    //键默认值（如果获取失败，返回默认值）
    public static String getString(Context mcontext,String key,String defvalue){
        SharedPreferences sp=mcontext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getString(key,defvalue);
    }
    public static void putInt(Context mcontext,String key,int value){
        SharedPreferences sp=mcontext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }
    //键默认值（如果获取失败，返回默认值）
    public static int getString(Context mcontext,String key,int defvalue){
        SharedPreferences sp=mcontext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getInt(key,defvalue);
    }
    public static void putBoolean(Context mcontext,String key,boolean value){
        SharedPreferences sp=mcontext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }
    //键默认值（如果获取失败，返回默认值）
    public static Boolean getBoolean(Context mcontext,String key,boolean defvalue){
        SharedPreferences sp=mcontext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(key,defvalue);
    }
    //删除单个
    public static void deleShare(Context mcontext,String key){
        SharedPreferences sp=mcontext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }
    //删除全部
    public static void deleAll(Context mcontext){
        SharedPreferences sp=mcontext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }
}
