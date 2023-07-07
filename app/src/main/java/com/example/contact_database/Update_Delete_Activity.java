package com.example.contact_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contact_database.Model.Contacts;

import java.util.ArrayList;

public class Update_Delete_Activity extends AppCompatActivity {
    ImageView backbutton, update, delete;
    EditText editname, editsurname, editnumber;
    My_Database My_database = new My_Database(Update_Delete_Activity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        backbutton = findViewById(R.id.backbutton);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        editname = findViewById(R.id.editname);
        editsurname = findViewById(R.id.editsurname);
        editnumber = findViewById(R.id.editnumber);



        int key_id = getIntent().getIntExtra("keyid", 0);
        String key_name = getIntent().getStringExtra("keyname");
        String key_surname = getIntent().getStringExtra("keysurname");
        String key_number = getIntent().getStringExtra("keynumber");
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Update_Delete_Activity.this, Create_Contact_Activity.class);
                startActivity(intent);
            }
        });
        editname.setText("" + key_name);
        editsurname.setText("" + key_surname);
        editnumber.setText("" + key_number);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int upid = key_id;
                String upname = editname.getText().toString();
                String upsurname = editsurname.getText().toString();
                String upnumber = editnumber.getText().toString();
                Log.d("TTT", "onClick: name"+upname);
                My_database.updateContact(upid, upname, upsurname, upnumber);

                Intent intent = new Intent(Update_Delete_Activity.this, MainActivity.class);
                startActivity(intent);


            }
        });


    }
}