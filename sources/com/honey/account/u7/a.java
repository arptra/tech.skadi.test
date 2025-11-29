package com.honey.account.u7;

import com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager;
import com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.entity.DataBinderValue;

public final /* synthetic */ class a implements DataBinderItemUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDataBinderItemUpdateListener f5228a;

    public /* synthetic */ a(IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        this.f5228a = iDataBinderItemUpdateListener;
    }

    public final void onUpdate(DataBinderValue dataBinderValue) {
        DataBinderItemSubscribeManager.subscribeInner$lambda$2(this.f5228a, dataBinderValue);
    }
}
