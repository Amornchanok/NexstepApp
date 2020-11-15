package com.amornchanok.nextstep_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    List<ArticleList>articleLists;
    Context ct;

    public ArticleAdapter(List<ArticleList> articleLists, Context ct) {
        this.articleLists = articleLists;
        this.ct = ct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.studio_resultlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticleList articleList=articleLists.get(position);
        Glide.with(ct)
                .load(articleList.getImageUrl())
                .into(holder.articleImg);

//        holder.articlename.setText(articleList.getArticleName());

    }

    @Override
    public int getItemCount() {
        return articleLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView articleImg;
//        TextView articlename;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            articleImg = itemView.findViewById(R.id.article_image);
//            articlename=itemView.findViewById(R.id.article_name);
        }
    }
}
