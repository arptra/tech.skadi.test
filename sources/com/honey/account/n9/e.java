package com.honey.account.n9;

import androidx.lifecycle.Observer;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.xjmz.myvu.MYVUActivity;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MYVUActivity f7465a;

    public /* synthetic */ e(MYVUActivity mYVUActivity) {
        this.f7465a = mYVUActivity;
    }

    public final void onChanged(Object obj) {
        MYVUActivity.Q0(this.f7465a, (NetDevice) obj);
    }
}
