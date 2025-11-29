package com.upuphone.xr.interconnect.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.upuphone.xr.interconnect.util.log.ILog;

public class AppArchiveReceiver extends BroadcastReceiver {
    private static final String TAG = "PackageInstalledReceiver";
    private AppArchiveListener mAppArchiveListener;
    private Context mContext;

    public AppArchiveReceiver(Context context) {
        this.mContext = context;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        ILog.d(TAG, "收到APK动态改变广播--" + action);
        if (action.equals("android.intent.action.PACKAGE_ADDED")) {
            ILog.d(TAG, "安装成功--" + schemeSpecificPart);
            boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
            AppArchiveListener appArchiveListener = this.mAppArchiveListener;
            if (appArchiveListener != null) {
                appArchiveListener.onAppInstalled(schemeSpecificPart, booleanExtra);
            }
        } else if (action.equals("android.intent.action.PACKAGE_REPLACED")) {
            ILog.d(TAG, "替换成功--" + schemeSpecificPart);
            AppArchiveListener appArchiveListener2 = this.mAppArchiveListener;
            if (appArchiveListener2 != null) {
                appArchiveListener2.onAppReplaced(schemeSpecificPart);
            }
        } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
            ILog.d(TAG, "卸载成功--" + schemeSpecificPart);
            intent.getBooleanExtra("android.intent.extra.DATA_REMOVED", false);
            boolean booleanExtra2 = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
            intent.getBooleanExtra("android.intent.extra.USER_INITIATED", false);
            AppArchiveListener appArchiveListener3 = this.mAppArchiveListener;
            if (appArchiveListener3 != null) {
                appArchiveListener3.onAppUninstalled(schemeSpecificPart, booleanExtra2);
            }
        }
    }

    public void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        if (Build.VERSION.SDK_INT >= 33) {
            this.mContext.registerReceiver(this, intentFilter, 4);
        } else {
            this.mContext.registerReceiver(this, intentFilter);
        }
    }

    public void setAppArchiveListener(AppArchiveListener appArchiveListener) {
        this.mAppArchiveListener = appArchiveListener;
    }
}
