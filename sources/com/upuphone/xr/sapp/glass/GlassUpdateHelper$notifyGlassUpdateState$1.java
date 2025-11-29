package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateHelper$notifyGlassUpdateState$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GlassUpdateState $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$notifyGlassUpdateState$1(GlassUpdateState glassUpdateState) {
        super(0);
        this.$value = glassUpdateState;
    }

    public final void invoke() {
        GlassUpdateHelper.G1(GlassUpdateHelper.b, GlobalExtKt.h(R.string.notify_download_paused), ((GlassUpdateState.DownloadFail) this.$value).getGlassUpdateInfo().getLatestVersion(), false, false, 12, (Object) null);
    }
}
