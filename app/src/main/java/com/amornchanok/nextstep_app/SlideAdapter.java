package com.amornchanok.nextstep_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;


public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
      R.drawable.icon_mainservice01,
      R.drawable.icon_mainservice02
    };

    public String[] slide_heading = {
            "ค้นหาห้องซ้อมเต้น",
            "ค้นหาการแข่งขัน"
    };

    public String[] slide_desc = {
            "เมื่อเห็นไอคอนนี้ ที่หน้าโฮม กดเลย!\n" + "NEXTSTEP จะพาคุณไปค้นหาห้องซ้อมเต้น\n" + "ที่ใช่สำหรับคุณ",
            "เมื่อเห็นไอคอนนี้ ที่หน้าโฮม กดเลย!\n" + "NEXTSTEP จะพาคุณไปค้นหาการแข่งขัน\n" + "ที่ใช่สำหรับคุณ"
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view,Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_images);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;

    };

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((RelativeLayout)object);
    }
}
