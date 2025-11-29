package com.upuphone.ar.tici.phone.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.db.TiciDBHelper", f = "TiciDBHelper.kt", i = {0, 0, 0}, l = {99, 106}, m = "updateTiciContentPart", n = {"paragraphIndexes", "ticiId", "partIndex"}, s = {"L$0", "J$0", "I$0"})
public final class TiciDBHelper$updateTiciContentPart$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciDBHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciDBHelper$updateTiciContentPart$1(TiciDBHelper ticiDBHelper, Continuation<? super TiciDBHelper$updateTiciContentPart$1> continuation) {
        super(continuation);
        this.this$0 = ticiDBHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(0, 0, (String) null, this);
    }
}
