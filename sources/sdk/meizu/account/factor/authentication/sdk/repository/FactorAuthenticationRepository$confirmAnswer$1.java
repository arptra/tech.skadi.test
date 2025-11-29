package sdk.meizu.account.factor.authentication.sdk.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.data.AnswerType;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository", f = "FactorAuthenticationRepository.kt", i = {}, l = {171}, m = "confirmAnswer-BWLJW6A", n = {}, s = {})
public final class FactorAuthenticationRepository$confirmAnswer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FactorAuthenticationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FactorAuthenticationRepository$confirmAnswer$1(FactorAuthenticationRepository factorAuthenticationRepository, Continuation<? super FactorAuthenticationRepository$confirmAnswer$1> continuation) {
        super(continuation);
        this.this$0 = factorAuthenticationRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r1 = this.this$0.m13confirmAnswerBWLJW6A((String) null, (String) null, (List<AnswerType>) null, this);
        return r1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r1 : Result.m19boximpl(r1);
    }
}
