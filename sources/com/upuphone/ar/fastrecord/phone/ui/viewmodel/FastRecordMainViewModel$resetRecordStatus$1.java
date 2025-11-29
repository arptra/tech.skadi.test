package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel", f = "FastRecordMainViewModel.kt", i = {0}, l = {547}, m = "resetRecordStatus", n = {"this"}, s = {"L$0"})
public final class FastRecordMainViewModel$resetRecordStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FastRecordMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainViewModel$resetRecordStatus$1(FastRecordMainViewModel fastRecordMainViewModel, Continuation<? super FastRecordMainViewModel$resetRecordStatus$1> continuation) {
        super(continuation);
        this.this$0 = fastRecordMainViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.resetRecordStatus((ArrayList<RecordEntity>) null, this);
    }
}
