package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.star.core.log.ULog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1$displayId$1", f = "VuGlassesModel.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassesModel$openArSpace$1$displayId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ VuGlassesModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesModel$openArSpace$1$displayId$1(VuGlassesModel vuGlassesModel, Continuation<? super VuGlassesModel$openArSpace$1$displayId$1> continuation) {
        super(2, continuation);
        this.this$0 = vuGlassesModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassesModel$openArSpace$1$displayId$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            VuGlassesModel vuGlassesModel = this.this$0;
            this.label = 1;
            obj = vuGlassesModel.S(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException unused) {
                ULog.f6446a.a("VuGlassesModel", "waitDisplayConnected cancelled");
                i = -1;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = ((Number) obj).intValue();
        return Boxing.boxInt(i);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Integer> continuation) {
        return ((VuGlassesModel$openArSpace$1$displayId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
