package com.xjmz.glasses.ipc.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.honey.account.m9.a;
import com.xjmz.glasses.usb.hid.IGlassesHid;
import java.util.ArrayList;
import java.util.List;

public class GlassesManager implements ServiceConnection {
    public static final String f = "GlassesManager";
    public static final boolean g = Log.isLoggable("GlassesManager", 3);

    /* renamed from: a  reason: collision with root package name */
    public IGlassesHid f8203a;
    public Context b;
    public final int c;
    public final List d;
    public IBinder.DeathRecipient e;

    public static class GlassesManagerHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final GlassesManager f8204a = new GlassesManager();
    }

    public interface IGlassesServiceConnection {
        void a();

        void onServiceConnected();
    }

    public static class WorkHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final GlassesManager f8205a;

        public void handleMessage(Message message) {
            if (message.what == 1) {
                GlassesManager glassesManager = this.f8205a;
                glassesManager.d(glassesManager.b);
            }
        }
    }

    public final void d(Context context) {
        Intent f2 = f(context);
        if (f2 == null) {
            Log.e(f, "can not create intent");
        } else if (!e(context, f2)) {
            String str = f;
            Log.e(str, "bindService: Service " + f2 + " could not be found to bind!");
        }
    }

    public final boolean e(Context context, Intent intent) {
        if (context.bindService(intent, this, 73)) {
            return true;
        }
        Log.e(f, "Bind failed immediately");
        return false;
    }

    public final Intent f(Context context) {
        Intent intent = new Intent("com.xjmz.glasses.ipc.usb.hid.ACTION");
        if (h(context)) {
            intent.setPackage(context.getPackageName());
            return intent;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null) {
            return null;
        }
        intent.setPackage(resolveService.serviceInfo.packageName);
        String str = f;
        Log.d(str, "ext packageName:" + resolveService.serviceInfo.packageName + ", action:" + "com.xjmz.glasses.ipc.usb.hid.ACTION");
        return intent;
    }

    public final void g() {
    }

    public final boolean h(Context context) {
        ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent("com.xjmz.glasses.ipc.usb.hid.ACTION").setPackage(context.getPackageName()), 131072);
        String str = f;
        Log.d(str, "isServiceExist, packageName:" + context.getPackageName() + ", info:" + resolveService);
        return resolveService != null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d(f, "onServiceConnected");
        synchronized (this) {
            this.f8203a = IGlassesHid.Stub.asInterface(iBinder);
            try {
                iBinder.linkToDeath(this.e, 0);
            } catch (RemoteException e2) {
                String str = f;
                Log.e(str, "linkToDeath failed:" + e2);
            }
            if (g) {
                String str2 = f;
                Log.i(str2, "notify onServiceConnected :" + this.d.size());
            }
            for (IGlassesServiceConnection iGlassesServiceConnection : this.d) {
                if (iGlassesServiceConnection != null) {
                    iGlassesServiceConnection.onServiceConnected();
                }
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        String str = f;
        Log.d(str, "onServiceDisconnected!!!");
        synchronized (this) {
            try {
                this.f8203a = null;
                if (g) {
                    Log.i(str, "notify onServiceDisconnected :" + this.d.size());
                }
                for (IGlassesServiceConnection iGlassesServiceConnection : this.d) {
                    if (iGlassesServiceConnection != null) {
                        iGlassesServiceConnection.a();
                    }
                }
            } finally {
            }
        }
    }

    public GlassesManager() {
        this.c = 1000;
        this.d = new ArrayList();
        this.e = new a(this);
        if (g) {
            Log.d(f, " GlassesManager ctor");
        }
    }
}
