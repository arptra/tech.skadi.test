package com.yalantis.ucrop.model;

import android.graphics.Bitmap;
import android.net.Uri;

public class CropParameters {

    /* renamed from: a  reason: collision with root package name */
    public int f8744a;
    public int b;
    public Bitmap.CompressFormat c;
    public int d;
    public String e;
    public String f;
    public ExifInfo g;
    public Uri h;
    public Uri i;

    public CropParameters(int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str, String str2, ExifInfo exifInfo) {
        this.f8744a = i2;
        this.b = i3;
        this.c = compressFormat;
        this.d = i4;
        this.e = str;
        this.f = str2;
        this.g = exifInfo;
    }

    public Bitmap.CompressFormat a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public Uri c() {
        return this.h;
    }

    public Uri d() {
        return this.i;
    }

    public ExifInfo e() {
        return this.g;
    }

    public String f() {
        return this.e;
    }

    public String g() {
        return this.f;
    }

    public int h() {
        return this.f8744a;
    }

    public int i() {
        return this.b;
    }

    public void j(Uri uri) {
        this.h = uri;
    }

    public void k(Uri uri) {
        this.i = uri;
    }
}
