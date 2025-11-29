package com.upuphone.ar.navi.lite.map;

import android.graphics.PointF;
import android.graphics.Rect;

public abstract class Overlay {

    /* renamed from: a  reason: collision with root package name */
    public int f5778a;
    public float b;
    public float c;
    public float d;
    public float e;
    public int f;
    public int g;
    public PointF h;
    public boolean i;
    public boolean j;
    public Rect k;

    public String toString() {
        return "{" + "\"layer\":" + this.f5778a + ",\"deltaScale\":" + this.b + ",\"deltaAngle\":" + this.c + ",\"deltaX\":" + this.d + ",\"deltaY\":" + this.e + ",\"width\":" + this.f + ",\"height\":" + this.g + ",\"originPoint\":" + this.h + ",\"editAble\":" + this.i + ",\"isShow\":" + this.j + ",\"rect\":" + this.k + '}';
    }
}
