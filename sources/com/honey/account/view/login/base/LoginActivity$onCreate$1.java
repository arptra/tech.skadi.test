package com.honey.account.view.login.base;

import android.content.Context;
import com.honey.account.R;
import com.honey.account.manager.PrivacyManager;
import com.honey.account.view.helper.PolicyAgreementStringBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/honey/account/view/login/base/LoginActivity$onCreate$1", "Lcom/honey/account/view/helper/PolicyAgreementStringBuilder$OnClickListener;", "onPrivacyPolicyClick", "", "context", "Landroid/content/Context;", "onUserAgreementClick", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LoginActivity$onCreate$1 implements PolicyAgreementStringBuilder.OnClickListener {
    final /* synthetic */ LoginActivity this$0;

    public LoginActivity$onCreate$1(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public void onPrivacyPolicyClick(@Nullable Context context) {
        PrivacyManager privacyManager = PrivacyManager.INSTANCE;
        LoginActivity loginActivity = this.this$0;
        String string = loginActivity.getResources().getString(R.string.honey_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        privacyManager.openOnlinePolicy(loginActivity, string, "pp");
    }

    public void onUserAgreementClick(@Nullable Context context) {
        PrivacyManager privacyManager = PrivacyManager.INSTANCE;
        LoginActivity loginActivity = this.this$0;
        String string = loginActivity.getResources().getString(R.string.honey_service_agreement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        privacyManager.openOnlinePolicy(loginActivity, string, "aup");
    }
}
