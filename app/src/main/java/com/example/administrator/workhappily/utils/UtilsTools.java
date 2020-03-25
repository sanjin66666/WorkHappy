package com.example.administrator.workhappily.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;


/**
 * Created by Administrator on 2020/3/24 0024.
 * 工具类
 */

public class UtilsTools {
    public static void setFont(Context mcontext, TextView textView){
        //设置字体
        Typeface fontType=Typeface.createFromAsset(mcontext.getAssets(),"fonts/FONT.TTF");
        textView.setTypeface(fontType);
    }
}
