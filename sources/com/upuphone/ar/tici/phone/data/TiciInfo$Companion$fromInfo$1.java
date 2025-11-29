package com.upuphone.ar.tici.phone.data;

import com.upuphone.ar.tici.phone.data.TiciInfo;
import com.upuphone.ar.tici.phone.db.entity.TiciContentPart;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.data.TiciInfo$Companion", f = "TiciInfo.kt", i = {0, 0, 0}, l = {32}, m = "fromInfo", n = {"entity", "currentContentPart", "nextContentPart"}, s = {"L$0", "L$1", "L$2"})
public final class TiciInfo$Companion$fromInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciInfo.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciInfo$Companion$fromInfo$1(TiciInfo.Companion companion, Continuation<? super TiciInfo$Companion$fromInfo$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((TiciEntity) null, (List) null, (TiciContentPart) null, (TiciContentPart) null, this);
    }
}
