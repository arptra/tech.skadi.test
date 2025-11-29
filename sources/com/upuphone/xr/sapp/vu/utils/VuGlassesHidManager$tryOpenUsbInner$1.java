package com.upuphone.xr.sapp.vu.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager", f = "VuGlassesHidManager.kt", i = {0, 1, 2, 3, 5}, l = {178, 183, 186, 188, 202, 204}, m = "tryOpenUsbInner", n = {"this", "this", "this", "this", "openResult"}, s = {"L$0", "L$0", "L$0", "L$0", "Z$0"})
public final class VuGlassesHidManager$tryOpenUsbInner$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuGlassesHidManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesHidManager$tryOpenUsbInner$1(VuGlassesHidManager vuGlassesHidManager, Continuation<? super VuGlassesHidManager$tryOpenUsbInner$1> continuation) {
        super(continuation);
        this.this$0 = vuGlassesHidManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.z(this);
    }
}
