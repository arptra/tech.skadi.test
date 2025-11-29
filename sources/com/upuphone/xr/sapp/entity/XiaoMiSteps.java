package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;

@Keep
public class XiaoMiSteps {
    private int id;
    private long mBeginTime;
    private long mEndTime;
    private int mMode;
    private int mSteps;

    public XiaoMiSteps(int i, long j, long j2, int i2, int i3) {
        this.id = i;
        this.mBeginTime = j;
        this.mEndTime = j2;
        this.mMode = i2;
        this.mSteps = i3;
    }

    public int getId() {
        return this.id;
    }

    public long getmBeginTime() {
        return this.mBeginTime;
    }

    public long getmEndTime() {
        return this.mEndTime;
    }

    public int getmMode() {
        return this.mMode;
    }

    public int getmSteps() {
        return this.mSteps;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setmBeginTime(long j) {
        this.mBeginTime = j;
    }

    public void setmEndTime(long j) {
        this.mEndTime = j;
    }

    public void setmMode(int i) {
        this.mMode = i;
    }

    public void setmSteps(int i) {
        this.mSteps = i;
    }

    public String toString() {
        return "XiaoMiSteps{id=" + this.id + ", mBeginTime=" + this.mBeginTime + ", mEndTime=" + this.mEndTime + ", mMode=" + this.mMode + ", mSteps=" + this.mSteps + '}';
    }
}
