package com.xjmz.myvu.modules.home;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.UnicronBatteryInfo;
import com.xjmz.myvu.common.ConnectVoidResult;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "info", "Lcom/upuphone/xr/sapp/entity/UnicronBatteryInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$initViewModel$8 extends Lambda implements Function1<UnicronBatteryInfo, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$initViewModel$8(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UnicronBatteryInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(UnicronBatteryInfo unicronBatteryInfo) {
        Object obj;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HomeFragment", "notifyRingInfo = " + unicronBatteryInfo);
        HomeFragment homeFragment = this.this$0;
        try {
            Result.Companion companion = Result.Companion;
            AndroidConnectApi.Ring1Device a2 = new AndroidConnectApi.Ring1Device.Builder().c(unicronBatteryInfo.getDevName()).d(Boolean.valueOf(unicronBatteryInfo.isConnect())).b(Long.valueOf((long) unicronBatteryInfo.getCapacity())).a();
            Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
            homeFragment.u0().d(a2, new ConnectVoidResult());
            obj = Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        ULog.Delegate delegate2 = ULog.f6446a;
        String r5 = Result.m28toStringimpl(obj);
        delegate2.g("HomeFragment", "notifyRingInfo runCatching " + r5);
    }
}
