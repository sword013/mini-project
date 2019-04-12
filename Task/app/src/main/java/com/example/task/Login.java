package com.example.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText login_user,login_pass;
    Button login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getting the components
        db=new DatabaseHelper(this);
        login_user=(EditText)findViewById(R.id.login_user);
        login_pass=(EditText)findViewById(R.id.login_pass);
        login=(Button)findViewById(R.id.login);



        //what should happen when someone hits login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s4=login_user.getText().toString();
                String s5=login_pass.getText().toString();

                if(s4.equals("")|| s5.equals("")){
                    //fields are empty
                    Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();

                }
                else{
                    //fields are not empty
                    boolean result=db.recordexists(s4,s5);
                    if(result==true){
                        //account exists
                        Intent intent=new Intent(Login.this,LoggedIn.class);
                        Bundle b=new Bundle();
                        b.putString("username",s4);
                        intent.putExtras(b);
                        startActivity(intent);


                    }
                    else{
                        //account does not exist
                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();

                    }
                }



               /* boolean result=db.record_exists(username,password);
                if(result==true){
                    //Yes such a entry does exist
                    Toast.makeText(getApplicationContext(),"Successful login",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong username and password",Toast.LENGTH_SHORT).show();
                }*/

            }
        });





    }

    public void notSigned(View view) {
        finish();
    }
}
