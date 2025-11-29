package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/GlassSettingApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$GlassSettingApi;", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$Result;", "", "result", "", "c", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$Result;)V", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassSettingApiHandler implements AndroidAppApi.GlassSettingApi {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8348a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/GlassSettingApiHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void c(AndroidAppApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        boolean B = ControlUtils.f7858a.B();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassSettingApiHandler", "getWearDetectionModel " + B);
        result.success(Boolean.valueOf(B));
    }
}
