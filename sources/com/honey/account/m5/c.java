package com.honey.account.m5;

import com.upuphone.datatrack.base.model.XJTrackData;
import com.upuphone.datatrack.sdk.XJHttpManager;
import java.util.function.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StringBuilder f4947a;

    public /* synthetic */ c(StringBuilder sb) {
        this.f4947a = sb;
    }

    public final void accept(Object obj) {
        XJHttpManager.j(this.f4947a, (XJTrackData) obj);
    }
}
