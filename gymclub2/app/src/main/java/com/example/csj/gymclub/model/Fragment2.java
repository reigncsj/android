package com.example.csj.gymclub.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csj.gymclub.R;
import com.example.csj.gymclub.adapter.CourseAdapter;
import com.example.csj.gymclub.bean.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class Fragment2 extends Fragment {
    private RecyclerView rec;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2,container,false);
        rec=(RecyclerView)view.findViewById(R.id.courseList);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this.getActivity());
        rec.setLayoutManager(layoutManager);
        CourseAdapter adapter=new CourseAdapter(this.getContext(),initCourse());
        rec.setAdapter(adapter);
    }

    private ArrayList<Course> initCourse(){
        ArrayList<Course> list = new ArrayList<Course>();
        list.add(new Course("一小时跑步","让全身都动起来",R.mipmap.paobu));
        list.add(new Course("健身训练","让你的身体壮起来",R.mipmap.jianshen));
        list.add(new Course("瑜伽练习","让你的身体美起来",R.mipmap.yujia));
        return  list;
    }
}

