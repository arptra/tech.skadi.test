package com.honey.account.m5;

import com.upuphone.datatrack.sdk.XJHttpManager;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StringJoiner f4946a;
    public final /* synthetic */ Map b;

    public /* synthetic */ b(StringJoiner stringJoiner, Map map) {
        this.f4946a = stringJoiner;
        this.b = map;
    }

    public final void accept(Object obj) {
        XJHttpManager.i(this.f4946a, this.b, (String) obj);
    }
}
