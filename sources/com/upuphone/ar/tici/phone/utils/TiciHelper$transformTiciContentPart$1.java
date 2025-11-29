package com.upuphone.ar.tici.phone.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.TiciHelper", f = "TiciHelper.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {316}, m = "transformTiciContentPart", n = {"contentPartList", "offsetLength", "content", "ticiId", "index$iv", "index", "byteSize"}, s = {"L$0", "L$1", "L$3", "J$0", "I$0", "I$1", "I$2"})
public final class TiciHelper$transformTiciContentPart$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHelper$transformTiciContentPart$1(TiciHelper ticiHelper, Continuation<? super TiciHelper$transformTiciContentPart$1> continuation) {
        super(continuation);
        this.this$0 = ticiHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(0, (List) null, this);
    }
}
