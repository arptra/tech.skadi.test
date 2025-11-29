package sdk.meizu.account.factor.authentication.sdk.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository", f = "FactorAuthenticationRepository.kt", i = {}, l = {94}, m = "getVCode-yxL6bBk", n = {}, s = {})
public final class FactorAuthenticationRepository$getVCode$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FactorAuthenticationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FactorAuthenticationRepository$getVCode$1(FactorAuthenticationRepository factorAuthenticationRepository, Continuation<? super FactorAuthenticationRepository$getVCode$1> continuation) {
        super(continuation);
        this.this$0 = factorAuthenticationRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r6 = this.this$0.m15getVCodeyxL6bBk((String) null, (BasicInfoType) null, (String) null, (GeetestData) null, this);
        return r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r6 : Result.m19boximpl(r6);
    }
}
