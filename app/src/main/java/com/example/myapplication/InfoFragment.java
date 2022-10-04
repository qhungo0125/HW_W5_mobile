package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class InfoFragment extends Fragment implements InfoCallback {
    MainActivity main;
    Context context;
    TextView classid,name,lop,score;
    Button first,previous,next,last;
    int currentID=-1;

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance() {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main=(MainActivity) getActivity();
        context=getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout myLayout = (FrameLayout)inflater.inflate(R.layout.fragment_info,null);
        // Inflate the layout for this fragment


        classid=(TextView) myLayout.findViewById(R.id.classid);
        name=(TextView) myLayout.findViewById(R.id.name);
        lop=(TextView) myLayout.findViewById(R.id.lop);
        score=(TextView) myLayout.findViewById(R.id.score);

        next=(Button) myLayout.findViewById(R.id.nextBtn);
        previous=(Button) myLayout.findViewById(R.id.previousBtn);
        first=(Button) myLayout.findViewById(R.id.firstBtn);
        last=(Button) myLayout.findViewById(R.id.lastBtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentID!=-1){
                    int nextIndex=currentID+1;
                    if(nextIndex<getSize()){
                        getPerson(nextIndex);

                    }else{
                        nextIndex=getSize()-1;
                        getPerson(nextIndex);
                    }
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentID!=-1){
                    int nextIndex=currentID-1;
                    if(nextIndex>=0){
                        getPerson(nextIndex);
                    }else{
                        nextIndex=0;
                        getPerson(nextIndex);
                    }
                }
            }
        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentID=getSize()-1;
                getPerson(currentID);
            }
        });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentID=0;
                getPerson(currentID);
            }
        });

        return myLayout;
    }

    @Override
    public void FragToMain(Person per) {
        classid.setText(per.getClassname());
        name.setText("Họ tên: "+per.getName());
        lop.setText("Lớp: "+per.getClasscut());
        score.setText("Điểm TB: "+per.getScore());
        currentID=per.getId();
    }

    @Override
    public void getPerson(int id) {
        Person nextpPer= main.getPersonFromList(id);
        FragToMain(nextpPer);
        return;
    }

    @Override
    public int getSize() {
        return main.getSize();
    }
}