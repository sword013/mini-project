package com.example.task;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddFixed extends AppCompatActivity {


    String username;
    int r;




    String taskname;
    String stress,fh,fm,fa,th,tm,ta;
    int sr,from_hr,from_min,from_ampm,to_hr,to_min,to_ampm;


    Integer[] week=new Integer[10080];
    int infinity=999;

DatabaseHelper db=new DatabaseHelper(this);

TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fixed);




        Bundle bundle=getIntent().getExtras();
        r=bundle.getInt("r");
        username=bundle.getString("username");
        //Toast.makeText(this, "username : "+username+"r : "+r, Toast.LENGTH_SHORT).show();

        Button FixedSubmit=(Button)findViewById(R.id.FixedSubmit);








        FixedSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int from,to;
                //step1 : Attach the elements ************************************************************
                EditText tn=(EditText) findViewById(R.id.tn);
                EditText srr=(EditText) findViewById(R.id.srr);
                EditText fromm_hr=(EditText) findViewById(R.id.fromm_hr);
                EditText fromm_min=(EditText) findViewById(R.id.fromm_min);
                EditText fromm_ampm=(EditText) findViewById(R.id.fromm_ampm);
                EditText too_hr=(EditText) findViewById(R.id.too_hr);
                EditText too_min=(EditText) findViewById(R.id.too_min);
                EditText too_ampm=(EditText) findViewById(R.id.too_ampm);



                //********************************************************************************






                //step2: get the inputs **********************************************************

                stress=srr.getText().toString();
                if(stress.equals("")){

                }else {
                    sr = Integer.parseInt(stress);
                }

                fh=fromm_hr.getText().toString();
                if(fh.equals("")){

                }else {
                    from_hr = Integer.parseInt(fh);
                }


                fm=fromm_min.getText().toString();
                if(fm.equals("")){}else{
                    from_min=Integer.parseInt(fm);}


                fa=fromm_ampm.getText().toString();
                if(fa.equals("")){}else {
                    from_ampm = Integer.parseInt(fa);
                }


                ta=too_ampm.getText().toString();
                if(ta.equals("")){}else {
                    to_ampm = Integer.parseInt(ta);
                }

                tm=too_min.getText().toString();
                if(tm.equals("")){}else {
                    to_min = Integer.parseInt(tm);
                }


                th=too_hr.getText().toString();
                if(th.equals("")){}else {
                    to_hr = Integer.parseInt(th);
                }

                taskname=tn.getText().toString();


                //********************************************************************************







                //for debugging purpose
/*                taskname="Singing";
                sr=5;
                from_hr=12;
                from_min=30;
                from_ampm=0;
                to_hr=6;
                to_min=30;
                to_ampm=1;




                stress="something";
                fh="something";
                fm="something";
                fa="something";
                th="something";
                tm="something";
                ta="s";
*/

                //**************



               // Toast.makeText(AddFixed.this,taskname+sr+from_hr+from_min+from_ampm+to_hr+to_min+to_ampm, Toast.LENGTH_SHORT).show();

                //start executing the tree now****************************************************

                if(stress.equals("")||taskname.equals("")||fh.equals("")||fm.equals("")||fa.equals("")||th.equals("")||tm.equals("")||ta.equals("")){
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();

                }
                else {
                   // Toast.makeText(AddFixed.this, "All fields are filled", Toast.LENGTH_SHORT).show();

                    //Now check if user exists



                        boolean result=db.check(username);
                        if(result==true){
                            //Toast.makeText(getApplicationContext(), "User exists,fetching from database", Toast.LENGTH_SHORT).show();



                            week=db.fixed_fetch(username);
                            //Toast.makeText(AddFixed.this, "Fetched from db the week !!", Toast.LENGTH_SHORT).show();


                        }
                        else{
                            //user does not exist
                            //Toast.makeText(getApplicationContext(), "User does not exists", Toast.LENGTH_SHORT).show();
                            for(int i=0;i<=10079;i++){
                                week[i]=999;
                            }

                        }

                    //********************************************************************************



                    //WE got week now, lets Try to insert the values !! So,are the values specified valid ? ********
                    //The fixed algo will come here

                    //Step1. Get FROM and TO

                    if(from_ampm==0){
                        //AM
                        if(from_hr==12){
                            from=from_hr*60-720+from_min;
                        }
                        else{
                            from=from_hr*60+from_min;
                        }
                    }


                    else{
                        //PM
                        if(from_hr!=12){
                            from=from_hr*60+720+from_min;
                        }
                        else{
                            from=from_hr*60+from_min;
                        }
                    }





                    if(to_ampm==0){
                        //AM
                        if(to_hr==12){
                            to=to_hr*60-720+to_min;
                        }
                        else{
                            to=to_hr*60+to_min;
                        }
                    }
                    else{
                        //PM
                        if(to_hr!=12){
                            to=to_hr*60+720+to_min;
                        }
                        else{
                            to=to_hr*60+to_min;
                        }
                    }




                    from=from+1440*r;
                    to=to+1440*r;




                    if(from>=to){
                        to=to+1440;
                    }

                    //Toast.makeText(AddFixed.this, "from="+String.valueOf(from)+"to:"+String.valueOf(to), Toast.LENGTH_SHORT).show();
                    int valid=1;

                    for(int i=from;i<=to;i++){
                        if(week[i]!=999){
                            valid=0;
                            break;
                        }
                    }

                    if(valid==0){
                        Toast.makeText(AddFixed.this, "Sorry,cannot be allocated,already filled ", Toast.LENGTH_SHORT).show();
                    }else{
                        //Toast.makeText(AddFixed.this, "Can be allocated !!!", Toast.LENGTH_SHORT).show();



                        //now see if the user already has some fixed task allocated**************
                            int val;
                            val=db.fixed_tasksexists(username);
                        //Toast.makeText(AddFixed.this, "max val : "+String.valueOf(val), Toast.LENGTH_SHORT).show();
                        if(val==-1){
                            //user hasnt assigned any task
                            val=0;
                        }
                        else{
                            //he has assigned,just use the next value to start allocation
                            val++;
                        }

                       // Toast.makeText(AddFixed.this, "Task's val to be assigned : "+String.valueOf(val), Toast.LENGTH_SHORT).show();



                        //********************************************************

//ETH PARYANT BATOBER AHE
                        //enter values in database !!!!
                        //Toast.makeText(AddFixed.this, "username : "+username+"taskname : "+taskname+"sr : "+String.valueOf(sr)+"from : "+String.valueOf(from)+"from_ampm : "+String.valueOf(from_ampm)+"to : "+String.valueOf(to)+"to_ampm : "+to_ampm, Toast.LENGTH_SHORT).show();
                        boolean resultl=db.f(username,taskname,sr,from,from_ampm,to,to_ampm,val);
                        if(resultl==true){
                            Toast.makeText(AddFixed.this, "Successfully inserted !!!!!!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //Toast.makeText(AddFixed.this, "Programming logic error occured", Toast.LENGTH_SHORT).show();
                        }
                        //***********************************************************************


                    }
                    //************************************************************************************************


                }

            }
        });













    }
}
