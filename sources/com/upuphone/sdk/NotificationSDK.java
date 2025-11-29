package com.upuphone.sdk;

import android.content.Context;

public class NotificationSDK {

    /* renamed from: a  reason: collision with root package name */
    public static volatile NotificationSDK f6440a;
    public static Context b;

    public NotificationSDK(Context context) {
        b = context;
    }

    public static NotificationSDK a(Context context) {
        if (f6440a == null) {
            synchronized (NotificationSDK.class) {
                try {
                    if (f6440a == null) {
                        f6440a = new NotificationSDK(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6440a;
    }

    public void b(Long l, String str, String str2, String str3, String str4, Boolean bool, ICallback iCallback) {
        ArSmartReminderModel arSmartReminderModel = new ArSmartReminderModel();
        arSmartReminderModel.c = str4;
        arSmartReminderModel.b = str3;
        arSmartReminderModel.d = l;
        arSmartReminderModel.f = str;
        arSmartReminderModel.f6439a = str2;
        arSmartReminderModel.g = Boolean.FALSE;
        iCallback.a(arSmartReminderModel, ResultType.ImportNotice);
    }
}
