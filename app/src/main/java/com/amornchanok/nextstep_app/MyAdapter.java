package com.amornchanok.nextstep_app;


import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Upload> uploadList;
    private onItemClickListener listener;


    public MyAdapter(Context context, List<Upload> uploadList) {
        this.context = context;
        this.uploadList = uploadList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.imageNameTextView.setText(uploadList.get(position).getI_name());
       // Picasso.with(context)

        Picasso.get().load(uploadList.get(position).getI_url()).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return uploadList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener,MenuItem.OnMenuItemClickListener {
        ImageView imageView;
        TextView imageNameTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.cardImageViewId);
            imageNameTextView=itemView.findViewById(R.id.cardTextViewId);
            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);

        }



        @Override
        public void onClick(View v) {
            if (listener!=null){
                int position=getAdapterPosition();
                if (position!=RecyclerView.NO_POSITION){
                    listener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Choose an action");
            MenuItem doAnyTask=menu.add(Menu.NONE,1,1,"do any task");
            MenuItem delete=menu.add(Menu.NONE,2,2,"delete");
            doAnyTask.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (listener!=null){
                int position=getAdapterPosition();
                if (position!=RecyclerView.NO_POSITION){
                    switch(item.getItemId()){
                        case 1:
                            listener.doAnuTask(position);
                            return true;
                        case 2:
                            listener.delete(position);
                            return true;
                    }
                }
            }
            return false;
        }
    }

    public  interface onItemClickListener{
        void onItemClick(int position);
        void doAnuTask(int position);
        void delete(int position);

    }
    public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }

}
