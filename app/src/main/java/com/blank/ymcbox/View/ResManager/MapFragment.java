package com.blank.ymcbox.View.ResManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blank.ymcbox.Adapter.BaseRecyclerAdapter;
import com.blank.ymcbox.Adapter.MapListAdapter;
import com.blank.ymcbox.Bean.AddonBean;
import com.blank.ymcbox.Bean.Item;
import com.blank.ymcbox.Bean.MapBean;
import com.blank.ymcbox.R;
import com.blank.ymcbox.Util.MapUtils;
import com.blank.ymcbox.Util.ResUtils;
import com.blankj.utilcode.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class MapFragment extends Fragment {

    RecyclerView recyclerview;
    BaseRecyclerAdapter adapter;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_res_1, container, false);
        SharedPreferences preferences= getDefaultSharedPreferences(getActivity());
        String path=Environment.getExternalStorageDirectory().getPath();
        if (preferences.getString("path","new").equals("old"))
            path+="/games/com.mojang/minecraftWorlds";
        else
            path += "/Android/data/" + preferences.getString("packagename", "com.mojang.minecraftpe") + "/files/games/com.mojang/minecraftWorlds";
        recyclerview=view.findViewById(R.id.recyclerview);
        final List<Item> mapList=new ArrayList<Item>();
        adapter=new BaseRecyclerAdapter(mapList,getContext());
        File gameFile=new File(path);
        File[] mapFileList=gameFile.listFiles();
        Calendar cal=Calendar.getInstance();
        for(File mapFile:mapFileList){
            String filePath=mapFile.getPath();
            try {
            String name=MapUtils.getName(filePath);
            File icon=new File(filePath + "/world_icon.jpeg");
            cal.setTimeInMillis(mapFile.lastModified());
            if (icon.exists()&&!StringUtils.isEmpty(name)) {
                Item item = new Item(name,cal.getTime().toString(),icon,filePath);
                mapList.add(item);
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
        adapter.setClickListener(new BaseRecyclerAdapter.ClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),MapActivity.class);
                intent.putExtra("PATH",mapList.get(position).getPath());
                startActivity(intent);
            }
        });
        return view;
    }
}