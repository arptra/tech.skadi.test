package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperatorManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "recordId", "", "code", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$2 extends Lambda implements Function2<Long, String, Unit> {
    public static final FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$2 INSTANCE = new FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$2();

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$2$1", f = "FastRecordHistoryAsrOperatorManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(j, str, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FastRecordHistoryAsrOperatorManager.AsrCallbackInterface asrCallbackInterface = (FastRecordHistoryAsrOperatorManager.AsrCallbackInterface) FastRecordHistoryAsrOperatorManager.callBackMap.get(Boxing.boxLong(j));
                if (asrCallbackInterface != null) {
                    asrCallbackInterface.asrResultFail(j, str);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).longValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(final long j, @NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "code");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        LogExt.logW("initSingleAsrOperator setFailCallBack record id = " + j, "FastRecordHistoryAsrOperatorManager");
        FastRecordHistoryAsrOperatorManager fastRecordHistoryAsrOperatorManager = FastRecordHistoryAsrOperatorManager.INSTANCE;
        fastRecordHistoryAsrOperatorManager.removeAsrTask(j);
        fastRecordHistoryAsrOperatorManager.setEventFail(j);
    }
}
