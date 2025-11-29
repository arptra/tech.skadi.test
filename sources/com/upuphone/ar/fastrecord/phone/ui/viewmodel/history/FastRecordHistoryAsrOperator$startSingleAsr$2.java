package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator$startSingleAsr$2", f = "FastRecordHistoryAsrOperator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordHistoryAsrOperator$startSingleAsr$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $languageType;
    final /* synthetic */ long $recordId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryAsrOperator$startSingleAsr$2(long j, Ref.ObjectRef<String> objectRef, Continuation<? super FastRecordHistoryAsrOperator$startSingleAsr$2> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$languageType = objectRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryAsrOperator$startSingleAsr$2(this.$recordId, this.$languageType, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$recordId;
            T t = this.$languageType.element;
            LogExt.logE("startSingleAsr updateRecordLangType recordId = " + j + ",languageType=" + t, FastRecordHistoryAsrOperator.TAG);
            FastRecordManager.Companion.getInstance().fastRecordDao().updateRecordLangType(this.$recordId, (String) this.$languageType.element);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordHistoryAsrOperator$startSingleAsr$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
