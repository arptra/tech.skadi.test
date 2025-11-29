package com.upuphone.xr.sapp.vu.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager", f = "VuGlassesHidManager.kt", i = {}, l = {296}, m = "tryOpenUsbBlock", n = {}, s = {})
public final class VuGlassesHidManager$tryOpenUsbBlock$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuGlassesHidManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesHidManager$tryOpenUsbBlock$1(VuGlassesHidManager vuGlassesHidManager, Continuation<? super VuGlassesHidManager$tryOpenUsbBlock$1> continuation) {
        super(continuation);
        this.this$0 = vuGlassesHidManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.y(this);
    }
}
