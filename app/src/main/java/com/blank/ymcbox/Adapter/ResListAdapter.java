package com.blank.ymcbox.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blank.ymcbox.Bean.ResBean;
import com.blank.ymcbox.R;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ResListAdapter extends RecyclerView.Adapter<ResListAdapter.ViewHolder> {

    List<ResBean> resList=new ArrayList<ResBean>();
    String path;

    public ResListAdapter(List resList,String path){
        this.resList=resList;
        this.path=path;
    }
    @NonNull
    @Override
    public ResListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_res,parent,false);
        ResListAdapter.ViewHolder viewHolder=new ResListAdapter.ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResListAdapter.ViewHolder holder, final int position) {
        holder.name.setText(resList.get(position).getHeader().getName());
        holder.time.setText(resList.get(position).getHeader().getDescription());
        /*try{
            File img=new File(resList.get(position)res.path = path + "/pack_icon.png";);
            holder.icon.setImageURI(Uri.fromFile(img));
        }catch(Exception NullPointerException){}*/
        holder.item.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String resBean=(new Gson()).toJson(resList.get(position));

            }
        });
    }

    @Override
    public int getItemCount() {
        return resList.size();
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
