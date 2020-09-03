package com.thanhduc91tpk.studentmanager3.model;

public class ClassObject {
    private String mId;
    private String mName;

    public ClassObject(String mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    public ClassObject() {
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return mId+" - "+mName;
    }
}
