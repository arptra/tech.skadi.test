package sdk.meizu.account.factor.authentication.sdk.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.Mode;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository", f = "FactorAuthenticationRepository.kt", i = {}, l = {132, 133}, m = "confirm-hUnOzRk", n = {}, s = {})
public final class FactorAuthenticationRepository$confirm$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FactorAuthenticationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FactorAuthenticationRepository$confirm$1(FactorAuthenticationRepository factorAuthenticationRepository, Continuation<? super FactorAuthenticationRepository$confirm$1> continuation) {
        super(continuation);
        this.this$0 = factorAuthenticationRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r7 = this.this$0.m12confirmhUnOzRk((String) null, (BasicInfoType) null, (Mode) null, (String) null, (String) null, this);
        return r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r7 : Result.m19boximpl(r7);
    }
}
