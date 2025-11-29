package com.upuphone.xr.sapp.vm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/vm/DeviceControlModel$initListener$5", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceControlModel$initListener$5 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlModel f7999a;

    public DeviceControlModel$initListener$5(DeviceControlModel deviceControlModel) {
        this.f7999a = deviceControlModel;
    }

    public void onReceive(Context context, Intent intent) {
        String action;
        if (intent != null && (action = intent.getAction()) != null) {
            DeviceControlModel deviceControlModel = this.f7999a;
            if (action.hashCode() == -1530327060 && action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("DeviceControlModel", "Received broadcasts ACTION_STATE_CHANGED data = " + intExtra);
                if (intExtra == 12) {
                    StarryNetHelper.f7917a.c(new DeviceControlModel$initListener$5$onReceive$1$1(deviceControlModel));
                }
            }
        }
    }
}
