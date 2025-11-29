package com.xjmz.glasses.ipc.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class GlassesHidService extends Service {
    public static final String b = "GlassesHidService";

    /* renamed from: a  reason: collision with root package name */
    public GlassedHidBinder f8208a;

    public IBinder onBind(Intent intent) {
        String str = b;
        Log.d(str, "onBind " + this);
        return this.f8208a;
    }

    public void onCreate() {
        super.onCreate();
        String str = b;
        Log.d(str, "onCreate " + getString(R.string.svhid_lib_version) + " " + this);
        this.f8208a = new GlassedHidBinder(getApplicationContext());
    }

    public void onDestroy() {
        String str = b;
        Log.d(str, "onDestroy " + this);
        super.onDestroy();
        this.f8208a.destroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        Log.d(b, "onLowMemory");
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        String str = b;
        Log.d(str, "onTrimMemory " + i);
    }

    public boolean onUnbind(Intent intent) {
        Log.d(b, "onUnbind");
        return super.onUnbind(intent);
    }
}
