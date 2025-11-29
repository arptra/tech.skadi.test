package com.honey.account.t8;

import android.os.Handler;
import android.os.Message;
import com.upuphone.xr.sapp.superconnect.ui.SplashActivity;

public final /* synthetic */ class a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f7616a;

    public /* synthetic */ a(SplashActivity splashActivity) {
        this.f7616a = splashActivity;
    }

    public final boolean handleMessage(Message message) {
        return SplashActivity.A0(this.f7616a, message);
    }
}
