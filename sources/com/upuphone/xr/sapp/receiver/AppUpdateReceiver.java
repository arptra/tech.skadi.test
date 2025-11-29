package com.upuphone.xr.sapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/receiver/AppUpdateReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppUpdateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        ULog.f6446a.a("AppUpdateHelper", "onReceive");
        AppUpdateHelper.f7841a.L();
    }
}
