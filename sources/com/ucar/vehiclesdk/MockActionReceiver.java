package com.ucar.vehiclesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.easy.logger.EasyLog;

public class MockActionReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5357a = "MockActionReceiver";

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && "ucar.intent.action.NOTIFICATION_MOCK_ACTION".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("mockPendingIntentId", -1);
            if (intExtra == -1) {
                EasyLog.i(f5357a, "mock action invalid!");
                return;
            }
            int i = intExtra >> 16;
            int i2 = intExtra & 65535;
            String stringExtra = intent.getStringExtra("notificationPackageName");
            String str = f5357a;
            EasyLog.a(str, "mock action onReceive notificationId: " + i + ", mockPendingIntentId: " + i2 + ", packageName: " + stringExtra);
            UCarAdapter.R0().M1(i, i2);
        }
    }
}
