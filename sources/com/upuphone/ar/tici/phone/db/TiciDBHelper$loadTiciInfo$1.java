package com.upuphone.ar.tici.phone.db;

import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.db.TiciDBHelper", f = "TiciDBHelper.kt", i = {0, 0, 0, 1, 1, 2, 2, 2}, l = {63, 67, 69, 70}, m = "loadTiciInfo", n = {"this", "ticiEntity", "currentPage", "ticiEntity", "contentPart", "ticiEntity", "contentPart", "nextContentPart"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1", "L$2"})
public final class TiciDBHelper$loadTiciInfo$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciDBHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciDBHelper$loadTiciInfo$1(TiciDBHelper ticiDBHelper, Continuation<? super TiciDBHelper$loadTiciInfo$1> continuation) {
        super(continuation);
        this.this$0 = ticiDBHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d((TiciEntity) null, (Integer) null, this);
    }
}
