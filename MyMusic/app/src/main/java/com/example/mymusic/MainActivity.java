package com.example.mymusic;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mineText;
    private TextView musicClubText;
    private TextView findText;
    private ViewPager viewPager;
    private List<Fragment> list;
    private FragmentAdapter fragmentAdapter;
    private Button menu;
    private DrawerLayout drawerLayout;
    private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null)
            actionBar.hide();
        search = findViewById(R.id.search);
        drawerLayout=findViewById(R.id.drawerlayout_main);
        menu=findViewById(R.id.menu);
        mineText=findViewById(R.id.mine);
        musicClubText=findViewById(R.id.music_club);
        findText=findViewById(R.id.find);
        viewPager=findViewById(R.id.main_viewpager);
        search.setOnClickListener(this);
        menu.setOnClickListener(this);
        mineText.setOnClickListener(this);
        musicClubText.setOnClickListener(this);
        findText.setOnClickListener(this);
        viewPager.setOnPageChangeListener(new MyPagerChangeListener());
        list = new ArrayList<>();
        list.add(new Mine());
        list.add(new MusicClub());
        list.add(new Find());

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(0);
        mineText.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mine:
                viewPager.setCurrentItem(0);
                mineText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                musicClubText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                findText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                break;
            case R.id.music_club:
                viewPager.setCurrentItem(1);
                mineText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                musicClubText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                findText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                break;
            case R.id.find:
                viewPager.setCurrentItem(2);
                mineText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                musicClubText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                findText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                break;
            case R.id.menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.search:
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
                break;
        }
    }

    class MyPagerChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    mineText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    musicClubText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    findText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    break;
                case 1:
                    mineText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    musicClubText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    findText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    break;
                case 2:
                    mineText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    musicClubText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    findText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    break;

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}


