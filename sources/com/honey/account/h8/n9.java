package com.honey.account.h8;

import android.os.Handler;
import android.os.Message;
import com.upuphone.xr.sapp.fragment.StandbyPositionFragment;

public final /* synthetic */ class n9 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StandbyPositionFragment f4700a;

    public /* synthetic */ n9(StandbyPositionFragment standbyPositionFragment) {
        this.f4700a = standbyPositionFragment;
    }

    public final boolean handleMessage(Message message) {
        return StandbyPositionFragment.l1(this.f4700a, message);
    }
}
