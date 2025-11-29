package sdk.meizu.account.factor.authentication.sdk;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import sdk.meizu.account.factor.authentication.sdk.view.LoadingView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lsdk/meizu/account/factor/authentication/sdk/view/LoadingView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FactorAuthenticationActivity$loadingView$2 extends Lambda implements Function0<LoadingView> {
    final /* synthetic */ FactorAuthenticationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FactorAuthenticationActivity$loadingView$2(FactorAuthenticationActivity factorAuthenticationActivity) {
        super(0);
        this.this$0 = factorAuthenticationActivity;
    }

    public final LoadingView invoke() {
        return (LoadingView) this.this$0.findViewById(R.id.factor_loading);
    }
}
