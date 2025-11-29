package com.yalantis.ucrop.model;

import android.graphics.RectF;

public class ImageState {

    /* renamed from: a  reason: collision with root package name */
    public RectF f8746a;
    public RectF b;
    public float c;
    public float d;

    public ImageState(RectF rectF, RectF rectF2, float f, float f2) {
        this.f8746a = rectF;
        this.b = rectF2;
        this.c = f;
        this.d = f2;
    }

    public RectF a() {
        return this.f8746a;
    }

    public float b() {
        return this.d;
    }

    public RectF c() {
        return this.b;
    }

    public float d() {
        return this.c;
    }
}
