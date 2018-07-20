package com.apkglobal.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
EditText e1,e2,e3;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b1=findViewById(R.id.b1);
    b2=findViewById(R.id.b2);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);


        b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             sp=getSharedPreferences("filename",0);
             ed=sp.edit();
             ed.putString("name",e1.getText().toString());
            ed.putString("email",e2.getText().toString());
            ed.putString("mobile",e3.getText().toString());
             ed.commit();
            Toast.makeText(MainActivity.this, "Save successfully", Toast.LENGTH_SHORT).show();

        }
    });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String sname=sp.getString("name",null);
                String sname1=sp.getString("email",null);
                String sname2=sp.getString("mobile",null);

                Toast.makeText(MainActivity.this,sname+"\n"+ sname1+"\n"+sname2 , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
