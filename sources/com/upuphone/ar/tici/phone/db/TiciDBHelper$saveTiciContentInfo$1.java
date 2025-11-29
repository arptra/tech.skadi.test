package com.upuphone.ar.tici.phone.db;

import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.db.TiciDBHelper", f = "TiciDBHelper.kt", i = {0, 0, 1, 1, 2, 3, 3, 4}, l = {29, 42, 45, 54, 56, 57}, m = "saveTiciContentInfo", n = {"ticiEntity", "content", "ticiEntity", "partList", "ticiEntity", "ticiEntity", "contentPartList", "contentPartList"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0"})
public final class TiciDBHelper$saveTiciContentInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciDBHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciDBHelper$saveTiciContentInfo$1(TiciDBHelper ticiDBHelper, Continuation<? super TiciDBHelper$saveTiciContentInfo$1> continuation) {
        super(continuation);
        this.this$0 = ticiDBHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e((TiciEntity) null, (String) null, false, this);
    }
}
