package com.example.sion10032.hmsystem.backend;

import java.io.Serializable;

/**
 * Created by sion10032
 * On 11/9/17.
 */

public class Medicine implements Serializable {

    private String mName;
    private String mDescription;
    private String mImgPath;
    private int mRemain;
    private boolean isUsing;

    Medicine(String name, String description, String imgPath, int remain, boolean isUsing){
        this.mName = name;
        this.mDescription = description;
        this.mImgPath = imgPath;
        this.mRemain = remain;
        this.isUsing = isUsing;
    }




    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getImgPath() {
        return mImgPath;
    }

    public void setImgPath(String mImgPath) {
        this.mImgPath = mImgPath;
    }

    public int getRemain() {
        return mRemain;
    }

    public void setRemain(int mRemain) {
        this.mRemain = mRemain;
    }

    public boolean isUsing() {
        return isUsing;
    }

    public void setUsing(boolean using) {
        isUsing = using;
    }





}
