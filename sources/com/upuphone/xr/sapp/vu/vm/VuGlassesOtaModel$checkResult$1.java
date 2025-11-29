package com.upuphone.xr.sapp.vu.vm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel", f = "VuGlassesOtaModel.kt", i = {0, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4}, l = {247, 252, 259, 267, 275}, m = "checkResult", n = {"updateVersion", "waitConnectCount", "isConnected", "updateVersion", "waitConnectCount", "isConnected", "updateVersion", "updateVersion", "model", "count", "updateVersion", "count"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "L$0", "L$1", "I$0", "L$0", "I$0"})
public final class VuGlassesOtaModel$checkResult$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuGlassesOtaModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesOtaModel$checkResult$1(VuGlassesOtaModel vuGlassesOtaModel, Continuation<? super VuGlassesOtaModel$checkResult$1> continuation) {
        super(continuation);
        this.this$0 = vuGlassesOtaModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.t((String) null, this);
    }
}
