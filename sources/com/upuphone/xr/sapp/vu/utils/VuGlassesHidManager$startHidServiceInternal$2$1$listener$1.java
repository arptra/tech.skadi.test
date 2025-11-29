package com.upuphone.xr.sapp.vu.utils;

import com.upuphone.xr.sapp.vu.utils.GlassesManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/vu/utils/VuGlassesHidManager$startHidServiceInternal$2$1$listener$1", "Lcom/upuphone/xr/sapp/vu/utils/GlassesManager$IGlassesServiceConnection;", "", "onServiceConnected", "()V", "a", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassesHidManager$startHidServiceInternal$2$1$listener$1 implements GlassesManager.IGlassesServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f8102a;

    public VuGlassesHidManager$startHidServiceInternal$2$1$listener$1(CancellableContinuation cancellableContinuation) {
        this.f8102a = cancellableContinuation;
    }

    public void a() {
    }

    public void onServiceConnected() {
        VuGlassesHidManager.d.remove(this);
        if (VuGlassesHidManager.e) {
            CancellableContinuation cancellableContinuation = this.f8102a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
        }
    }
}
