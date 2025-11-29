package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.data.ImportFileState;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.EventBus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciHistoryActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciHistoryActivity.kt\ncom/upuphone/ar/tici/phone/TiciHistoryActivity$initViewModels$8\n+ 2 EventBus.kt\ncom/upuphone/ar/tici/phone/utils/EventBus\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,547:1\n68#2:548\n69#2:555\n83#2,7:556\n70#2:563\n36#3:549\n21#3:550\n23#3:554\n50#4:551\n55#4:553\n106#5:552\n*S KotlinDebug\n*F\n+ 1 TiciHistoryActivity.kt\ncom/upuphone/ar/tici/phone/TiciHistoryActivity$initViewModels$8\n*L\n219#1:548\n219#1:555\n219#1:556,7\n219#1:563\n219#1:549\n219#1:550\n219#1:554\n219#1:551\n219#1:553\n219#1:552\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciHistoryActivity$initViewModels$8", f = "TiciHistoryActivity.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
public final class TiciHistoryActivity$initViewModels$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TiciHistoryActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHistoryActivity$initViewModels$8(TiciHistoryActivity ticiHistoryActivity, Continuation<? super TiciHistoryActivity$initViewModels$8> continuation) {
        super(2, continuation);
        this.this$0 = ticiHistoryActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHistoryActivity$initViewModels$8(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TiciHistoryActivity$initViewModels$8$invokeSuspend$$inlined$registerSticky$1 ticiHistoryActivity$initViewModels$8$invokeSuspend$$inlined$registerSticky$1 = new TiciHistoryActivity$initViewModels$8$invokeSuspend$$inlined$registerSticky$1(EventBus.e);
            Job unused = BuildersKt__Builders_commonKt.d(EventBus.b, (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryActivity$initViewModels$8$invokeSuspend$$inlined$registerSticky$2((Continuation) null), 3, (Object) null);
            final TiciHistoryActivity ticiHistoryActivity = this.this$0;
            AnonymousClass1 r10 = new FlowCollector() {
                /* renamed from: d */
                public final Object emit(ImportFileState importFileState, Continuation continuation) {
                    CommonExtKt.b("receive ImportFileState: " + importFileState, "TiciHistoryActivity");
                    ticiHistoryActivity.c1(importFileState);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (ticiHistoryActivity$initViewModels$8$invokeSuspend$$inlined$registerSticky$1.collect(r10, this) == coroutine_suspended) {
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
        return ((TiciHistoryActivity$initViewModels$8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
