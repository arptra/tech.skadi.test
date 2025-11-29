package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentGlassManagerBinding;
import com.upuphone.xr.sapp.entity.GlassWifiData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nGlassManagerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassManagerFragment.kt\ncom/upuphone/xr/sapp/fragment/GlassManagerFragment$addObserve$10\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,770:1\n1#2:771\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/GlassWifiData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassManagerFragment$addObserve$10 extends Lambda implements Function1<GlassWifiData, Unit> {
    final /* synthetic */ Ref.BooleanRef $isFirst;
    final /* synthetic */ GlassManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassManagerFragment$addObserve$10(Ref.BooleanRef booleanRef, GlassManagerFragment glassManagerFragment) {
        super(1);
        this.$isFirst = booleanRef;
        this.this$0 = glassManagerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassWifiData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GlassWifiData glassWifiData) {
        String str;
        ULog.Delegate delegate = ULog.f6446a;
        boolean wifiState = glassWifiData.getWifiState();
        boolean z = this.$isFirst.element;
        String ssid = glassWifiData.getSsid();
        delegate.a("GlassManagerFragment", "glassWifiInfo::state is:" + wifiState + ", isFirst:" + z + ", ssid:" + ssid);
        Ref.BooleanRef booleanRef = this.$isFirst;
        if (booleanRef.element) {
            booleanRef.element = false;
            return;
        }
        Intrinsics.checkNotNullExpressionValue(this.this$0.getString(R.string.word_close), "getString(...)");
        if (glassWifiData.getWifiState()) {
            String ssid2 = glassWifiData.getSsid();
            GlassManagerFragment glassManagerFragment = this.this$0;
            if (ssid2.length() == 0) {
                ssid2 = glassManagerFragment.getString(R.string.word_open);
                Intrinsics.checkNotNullExpressionValue(ssid2, "getString(...)");
            }
            str = StringsKt.replace$default(ssid2, "\"", "", false, 4, (Object) null);
            if (str == null) {
                str = this.this$0.getString(R.string.unknow_network);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            }
        } else {
            str = this.this$0.getString(R.string.word_close);
            Intrinsics.checkNotNull(str);
        }
        FragmentGlassManagerBinding W0 = this.this$0.j;
        if (W0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            W0 = null;
        }
        W0.l.setRightContent(str);
    }
}
