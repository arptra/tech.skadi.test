package com.upuphone.ar.fastrecord.phone.ui.adapter;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter$showAsrState$1$1", f = "FastRecordViewAdapter.kt", i = {}, l = {290, 292}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordViewAdapter$showAsrState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ AsrDuringProgress $mAsrDuringProgress;
    final /* synthetic */ RecordEntity $recordEntity;
    int label;
    final /* synthetic */ FastRecordViewAdapter this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter$showAsrState$1$1$1", f = "FastRecordViewAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter$showAsrState$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(fastRecordViewAdapter, i2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                fastRecordViewAdapter.notifyItemChanged(i2);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordViewAdapter$showAsrState$1$1(AsrDuringProgress asrDuringProgress, RecordEntity recordEntity, FastRecordViewAdapter fastRecordViewAdapter, int i, Continuation<? super FastRecordViewAdapter$showAsrState$1$1> continuation) {
        super(2, continuation);
        this.$mAsrDuringProgress = asrDuringProgress;
        this.$recordEntity = recordEntity;
        this.this$0 = fastRecordViewAdapter;
        this.$index = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordViewAdapter$showAsrState$1$1(this.$mAsrDuringProgress, this.$recordEntity, this.this$0, this.$index, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
            long recordId = this.$mAsrDuringProgress.getRecordId();
            this.label = 1;
            obj = FastRecordDao.DefaultImpls.findRecordEntityById$default(fastRecordDao, recordId, (String) null, this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RecordEntity recordEntity = (RecordEntity) obj;
        this.$recordEntity.setShortHandText(recordEntity != null ? recordEntity.getShortHandText() : null);
        MainCoroutineDispatcher c = Dispatchers.c();
        final FastRecordViewAdapter fastRecordViewAdapter = this.this$0;
        final int i2 = this.$index;
        AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        this.label = 2;
        if (BuildersKt.g(c, r1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordViewAdapter$showAsrState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
