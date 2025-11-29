package sdk.meizu.account.factor.authentication.sdk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FactorAuthenticationUtil$factorValidate$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FactorAuthenticationUtil.FactorValidateListener $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FactorAuthenticationUtil$factorValidate$1$2(FactorAuthenticationUtil.FactorValidateListener factorValidateListener) {
        super(0);
        this.$listener = factorValidateListener;
    }

    public final void invoke() {
        this.$listener.failure("data is null.");
    }
}
