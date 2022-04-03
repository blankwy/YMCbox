package com.blank.ymcbox.View.ResManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blank.ymcbox.Adapter.BaseRecyclerAdapter;
import com.blank.ymcbox.Adapter.ResListAdapter;
import com.blank.ymcbox.Bean.AddonBean;
import com.blank.ymcbox.Bean.Item;
import com.blank.ymcbox.Bean.ResBean;
import com.blank.ymcbox.R;
import com.blank.ymcbox.Util.ResUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class ResFragment extends Fragment {


    public ResFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_res_3, container, false);
        SharedPreferences preferences= getDefaultSharedPreferences(getActivity());
        String path=Environment.getExternalStorageDirectory().getPath();
        if (preferences.getString("path","new").equals("old")){
            path+="/games/com.mojang/resource_packs";
        }else{
            path+="/Android/data/"+preferences.getString("packagename","com.mojang.minecraftpe")+"/files/games/com.mojang/resource_packs";
        }
        RecyclerView recyclerview=view.findViewById(R.id.recyclerview);
        final List<Item> resList = new ArrayList<Item>();
        for(File resFile:new File(path).listFiles()){
            String filePath=resFile.getPath();
            if (new File(filePath+"/pack_icon.png").exists()&&new File(filePath+"/manifest.json").exists()) {
                try {
                    ResBean bean=ResUtils.getRes(filePath);
                    Item item = new Item(bean.getHeader().getName(),bean.getHeader().getDescription(),new File(filePath + "/pack_icon.png"),filePath);
                    resList.add(item);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        BaseRecyclerAdapter adapter=new BaseRecyclerAdapter(resList,getContext());
        recyclerview.setAdapter(adapter);

        return view;
    }
}