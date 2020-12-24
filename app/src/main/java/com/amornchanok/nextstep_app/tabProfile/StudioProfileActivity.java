package com.amornchanok.nextstep_app.tabProfile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.amornchanok.nextstep_app.R;
import com.amornchanok.nextstep_app.calendarBooking.CalendarActivity;
import com.amornchanok.nextstep_app.searchStudio.SearchRoomActivity;
import com.google.android.material.tabs.TabLayout;

public class StudioProfileActivity extends AppCompatActivity {
    Button bt_calendarbook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studio_profile);

        bt_calendarbook = (Button) findViewById(R.id.bt_calendarbook);
        bt_calendarbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarActivity();
            }

            private void openCalendarActivity() {
                    Intent intent = new Intent(StudioProfileActivity.this, CalendarActivity.class);
                    startActivity(intent);
            }

        });

        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabLayout tabInfo = findViewById(R.id.tabInfo);
        TabLayout tabRoom = findViewById(R.id.tabRoom);
        TabLayout tabReview = findViewById(R.id.tabReview);
        final ViewPager viewPager = findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
