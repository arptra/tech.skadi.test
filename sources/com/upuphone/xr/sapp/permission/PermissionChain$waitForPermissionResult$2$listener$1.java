package com.upuphone.xr.sapp.permission;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/permission/PermissionChain$waitForPermissionResult$2$listener$1", "Lcom/upuphone/xr/sapp/permission/PermissionListener;", "Lcom/upuphone/xr/sapp/permission/PermissionResult;", "result", "", "a", "(Lcom/upuphone/xr/sapp/permission/PermissionResult;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PermissionChain$waitForPermissionResult$2$listener$1 implements PermissionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f7816a;

    public PermissionChain$waitForPermissionResult$2$listener$1(CancellableContinuation cancellableContinuation) {
        this.f7816a = cancellableContinuation;
    }

    public void a(PermissionResult permissionResult) {
        Intrinsics.checkNotNullParameter(permissionResult, "result");
        if (this.f7816a.isActive()) {
            this.f7816a.resumeWith(Result.m20constructorimpl(permissionResult));
        }
    }
}
