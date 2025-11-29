package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.UsbPermissionHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/vu/vm/VuGlassControlModel$requestPermission$2$1", "Lcom/upuphone/xr/sapp/vu/utils/UsbPermissionHelper$OnGrantedResult;", "", "granted", "", "a", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassControlModel$requestPermission$2$1 implements UsbPermissionHelper.OnGrantedResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f8111a;

    public VuGlassControlModel$requestPermission$2$1(CancellableContinuation cancellableContinuation) {
        this.f8111a = cancellableContinuation;
    }

    public void a(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassControlModel", "requestPermission onResult: " + z);
        if (this.f8111a.isActive()) {
            this.f8111a.resumeWith(Result.m20constructorimpl(Boolean.valueOf(z)));
        }
    }
}
