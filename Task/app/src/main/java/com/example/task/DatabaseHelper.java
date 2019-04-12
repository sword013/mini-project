package com.example.task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists user(username text primary key,password text);");
       db.execSQL("Create table if not exists fixed(id integer primary key AUTOINCREMENT,username text,TaskName text,SR integer,fromm integer,from_ampm integer,too integer,to_ampm integer,val integer);");
       db.execSQL("Create table if not exists var(username text,TaskName text,SR integer,urg integer,imp integer,fromm integer,too integer,allocated integer,dur integer,val integer);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
       db.execSQL("drop table if exists fixed");
        db.execSQL("drop table if exists var");
    }


    //REGISTER :1.INSERT QUERY
    public boolean insert(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);

        long ins = db.insert("user", null, contentValues);

        if (ins == -1) return false;
        else return true;
    }


    //REGISTER: 2.checking if username exits
    public boolean check_username(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=?", new String[]{username});
        if (cursor.getCount() > 0) return true;
        else return false;
    }


    //LOGIN : check the username and password ;
    public boolean recordexists(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0) return true;
        else return false;
    }








    //AddFixed queries*********************************************************
    public int fixed_userexists(String username){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from fixed where username=?", new String[]{username});
        if (c.getCount() > 0) return 1;
        else return 0;

    }



  public Integer[] fixed_fetch(String username){


        SQLiteDatabase db=this.getReadableDatabase();
         Integer[] week=new Integer[10080];
        Cursor cursor=db.rawQuery("select fromm,too,val from fixed where username=?",new String[]{username});

      for(int i=0;i<=10079;i++){
          week[i]=999;
      }


      cursor.moveToFirst();
            do{
                int fromm=cursor.getInt(cursor.getColumnIndex("fromm"));
               int too=cursor.getInt(cursor.getColumnIndex("too"));
                int val=cursor.getInt(cursor.getColumnIndex("val"));

                for(int i=fromm;i<=too;i++){
                    week[i]=val;
                }

            }while(cursor.moveToNext());



        return week;
  }


  public void insert_demo(String username){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("username",username);
        values.put("TaskName","Singing");
        values.put("SR",9);
        values.put("fromm",900);
        values.put("from_ampm",0);
      values.put("too",1000);
      values.put("to_ampm",0);
      values.put("val",4);

      db.insert("fixed",null,values);


  }

  public StringBuilder demo_fetch(){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select username,TaskName,SR from fixed",new String[]{});
        if(cursor!=null){
            cursor.moveToFirst();
        }

        StringBuilder sb=new StringBuilder();
        do{
            String username=cursor.getString(cursor.getColumnIndex("username"));
            String TaskName=cursor.getString(cursor.getColumnIndex("TaskName"));
             int sr=cursor.getInt(cursor.getColumnIndex("SR"));

            sb.append("Username : "+username+"  Taskname: "+TaskName+"  S/r: "+sr+"\n");
        }while(cursor.moveToNext());

      return sb;



  }





  public int fixed_tasksexists(String username) {
      int max = -1, ival;
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor = db.rawQuery("select val from fixed where username=?", new String[]{username});
      if (cursor.getCount() > 0) {
          cursor.moveToFirst();
          do {

              ival = cursor.getInt(cursor.getColumnIndex("val"));
              if (ival > max) {
                  max = ival;
              }

          } while (cursor.moveToNext());


          return max;


      }else return -1;

  }




  public boolean fixed_insert(String username,int val,String taskname,int from,int to,int from_ampm,int to_ampm,int sr){
      SQLiteDatabase db=this.getWritableDatabase();

      ContentValues values=new ContentValues();
      values.put("username",username);
      values.put("TaskName",taskname);
      values.put("SR",sr);
      values.put("fromm",from);
      values.put("from_ampm",from_ampm);
      values.put("to",to);
      values.put("to_ampm",to_ampm);
      values.put("val",val);

      long ins=db.insert("fixed",null,values);

      if(ins==-1){
          return false;
      }
      else{
          return true;
      }
  }



  public void fixed_delete(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("fixed","username=?",new String[]{username});
  }


  public boolean check(String username){
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor = db.rawQuery("select * from fixed where username=?", new String[]{username});
      if (cursor.getCount() > 0) return true;
      else return false;

  }

  public boolean f(String username,String taskname,int sr,int from,int from_ampm,int to,int to_ampm,int val){
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put("username", username);
      contentValues.put("TaskName",taskname );
      contentValues.put("SR", sr);
      contentValues.put("fromm", from);
      contentValues.put("from_ampm",from_ampm );
      contentValues.put("too",to );
      contentValues.put("to_ampm", to_ampm);
      contentValues.put("val",val );


      long ins = db.insert("fixed", null, contentValues);

      if (ins == -1) return false;
      else return true;
  }







    public StringBuilder showFixed(String username){

        SQLiteDatabase db=this.getReadableDatabase();
        StringBuilder sb = new StringBuilder();
        Cursor cursor=db.rawQuery("select * from fixed where username=?",new String[]{username});
        if(cursor!=null) {
            cursor.moveToFirst();



            do {
                String un = cursor.getString(cursor.getColumnIndex("username"));
                String TaskName = cursor.getString(cursor.getColumnIndex("TaskName"));
                int sr = cursor.getInt(cursor.getColumnIndex("SR"));
                int from = cursor.getInt(cursor.getColumnIndex("fromm"));
                int to = cursor.getInt(cursor.getColumnIndex("too"));
                int from_ampm = cursor.getInt(cursor.getColumnIndex("from_ampm"));
                int to_ampm = cursor.getInt(cursor.getColumnIndex("to_ampm"));
                int val = cursor.getInt(cursor.getColumnIndex("val"));

                //backconversion
                String fa, ta;
                int from_hr, from_min, to_hr, to_min;

                if (from_ampm == 0) {
                    fa = "am";
                } else {
                    fa = "pm";
                }

                if (to_ampm == 0) {
                    ta = "am";

                } else {
                    ta = "pm";
                }

                int rf, rt;
                rf = from / 1440;
                from_hr = (from - rf * 1440) / 60;
                if (from_hr == 0) {
                    from_hr = 12;
                }
                if (from_hr > 12) {
                    from_hr = from_hr - 12;
                }

                rt = to / 1440;
                to_hr = (to - rt * 1440) / 60;
                if (to_hr == 0) {
                    to_hr = 12;
                }

                if (to_hr > 12) {
                    to_hr = to_hr - 12;
                }

                from_min = from % 60;

                to_min = to % 60;


                sb.append("TaskNo : " + val + "\nTaskName: " + TaskName + "\nStress/Relief : " + sr + "\nFrom: " + from_hr + ":" + from_min + " " + fa + "\nTo : " + to_hr + ":" + to_min + " " + ta + "\n\n\n");
            } while (cursor.moveToNext());
        }
        else{
            sb.append("null");
        }

        return sb;



    }

    public boolean fixedDel(String username,String taskname){
        SQLiteDatabase db=this.getWritableDatabase();
        int del=db.delete("fixed","username=? and taskname=?",new String[]{username,taskname});
        if(del==0){
            return false;
        }else{
            return true;
        }
    }







    //*************************Timetable queries ********************************************

    public Integer[] timetable_fixed_fetch(String username){

        SQLiteDatabase db=this.getReadableDatabase();
        Integer[] week=new Integer[10080];
        Cursor cursor=db.rawQuery("select fromm,too,val from fixed where username=?",new String[]{username});

        for(int i=0;i<=10079;i++){
            week[i]=999;
        }

        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            do {
                int fromm = cursor.getInt(cursor.getColumnIndex("fromm"));
                int too = cursor.getInt(cursor.getColumnIndex("too"));
                int val = cursor.getInt(cursor.getColumnIndex("val"));

                for (int i = fromm; i <= too; i++) {
                    week[i] = val;
                }

            } while (cursor.moveToNext());
        }


        return week;
    }




}
