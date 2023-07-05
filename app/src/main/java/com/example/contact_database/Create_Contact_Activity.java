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
    ImageView back, save;
    EditText name1, surname1, number1;
    My_Database database = new My_Database(Create_Contact_Activity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        back = findViewById(R.id.back);
        save = findViewById(R.id.save);
        name1 = findViewById(R.id.name1);
        surname1 = findViewById(R.id.surname1);
        number1 = findViewById(R.id.number1);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Create_Contact_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n1 = name1.getText().toString();
                String n2 = surname1.getText().toString();
                String n3 = number1.getText().toString();
                database.addContacts("" + n1, "" + n2, "" + n3);

                Log.d("YYY", "onClick: create data " + n1);

                Intent intent = new Intent(Create_Contact_Activity.this, MainActivity.class);

                startActivity(intent);

                }





        });


    }
}