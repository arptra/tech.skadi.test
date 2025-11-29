package com.upuphone.xr.sapp.utils;

import com.upuphone.xr.sapp.utils.GenericWindowResult;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/upuphone/xr/sapp/utils/GenericWindowExtKt$waitForButtonAction$2$callback$1", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "", "windowType", "actionType", "", "a", "(II)V", "", "data", "c", "(ILjava/lang/Object;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GenericWindowExtKt$waitForButtonAction$2$callback$1 implements SuperGenericWindowView.IActionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f7883a;

    public GenericWindowExtKt$waitForButtonAction$2$callback$1(CancellableContinuation cancellableContinuation) {
        this.f7883a = cancellableContinuation;
    }

    public void a(int i, int i2) {
        if (this.f7883a.isActive()) {
            CancellableContinuation cancellableContinuation = this.f7883a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(new GenericWindowResult.ButtonAction(i, i2)));
        }
    }

    public void c(int i, Object obj) {
    }
}
