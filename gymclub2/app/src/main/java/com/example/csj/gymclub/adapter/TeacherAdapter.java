package com.example.csj.gymclub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.csj.gymclub.R;
import com.example.csj.gymclub.bean.Course;
import com.example.csj.gymclub.bean.Teacher;

import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener {
    private Context mContext;
    ArrayList<Teacher> mlist;
    private RecyclerViewOnItemClickListener mClickListener;


    public TeacherAdapter(Context context, ArrayList<Teacher> list) {
        this.mContext = context;
        this.mlist=list;
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.course_item, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    public void setOnItemClickListener(RecyclerViewOnItemClickListener listener) {
        this.mClickListener = listener;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.tv1.setText((String)mlist.get(position).getName());
        myViewHolder.tv2.setText((String)mlist.get(position).getIntroduce());
        myViewHolder.iv.setImageResource((int)mlist.get(position).getImageId());
        myViewHolder.root.setTag(position);
        /*
        if (mClickListener != null) {
            myViewHolder.cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClickListener.onItemClick(myViewHolder.itemView, myViewHolder.getLayoutPosition());
                }
            });
        }
        */
    }
    @Override
    public void onClick(View v) {
        if (mClickListener != null) {
            //注意这里使用getTag方法获取数据
            mClickListener.onItemClick(v, (Integer) v.getTag());
        }

    }
}
