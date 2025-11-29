package com.upuphone.starrynetsdk;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.api.ApiConstant;
import com.upuphone.starrynetsdk.api.Camp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class StarryNet {
    public static final int CODE_PERMISSION_DENIED = -300100;
    public static final String PACKAGE_STARRYNET = "com.upuphone.starrynetsdk";
    public static final String SERVICE_RUNASONE = "com.upuphone.starrynetsdk.RunAsOneService";
    private final BroadcastReceiver installReceiver;
    private final List<InstallListener> listeners;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final StarryNet INSTANCE = new StarryNet();

        private Holder() {
        }
    }

    public static StarryNet getInstance() {
        return Holder.INSTANCE;
    }

    private long getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.upuphone.starrynet", 0).getLongVersionCode();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.upuphone.starrynet", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void installInternal(Context context) {
        SLog.d("init local service.");
        Runasone.getInstance().init(context);
    }

    /* access modifiers changed from: private */
    public void installLocalService(Context context) {
        SLog.d("install local service");
        Intent intent = new Intent();
        intent.setClass(context, RunAsOneService.class);
        context.bindService(intent, new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    StarryNet.this.onServiceInstalled((RunasoneHub) iBinder);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    StarryNet.this.onServiceInstalled(Hub.Stub.asInterface(iBinder));
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                StarryNet.this.onServiceUninstalled();
            }
        }, 1);
    }

    private boolean isPermissionAllGranted(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 31) {
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
            arrayList.add("android.permission.BLUETOOTH_SCAN");
        } else {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        for (String checkPermission : arrayList) {
            if (packageManager.checkPermission(checkPermission, packageName) != 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onServiceInstalled(Hub hub) {
        SLog.d("starrynet service installed.");
        Camp.getInstance().report(hub);
        for (InstallListener onInstalled : this.listeners) {
            onInstalled.onInstalled();
        }
    }

    /* access modifiers changed from: private */
    public void onServiceUninstalled() {
        SLog.d("starrynet service uninstalled.");
        Camp.getInstance().report((Hub) null);
        for (InstallListener onUninstalled : this.listeners) {
            onUninstalled.onUninstalled();
        }
    }

    private void registerReadyReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ApiConstant.ACTION);
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this.installReceiver, intentFilter, 2);
        } else {
            context.registerReceiver(this.installReceiver, intentFilter);
        }
    }

    public int install(Context context) {
        SLog.d("install starrynet service.");
        if (!isPermissionAllGranted(context)) {
            return CODE_PERMISSION_DENIED;
        }
        installInternal(context);
        return 0;
    }

    public boolean isInstalled() {
        return Camp.getInstance().isInstalled();
    }

    public void registerInstallListener(InstallListener installListener) {
        if (Camp.getInstance().isInstalled()) {
            installListener.onInstalled();
        }
        this.listeners.add(installListener);
    }

    public void runasoneInitDone(Context context) {
        SLog.d("runasoneInitDone: install starrynet service.");
        installLocalService(context);
    }

    public void unRegisterInstallListener(InstallListener installListener) {
        this.listeners.remove(installListener);
    }

    public long versionCode() {
        return -1;
    }

    public String versionName() {
        return "";
    }

    private StarryNet() {
        this.listeners = new CopyOnWriteArrayList();
        this.installReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                SLog.d("reinstall starrynet service.");
                StarryNet.this.installLocalService(context);
            }
        };
    }
}
