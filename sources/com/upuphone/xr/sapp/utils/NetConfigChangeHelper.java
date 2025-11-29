package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.common.AppApiVoidResult;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/utils/NetConfigChangeHelper;", "", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NetConfigChangeHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7897a = new Companion((DefaultConstructorMarker) null);
    public static final String b = "NetConfigChangeHelper";
    public static AndroidAppApi.FlutterAppApi c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002XD¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/utils/NetConfigChangeHelper$Companion;", "", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$FlutterAppApi;", "flutterApi", "", "a", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$FlutterAppApi;)V", "b", "", "TAG", "Ljava/lang/String;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$FlutterAppApi;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(AndroidAppApi.FlutterAppApi flutterAppApi) {
            Intrinsics.checkNotNullParameter(flutterAppApi, "flutterApi");
            NetConfigChangeHelper.c = flutterAppApi;
        }

        public final void b() {
            AndroidAppApi.FlutterAppApi a2 = NetConfigChangeHelper.c;
            if (a2 != null) {
                a2.f(new AppApiVoidResult());
            }
            ULog.f6446a.a(NetConfigChangeHelper.b, "notifyNetworkChange -> 通知flutter更新netConfig");
        }

        public Companion() {
        }
    }
}
