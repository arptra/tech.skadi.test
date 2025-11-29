package com.xjmz.myvu.modules.home;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.audio.GlassVolInfo;
import com.xjmz.myvu.common.AirGlassControlResult;
import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import com.xjmz.myvu.flutter.pigeon.GlassVolumeInfoExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/audio/GlassVolInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$initViewModel$11 extends Lambda implements Function1<GlassVolInfo, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$initViewModel$11(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassVolInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GlassVolInfo glassVolInfo) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HomeFragment", "glassVolInfo: " + glassVolInfo);
        AndroidAirGlassControlApi.FlutterAirGlassControlApi C0 = this.this$0.X0();
        Intrinsics.checkNotNull(glassVolInfo);
        C0.j(GlassVolumeInfoExtKt.b(glassVolInfo), new AirGlassControlResult());
    }
}
