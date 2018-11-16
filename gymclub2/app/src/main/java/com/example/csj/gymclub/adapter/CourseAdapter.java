package com.example.csj.gymclub.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.csj.gymclub.R;
import com.example.csj.gymclub.bean.Course;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    ArrayList<Course> mlist;
    TextView tv1;
    TextView tv2;
    ImageView iv;
    CardView cv;

    public CourseAdapter(Context context, ArrayList<Course> list) {
        this.mContext = context;
        this.mlist=list;
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.course_item,parent,false);
        cv = (CardView)view.findViewById(R.id.course);
        tv1 = (TextView) view.findViewById(R.id.c_item1);
        tv2 = (TextView) view.findViewById(R.id.c_item2);
        iv = (ImageView) view.findViewById(R.id.image1);
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view){};
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        tv1.setText((String)mlist.get(position).getTitle());
        tv2.setText((String)mlist.get(position).getContent());
        iv.setImageResource((int)mlist.get(position).getImageId());
    }
}

