package com.upuphone.xr.sapp.vu.ota;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper", f = "VuGlassUpdateHelper.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {163}, m = "update", n = {"this", "onProgress", "dir", "result", "pair", "segment", "index$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "F$0", "I$0"})
public final class VuGlassUpdateHelper$update$1 extends ContinuationImpl {
    float F$0;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuGlassUpdateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassUpdateHelper$update$1(VuGlassUpdateHelper vuGlassUpdateHelper, Continuation<? super VuGlassUpdateHelper$update$1> continuation) {
        super(continuation);
        this.this$0 = vuGlassUpdateHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m((VuUpdateInfo) null, (Function1) null, this);
    }
}
