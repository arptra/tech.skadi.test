package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.starrynet.msg.SyncParagraphInfo;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciMainActivity$initViewModels$18", f = "TiciMainActivity.kt", i = {}, l = {443}, m = "invokeSuspend", n = {}, s = {})
public final class TiciMainActivity$initViewModels$18 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TiciMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainActivity$initViewModels$18(TiciMainActivity ticiMainActivity, Continuation<? super TiciMainActivity$initViewModels$18> continuation) {
        super(2, continuation);
        this.this$0 = ticiMainActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciMainActivity$initViewModels$18(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow X = this.this$0.d.X();
            final TiciMainActivity ticiMainActivity = this.this$0;
            AnonymousClass1 r1 = new FlowCollector() {
                /* renamed from: d */
                public final Object emit(SyncParagraphInfo syncParagraphInfo, Continuation continuation) {
                    CommonExtKt.e("syncParagraphInfo: " + syncParagraphInfo, "TiciMainActivity");
                    ticiMainActivity.B1();
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (X.collect(r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciMainActivity$initViewModels$18) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
