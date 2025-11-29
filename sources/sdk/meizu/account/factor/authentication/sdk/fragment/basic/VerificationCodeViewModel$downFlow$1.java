package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel$downFlow$1", f = "VerificationCodeViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
public final class VerificationCodeViewModel$downFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VerificationCodeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationCodeViewModel$downFlow$1(VerificationCodeViewModel verificationCodeViewModel, Continuation<? super VerificationCodeViewModel$downFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = verificationCodeViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VerificationCodeViewModel$downFlow$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0037
        L_0x000f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r6)
        L_0x001a:
            sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel r6 = r5.this$0
            kotlinx.coroutines.flow.MutableStateFlow r6 = r6._vCodeTimeDownFlow
            java.lang.Object r6 = r6.getValue()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r6 <= 0) goto L_0x0050
            r5.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r5)
            if (r6 != r0) goto L_0x0037
            return r0
        L_0x0037:
            sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel r6 = r5.this$0
            kotlinx.coroutines.flow.MutableStateFlow r6 = r6._vCodeTimeDownFlow
            java.lang.Object r1 = r6.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            int r1 = r1 - r2
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r6.setValue(r1)
            goto L_0x001a
        L_0x0050:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel$downFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VerificationCodeViewModel$downFlow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
