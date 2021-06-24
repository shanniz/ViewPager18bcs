package com.example.viewpager18bcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> tasks;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<>();
        tasks.add(new Task("watch movie", " watch at 4pm " ));
        tasks.add(new Task("watch movie", " watch at 5pm " ));
        tasks.add(new Task("play game", "  at 7 pm " ));

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager = findViewById(R.id.viewPagerTask);
        mViewPager.setAdapter(new FragmentStatePagerAdapter( fragmentManager) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                Task task = tasks.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("title", task.getTitle());
                bundle.putString("description", task.getDescription());
                Fragment fragment = new TaskFragment();
                fragment.setArguments(bundle);
                return fragment;
            }

            @Override
            public int getCount() {
                return tasks.size();
            }
        });
    }
}