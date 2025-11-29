package com.upuphone.ar.tici.phone.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.TiciHelper", f = "TiciHelper.kt", i = {0, 0, 0, 3, 3, 4}, l = {576, 580, 581, 583, 599}, m = "readFileAsText", n = {"this", "file", "maxLength", "file", "maxLength", "charset"}, s = {"L$0", "L$1", "I$0", "L$0", "I$0", "L$0"})
public final class TiciHelper$readFileAsText$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHelper$readFileAsText$1(TiciHelper ticiHelper, Continuation<? super TiciHelper$readFileAsText$1> continuation) {
        super(continuation);
        this.this$0 = ticiHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k((String) null, 0, this);
    }
}
