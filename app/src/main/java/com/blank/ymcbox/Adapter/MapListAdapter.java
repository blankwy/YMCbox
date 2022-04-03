package com.blank.ymcbox.Adapter;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import android.net.Uri;
import java.io.File;

import android.view.LayoutInflater;

import android.widget.LinearLayout;
import android.view.View.OnClickListener;

import com.blank.ymcbox.Bean.MapBean;
import com.blank.ymcbox.R;
import com.google.gson.Gson;


public class MapListAdapter extends RecyclerView.Adapter<MapListAdapter.ViewHolder> {
	List<MapBean> mapList=new ArrayList<MapBean>();

	public MapListAdapter(List mapList){
		this.mapList=mapList;
	}
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_res,parent,false);
		ViewHolder viewHolder=new ViewHolder(itemView);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
		holder.name.setText(mapList.get(position).getName());
		holder.time.setText(mapList.get(position).getDescription());
		try{
		File img=new File(mapList.get(position).getIcon());
		holder.icon.setImageURI(Uri.fromFile(img));
		}catch(Exception NullPointerException){}
		holder.item.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View view) {
					String mapBean=(new Gson()).toJson(mapList.get(position));
					
				}
			});
		}

	@Override
	public int getItemCount() {
		return mapList.size();
	}
	
    
    class ViewHolder extends RecyclerView.ViewHolder{
		TextView name,time;
		ImageView icon;
		LinearLayout item;
		public ViewHolder(@NonNull View itemView){
			super(itemView);
			this.name=itemView.findViewById(R.id.name);
			this.time=itemView.findViewById(R.id.time);
			this.icon=itemView.findViewById(R.id.icon);
			this.item=itemView.findViewById(R.id.itemview);
		}
	}
    
}
