package com.meizu.net.pedometerprovider.manager.bean;

import android.text.TextUtils;

public class UInfo {
    public static final int AGE = 25;
    public static final int DEFAULT_GENDER = 1;
    public static final float DEFAULT_HEIGHT = 165.0f;
    public static final int DEFAULT_TARGET = 5000;
    public static final float DEFAULT_WEIGHT = 60.0f;
    private int age;
    private int gender;
    private float height;
    private int target;
    private String token;
    private String userId;
    private float weight;

    public int getAge() {
        return this.age;
    }

    public int getGender() {
        return this.gender;
    }

    public float getHeight() {
        return this.height;
    }

    public int getTarget() {
        return this.target;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public float getWeight() {
        return this.weight;
    }

    public boolean isLogin() {
        return !TextUtils.isEmpty(getUserId());
    }

    public void setAge(int i) {
        this.age = i;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public void setTarget(int i) {
        this.target = i;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWeight(float f) {
        this.weight = f;
    }
}
