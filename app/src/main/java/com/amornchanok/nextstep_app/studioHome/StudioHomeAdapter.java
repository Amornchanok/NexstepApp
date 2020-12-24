package com.amornchanok.nextstep_app.studioHome;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.amornchanok.nextstep_app.R;
import com.amornchanok.nextstep_app.model.Studios;
import com.amornchanok.nextstep_app.tabProfile.StudioProfileActivity;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudioHomeAdapter extends RecyclerView.Adapter<StudioHomeAdapter.MyViewHolder> {

    private ArrayList<Studios> studios;
//    private Context mContext;

//    public StudioHomeAdapter(ArrayList<Studios> studios, ValueEventListener mContext) {
    public StudioHomeAdapter(ArrayList<Studios> studios) {
        this.studios = studios;
//        this.mContext = (Context) mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new MyViewHolder( LayoutInflater.from(parent.getContext()).inflate(R.layout.item_studio_home,parent,false));
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        holder.tvName.setText(studios.get(position).getStudioname());
        holder.tvPrice.setText(studios.get(position).getPrice() + " บาท / ชั่วโมง" .toString());
        Picasso.get().load(studios.get(position).getPic().getPreview()).into(holder.ivPic);

        holder.ivPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileStudio();
            }
        });
    }

    public void openProfileStudio() {
//        Intent intent = new Intent( mContext,StudioProfileActivity.class);
//        Intent intent = new Intent( StudioProfileActivity.class);
//        startActivity(intent);
    }

    private void startActivity(Intent intent) {
    }

    @Override
    public int getItemCount() {
        return studios.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvPrice;
        ImageView ivPic;
        public MyViewHolder(View v){
            super(v);
            this.tvName = v.findViewById(R.id.studioname);
            this.tvPrice = v.findViewById(R.id.studioprice);
            this.ivPic = v.findViewById(R.id.studiopic);

        }
    }
}
