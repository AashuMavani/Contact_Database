package com.example.contact_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class Create_Contact_Activity extends AppCompatActivity {
    ImageView back,save;
    EditText name,surname,number;
    ArrayList<Integer>idlist=new ArrayList<>();
    ArrayList<String> namelist=new ArrayList<>();
    ArrayList<String> surnamelist=new ArrayList<>();
    ArrayList<String>numberlist=new ArrayList<>();

    My_Database database=new My_Database(Create_Contact_Activity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        back=findViewById(R.id.back);
        save=findViewById(R.id.save);
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        number=findViewById(R.id.number);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Create_Contact_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String n1=name.getText().toString();
            String n2=surname.getText().toString();
            String n3=number.getText().toString();
            database.addContacts(""+n1,""+n2,""+n3);

                Log.d("YYY", "onClick: create data "+n1);
             Cursor cursor=database.showdata();

             while (cursor.moveToNext())
             {
                    idlist.add(cursor.getInt(0));
                    namelist.add(cursor.getString(1));
                    surnamelist.add(cursor.getString(2));
                    numberlist.add(cursor.getString(3));
                 Log.d("YYY", "onClick: "+idlist+","+numberlist+","+surnamelist+","+numberlist);
             }
             Intent intent=new Intent(Create_Contact_Activity.this,MainActivity.class);
             intent.putExtra("keyidlist",idlist);
             intent.putExtra("keynamelist",namelist);
             intent.putExtra("keysurnamelist",surnamelist);
             intent.putExtra("keynumberlist",numberlist);
             startActivity(intent);



            }
        });


    }
}