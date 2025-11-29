package com.upuphone.xr.sapp.unicron;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronUpdateHelper", f = "UnicronUpdateHelper.kt", i = {}, l = {642}, m = "processUpdateFile", n = {}, s = {})
public final class UnicronUpdateHelper$processUpdateFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnicronUpdateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnicronUpdateHelper$processUpdateFile$1(UnicronUpdateHelper unicronUpdateHelper, Continuation<? super UnicronUpdateHelper$processUpdateFile$1> continuation) {
        super(continuation);
        this.this$0 = unicronUpdateHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.R((File) null, this);
    }
}
