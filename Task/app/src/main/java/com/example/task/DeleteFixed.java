package com.example.task;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteFixed extends AppCompatActivity {
String username;
String taskname;
DatabaseHelper db=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_fixed);

        Bundle b=getIntent().getExtras();
        username=b.getString("username");
        Toast.makeText(this, "Username : "+username, Toast.LENGTH_SHORT).show();



    }

    public void fixedDelSubmit(View view) {

        EditText et=(EditText)findViewById(R.id.fixedDelet);
        taskname=et.getText().toString();

        if(taskname.equals("")){
            Toast.makeText(this, "Please specify the Taskname !", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean delresult = db.fixedDel(username, taskname);

            if (delresult == true) {
                Toast.makeText(this, "Deleted Successfully !!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No such task exists !!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
