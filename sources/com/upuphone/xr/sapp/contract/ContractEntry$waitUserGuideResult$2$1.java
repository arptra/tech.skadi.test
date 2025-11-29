package com.upuphone.xr.sapp.contract;

import androidx.core.util.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/contract/UserGuideAuthResult;", "result", "", "a", "(Lcom/upuphone/xr/sapp/contract/UserGuideAuthResult;)V"}, k = 3, mv = {1, 9, 0})
public final class ContractEntry$waitUserGuideResult$2$1<T> implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f6693a;

    public ContractEntry$waitUserGuideResult$2$1(CancellableContinuation cancellableContinuation) {
        this.f6693a = cancellableContinuation;
    }

    /* renamed from: a */
    public final void accept(UserGuideAuthResult userGuideAuthResult) {
        Intrinsics.checkNotNullParameter(userGuideAuthResult, "result");
        if (this.f6693a.isActive()) {
            this.f6693a.resumeWith(Result.m20constructorimpl(userGuideAuthResult));
        }
    }
}
