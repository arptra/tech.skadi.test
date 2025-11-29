package com.upuphone.ar.fastrecord.phone.ui.adapter;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordDetailHistoryViewAdapter$clearEditStateAndSaveData$2", f = "FastRecordDetailHistoryViewAdapter.kt", i = {}, l = {464, 467}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordDetailHistoryViewAdapter$clearEditStateAndSaveData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callBack;
    final /* synthetic */ StringBuffer $tempFastRecordContent;
    int label;
    final /* synthetic */ FastRecordDetailHistoryViewAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailHistoryViewAdapter$clearEditStateAndSaveData$2(FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter, StringBuffer stringBuffer, Function0<Unit> function0, Continuation<? super FastRecordDetailHistoryViewAdapter$clearEditStateAndSaveData$2> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordDetailHistoryViewAdapter;
        this.$tempFastRecordContent = stringBuffer;
        this.$callBack = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailHistoryViewAdapter$clearEditStateAndSaveData$2(this.this$0, this.$tempFastRecordContent, this.$callBack, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FastRecordVoiceWordDao fastRecordVoiceWordDao = FastRecordManager.Companion.getInstance().fastRecordVoiceWordDao();
            ArrayList access$getRecordWordList$p = this.this$0.recordWordList;
            this.label = 1;
            if (fastRecordVoiceWordDao.updateList(access$getRecordWordList$p, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.$callBack.invoke();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long recordId = ((RecordVoiceWordEntity) this.this$0.recordWordList.get(0)).getRecordId();
        FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
        String stringBuffer = this.$tempFastRecordContent.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "toString(...)");
        this.label = 2;
        if (fastRecordDao.updateRecordContent(recordId, stringBuffer, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.$callBack.invoke();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailHistoryViewAdapter$clearEditStateAndSaveData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
