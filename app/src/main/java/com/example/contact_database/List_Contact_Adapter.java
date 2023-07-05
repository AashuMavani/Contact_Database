package com.example.contact_database;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.contact_database.Model.Contacts;

import java.util.ArrayList;

public class List_Contact_Adapter extends BaseAdapter {

    MainActivity mainActivity;

    ArrayList<Contacts> contactsList;

    public List_Contact_Adapter(MainActivity mainActivity, ArrayList<Contacts> contactsList) {
        this.mainActivity = mainActivity;
        this.contactsList = contactsList;
    }


    @Override
    public int getCount() {
        return contactsList.size();
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
        view = LayoutInflater.from(mainActivity).inflate(R.layout.listview_item_layout, parent, false);
        TextView t1 = view.findViewById(R.id.name);
        TextView t2 = view.findViewById(R.id.surname);
        TextView t3 = view.findViewById(R.id.number);

//        Log.d("YYY", "Adapter surnamelist=" + surnamelist);
//        Log.d("YYY", "Adapter= " + namelist);

        t1.setText("" + contactsList.get(position).getName());
        t2.setText("" + contactsList.get(position).getSurname());
        t3.setText("" + contactsList.get(position).getNumber());

        return view;
    }
}
