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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel", f = "FastRecordMainViewModel.kt", i = {}, l = {90, 96}, m = "checkFastRecordVideoState", n = {}, s = {})
public final class FastRecordMainViewModel$checkFastRecordVideoState$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FastRecordMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainViewModel$checkFastRecordVideoState$1(FastRecordMainViewModel fastRecordMainViewModel, Continuation<? super FastRecordMainViewModel$checkFastRecordVideoState$1> continuation) {
        super(continuation);
        this.this$0 = fastRecordMainViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkFastRecordVideoState((ArrayList<RecordEntity>) null, this);
    }
}
