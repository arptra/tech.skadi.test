package com.honey.account.na;

import com.xjsd.ai.assistant.phone.vui.WeatherVuiHandler;
import java.util.function.Predicate;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeatherVuiHandler f7471a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public /* synthetic */ d(WeatherVuiHandler weatherVuiHandler, long j, long j2) {
        this.f7471a = weatherVuiHandler;
        this.b = j;
        this.c = j2;
    }

    public final boolean test(Object obj) {
        return WeatherVuiHandler.e(this.f7471a, this.b, this.c, obj);
    }
}
