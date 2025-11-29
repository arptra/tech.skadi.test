package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.db.RecordContentHistoryTagEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel$saveAllChangedNormalTagToHistory$5", f = "FastRecordTagViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTagViewModel$saveAllChangedNormalTagToHistory$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<RecordContentHistoryTagEntity> $curRecordContentHistoryList;
    int label;
    final /* synthetic */ FastRecordTagViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagViewModel$saveAllChangedNormalTagToHistory$5(FastRecordTagViewModel fastRecordTagViewModel, ArrayList<RecordContentHistoryTagEntity> arrayList, Continuation<? super FastRecordTagViewModel$saveAllChangedNormalTagToHistory$5> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordTagViewModel;
        this.$curRecordContentHistoryList = arrayList;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTagViewModel$saveAllChangedNormalTagToHistory$5(this.this$0, this.$curRecordContentHistoryList, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0._mCurRecordContentHistoryTagEntityList.setValue(this.$curRecordContentHistoryList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTagViewModel$saveAllChangedNormalTagToHistory$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
