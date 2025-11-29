package com.upuphone.xr.sapp.tips;

import com.upuphone.runasone.relay.api.IntentKey;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/tips/TipsModel;", "", "Lcom/upuphone/xr/sapp/tips/TipsKey;", "key", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$HomeTips;", "homeTips", "Lkotlin/Function0;", "", "btnClick", "<init>", "(Lcom/upuphone/xr/sapp/tips/TipsKey;Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$HomeTips;Lkotlin/jvm/functions/Function0;)V", "a", "Lcom/upuphone/xr/sapp/tips/TipsKey;", "b", "()Lcom/upuphone/xr/sapp/tips/TipsKey;", "setKey", "(Lcom/upuphone/xr/sapp/tips/TipsKey;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$HomeTips;", "getHomeTips", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$HomeTips;", "setHomeTips", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$HomeTips;)V", "c", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "setBtnClick", "(Lkotlin/jvm/functions/Function0;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TipsModel {

    /* renamed from: a  reason: collision with root package name */
    public TipsKey f7828a;
    public AndroidAppApi.HomeTips b;
    public Function0 c;

    public TipsModel(TipsKey tipsKey, AndroidAppApi.HomeTips homeTips, Function0 function0) {
        Intrinsics.checkNotNullParameter(tipsKey, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(homeTips, "homeTips");
        this.f7828a = tipsKey;
        this.b = homeTips;
        this.c = function0;
    }

    public final Function0 a() {
        return this.c;
    }

    public final TipsKey b() {
        return this.f7828a;
    }
}
