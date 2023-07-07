package com.example.contact_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contact_database.Model.Contacts;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    FloatingActionButton add;
    ArrayList<Contacts> contactsList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        add = findViewById(R.id.add);

        showData();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Create_Contact_Activity.class);

                startActivity(intent);
            }
        });
    }

    private void showData() {

        My_Database my_database=new My_Database(MainActivity.this);
        Cursor cursor=my_database.showdata();
        while (cursor.moveToNext()) {
            int id=cursor.getInt(0);
            String name=(cursor.getString(1));
            String sname=(cursor.getString(2));
            String number=(cursor.getString(3));
            Contacts contacts=new Contacts(id,name,sname,number);
            contactsList.add(contacts);

        }
        List_Contact_Adapter adapter = new List_Contact_Adapter(MainActivity.this, contactsList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,Update_Delete_Activity.class);
                intent.putExtra("position",position);
                intent.putExtra("keyid",contactsList.get(position).getId());
                intent.putExtra("keyname",contactsList.get(position).getName());
                intent.putExtra("keysurname",contactsList.get(position).getSurname());
                intent.putExtra("keynumber",contactsList.get(position).getNumber());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                my_database.DeleteDataBase(contactsList.get(position).getId());
                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}