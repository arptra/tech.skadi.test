package com.ucar.vehiclesdk.common;

import android.app.PendingIntent;
import android.graphics.Bitmap;

public class UCarNotification {

    /* renamed from: a  reason: collision with root package name */
    public int f5419a;
    public boolean b;
    public String c;
    public String d;
    public PendingIntent e;
    public Bitmap f;
    public String g;
    public Bitmap h;
    public String i;
    public String j;
    public String k;
    public PendingIntent l;
    public PendingIntent m;
    public PendingIntent n;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f5420a;
        public boolean b;
        public String c;
        public String d;
        public PendingIntent e;
        public Bitmap f;
        public String g;
        public Bitmap h;
        public String i;
        public String j;
        public String k;
        public PendingIntent l;
        public PendingIntent m;
        public PendingIntent n;

        public Builder A(int i2) {
            this.f5420a = i2;
            return this;
        }

        public Builder B(boolean z) {
            this.b = z;
            return this;
        }

        public Builder C(String str) {
            this.g = str;
            return this;
        }

        public UCarNotification o() {
            return new UCarNotification(this);
        }

        public Builder p(PendingIntent pendingIntent) {
            this.l = pendingIntent;
            return this;
        }

        public Builder q(String str) {
            this.i = str;
            return this;
        }

        public Builder r(PendingIntent pendingIntent) {
            this.m = pendingIntent;
            return this;
        }

        public Builder s(String str) {
            this.j = str;
            return this;
        }

        public Builder t(PendingIntent pendingIntent) {
            this.n = pendingIntent;
            return this;
        }

        public Builder u(String str) {
            this.k = str;
            return this;
        }

        public Builder v(Bitmap bitmap) {
            this.h = bitmap;
            return this;
        }

        public Builder w(PendingIntent pendingIntent) {
            this.e = pendingIntent;
            return this;
        }

        public Builder x(String str) {
            this.d = str;
            return this;
        }

        public Builder y(String str) {
            this.c = str;
            return this;
        }

        public Builder z(Bitmap bitmap) {
            this.f = bitmap;
            return this;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UCarNotification{mId = ");
        sb.append(this.f5419a);
        sb.append(", mIsOngoing = ");
        sb.append(this.b);
        sb.append(", mContentTitle = '");
        sb.append(this.c);
        sb.append('\'');
        sb.append(", mContentText = '");
        sb.append(this.d);
        sb.append('\'');
        sb.append(", mContentIntent is null: ");
        boolean z = false;
        sb.append(this.e == null);
        sb.append(", mIcon is null: ");
        sb.append(this.f == null);
        sb.append(", mPackageName = '");
        sb.append(this.g);
        sb.append('\'');
        sb.append(", mContentBigIcon is null: ");
        sb.append(this.h == null);
        sb.append(", mActionFirstTitle = '");
        sb.append(this.i);
        sb.append('\'');
        sb.append(", mActionSecondTitle = '");
        sb.append(this.j);
        sb.append('\'');
        sb.append(", mActionThirdTitle = '");
        sb.append(this.k);
        sb.append('\'');
        sb.append(", mActionFirstPendingIntent is null: ");
        sb.append(this.l == null);
        sb.append(", mActionSecondPendingIntent is null: ");
        sb.append(this.m == null);
        sb.append(", mActionThirdPendingIntent is null: ");
        if (this.n == null) {
            z = true;
        }
        sb.append(z);
        sb.append('}');
        return sb.toString();
    }

    public UCarNotification(Builder builder) {
        this.f5419a = builder.f5420a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
    }
}
