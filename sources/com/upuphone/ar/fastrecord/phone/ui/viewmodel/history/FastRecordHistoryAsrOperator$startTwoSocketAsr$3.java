package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryAsrOperator$startTwoSocketAsr$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $pcmPath;
    final /* synthetic */ String $pcmTwo;
    final /* synthetic */ FastRecordHistoryAsrOperator this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator$startTwoSocketAsr$3$1", f = "FastRecordHistoryAsrOperator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator$startTwoSocketAsr$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(str, fastRecordHistoryAsrOperator, str2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                fastRecordHistoryAsrOperator.fileTotalTime = RecordFileUtils.INSTANCE.getFileSize(str) / ((long) 32);
                long access$getFileTotalTime$p = fastRecordHistoryAsrOperator.fileTotalTime;
                LogExt.logE("two socket fileTotalTime = " + access$getFileTotalTime$p, FastRecordHistoryAsrOperator.TAG);
                LogExt.logE("start send phone voice file data SPLIT_READ_FILE_TIME = 5", FastRecordHistoryAsrOperator.TAG);
                fastRecordHistoryAsrOperator.startPhoneUpSocket(str);
                fastRecordHistoryAsrOperator.startPhoneDownSocket(str2);
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
    public FastRecordHistoryAsrOperator$startTwoSocketAsr$3(String str, FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator, String str2) {
        super(0);
        this.$pcmPath = str;
        this.this$0 = fastRecordHistoryAsrOperator;
        this.$pcmTwo = str2;
    }

    public final void invoke() {
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.b());
        final String str = this.$pcmPath;
        final FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = this.this$0;
        final String str2 = this.$pcmTwo;
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
