package com.upuphone.xr.sapp.vu.ota;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.VuGlassesEventDispatcher;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/vu/ota/VuGlassUpdateHelper$installRom$2$1$listener$1", "Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnUpgradeStateChangeListener;", "", "curProgress", "totalProgress", "progressType", "status", "", "a", "(IIII)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassUpdateHelper$installRom$2$1$listener$1 implements VuGlassesEventDispatcher.OnUpgradeStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f8082a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Function1 c;

    public VuGlassUpdateHelper$installRom$2$1$listener$1(CancellableContinuation cancellableContinuation, int i, Function1 function1) {
        this.f8082a = cancellableContinuation;
        this.b = i;
        this.c = function1;
    }

    public void a(int i, int i2, int i3, int i4) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassUpdateHelper", "onUpgradeStateChanged: curProgress: " + i + ", totalProgress: " + i2 + ", progressType: " + i3 + ", status: " + i4);
        if (this.f8082a.isActive() && i3 == this.b) {
            if (i4 == 0) {
                this.c.invoke(Integer.valueOf((i * 100) / i2));
                if (i == i2) {
                    VuGlassesEventDispatcher.f8098a.q(this);
                    CancellableContinuation cancellableContinuation = this.f8082a;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
                    return;
                }
                return;
            }
            VuGlassesEventDispatcher.f8098a.q(this);
            CancellableContinuation cancellableContinuation2 = this.f8082a;
            Result.Companion companion2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
        }
    }
}
