package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt;
import sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaManager;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;
import sdk.meizu.account.factor.authentication.sdk.view.VCodeEditLayout;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"sdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeFragment$onViewCreated$4", "Lsdk/meizu/account/factor/authentication/sdk/captcha/CaptchaManager$Callback;", "onFail", "", "msg", "", "onSuccess", "data", "Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VerificationCodeFragment$onViewCreated$4 implements CaptchaManager.Callback {
    final /* synthetic */ VerificationCodeFragment this$0;

    public VerificationCodeFragment$onViewCreated$4(VerificationCodeFragment verificationCodeFragment) {
        this.this$0 = verificationCodeFragment;
    }

    public void onFail(@Nullable String str) {
        VCodeEditLayout access$getEditLayout$p = this.this$0.editLayout;
        if (access$getEditLayout$p != null) {
            access$getEditLayout$p.showError(str);
        }
    }

    public void onSuccess(@Nullable GeetestData geetestData) {
        this.this$0.getVCodeModel().getVCode(FactorAuthenticationActivityKt.getParamToken(), this.this$0.getBasicType(), geetestData);
    }
}
