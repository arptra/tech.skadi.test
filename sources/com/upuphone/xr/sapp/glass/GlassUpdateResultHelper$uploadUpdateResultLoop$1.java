package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateResultParam;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateResultHelper", f = "GlassUpdateResultHelper.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {267, 270, 282}, m = "uploadUpdateResultLoop", n = {"this", "param", "count", "this", "param", "count", "this", "param", "count"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
public final class GlassUpdateResultHelper$uploadUpdateResultLoop$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GlassUpdateResultHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateResultHelper$uploadUpdateResultLoop$1(GlassUpdateResultHelper glassUpdateResultHelper, Continuation<? super GlassUpdateResultHelper$uploadUpdateResultLoop$1> continuation) {
        super(continuation);
        this.this$0 = glassUpdateResultHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.I((GlassUpdateResultParam) null, this);
    }
}
