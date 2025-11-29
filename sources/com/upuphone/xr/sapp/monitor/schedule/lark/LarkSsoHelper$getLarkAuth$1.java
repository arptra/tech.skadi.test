package com.upuphone.xr.sapp.monitor.schedule.lark;

import android.app.Activity;
import com.ss.android.larksso.CallBackData;
import com.ss.android.larksso.IGetDataCallback;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/monitor/schedule/lark/LarkSsoHelper$getLarkAuth$1", "Lcom/ss/android/larksso/IGetDataCallback;", "Lcom/ss/android/larksso/CallBackData;", "data", "", "a", "(Lcom/ss/android/larksso/CallBackData;)V", "b", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LarkSsoHelper$getLarkAuth$1 implements IGetDataCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LarkSsoHelper f7789a;
    public final /* synthetic */ Activity b;

    public LarkSsoHelper$getLarkAuth$1(LarkSsoHelper larkSsoHelper, Activity activity) {
        this.f7789a = larkSsoHelper;
        this.b = activity;
    }

    public void a(CallBackData callBackData) {
        String str;
        if (!(callBackData == null || (str = callBackData.f10001a) == null)) {
            LarkSsoHelper larkSsoHelper = this.f7789a;
            Activity activity = this.b;
            larkSsoHelper.g(str);
            larkSsoHelper.e(str, activity);
        }
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = null;
        String str3 = callBackData != null ? callBackData.f10001a : null;
        if (callBackData != null) {
            str2 = callBackData.b;
        }
        delegate.a("Schedule-LarkSsoHelper", "getLarkAuth onSuccess: code:" + str3 + "  codeVerifier:" + str2);
    }

    public void b(CallBackData callBackData) {
        ULog.Delegate delegate = ULog.f6446a;
        String str = null;
        String str2 = callBackData != null ? callBackData.f10001a : null;
        if (callBackData != null) {
            str = callBackData.b;
        }
        delegate.a("Schedule-LarkSsoHelper", "getLarkAuth onError:" + str2 + ",onError:" + str);
    }
}
