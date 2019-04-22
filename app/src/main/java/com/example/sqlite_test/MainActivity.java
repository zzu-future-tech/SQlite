package com.example.sqlite_test;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sqlite_test.R;
import java.util.Date;
import com.example.sqlite_test.datebasemethod.*;
import com.example.sqlite_test.datebasemethod.dateBase;
/*
 * 删除被注释的代码后阅读更佳，为日后扩充和测试方法 作者并未删除被注释的代码
 */
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.create)
    Button create;
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.textView1)
    TextView text1;
    @BindView(R.id.textView2)
    TextView text2;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.dalete)
    Button delete;
    @BindView(R.id.querty1)
    Button querty1;
    @BindView(R.id.querty2)
    Button querty2;
    @BindView(R.id.quertyall)
    Button quertyall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dateBase db = new dateBase("test", MainActivity.this);
                    db.close();
                }catch(Exception e){
                    System.out.println("Get a Exception:" +e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dateBase db = new dateBase("test", MainActivity.this);

                  /*  ContentValues values=new ContentValues();
                    values.put("dressid",1);
                    values.put("style","夹克");
                    values.put("color","红色");
                    values.put("thickness","厚");
                    values.put("photo","image");
                    values.put("attribute","婚礼");
                    values.put("userid","123");*/
                    clothesInformationPack ci= new clothesInformationPack(1,"夹克","red","厚","123456","婚礼","1");
                    ContentValues values=ci.getValues();
                    clothesInformationPack cii= new clothesInformationPack(2,"西装","red","厚","123456","职场","1");
                    ContentValues valuess=cii.getValues();
                    db.insertCloth(values);
                   db.insertCloth(valuess);
                    db.close();
                }catch (Exception e){
                    System.out.println("Get a Exception:" +e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dateBase db = new dateBase("test", MainActivity.this);
                 /*   ContentValues values=new ContentValues();
                    values.put("dressid",1);
                    values.put("style","夹克");
                    values.put("color","红色");
                    values.put("thickness","厚");
                    values.put("photo","image");
                    values.put("attribute","宴会");
                    values.put("userid","123");*/
                    clothesInformationPack ci= new clothesInformationPack(1,"夹克","red","厚","123456","宴会","1");
                    ContentValues values=ci.getValues();
                    db.update(values);
                    db.close();
                }catch (Exception e){
                    System.out.println("Get a Exception:" +e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dateBase db = new dateBase("test", MainActivity.this);
                    db.deleteClothesByDressid(1);
                    db.close();
                }catch(Exception e)
                {
                    System.out.println("Get a Exception:" +e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        querty1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dateBase db = new dateBase("test", MainActivity.this);
                    Cursor cursor = db.queryByDressid(1);
                    while (cursor.moveToNext()) {
                        String dressid = cursor.getString(cursor.getColumnIndex("dressid"));
                        String style = cursor.getString(cursor.getColumnIndex("style"));
                        String color = cursor.getString(cursor.getColumnIndex("color"));
                        String thickness= cursor.getString(cursor.getColumnIndex("thickness"));
                        String photo=cursor.getString(cursor.getColumnIndex("photo"));
                        String attribute=cursor.getString(cursor.getColumnIndex("attribute"));
                        String userid=cursor.getString(cursor.getColumnIndex("userid"));
                        String gmt=cursor.getString(cursor.getColumnIndex("gmt_create"));
                        text1.setText(dressid+style+color+thickness+attribute+gmt);
                    }
                    db.close();
                }catch(Exception e){
                    System.out.println("Get a Exception:" +e.getMessage());
                    e.printStackTrace();
                }
                //text2.setText(id1+name+riqi);
            }
        });
        querty2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dateBase db = new dateBase("test", MainActivity.this);
                    Cursor cursor = db.queryByDressid(2);
                    while (cursor.moveToNext()) {
                        String dressid = cursor.getString(cursor.getColumnIndex("dressid"));
                        String style = cursor.getString(cursor.getColumnIndex("style"));
                        String color = cursor.getString(cursor.getColumnIndex("color"));
                        String thickness= cursor.getString(cursor.getColumnIndex("thickness"));
                        String photo=cursor.getString(cursor.getColumnIndex("photo"));
                        String attribute=cursor.getString(cursor.getColumnIndex("attribute"));
                        String userid=cursor.getString(cursor.getColumnIndex("userid"));
                        String gmt=cursor.getString(cursor.getColumnIndex("gmt_create"));
                        text1.setText(dressid+style+color+thickness+attribute+gmt);
                    }
                    db.close();
                }catch(Exception e){
                    System.out.println("Get a Exception:" +e.getMessage());
                    e.printStackTrace();
                }
                //text2.setText(id1+name+riqi);
            }
        });
        quertyall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dateBase dp = new dateBase("test", MainActivity.this);
                    Cursor cursor = dp.db.rawQuery("select * from clothesInformation where userid=?", new String[]{"1"});
                    int i = 1;
                    while (cursor.moveToNext()) {
                       /* try {
                            Thread2 t2 = new Thread2("y2");
                            t2.start();
                            t2.sleep(5000);
                            //  t2.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                        String dressid = cursor.getString(cursor.getColumnIndex("dressid"));
                        String style = cursor.getString(cursor.getColumnIndex("style"));
                        String color = cursor.getString(cursor.getColumnIndex("color"));
                        String thickness = cursor.getString(cursor.getColumnIndex("thickness"));
                        String photo = cursor.getString(cursor.getColumnIndex("photo"));
                        String attribute = cursor.getString(cursor.getColumnIndex("attribute"));
                        String userid = cursor.getString(cursor.getColumnIndex("userid"));
                        String gmt = cursor.getString(cursor.getColumnIndex("gmt_create"));
                        //text1.setText(dressid+style+color+thickness+attribute+gmt);
                        if(i==1){
                            text1.setText(dressid+style+color+thickness+attribute+gmt);
                            i++;}
                        if(i==2){
                            text2.setText(dressid+style+color+thickness+attribute+gmt);
                        }
                        //  Thread.sleep(1000);
                        // new Thread(new Thread1("Thead1")).start();
                    }
                    dp.close();
                }catch(Exception e){
                    System.out.println("Get a Exception:" +e.getMessage());
                    e.printStackTrace();
                }
                //text2.setText(id1+name+riqi);
            }
        });
    }
}
class Thread1 implements Runnable{
    private String name;
    public Thread1(String name){
        this.name=name;
    }
    @Override
    public void run(){
        System.out.print(name+"开始运行");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Thread2 extends Thread {

    public Thread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.print(this.getName() + "开始运行");
        long a=1;
        for(int i=1;i<=5000;i++)
        {
            a++;
        }
        /*try {
            sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }*/
    }
}
