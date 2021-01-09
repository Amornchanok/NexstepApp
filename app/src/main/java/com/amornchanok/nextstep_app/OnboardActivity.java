package com.amornchanok.nextstep_app;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnboardActivity extends AppCompatActivity {
    private ViewPager slideViewPager;
    private LinearLayout dotLayout;

    private TextView[] mDots;

    private SlideAdapter slideAdapter;

    private Button btBack;
    private Button btNext;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);

        slideViewPager = (ViewPager)findViewById(R.id.slideViewPager);
        dotLayout = (LinearLayout)findViewById(R.id.dotsLayout);

        btNext = (Button) findViewById(R.id.btNext);
        btBack = (Button) findViewById(R.id.btBack);

        slideAdapter = new SlideAdapter(this);

        slideViewPager.setAdapter(slideAdapter);

        addDotsIndicator(0);

        slideViewPager.addOnPageChangeListener(viewListener);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage + 1);
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage - 1);
            }
        });

    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[2];
        dotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.purple));

            dotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            currentPage = i;
            if(i == 0) {
                btNext.setEnabled(true);
                btBack.setEnabled(false);
                btBack.setVisibility(View.VISIBLE);

                btNext.setText("Next");
                btBack.setText("");

            }else if (i == mDots.length){

                btNext.setEnabled(true);
                btBack.setEnabled(true);
                btBack.setVisibility(View.VISIBLE);

                btNext.setText("Finish");
                btBack.setText("Back");
            }else {

                btNext.setEnabled(true);
                btBack.setEnabled(true);
                btBack.setVisibility(View.VISIBLE);

                btNext.setText("Next");
                btBack.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
