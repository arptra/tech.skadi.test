package com.android.internal.util;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import io.netty.handler.codec.http2.Http2CodecUtil;

public abstract class AsyncService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public Messenger f2364a;
    public Handler b;
    public AsyncServiceInfo c;

    public static final class AsyncServiceInfo {

        /* renamed from: a  reason: collision with root package name */
        public Handler f2365a;
        public int b;
    }

    public abstract AsyncServiceInfo a();

    public IBinder onBind(Intent intent) {
        return this.f2364a.getBinder();
    }

    public void onCreate() {
        super.onCreate();
        AsyncServiceInfo a2 = a();
        this.c = a2;
        this.b = a2.f2365a;
        this.f2364a = new Messenger(this.b);
    }

    public void onDestroy() {
        Log.d("AsyncService", "onDestroy");
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.what = 16777216;
        this.b.sendMessage(obtainMessage);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d("AsyncService", "onStartCommand");
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.what = Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND;
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        obtainMessage.obj = intent;
        this.b.sendMessage(obtainMessage);
        return this.c.b;
    }
}
