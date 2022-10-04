package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListPersonAdapter extends BaseAdapter {
    private Context context;
    Person[] arrPerson;

    public ListPersonAdapter(Context context, Person[] arrPerson) {
        this.context = context;
        this.arrPerson = arrPerson;
    }

    @Override
    public int getCount() {
        return arrPerson.length;
    }

    @Override
    public Object getItem(int i) {
        return arrPerson[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        LinearLayout singleFrame=(LinearLayout)inflater.inflate(R.layout.person_item,null);

        ImageView avatar;
        TextView id;

        avatar=(ImageView) singleFrame.findViewById(R.id.avatar);
        id=(TextView) singleFrame.findViewById(R.id.classid);

        avatar.setImageResource(arrPerson[i].getAvatar());
        id.setText(arrPerson[i].getClassname());

        return singleFrame;
    }
}
