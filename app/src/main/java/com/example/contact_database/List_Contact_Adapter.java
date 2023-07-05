package com.example.contact_database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class List_Contact_Adapter extends BaseAdapter {

   MainActivity mainActivity;
   ArrayList<Integer> idlist;
   ArrayList<String> namelist;
   ArrayList<String> surnamelist;
   ArrayList<String>numberlist;

    public List_Contact_Adapter(MainActivity mainActivity, ArrayList<Integer> idlist, ArrayList<String> namelist, ArrayList<String> surnamelist, ArrayList<String> numberlist) {
        this.mainActivity = mainActivity;
        this.idlist = idlist;
        this.namelist = namelist;
        this.surnamelist = surnamelist;
        this.numberlist=numberlist;
    }



    @Override
    public int getCount() {
        return namelist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(mainActivity).inflate(R.layout.listview_item_layout,parent,false);

        return view;
    }
}
