package com.upuphone.ar.fastrecord.phone.ui.fragment;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager;
import com.upuphone.xr.interconnect.entity.AIModelResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordTodoFragment$initTodoView$1$2$1$aiResult$1", f = "FastRecordTodoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTodoFragment$initTodoView$1$2$1$aiResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIModelResult $result;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FastRecordTodoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoFragment$initTodoView$1$2$1$aiResult$1(AIModelResult aIModelResult, FastRecordTodoFragment fastRecordTodoFragment, Continuation<? super FastRecordTodoFragment$initTodoView$1$2$1$aiResult$1> continuation) {
        super(2, continuation);
        this.$result = aIModelResult;
        this.this$0 = fastRecordTodoFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FastRecordTodoFragment$initTodoView$1$2$1$aiResult$1 fastRecordTodoFragment$initTodoView$1$2$1$aiResult$1 = new FastRecordTodoFragment$initTodoView$1$2$1$aiResult$1(this.$result, this.this$0, continuation);
        fastRecordTodoFragment$initTodoView$1$2$1$aiResult$1.L$0 = obj;
        return fastRecordTodoFragment$initTodoView$1$2$1$aiResult$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AIModelResult aIModelResult = this.$result;
            LogExt.logI("requestAIState result=" + aIModelResult + ", agreeType=1", "TodoFragment");
            AIModelResult aIModelResult2 = this.$result;
            if (aIModelResult2 != null) {
                FastRecordTodoFragment fastRecordTodoFragment = this.this$0;
                if (Intrinsics.areEqual((Object) "1", (Object) String.valueOf(aIModelResult2.getState()))) {
                    fastRecordTodoFragment.getExtractTodo();
                } else {
                    RecordConnectManager.Companion.getInstance().requestPermission();
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                RecordConnectManager.Companion.getInstance().requestPermission();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTodoFragment$initTodoView$1$2$1$aiResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
