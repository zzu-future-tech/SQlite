package com.example.sqlite_test.datebasemethod;

import android.content.ContentValues;

/**
 * Create by xu on 2019/4/22
 */
public class clothesInformationPack {
    private ContentValues values;
    public clothesInformationPack(int dressid,String style,String color,String thickness,String photo,String attribute,String userid){
        values = new ContentValues();
        values.put("dressid",dressid);
        values.put("style",style);
        values.put("color",color);
        values.put("thickness",thickness);
        values.put("photo",photo);
        values.put("attribute",attribute);
        values.put("userid",userid);
    }
    public ContentValues getValues(){
        return  values;
    }
}
