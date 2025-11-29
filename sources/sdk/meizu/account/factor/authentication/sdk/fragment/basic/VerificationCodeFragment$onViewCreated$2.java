package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.view.VCodeEditLayout;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "second", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeFragment$onViewCreated$2", f = "VerificationCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VerificationCodeFragment$onViewCreated$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ VerificationCodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationCodeFragment$onViewCreated$2(VerificationCodeFragment verificationCodeFragment, Continuation<? super VerificationCodeFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = verificationCodeFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VerificationCodeFragment$onViewCreated$2 verificationCodeFragment$onViewCreated$2 = new VerificationCodeFragment$onViewCreated$2(this.this$0, continuation);
        verificationCodeFragment$onViewCreated$2.I$0 = ((Number) obj).intValue();
        return verificationCodeFragment$onViewCreated$2;
    }

    @Nullable
    public final Object invoke(int i, @Nullable Continuation<? super Unit> continuation) {
        return ((VerificationCodeFragment$onViewCreated$2) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i = this.I$0;
            VCodeEditLayout access$getEditLayout$p = this.this$0.editLayout;
            if (access$getEditLayout$p != null) {
                access$getEditLayout$p.repeatTime(i);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }
}
