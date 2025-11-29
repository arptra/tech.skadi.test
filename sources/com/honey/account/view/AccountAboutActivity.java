package com.honey.account.view;

import android.os.Bundle;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.honey.account.R;
import com.honey.account.manager.PrivacyManager;
import com.honey.account.view.helper.ActivityGotoHelperKt;
import com.honey.account.view.widget.OptionItemLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR#\u0010\u000e\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/honey/account/view/AccountAboutActivity;", "Lcom/honey/account/view/BaseCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "mLlAccountCancellation", "Lcom/honey/account/view/widget/OptionItemLayout;", "kotlin.jvm.PlatformType", "getMLlAccountCancellation", "()Lcom/honey/account/view/widget/OptionItemLayout;", "mLlAccountCancellation$delegate", "Lkotlin/Lazy;", "mLlAccountPrivacy", "getMLlAccountPrivacy", "mLlAccountPrivacy$delegate", "mLlAccountService", "getMLlAccountService", "mLlAccountService$delegate", "bindListener", "", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountAboutActivity extends BaseCompatActivity implements View.OnClickListener {
    @NotNull
    private final Lazy mLlAccountCancellation$delegate = LazyKt.lazy(new AccountAboutActivity$mLlAccountCancellation$2(this));
    @NotNull
    private final Lazy mLlAccountPrivacy$delegate = LazyKt.lazy(new AccountAboutActivity$mLlAccountPrivacy$2(this));
    @NotNull
    private final Lazy mLlAccountService$delegate = LazyKt.lazy(new AccountAboutActivity$mLlAccountService$2(this));

    private final void bindListener() {
        getMLlAccountService().setOnClickListener(this);
        getMLlAccountPrivacy().setOnClickListener(this);
        getMLlAccountCancellation().setOnClickListener(this);
    }

    private final OptionItemLayout getMLlAccountCancellation() {
        return (OptionItemLayout) this.mLlAccountCancellation$delegate.getValue();
    }

    private final OptionItemLayout getMLlAccountPrivacy() {
        return (OptionItemLayout) this.mLlAccountPrivacy$delegate.getValue();
    }

    private final OptionItemLayout getMLlAccountService() {
        return (OptionItemLayout) this.mLlAccountService$delegate.getValue();
    }

    public void onClick(@Nullable View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i = R.id.ll_account_service;
        if (valueOf != null && valueOf.intValue() == i) {
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            String string = getResources().getString(R.string.honey_service_agreement);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            privacyManager.openOnlinePolicy(this, string, "aup");
            return;
        }
        int i2 = R.id.ll_account_privacy;
        if (valueOf != null && valueOf.intValue() == i2) {
            PrivacyManager privacyManager2 = PrivacyManager.INSTANCE;
            String string2 = getResources().getString(R.string.honey_privacy_policy);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            privacyManager2.openOnlinePolicy(this, string2, "pp");
            return;
        }
        int i3 = R.id.ll_account_cancellation;
        if (valueOf != null && valueOf.intValue() == i3) {
            ActivityGotoHelperKt.startAccountCancellationActivity(this);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_about_layout);
        getMLlAccountCancellation().setMainTitleColor(ResourcesCompat.d(getResources(), R.color.honey_error, getTheme()));
        bindListener();
    }
}
