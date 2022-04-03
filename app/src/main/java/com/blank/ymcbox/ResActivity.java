package com.blank.ymcbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.blank.ymcbox.Adapter.PagerViewAdapter;
import com.blank.ymcbox.View.ResManager.AddonFragment;
import com.blank.ymcbox.View.ResManager.MapFragment;
import com.blank.ymcbox.View.ResManager.ResFragment;
import com.google.android.material.tabs.TabLayout;

public class ResActivity extends AppCompatActivity {
    PagerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        Toolbar toolbar=findViewById(R.id.toolbar);
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        ViewPager viewPager=findViewById(R.id.viewPager);
        setSupportActionBar(toolbar);
        adapter=new PagerViewAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        adapter.addFragment(new MapFragment());
        adapter.addFragment(new AddonFragment());
        adapter.addFragment(new ResFragment());
        viewPager.setAdapter(adapter);
        tabLayout.getTabAt(0).setText(R.string.map);
        tabLayout.getTabAt(1).setText(R.string.addon);
        tabLayout.getTabAt(2).setText(R.string.res);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}