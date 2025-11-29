package com.honey.account.view.login.vcode;

import com.honey.account.data.GeetestData;
import com.honey.account.manager.CaptchaManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/honey/account/view/login/vcode/VCodeLoginActivity$onStart$1", "Lcom/honey/account/manager/CaptchaManager$Callback;", "getAccount", "", "isAgreement", "", "agreeCallback", "Lkotlin/Function0;", "", "onFail", "msg", "onSuccess", "data", "Lcom/honey/account/data/GeetestData;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VCodeLoginActivity$onStart$1 implements CaptchaManager.Callback {
    final /* synthetic */ VCodeLoginActivity this$0;

    public VCodeLoginActivity$onStart$1(VCodeLoginActivity vCodeLoginActivity) {
        this.this$0 = vCodeLoginActivity;
    }

    @NotNull
    public String getAccount() {
        return this.this$0.getAccountEditLayout().getAccountInAreaCode();
    }

    public boolean isAgreement(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "agreeCallback");
        if (!this.this$0.getAgreementCheckBox().isChecked()) {
            this.this$0.showAgreementDialog(function0);
        }
        return this.this$0.getAgreementCheckBox().isChecked();
    }

    public void onFail(@Nullable String str) {
        this.this$0.showError(str);
    }

    public void onSuccess(@Nullable GeetestData geetestData) {
        this.this$0.getViewModel().getVCode(getAccount(), geetestData);
    }
}
