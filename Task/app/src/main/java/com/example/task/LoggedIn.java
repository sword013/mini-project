package com.example.task;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoggedIn extends AppCompatActivity {


    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);


        Bundle b=getIntent().getExtras();
        username=b.getString("username");



    }


    public void showtt(View view) {
        Intent i = new Intent(this,TimeTable.class);
        Bundle b=new Bundle();
        b.putString("username",username);
        i.putExtras(b);
        startActivity(i);
    }

    public void gotoSelectDay(View view) {
        Intent i=new Intent(this,AllotFixedTasks.class);
        Bundle b=new Bundle();
        b.putString("username",username);
        i.putExtras(b);
        startActivity(i);
    }

    public void showFixed(View view) {

        Intent i=new Intent(this,FixedTasks.class);
        Bundle b=new Bundle();
        b.putString("username",username);
        i.putExtras(b);
        startActivity(i);

    }
}
