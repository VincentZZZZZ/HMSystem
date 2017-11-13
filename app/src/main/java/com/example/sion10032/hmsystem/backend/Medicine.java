package com.example.sion10032.hmsystem.backend;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by sion10032
 * On 11/9/17.
 */

public class Medicine implements Serializable {
    private UUID mUUID;
    private String mName;
    private String mDescription;
    private String mImgPath;
    private int mRemains;
    private boolean isUsing;

    public Medicine(UUID uuid, String name, String description, String imgPath, int remains, boolean isUsing){
        this.mUUID = uuid;
        this.mName = name;
        this.mDescription = description;
        this.mImgPath = imgPath;
        this.mRemains = remains;
        this.isUsing = isUsing;
    }


    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID mUUID) {
        this.mUUID = mUUID;
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

    public int getRemains() {
        return mRemains;
    }

    public void setRemains(int mRemains) {
        this.mRemains = mRemains;
    }

    public boolean isUsing() {
        return isUsing;
    }

    public void setUsing(boolean using) {
        isUsing = using;
    }





}
