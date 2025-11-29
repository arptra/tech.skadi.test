package com.upuphone.xr.sapp.vu.ota;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper", f = "VuGlassUpdateHelper.kt", i = {}, l = {204}, m = "installRom", n = {}, s = {})
public final class VuGlassUpdateHelper$installRom$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuGlassUpdateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassUpdateHelper$installRom$1(VuGlassUpdateHelper vuGlassUpdateHelper, Continuation<? super VuGlassUpdateHelper$installRom$1> continuation) {
        super(continuation);
        this.this$0 = vuGlassUpdateHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j((File) null, 0, (Function1) null, this);
    }
}
