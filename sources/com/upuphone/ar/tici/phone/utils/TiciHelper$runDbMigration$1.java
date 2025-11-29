package com.upuphone.ar.tici.phone.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.TiciHelper", f = "TiciHelper.kt", i = {0, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6}, l = {438, 440, 447, 452, 456, 457, 464}, m = "runDbMigration$ar_tici_release", n = {"this", "this", "this", "ticiEntity", "this", "ticiEntity", "this", "ticiEntity", "partList", "this", "ticiEntity", "partList", "this", "ticiEntity"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class TiciHelper$runDbMigration$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHelper$runDbMigration$1(TiciHelper ticiHelper, Continuation<? super TiciHelper$runDbMigration$1> continuation) {
        super(continuation);
        this.this$0 = ticiHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(this);
    }
}
