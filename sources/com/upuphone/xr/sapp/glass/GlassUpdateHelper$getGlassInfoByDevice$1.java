package com.upuphone.xr.sapp.glass;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper", f = "GlassUpdateHelper.kt", i = {}, l = {1727}, m = "getGlassInfoByDevice", n = {}, s = {})
public final class GlassUpdateHelper$getGlassInfoByDevice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GlassUpdateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$getGlassInfoByDevice$1(GlassUpdateHelper glassUpdateHelper, Continuation<? super GlassUpdateHelper$getGlassInfoByDevice$1> continuation) {
        super(continuation);
        this.this$0 = glassUpdateHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.z0(this);
    }
}
