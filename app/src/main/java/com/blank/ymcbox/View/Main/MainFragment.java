package com.blank.ymcbox.View.Main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.blank.ymcbox.R;
import com.blank.ymcbox.ResActivity;
import com.blankj.utilcode.util.AppUtils;
import com.google.android.material.snackbar.Snackbar;


public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    private Button start,download,wiki;
    private TextView version,running;
    private SharedPreferences preferences;
    private String mcPackageName;
    private CardView resManage;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.main_fragment, container, false);
        start=view.findViewById(R.id.start);
        download=view.findViewById(R.id.download);
        wiki=view.findViewById(R.id.wiki);
        running = view.findViewById(R.id.running);
        version=view.findViewById(R.id.version);
        resManage=view.findViewById(R.id.resmanage);
        preferences= PreferenceManager.getDefaultSharedPreferences(getActivity());
        mcPackageName= preferences.getString("packagename","com.mojang.minecraftpe");
        version.setText(AppUtils.getAppVersionName(mcPackageName));
        if (AppUtils.isAppRunning(mcPackageName)){
            running.setText("正在运行");
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AppUtils.isAppInstalled(mcPackageName)) {
                    AppUtils.launchApp(mcPackageName);
                }else{
                    Snackbar.make(view,"未安装，请先下载",Snackbar.LENGTH_INDEFINITE).show();
                }
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://pan.bilnn.cn/s/q4Q6C9"));
                startActivity(intent);
            }
        });
        wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://minecraft.fandom.com/zh/wiki/Minecraft_Wiki"));
                startActivity(intent);
            }
        });
        resManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ResActivity.class);
                startActivity(intent);
            }
        });

    }



}