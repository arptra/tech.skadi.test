package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.data.ImportFileState;
import com.upuphone.ar.tici.phone.utils.EventBus;
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
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nEventBus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventBus.kt\ncom/upuphone/ar/tici/phone/utils/EventBus$plugSticky$1\n*L\n1#1,90:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H@¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/upuphone/ar/tici/phone/utils/EventBus$plugSticky$1", "com/upuphone/ar/tici/phone/utils/EventBus$registerSticky$lambda$0$$inlined$plugSticky$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.EventBus$plugSticky$1", f = "EventBus.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class TiciHistoryActivity$initViewModels$8$invokeSuspend$$inlined$registerSticky$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public TiciHistoryActivity$initViewModels$8$invokeSuspend$$inlined$registerSticky$2(Continuation continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHistoryActivity$initViewModels$8$invokeSuspend$$inlined$registerSticky$2(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EventBus eventBus = EventBus.b;
        Object e = eventBus.e(ImportFileState.class);
        if (e != null) {
            eventBus.f(e);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciHistoryActivity$initViewModels$8$invokeSuspend$$inlined$registerSticky$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
