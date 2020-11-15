package com.amornchanok.nextstep_app;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {
    View view;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;
    }

    public void setDetails(Context context, String text, String imageUrl) {
        TextView mText = view.findViewById(R.id.listviewtxt);
        ImageView mImage = view.findViewById(R.id.article_image);
        Picasso.get().load(imageUrl).into(mImage);
    }
}
