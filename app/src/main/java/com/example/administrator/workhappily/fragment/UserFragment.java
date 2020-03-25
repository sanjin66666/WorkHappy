package com.example.administrator.workhappily.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.workhappily.R;

/**
 * Created by Administrator on 2020/3/24 0024.
 */

public class UserFragment extends Fragment{
    public View onCreatView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment_user,null);
        return view;
    }
}
