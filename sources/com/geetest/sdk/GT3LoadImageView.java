package com.geetest.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class GT3LoadImageView extends View implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public int f2899a;
    public int b = -2;
    public int c = -2;

    public GT3LoadImageView(Context context) {
        super(context);
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public int getIconRes() {
        return this.f2899a;
    }

    public int getLoadViewHeight() {
        return this.c;
    }

    public int getLoadViewWidth() {
        return this.b;
    }

    public void setIconRes(int i) {
        this.f2899a = i;
    }

    public void setLoadViewHeight(int i) {
        this.c = i;
    }

    public void setLoadViewWidth(int i) {
        this.b = i;
    }

    public GT3LoadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GT3LoadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
