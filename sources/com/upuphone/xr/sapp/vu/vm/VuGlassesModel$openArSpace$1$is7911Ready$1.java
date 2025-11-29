package com.upuphone.xr.sapp.vu.vm;

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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesModel$openArSpace$1$is7911Ready$1", f = "VuGlassesModel.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassesModel$openArSpace$1$is7911Ready$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ VuGlassesModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesModel$openArSpace$1$is7911Ready$1(VuGlassesModel vuGlassesModel, Continuation<? super VuGlassesModel$openArSpace$1$is7911Ready$1> continuation) {
        super(2, continuation);
        this.this$0 = vuGlassesModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassesModel$openArSpace$1$is7911Ready$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            VuGlassesModel vuGlassesModel = this.this$0;
            this.label = 1;
            obj = vuGlassesModel.v(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((VuGlassesModel$openArSpace$1$is7911Ready$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
