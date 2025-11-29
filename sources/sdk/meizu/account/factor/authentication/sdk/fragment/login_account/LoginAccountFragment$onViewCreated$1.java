package sdk.meizu.account.factor.authentication.sdk.fragment.login_account;

import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel;
import sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaManager;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"sdk/meizu/account/factor/authentication/sdk/fragment/login_account/LoginAccountFragment$onViewCreated$1", "Lsdk/meizu/account/factor/authentication/sdk/captcha/CaptchaManager$Callback;", "onFail", "", "msg", "", "onSuccess", "data", "Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LoginAccountFragment$onViewCreated$1 implements CaptchaManager.Callback {
    final /* synthetic */ LoginAccountFragment this$0;

    public LoginAccountFragment$onViewCreated$1(LoginAccountFragment loginAccountFragment) {
        this.this$0 = loginAccountFragment;
    }

    public void onFail(@Nullable String str) {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Toast.makeText(requireActivity, "Captcha fail. " + str, 0).show();
    }

    public void onSuccess(@Nullable GeetestData geetestData) {
        EditText access$getAccountEdit$p = this.this$0.accountEdit;
        FactorAuthenticationActivityKt.setParamAccount(String.valueOf(access$getAccountEdit$p != null ? access$getAccountEdit$p.getText() : null));
        FactorAuthenticationViewModel.getValidateTypes$default(this.this$0.getViewModel(), (String) null, geetestData, 1, (Object) null);
    }
}
