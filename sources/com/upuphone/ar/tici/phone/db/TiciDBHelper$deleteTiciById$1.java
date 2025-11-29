package com.upuphone.ar.tici.phone.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.db.TiciDBHelper", f = "TiciDBHelper.kt", i = {0}, l = {83, 84}, m = "deleteTiciById", n = {"id"}, s = {"J$0"})
public final class TiciDBHelper$deleteTiciById$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciDBHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciDBHelper$deleteTiciById$1(TiciDBHelper ticiDBHelper, Continuation<? super TiciDBHelper$deleteTiciById$1> continuation) {
        super(continuation);
        this.this$0 = ticiDBHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(0, this);
    }
}
