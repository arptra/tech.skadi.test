package com.honey.account.view.login.validate;

import com.honey.account.data.GeetestData;
import com.honey.account.manager.CaptchaManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nValidateAccountActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValidateAccountActivity.kt\ncom/honey/account/view/login/validate/ValidateAccountActivity$onStart$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,274:1\n1#2:275\n*E\n"})
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/honey/account/view/login/validate/ValidateAccountActivity$onStart$1", "Lcom/honey/account/manager/CaptchaManager$Callback;", "getAccount", "", "isAgreement", "", "agreeCallback", "Lkotlin/Function0;", "", "onFail", "msg", "onSuccess", "data", "Lcom/honey/account/data/GeetestData;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ValidateAccountActivity$onStart$1 implements CaptchaManager.Callback {
    final /* synthetic */ ValidateAccountActivity this$0;

    public ValidateAccountActivity$onStart$1(ValidateAccountActivity validateAccountActivity) {
        this.this$0 = validateAccountActivity;
    }

    @NotNull
    public String getAccount() {
        String access$getMAccount$p = this.this$0.mAccount;
        return access$getMAccount$p == null ? "" : access$getMAccount$p;
    }

    public boolean isAgreement(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "agreeCallback");
        return true;
    }

    public void onFail(@Nullable String str) {
        this.this$0.showErrorMsg(str);
    }

    public void onSuccess(@Nullable GeetestData geetestData) {
        String access$getMAccount$p = this.this$0.mAccount;
        if (access$getMAccount$p != null) {
            this.this$0.getViewModel().getVCode(access$getMAccount$p, geetestData);
        }
    }
}
