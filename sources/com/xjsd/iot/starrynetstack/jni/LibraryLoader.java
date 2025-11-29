package com.xjsd.iot.starrynetstack.jni;

import android.util.Log;
import java.util.Arrays;

public class LibraryLoader {

    /* renamed from: a  reason: collision with root package name */
    public String[] f8705a;
    public boolean b;
    public boolean c;

    public LibraryLoader(String... strArr) {
        this.f8705a = strArr;
    }

    public synchronized boolean a() {
        if (this.b) {
            return this.c;
        }
        this.b = true;
        try {
            for (String str : this.f8705a) {
                System.loadLibrary(str);
                Log.d("LibraryLoader", "load success :" + str);
            }
            this.c = true;
        } catch (UnsatisfiedLinkError e) {
            Log.w("LibraryLoader", "Failed to load " + Arrays.toString(this.f8705a) + e);
        }
        return this.c;
    }
}
