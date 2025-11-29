package com.android.internal.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.Stack;

public class AsyncChannel {
    public static String[] g;

    /* renamed from: a  reason: collision with root package name */
    public AsyncChannelConnection f2358a;
    public Context b;
    public Handler c;
    public Messenger d;
    public Messenger e;
    public DeathMonitor f;

    /* renamed from: com.android.internal.util.AsyncChannel$1ConnectAsync  reason: invalid class name */
    final class AnonymousClass1ConnectAsync implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Context f2359a;
        public Handler b;
        public String c;
        public String d;
        public final /* synthetic */ AsyncChannel e;

        public void run() {
            this.e.g(this.e.d(this.f2359a, this.b, this.c, this.d));
        }
    }

    public class AsyncChannelConnection implements ServiceConnection {
        public AsyncChannelConnection() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Messenger unused = AsyncChannel.this.e = new Messenger(iBinder);
            AsyncChannel.this.g(0);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            AsyncChannel.this.f(0);
        }
    }

    public final class DeathMonitor implements IBinder.DeathRecipient {
        public DeathMonitor() {
        }

        public void binderDied() {
            AsyncChannel.this.f(4);
        }
    }

    public static class SyncMessenger {

        /* renamed from: a  reason: collision with root package name */
        public static Stack f2362a = new Stack();
        public static int b = 0;

        public class SyncHandler extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public Object f2363a;
            public Message b;

            public void handleMessage(Message message) {
                Message obtain = Message.obtain();
                obtain.copyFrom(message);
                synchronized (this.f2363a) {
                    this.b = obtain;
                    this.f2363a.notify();
                }
            }
        }
    }

    static {
        String[] strArr = new String[5];
        g = strArr;
        strArr[0] = "CMD_CHANNEL_HALF_CONNECTED";
        strArr[1] = "CMD_CHANNEL_FULL_CONNECTION";
        strArr[2] = "CMD_CHANNEL_FULLY_CONNECTED";
        strArr[3] = "CMD_CHANNEL_DISCONNECT";
        strArr[4] = "CMD_CHANNEL_DISCONNECTED";
    }

    public int d(Context context, Handler handler, String str, String str2) {
        this.f2358a = new AsyncChannelConnection();
        this.b = context;
        this.c = handler;
        this.d = new Messenger(handler);
        this.e = null;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName(str, str2);
        return context.bindService(intent, this.f2358a, 1) ^ true ? 1 : 0;
    }

    public final boolean e() {
        if (this.f2358a != null || this.f != null) {
            return true;
        }
        this.f = new DeathMonitor();
        try {
            this.e.getBinder().linkToDeath(this.f, 0);
            return true;
        } catch (RemoteException unused) {
            this.f = null;
            return false;
        }
    }

    public final void f(int i) {
        Handler handler = this.c;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(69636);
            obtainMessage.arg1 = i;
            obtainMessage.obj = this;
            obtainMessage.replyTo = this.e;
            this.c.sendMessage(obtainMessage);
        }
    }

    public final void g(int i) {
        Message obtainMessage = this.c.obtainMessage(69632);
        obtainMessage.arg1 = i;
        obtainMessage.obj = this;
        obtainMessage.replyTo = this.e;
        if (!e()) {
            obtainMessage.arg1 = 1;
        }
        this.c.sendMessage(obtainMessage);
    }
}
