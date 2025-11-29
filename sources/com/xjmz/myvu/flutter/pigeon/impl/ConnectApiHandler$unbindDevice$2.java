package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectApiHandler$unbindDevice$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ AndroidConnectApi.Result<Boolean> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectApiHandler$unbindDevice$2(AndroidConnectApi.Result<Boolean> result) {
        super(1);
        this.$result = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ULog.f6446a.a("ConnectApiHandler", "unbind view Device");
        this.$result.success(Boolean.valueOf(z));
    }
}
