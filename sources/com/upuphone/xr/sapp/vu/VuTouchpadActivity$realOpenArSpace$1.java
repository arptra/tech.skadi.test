package com.upuphone.xr.sapp.vu;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.VuTouchpadActivity", f = "VuTouchpadActivity.kt", i = {0}, l = {294}, m = "realOpenArSpace", n = {"this"}, s = {"L$0"})
public final class VuTouchpadActivity$realOpenArSpace$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuTouchpadActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuTouchpadActivity$realOpenArSpace$1(VuTouchpadActivity vuTouchpadActivity, Continuation<? super VuTouchpadActivity$realOpenArSpace$1> continuation) {
        super(continuation);
        this.this$0 = vuTouchpadActivity;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.u1(0, false, this);
    }
}
