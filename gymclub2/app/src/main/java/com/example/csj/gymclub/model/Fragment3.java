package com.example.csj.gymclub.model;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.csj.gymclub.R;
import com.example.csj.gymclub.adapter.CourseAdapter;
import com.example.csj.gymclub.bean.Course;

import java.util.ArrayList;

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class Fragment3 extends Fragment {
    private RecyclerView rec;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment3,container,false);
        rec=(RecyclerView)view.findViewById(R.id.newList);
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
        list.add(new Course("爆炸新闻","著名训练师加入我APP",R.mipmap.news,""));
        list.add(new Course("爆炸新闻","著名训练师加入我APP",R.mipmap.news,""));
        list.add(new Course("爆炸新闻","著名训练师加入我APP",R.mipmap.news,""));
        list.add(new Course("爆炸新闻","著名训练师加入我APP",R.mipmap.news,""));
        list.add(new Course("爆炸新闻","著名训练师加入我APP",R.mipmap.news,""));
        list.add(new Course("爆炸新闻","著名训练师加入我APP",R.mipmap.news,""));
        return  list;
    }
}

