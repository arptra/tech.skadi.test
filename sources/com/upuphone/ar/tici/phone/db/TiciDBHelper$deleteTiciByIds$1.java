package com.upuphone.ar.tici.phone.db;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.db.TiciDBHelper", f = "TiciDBHelper.kt", i = {0}, l = {88, 89}, m = "deleteTiciByIds", n = {"ids"}, s = {"L$0"})
public final class TiciDBHelper$deleteTiciByIds$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciDBHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciDBHelper$deleteTiciByIds$1(TiciDBHelper ticiDBHelper, Continuation<? super TiciDBHelper$deleteTiciByIds$1> continuation) {
        super(continuation);
        this.this$0 = ticiDBHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c((List) null, this);
    }
}
