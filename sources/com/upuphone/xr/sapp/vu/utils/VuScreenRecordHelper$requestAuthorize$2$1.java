package com.upuphone.xr.sapp.vu.utils;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuScreenRecordHelper$requestAuthorize$2$1 extends Lambda implements Function1<Intent, Unit> {
    final /* synthetic */ CancellableContinuation<Intent> $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuScreenRecordHelper$requestAuthorize$2$1(CancellableContinuation<? super Intent> cancellableContinuation) {
        super(1);
        this.$it = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Intent intent) {
        this.$it.resumeWith(Result.m20constructorimpl(intent));
    }
}
