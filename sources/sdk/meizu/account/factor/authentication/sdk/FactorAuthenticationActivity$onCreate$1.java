package sdk.meizu.account.factor.authentication.sdk;

import kotlin.Metadata;
import sdk.meizu.account.factor.authentication.sdk.view.LoadingListener;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"sdk/meizu/account/factor/authentication/sdk/FactorAuthenticationActivity$onCreate$1", "Lsdk/meizu/account/factor/authentication/sdk/view/LoadingListener;", "loadingStart", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FactorAuthenticationActivity$onCreate$1 implements LoadingListener {
    final /* synthetic */ FactorAuthenticationActivity this$0;

    public FactorAuthenticationActivity$onCreate$1(FactorAuthenticationActivity factorAuthenticationActivity) {
        this.this$0 = factorAuthenticationActivity;
    }

    public void loadingStart() {
        this.this$0.loadingData();
    }
}
