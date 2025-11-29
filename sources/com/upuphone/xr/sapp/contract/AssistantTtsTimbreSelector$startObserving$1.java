package com.upuphone.xr.sapp.contract;

import com.xjsd.ai.assistant.common.data.DataStoreUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAssistantTtsTimbreSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssistantTtsTimbreSelector.kt\ncom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$startObserving$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,276:1\n53#2:277\n55#2:281\n50#3:278\n55#3:280\n107#4:279\n*S KotlinDebug\n*F\n+ 1 AssistantTtsTimbreSelector.kt\ncom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$startObserving$1\n*L\n123#1:277\n123#1:281\n123#1:278\n123#1:280\n123#1:279\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.contract.AssistantTtsTimbreSelector$startObserving$1", f = "AssistantTtsTimbreSelector.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
public final class AssistantTtsTimbreSelector$startObserving$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AssistantTtsTimbreSelector this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssistantTtsTimbreSelector$startObserving$1(AssistantTtsTimbreSelector assistantTtsTimbreSelector, Continuation<? super AssistantTtsTimbreSelector$startObserving$1> continuation) {
        super(2, continuation);
        this.this$0 = assistantTtsTimbreSelector;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AssistantTtsTimbreSelector$startObserving$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AssistantTtsTimbreSelector$startObserving$1$invokeSuspend$$inlined$map$1 assistantTtsTimbreSelector$startObserving$1$invokeSuspend$$inlined$map$1 = new AssistantTtsTimbreSelector$startObserving$1$invokeSuspend$$inlined$map$1(DataStoreUtils.f8415a.h(this.this$0.f6679a).getData());
            final AssistantTtsTimbreSelector assistantTtsTimbreSelector = this.this$0;
            AnonymousClass2 r5 = new FlowCollector() {
                public final Object d(int i, Continuation continuation) {
                    assistantTtsTimbreSelector.c.m(i);
                    return Unit.INSTANCE;
                }

                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return d(((Number) obj).intValue(), continuation);
                }
            };
            this.label = 1;
            if (assistantTtsTimbreSelector$startObserving$1$invokeSuspend$$inlined$map$1.collect(r5, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AssistantTtsTimbreSelector$startObserving$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
