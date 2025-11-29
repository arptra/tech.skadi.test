package com.upuphone.xr.sapp.permission;

import androidx.activity.result.ActivityResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/permission/PermissionChain$waitForActivityResult$2$callback$1", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResult;", "", "Lcom/upuphone/xr/sapp/permission/ActivityResultCallback;", "result", "a", "(Landroidx/activity/result/ActivityResult;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PermissionChain$waitForActivityResult$2$callback$1 implements Function1<ActivityResult, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f7815a;

    public PermissionChain$waitForActivityResult$2$callback$1(CancellableContinuation cancellableContinuation) {
        this.f7815a = cancellableContinuation;
    }

    public void a(ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "result");
        if (this.f7815a.isActive()) {
            this.f7815a.resumeWith(Result.m20constructorimpl(activityResult));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ActivityResult) obj);
        return Unit.INSTANCE;
    }
}
