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

import com.example.csj.gymclub.R;
import com.example.csj.gymclub.adapter.RecyclerViewOnItemClickListener;
import com.example.csj.gymclub.adapter.TeacherAdapter;
import com.example.csj.gymclub.bean.Course;
import com.example.csj.gymclub.bean.Teacher;

import java.util.ArrayList;

public class Fragment4 extends Fragment {
    private RecyclerView rec;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment4,container,false);
        rec=(RecyclerView)view.findViewById(R.id.TeacherList);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this.getActivity());
        rec.setLayoutManager(layoutManager);
        final ArrayList<Teacher> list=initCourse();

        TeacherAdapter adapter=new TeacherAdapter(this.getContext(),list);
        adapter.setOnItemClickListener(new RecyclerViewOnItemClickListener(){
            @Override
            public void onItemClick(View view, int postion) {
                Teacher teacher=list.get(postion);
                Intent i = new Intent(getContext(), TeacherActivity.class);
                i.putExtra("name",teacher.getName());
                i.putExtra("id",teacher.getid());
                i.putExtra("img",teacher.getImageId());
                startActivity(i);
            }
        });
        rec.setAdapter(adapter);
    }

    private ArrayList<Teacher> initCourse(){
        ArrayList<Teacher> list = new ArrayList<Teacher>();
        list.add(new Teacher("周杰伦 ","听妈妈的话,锻炼身体",R.mipmap.zjl,1));
        list.add(new Teacher("汪峰","在训练房里,一起摇摆",R.mipmap.wf,2));
        list.add(new Teacher("刘诗诗","在舞蹈中,成为梦中的若曦",R.mipmap.lss,3));
        list.add(new Teacher("庾澄庆","让你一次跑个够",R.mipmap.ycq,4));
        return  list;
    }
}
