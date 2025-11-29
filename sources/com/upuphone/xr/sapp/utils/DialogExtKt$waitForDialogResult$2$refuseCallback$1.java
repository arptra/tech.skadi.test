package com.upuphone.xr.sapp.utils;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DialogExtKt$waitForDialogResult$2$refuseCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CancellableContinuation<DialogResult> $cont;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogExtKt$waitForDialogResult$2$refuseCallback$1(CancellableContinuation<? super DialogResult> cancellableContinuation) {
        super(0);
        this.$cont = cancellableContinuation;
    }

    public final void invoke() {
        if (this.$cont.isActive()) {
            CancellableContinuation<DialogResult> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(new DialogResult(DialogAction.Refuse)));
        }
    }
}
