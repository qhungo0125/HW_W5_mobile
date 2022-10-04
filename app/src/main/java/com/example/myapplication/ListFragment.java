package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;


public class ListFragment extends Fragment implements ListCallback{

    MainActivity main;
    Context context;
    String[] names = {"Le Thi A","Le Thi A","Le Thi A","Le Thi A",
            "Le Thi A","Le Thi A","Le Thi A","Le Thi A"};
    String[] lops = {"A1","A1","A2","A2","A1","A3","A2","A4"};
    String[] diem = {"1","2","3","4","5","6","7","8"};
    String[] items = {"A1_9829","A1_1809","A2_3509","A2_3100","A1_1120",
            "A3_4120","A2_8100","A4_1160"};
    Integer[] avatar = {R.drawable.ic_baseline_person_24,R.drawable.ic_baseline_person_24,R.drawable.ic_baseline_person_24,R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,R.drawable.ic_baseline_person_24,R.drawable.ic_baseline_person_24,R.drawable.ic_baseline_person_24,
            };
    Person[] arrpers;
    ListView list;
    ListPersonAdapter aa;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
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
        FrameLayout myLayout = (FrameLayout)inflater.inflate(R.layout.fragment_list,null);
        // Inflate the layout for this fragment

        list = (ListView)myLayout.findViewById(R.id.list_view);
        TextView currentid = (TextView)myLayout.findViewById(R.id.currentID);
        arrpers = new Person[names.length];
        for(int i=0;i< names.length;i++){
            arrpers[i]= new Person(avatar[i],names[i],diem[i],i,items[i],lops[i]);
        }

        aa = new ListPersonAdapter(context,arrpers);
        list.setAdapter(aa);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                main.MainToFrag(arrpers[i]);
                currentid.setText("Mã số: "+ items[i]);
            }
        });


        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                view.setEnabled(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                main.findViewById(R.id.item).setEnabled(true);
            }
        });

        return myLayout;
    }

    @Override
    public Person getPerson(int id) {

        for(int i=0;i<arrpers.length;i++){
            if(i!=id)
                list.getChildAt(i).setSelected(false);
            else{
                list.getChildAt(i).setSelected(true);
            }
        }


        return arrpers[id];
    }

    @Override
    public int getSize() {
        return arrpers.length;
    }
}