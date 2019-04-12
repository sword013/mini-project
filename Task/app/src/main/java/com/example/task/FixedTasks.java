package com.example.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FixedTasks extends AppCompatActivity {
String username;
DatabaseHelper db=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_tasks);

        Bundle b=getIntent().getExtras();
        username=b.getString("username");
        TextView tv = findViewById(R.id.showFixedTasks);

        int result=db.fixed_userexists(username);
        if(result==1) {
            StringBuilder sb = new StringBuilder();
            sb = db.showFixed(username);



            tv.setText(sb.toString());
        }
        else{
            tv.setText("No fixed tasks allocated ");
        }

    }
}
