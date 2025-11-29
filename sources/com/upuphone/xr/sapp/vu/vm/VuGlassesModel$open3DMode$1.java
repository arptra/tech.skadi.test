package com.upuphone.xr.sapp.vu.vm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesModel", f = "VuGlassesModel.kt", i = {}, l = {352}, m = "open3DMode", n = {}, s = {})
public final class VuGlassesModel$open3DMode$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuGlassesModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesModel$open3DMode$1(VuGlassesModel vuGlassesModel, Continuation<? super VuGlassesModel$open3DMode$1> continuation) {
        super(continuation);
        this.this$0 = vuGlassesModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.H(this);
    }
}
