package com.blank.ymcbox.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blank.ymcbox.Bean.Item;
import com.blank.ymcbox.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder> {

    List<Item> item=new ArrayList<Item>();
    Context context;

    public BaseRecyclerAdapter(List item,Context context){
        this.item=item;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_res,parent,false);
        ViewHolder viewHolder=new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Item i=item.get(position);
        holder.name.setText(i.getName());
        holder.description.setText(i.getDescription());
        Glide.with(context).load(i.getIcon()).into(holder.icon);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,description;
        ImageView icon;
        LinearLayout item;
        public ViewHolder(@NonNull View itemView){
        super(itemView);
        this.name=itemView.findViewById(R.id.name);
        this.description=itemView.findViewById(R.id.description);
        this.icon=itemView.findViewById(R.id.icon);
        this.item=itemView.findViewById(R.id.itemview);
    }
    }

    private ClickListener listener;
    public interface ClickListener{
        public void onClick(int position);
    }
    public void setClickListener(ClickListener listener){
        this.listener=listener;
    }

}
