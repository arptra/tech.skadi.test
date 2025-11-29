package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.datatrack.AppDataTrackEvent;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassManagerFragment$initView$19$showPrivacy$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GlassManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassManagerFragment$initView$19$showPrivacy$1(GlassManagerFragment glassManagerFragment) {
        super(0);
        this.this$0 = glassManagerFragment;
    }

    public final void invoke() {
        StaticMethodUtilsKt.t(this.this$0, R.id.voiceAssistantsFragment);
        SdkContext.f6675a.d().reportEvent(AppDataTrackEvent.APP_CLICK, MapsKt.hashMapOf(TuplesKt.to("status", "1")));
    }
}
