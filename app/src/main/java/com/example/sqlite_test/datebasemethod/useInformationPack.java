package com.example.sqlite_test.datebasemethod;

import android.content.ContentValues;

/**
 * Create by xu on 2019/4/22
 * 对从ui获得是数据进行封装 传出ContentValues 供数据库中userInformation表操作
 */
public class useInformationPack {
    private ContentValues values;
    public useInformationPack(int id,String userid,String password,String nickname,String sex,String phone ,String birthday){
        values =new ContentValues();
        values.put("id",id);
        values.put("userid",userid);
        values.put("password",password);
        values.put("nickname",nickname);
        values.put("sex",sex);
        values.put("phone",phone);
        values.put("birthday",birthday);
    }
    public ContentValues getValues(){
        return values;
    }
}
