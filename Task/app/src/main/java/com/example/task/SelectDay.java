package com.example.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SelectDay extends AppCompatActivity {
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_day);

        Bundle b=getIntent().getExtras();
        username=b.getString("username");
        //Toast.makeText(this, "Username : "+username, Toast.LENGTH_SHORT).show();



    }

    public void mon(View view) {

        Intent i=new Intent(this,AddFixed.class);
        Bundle bundle=new Bundle();
        bundle.putInt("r",0);
        bundle.putString("username",username);
        i.putExtras(bundle);
        startActivity(i);
    }

    public void tue(View view) {
        Intent i=new Intent(this,AddFixed.class);
        Bundle bundle=new Bundle();
        bundle.putInt("r",1);
        bundle.putString("username",username);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void wed(View view) {
        Intent i=new Intent(this,AddFixed.class);
        Bundle bundle=new Bundle();
        bundle.putInt("r",2);
        bundle.putString("username",username);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void thur(View view) {
        Intent i=new Intent(this,AddFixed.class);
        Bundle bundle=new Bundle();
        bundle.putInt("r",3);
        bundle.putString("username",username);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void fri(View view) {
        Intent i=new Intent(this,AddFixed.class);
        Bundle bundle=new Bundle();
        bundle.putInt("r",4);
        bundle.putString("username",username);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void sat(View view) {
        Intent i=new Intent(this,AddFixed.class);
        Bundle bundle=new Bundle();
        bundle.putInt("r",5);
        bundle.putString("username",username);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void sun(View view) {
        Intent i=new Intent(this,AddFixed.class);
        Bundle bundle=new Bundle();
        bundle.putInt("r",6);
        bundle.putString("username",username);
        i.putExtras(bundle);
        startActivity(i);
    }
}
