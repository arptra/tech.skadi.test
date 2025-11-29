package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {}, l = {178, 189}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ boolean $isFinishAsr;
    final /* synthetic */ long $recordId;
    int label;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1$2", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(function0, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                function0.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1(long j, boolean z, FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, Function0<Unit> function0, Continuation<? super FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$isFinishAsr = z;
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
        this.$callback = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1(this.$recordId, this.$isFinishAsr, this.this$0, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        RecordEntity recordEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
            long j = this.$recordId;
            this.label = 1;
            obj = FastRecordDao.DefaultImpls.findRecordEntityById$default(fastRecordDao, j, (String) null, this, 2, (Object) null);
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
        RecordEntity recordEntity2 = (RecordEntity) obj;
        if (recordEntity2 != null) {
            long j2 = this.$recordId;
            boolean z = this.$isFinishAsr;
            FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel = this.this$0;
            String languageType = recordEntity2.getLanguageType();
            LogExt.logW("updateCurRecordLanguageType recordId = " + j2 + ",languageType = " + languageType + ",isFinishAsr = " + z, "FastRecordDetailRecordHistoryViewModel");
            RecordEntity recordEntity3 = (RecordEntity) fastRecordDetailRecordHistoryViewModel._mCurFastRecordLiveData.getValue();
            if (recordEntity3 != null) {
                recordEntity3.setLanguageType(recordEntity2.getLanguageType());
            }
            if (z && (recordEntity = (RecordEntity) fastRecordDetailRecordHistoryViewModel._mCurFastRecordLiveData.getValue()) != null) {
                recordEntity.setFinishAsr(true);
            }
        }
        MainCoroutineDispatcher c = Dispatchers.c();
        final Function0<Unit> function0 = this.$callback;
        AnonymousClass2 r1 = new AnonymousClass2((Continuation<? super AnonymousClass2>) null);
        this.label = 2;
        if (BuildersKt.g(c, r1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
