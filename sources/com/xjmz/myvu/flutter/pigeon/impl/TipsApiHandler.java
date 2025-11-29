package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.xr.sapp.tips.TipsManager;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/TipsApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$TipsApi;", "<init>", "()V", "", "tipsKey", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$VoidResult;", "result", "", "a", "(Ljava/lang/String;Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$VoidResult;)V", "d", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TipsApiHandler implements AndroidAppApi.TipsApi {
    public void a(String str, AndroidAppApi.VoidResult voidResult) {
        Intrinsics.checkNotNullParameter(str, "tipsKey");
        Intrinsics.checkNotNullParameter(voidResult, "result");
        TipsManager.f7827a.f(str);
        voidResult.success();
    }

    public void d(String str, AndroidAppApi.VoidResult voidResult) {
        Intrinsics.checkNotNullParameter(str, "tipsKey");
        Intrinsics.checkNotNullParameter(voidResult, "result");
        TipsManager.f7827a.e(str);
        voidResult.success();
    }
}
