package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintsState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/work/impl/constraints/ConstraintsState;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.work.impl.constraints.controllers.ConstraintController$track$1", f = "ContraintControllers.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
public final class ConstraintController$track$1 extends SuspendLambda implements Function2<ProducerScope<? super ConstraintsState>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConstraintController<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintController$track$1(ConstraintController<T> constraintController, Continuation<? super ConstraintController$track$1> continuation) {
        super(2, continuation);
        this.this$0 = constraintController;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ConstraintController$track$1 constraintController$track$1 = new ConstraintController$track$1(this.this$0, continuation);
        constraintController$track$1.L$0 = obj;
        return constraintController$track$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            final ConstraintController$track$1$listener$1 constraintController$track$1$listener$1 = new ConstraintController$track$1$listener$1(this.this$0, producerScope);
            this.this$0.f2142a.c(constraintController$track$1$listener$1);
            final ConstraintController<T> constraintController = this.this$0;
            AnonymousClass1 r3 = new Function0<Unit>() {
                public final void invoke() {
                    constraintController.f2142a.f(constraintController$track$1$listener$1);
                }
            };
            this.label = 1;
            if (ProduceKt.a(producerScope, r3, this) == coroutine_suspended) {
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
    public final Object invoke(@NotNull ProducerScope<? super ConstraintsState> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ConstraintController$track$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
