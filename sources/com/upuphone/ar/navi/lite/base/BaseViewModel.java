package com.upuphone.ar.navi.lite.base;

import androidx.databinding.BaseObservable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BaseViewModel extends BaseObservable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5653a = false;
    public String b;
    public int c = 0;
    public boolean d = true;
    public int e = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface NaviMode {
    }

    public BaseViewModel(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public void c(boolean z) {
        this.d = z;
    }
}
