package com.example.task;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class AllotFixedTasks extends AppCompatActivity {
String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allot_fixed_tasks);


        Bundle b=getIntent().getExtras();
        username=b.getString("username");
        Toast.makeText(this, "Username : "+username, Toast.LENGTH_SHORT).show();


    }



        public void aft_add(View view) {
        Bundle b=new Bundle();
        b.putString("username",username);
        Intent i=new Intent(this,SelectDay.class);
        i.putExtras(b);
        startActivity(i);

    }

    public void aft_del(View view) {
        Bundle b=new Bundle();
        b.putString("username",username);
        Intent i=new Intent(this,DeleteFixed.class);
        i.putExtras(b);
        startActivity(i);
    }

    public void aft_gb(View view) {
        finish();
    }
}
