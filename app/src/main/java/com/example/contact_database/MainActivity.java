package com.example.contact_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    FloatingActionButton add;
    ArrayList<Integer> idlist=new ArrayList<>();
    ArrayList<String> namelist=new ArrayList<>();
    ArrayList<String> surnamelist=new ArrayList<>();
    ArrayList<String>numberlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        add=findViewById(R.id.add);

       idlist=getIntent().getIntegerArrayListExtra("keyidlist");
       namelist=getIntent().getStringArrayListExtra("keynamelist");
       surnamelist=getIntent().getStringArrayListExtra("keysurname");
       numberlist=getIntent().getStringArrayListExtra("keynumberlist");



        List_Contact_Adapter adapter=new List_Contact_Adapter(MainActivity.this,idlist,namelist,surnamelist,numberlist);
       listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, Create_Contact_Activity.class);

                startActivity(intent);
            }
        });

    }
}