package com.example.csj.gymclub.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.csj.gymclub.R;

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle =this.getArguments();//得到从Activity传来的数据
        String mess = null;
        if(bundle!=null){
            mess = bundle.getString("name");
        }
        TextView mView = (TextView)getActivity().findViewById(R.id.editText13);
        mView.setText(mess);
        Button mEmailSignInButton1 = (Button)getActivity().findViewById(R.id.email_sign_out_button1);
        mEmailSignInButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //attemptLogin();
                Intent i =new Intent(getActivity(),LoginActivity.class);
                startActivity(i);
            }
        });
    }
}


