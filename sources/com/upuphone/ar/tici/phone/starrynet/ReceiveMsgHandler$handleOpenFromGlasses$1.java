package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.TiciAppViewModel;
import com.upuphone.ar.tici.phone.data.OpenTiciFrom;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.utils.TiciHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$handleOpenFromGlasses$1", f = "ReceiveMsgHandler.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
public final class ReceiveMsgHandler$handleOpenFromGlasses$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ReceiveMsgHandler$handleOpenFromGlasses$1(Continuation<? super ReceiveMsgHandler$handleOpenFromGlasses$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReceiveMsgHandler$handleOpenFromGlasses$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TiciHelper ticiHelper = TiciHelper.f6002a;
            this.label = 1;
            obj = ticiHelper.e(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TiciAppViewModel.O0(TiciApp.b.c(), (TiciEntity) obj, OpenTiciFrom.Glass, false, true, (Integer) null, (Integer) null, 0, 116, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReceiveMsgHandler$handleOpenFromGlasses$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
