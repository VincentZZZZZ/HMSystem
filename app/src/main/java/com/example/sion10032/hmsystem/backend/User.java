package com.example.sion10032.hmsystem.backend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sion10032.hmsystem.DB.UserDBHelper;

import java.util.ArrayList;
import java.util.Observable;
import java.util.UUID;

/**
 * Created by sion10032
 * On 11/9/17.
 */



/*
 * User can manage DB
 * so class User need to implement this interface
 */
interface UserDBManage{
    void addMed(Medicine Med);
    boolean delMed(UUID uuid);
    ArrayList<Medicine> getAllMed();
    Medicine searchMed(String MedName);
}

/*
 * Model
 */
public class User implements UserDBManage {
    private UUID mUserID;
    private ArrayList<Medicine> mMeds;

    private SQLiteDatabase mUserDB;
    private UserDBHelper mUserDBHelper;

    public User(UUID uuid, Context context){
        mUserID = uuid;
        mUserDBHelper = new UserDBHelper(context, mUserID.toString());
        mUserDB = mUserDBHelper.getWritableDatabase();

        // TODO just for test, remember to delete in the future
        mUserDB.execSQL("DELETE FROM " + mUserDBHelper.MED_TABLE);

        mMeds = getAllMedHelper();
    }

    private ArrayList<Medicine> getAllMedHelper(){
        Cursor allData = mUserDB.rawQuery("SELECT * FROM " + UserDBHelper.MED_TABLE, null);
        ArrayList<Medicine> Meds = new ArrayList<>();
        while(allData.moveToNext()){
            Meds.add(new Medicine(
                    UUID.fromString(allData.getString(allData.getColumnIndex("UUID"))),
                    allData.getString(allData.getColumnIndex("MEDNAME")),
                    allData.getString(allData.getColumnIndex("DESCRIPTION")),
                    allData.getString(allData.getColumnIndex("IMGPATH")),
                    allData.getInt(allData.getColumnIndex("REMAINS")),
                    allData.getInt(allData.getColumnIndex("ISUSING")) == 1 )
            );
        }
        allData.close();
        return Meds;
    }

    private Medicine findMedHelper(UUID uuid){
        for (Medicine i : mMeds)
            if( i.getUUID() == uuid )
                return i;
        return null;
    }

    private Medicine findMedHelper(String MedName){
        for (Medicine i : mMeds)
            if( i.getName().equals(MedName) )
                return i;
        return null;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        mUserDB.close();
    }

    @Override
    public void addMed(Medicine Med) {
        mUserDB.beginTransaction();
        ContentValues med = new ContentValues();
        med.put("UUID", Med.getUUID().toString());
        med.put("MEDNAME", Med.getName());
        med.put("DESCRIPTION", Med.getDescription());
        med.put("IMGPATH", Med.getImgPath());
        med.put("REMAINS", Med.getRemains());
        med.put("ISUSING", Med.isUsing());
        mUserDB.insert(mUserDBHelper.MED_TABLE, null, med);
        mUserDB.setTransactionSuccessful();
        mUserDB.endTransaction();

        mMeds.add(Med);
    }

    @Override
    public boolean delMed(UUID uuid) {
        if( findMedHelper(uuid) == null )
            return false;
        mUserDB.beginTransaction();
        mUserDB.delete(mUserDBHelper.MED_TABLE, "UUID == ?", new String[] {uuid.toString()});
        mUserDB.setTransactionSuccessful();
        mUserDB.endTransaction();
        return true;
    }

    @Override
    public ArrayList<Medicine> getAllMed() {
        return mMeds;
    }

    @Override
    public Medicine searchMed(String MedName) {
        return findMedHelper(MedName);
    }
}
