package com.example.task;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class TimeTable extends AppCompatActivity {

    LinearLayout l1 = null;
    Integer[] week=new Integer[10080];
    DatabaseHelper db=new DatabaseHelper(this);
    String username;
    Integer checkpoints[]=new Integer[10080];
    int val;
    int cpc=0,vc=0;//checkpoint count,value count
    Integer[] vala=new Integer[10080];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        Bundle b=getIntent().getExtras();
        username=b.getString("username");


        week=db.timetable_fixed_fetch(username);


       val=vala[0]=week[0];
       checkpoints[0]=0;


       for(int i=1;i<=1439;i++){
           if(val!=week[i]){
               vc++;
               val=vala[vc]=week[i];
               cpc++;
               checkpoints[cpc]=i-1;
               cpc++;
               checkpoints[cpc]=i;


           }
       }

       cpc++;
       checkpoints[cpc]=1439;







        for (int i = 0; i <= cpc/2; i++) {
            RelativeLayout second = new RelativeLayout(TimeTable.this);
            int k;
            int height;
            k=i*2;
            height=checkpoints[k+1]-checkpoints[k]+1;
            height=height*2;

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(40, height);


            l1 = (LinearLayout) findViewById(R.id.mon);


            second.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            second.setLayoutParams(lp);
            if (vala[i] == 999) {
                second.setBackgroundColor(Color.YELLOW);
            } else {
                second.setBackgroundColor(Color.RED);
            }


            l1.addView(second);
        }



        //TUESDAY
        cpc=0;
        vc=0;
        val=vala[0]=week[0];
        checkpoints[0]=1440;


        for(int i=1440;i<=2879;i++){
            if(val!=week[i]){
                vc++;
                val=vala[vc]=week[i];
                cpc++;
                checkpoints[cpc]=i-1;
                cpc++;
                checkpoints[cpc]=i;


            }
        }

        cpc++;
        checkpoints[cpc]=2879;





        for (int i = 0; i <= cpc/2; i++) {
            RelativeLayout second = new RelativeLayout(TimeTable.this);
            int k;
            int height;
            k=i*2;

            height=checkpoints[k+1]-checkpoints[k]+1;
            height=height*2;


            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(40, height);


            l1 = (LinearLayout) findViewById(R.id.tue);


            second.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            second.setLayoutParams(lp);
            if (vala[i] == 999) {
                second.setBackgroundColor(Color.YELLOW);
            } else {
                second.setBackgroundColor(Color.RED);
            }


            l1.addView(second);
        }


        //wednesday

        cpc=0;
        vc=0;
        val=vala[0]=week[0];
        checkpoints[0]=2880;


        for(int i=2880;i<=4319;i++){
            if(val!=week[i]){
                vc++;
                val=vala[vc]=week[i];
                cpc++;
                checkpoints[cpc]=i-1;
                cpc++;
                checkpoints[cpc]=i;


            }
        }

        cpc++;
        checkpoints[cpc]=4319;





        for (int i = 0; i <= cpc/2; i++) {
            RelativeLayout second = new RelativeLayout(TimeTable.this);
            int k;
            int height;
            k=i*2;
            height=checkpoints[k+1]-checkpoints[k]+1;
            height=height*2;

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(40, height);


            l1 = (LinearLayout) findViewById(R.id.wed);


            second.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            second.setLayoutParams(lp);
            if (vala[i] == 999) {
                second.setBackgroundColor(Color.YELLOW);
            } else {
                second.setBackgroundColor(Color.RED);
            }


            l1.addView(second);
        }


        //thursday
        cpc=0;
        vc=0;
        val=vala[0]=week[0];
        checkpoints[0]=4320;


        for(int i=4320;i<=5759;i++){
            if(val!=week[i]){
                vc++;
                val=vala[vc]=week[i];
                cpc++;
                checkpoints[cpc]=i-1;
                cpc++;
                checkpoints[cpc]=i;


            }
        }

        cpc++;
        checkpoints[cpc]=5759;





        for (int i = 0; i <= cpc/2; i++) {
            RelativeLayout second = new RelativeLayout(TimeTable.this);
            int k;
            int height;
            k=i*2;
            height=checkpoints[k+1]-checkpoints[k]+1;
            height=height*2;

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(40, height);


            l1 = (LinearLayout) findViewById(R.id.thur);


            second.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            second.setLayoutParams(lp);
            if (vala[i] == 999) {
                second.setBackgroundColor(Color.YELLOW);
            } else {
                second.setBackgroundColor(Color.RED);
            }


            l1.addView(second);
        }




        //friday

        cpc=0;
        vc=0;
        val=vala[0]=week[0];
        checkpoints[0]=5760;


        for(int i=5760;i<=7199;i++){
            if(val!=week[i]){
                vc++;
                val=vala[vc]=week[i];
                cpc++;
                checkpoints[cpc]=i-1;
                cpc++;
                checkpoints[cpc]=i;


            }
        }

        cpc++;
        checkpoints[cpc]=7199;





        for (int i = 0; i <= cpc/2; i++) {
            RelativeLayout second = new RelativeLayout(TimeTable.this);
            int k;
            int height;
            k=i*2;
            height=checkpoints[k+1]-checkpoints[k]+1;
            height=height*2;

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(40, height);


            l1 = (LinearLayout) findViewById(R.id.fri);


            second.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            second.setLayoutParams(lp);
            if (vala[i] == 999) {
                second.setBackgroundColor(Color.YELLOW);
            } else {
                second.setBackgroundColor(Color.RED);
            }


            l1.addView(second);
        }




        //saturday
        cpc=0;
        vc=0;
        val=vala[0]=week[0];
        checkpoints[0]=7200;


        for(int i=7200;i<=8639;i++){
            if(val!=week[i]){
                vc++;
                val=vala[vc]=week[i];
                cpc++;
                checkpoints[cpc]=i-1;
                cpc++;
                checkpoints[cpc]=i;


            }
        }

        cpc++;
        checkpoints[cpc]=8639;





        for (int i = 0; i <= cpc/2; i++) {
            RelativeLayout second = new RelativeLayout(TimeTable.this);
            int k;
            int height;
            k=i*2;
            height=checkpoints[k+1]-checkpoints[k]+1;
            height=height*2;

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(40, height);


            l1 = (LinearLayout) findViewById(R.id.sat);


            second.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            second.setLayoutParams(lp);
            if (vala[i] == 999) {
                second.setBackgroundColor(Color.YELLOW);
            } else {
                second.setBackgroundColor(Color.RED);
            }


            l1.addView(second);
        }


        //sunday

        cpc=0;
        vc=0;
        val=vala[0]=week[0];
        checkpoints[0]=8640;


        for(int i=8640;i<=10079;i++){
            if(val!=week[i]){
                vc++;
                val=vala[vc]=week[i];
                cpc++;
                checkpoints[cpc]=i-1;
                cpc++;
                checkpoints[cpc]=i;


            }
        }

        cpc++;
        checkpoints[cpc]=10079;





        for (int i = 0; i <= cpc/2; i++) {
            RelativeLayout second = new RelativeLayout(TimeTable.this);
            int k;
            int height;
            k=i*2;
            height=checkpoints[k+1]-checkpoints[k]+1;
            height=height*2;

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(40, height);


            l1 = (LinearLayout) findViewById(R.id.sun);


            second.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            second.setLayoutParams(lp);
            if (vala[i] == 999) {
                second.setBackgroundColor(Color.YELLOW);
            } else {
                second.setBackgroundColor(Color.RED);
            }


            l1.addView(second);
        }


    }
}
