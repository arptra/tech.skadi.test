package com.upuphone.xr.sapp.vu.vm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesModel", f = "VuGlassesModel.kt", i = {0, 0, 0, 1}, l = {397, 404, 408}, m = "checkUsbAgain", n = {"this", "retryCount", "isConnected", "this"}, s = {"L$0", "I$0", "Z$0", "L$0"})
public final class VuGlassesModel$checkUsbAgain$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuGlassesModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesModel$checkUsbAgain$1(VuGlassesModel vuGlassesModel, Continuation<? super VuGlassesModel$checkUsbAgain$1> continuation) {
        super(continuation);
        this.this$0 = vuGlassesModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.x(this);
    }
}
