package com.upuphone.xr.sapp.glass;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.StarGlassUpdater", f = "StarGlassUpdater.kt", i = {}, l = {161}, m = "checkGlassUpdateFileInner", n = {}, s = {})
public final class StarGlassUpdater$checkGlassUpdateFileInner$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StarGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarGlassUpdater$checkGlassUpdateFileInner$1(StarGlassUpdater starGlassUpdater, Continuation<? super StarGlassUpdater$checkGlassUpdateFileInner$1> continuation) {
        super(continuation);
        this.this$0 = starGlassUpdater;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.D((String) null, (String) null, this);
    }
}
