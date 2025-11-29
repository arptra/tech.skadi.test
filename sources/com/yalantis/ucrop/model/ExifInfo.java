package com.yalantis.ucrop.model;

public class ExifInfo {

    /* renamed from: a  reason: collision with root package name */
    public int f8745a;
    public int b;
    public int c;

    public ExifInfo(int i, int i2, int i3) {
        this.f8745a = i;
        this.b = i2;
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        if (this.f8745a == exifInfo.f8745a && this.b == exifInfo.b) {
            return this.c == exifInfo.c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f8745a * 31) + this.b) * 31) + this.c;
    }
}
