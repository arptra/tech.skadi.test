package com.upuphone.xr.sapp.monitor.net;

import com.upuphone.star.httplib.HttpInstance;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0006J\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006J\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0006J\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/net/HttpConfig;", "", "<init>", "()V", "", "c", "()Ljava/lang/String;", "i", "h", "b", "f", "g", "e", "a", "Lcom/upuphone/star/httplib/HttpInstance;", "Lkotlin/Lazy;", "d", "()Lcom/upuphone/star/httplib/HttpInstance;", "http", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class HttpConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final HttpConfig f7742a = new HttpConfig();
    public static final Lazy b = LazyKt.lazy(HttpConfig$http$2.INSTANCE);

    public final String a() {
        return NetConfig.f6666a.c();
    }

    public final String b() {
        return NetConfig.f6666a.d();
    }

    public final String c() {
        NetConfig.Companion companion;
        String str;
        if (SuperNotificationManager.f7749a.B()) {
            companion = NetConfig.f6666a;
            str = "sApisix";
        } else {
            companion = NetConfig.f6666a;
            str = "sApisixKm";
        }
        return companion.v(str);
    }

    public final HttpInstance d() {
        return (HttpInstance) b.getValue();
    }

    public final String e() {
        return NetConfig.f6666a.t();
    }

    public final String f() {
        return NetConfig.f6666a.f();
    }

    public final String g() {
        return NetConfig.f6666a.g();
    }

    public final String h() {
        NetConfig.Companion companion;
        String str;
        if (SuperNotificationManager.f7749a.B()) {
            companion = NetConfig.f6666a;
            str = "sWeather";
        } else {
            companion = NetConfig.f6666a;
            str = "sWeatherKm";
        }
        return companion.v(str);
    }

    public final String i() {
        NetConfig.Companion companion;
        String str;
        if (SuperNotificationManager.f7749a.B()) {
            companion = NetConfig.f6666a;
            str = "sXrWeather";
        } else {
            companion = NetConfig.f6666a;
            str = "sXrWeatherKm";
        }
        return companion.v(str);
    }
}
