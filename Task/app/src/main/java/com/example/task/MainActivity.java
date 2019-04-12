package com.example.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    EditText user,pass,cpass;
    Button register,gotologin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.login_pass);
        cpass=(EditText)findViewById(R.id.cpass);
        register=(Button)findViewById(R.id.register);
        gotologin=(Button)findViewById(R.id.gotologin);


        //what should happen when go to login button is clicked
        gotologin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }

        });



        //what should happen when register button is clicked
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String s1=user.getText().toString();
                String s2=pass.getText().toString();
                String s3=cpass.getText().toString();


                if(s1.equals("")||s2.equals("")||s3.equals("")) {
                    //empty fields
                    Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    //not empty fields
                    boolean exists=db.check_username(s1);
                    if(exists==true){
                        //username already exists
                        Toast.makeText(getApplicationContext(), "Username already exists", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        //username doesnt exist

                        if(s2.equals(s3)){
                            //passwords match
                            boolean insert = db.insert(s1, s2);
                            if(insert==true){
                                //insertion successful
                                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();

                            }
                            else{
                                //insertion failed
                                Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();

                            }

                        }
                        else{
                            //passwords do not match
                            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();

                        }
                    }

                }


            }

               /* //All or one of the fields is empty
                if(s1.equals("")||s2.equals("")||s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                //All fields there and passwords match too
                else if(s2.equals(s3)){
                    //Check if record username already exists as its the pk
                    boolean exists=db.check_username(s1);
                    if(exists==true){
                        //record exists
                        Toast.makeText(getApplicationContext(),"Username already Exists ",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //record doesnt exist, the username is unique,Fire the Insert query now
                        Boolean insert = db.insert(s1, s2);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Error : Insert query failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                //Fields are full but passwords dont match
               else{
                   Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT);
                }
            }*/
        });

    }

    /*public void buClick(View view) {
        Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
    }*/
}
