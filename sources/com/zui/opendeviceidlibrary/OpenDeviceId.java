package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.zui.deviceidservice.IDeviceidInterface;

public class OpenDeviceId {
    private static boolean DBG = false;
    private static String TAG = "OpenDeviceId library";
    /* access modifiers changed from: private */
    public CallBack mCallerCallBack = null;
    private ServiceConnection mConnection;
    private Context mContext = null;
    /* access modifiers changed from: private */
    public IDeviceidInterface mDeviceidInterface;

    public interface CallBack<T> {
        void serviceConnected(T t, OpenDeviceId openDeviceId);
    }

    private void logPrintE(String str) {
    }

    /* access modifiers changed from: private */
    public void logPrintI(String str) {
    }

    public String getAAID() {
        Context context = this.mContext;
        if (context != null) {
            String packageName = context.getPackageName();
            logPrintI("liufeng, getAAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                logPrintI("input package is null!");
                return null;
            }
            try {
                IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
                if (iDeviceidInterface == null) {
                    return null;
                }
                String aaid = iDeviceidInterface.getAAID(packageName);
                return ((aaid == null || "".equals(aaid)) && this.mDeviceidInterface.createAAIDForPackageName(packageName)) ? this.mDeviceidInterface.getAAID(packageName) : aaid;
            } catch (RemoteException unused) {
                logPrintE("getAAID error, RemoteException!");
                return null;
            }
        } else {
            logPrintI("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public String getOAID() {
        if (this.mContext != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.getOAID();
                }
                return null;
            } catch (RemoteException e) {
                logPrintE("getOAID error, RemoteException!");
                e.printStackTrace();
                return null;
            }
        } else {
            logPrintE("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public String getUDID() {
        String str;
        if (this.mContext != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.getUDID();
                }
                return null;
            } catch (RemoteException e) {
                e = e;
                str = "getUDID error, RemoteException!";
                logPrintE(str);
                e.printStackTrace();
                return null;
            } catch (Exception e2) {
                e = e2;
                str = "getUDID error, Exception!";
                logPrintE(str);
                e.printStackTrace();
                return null;
            }
        } else {
            logPrintE("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public String getVAID() {
        Context context = this.mContext;
        if (context != null) {
            String packageName = context.getPackageName();
            logPrintI("liufeng, getVAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                logPrintI("input package is null!");
                return null;
            }
            try {
                IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.getVAID(packageName);
                }
                return null;
            } catch (RemoteException e) {
                logPrintE("getVAID error, RemoteException!");
                e.printStackTrace();
                return null;
            }
        } else {
            logPrintI("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public int init(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.mContext = context;
            this.mCallerCallBack = callBack;
            this.mConnection = new ServiceConnection() {
                public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        IDeviceidInterface unused = OpenDeviceId.this.mDeviceidInterface = IDeviceidInterface.Stub.asInterface(iBinder);
                        if (OpenDeviceId.this.mCallerCallBack != null) {
                            OpenDeviceId.this.mCallerCallBack.serviceConnected("Deviceid Service Connected", OpenDeviceId.this);
                        }
                        OpenDeviceId.this.logPrintI("Service onServiceConnected");
                    } catch (Throwable th) {
                        throw th;
                    }
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    IDeviceidInterface unused = OpenDeviceId.this.mDeviceidInterface = null;
                    OpenDeviceId.this.logPrintI("Service onServiceDisconnected");
                }
            };
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.mContext.bindService(intent, this.mConnection, 1)) {
                logPrintI("bindService Successful!");
                return 1;
            }
            logPrintI("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface == null) {
                return false;
            }
            logPrintI("Device support opendeviceid");
            return this.mDeviceidInterface.isSupport();
        } catch (RemoteException unused) {
            logPrintE("isSupport error, RemoteException!");
            return false;
        }
    }

    public void setLogEnable(boolean z) {
        DBG = z;
    }

    public void shutdown() {
        try {
            this.mContext.unbindService(this.mConnection);
            logPrintI("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            logPrintE("unBind Service exception");
        }
        this.mDeviceidInterface = null;
    }
}
