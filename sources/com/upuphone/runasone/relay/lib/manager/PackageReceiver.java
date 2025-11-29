package com.upuphone.runasone.relay.lib.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import java.util.HashMap;

public class PackageReceiver extends BroadcastReceiver {
    private String TAG = ("connect:" + PackageReceiver.class.getSimpleName());

    public HashMap<String, MetaBean> getMetaBean(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return AppConfigManager.getInstance().getMetaDataByPackageInfo(context, packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onReceive(Context context, Intent intent) {
        String dataString = intent.getDataString();
        if (dataString != null && dataString.contains(AccountConstantKt.CODE_SEPARTOR)) {
            dataString = intent.getDataString().split(AccountConstantKt.CODE_SEPARTOR)[1];
        }
        if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
            Log.i("1------", dataString + "新安装");
            HashMap<String, MetaBean> metaBean = getMetaBean(context, dataString);
            if (metaBean != null) {
                AppConfigManager.getInstance().addAppUnitCode(metaBean, true);
            }
        } else if ("android.intent.action.PACKAGE_REPLACED".equals(intent.getAction())) {
            Log.i("1------", dataString + "替换了");
            HashMap<String, MetaBean> metaBean2 = getMetaBean(context, dataString);
            if (metaBean2 == null) {
                AppConfigManager.getInstance().removeAppUnitCodeByPkgName(dataString);
            } else {
                AppConfigManager.getInstance().addAppUnitCode(metaBean2, true);
            }
        } else if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
            Log.i("1------", dataString + "卸载了");
            AppConfigManager.getInstance().removeAppUnitCodeByPkgName(dataString);
        }
    }
}
