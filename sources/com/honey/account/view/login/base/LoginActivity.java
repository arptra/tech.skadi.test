package com.honey.account.view.login.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.honey.account.AccountHelper;
import com.honey.account.R;
import com.honey.account.country.CountryActivity;
import com.honey.account.m2.a;
import com.honey.account.m2.b;
import com.honey.account.m2.c;
import com.honey.account.view.AccountAlertDialog;
import com.honey.account.view.BaseCompatActivity;
import com.honey.account.view.helper.DialogHelperKt;
import com.honey.account.view.helper.PolicyAgreementStringBuilder;
import com.honey.account.view.widget.AccountEditLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H&J\"\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0012\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010,\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\"H&J\u0018\u00100\u001a\u00020\"2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\"02H\u0005J\u0012\u00103\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u000105H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8DX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128DX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00066"}, d2 = {"Lcom/honey/account/view/login/base/LoginActivity;", "Lcom/honey/account/view/BaseCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "accountEditLayout", "Lcom/honey/account/view/widget/AccountEditLayout;", "getAccountEditLayout", "()Lcom/honey/account/view/widget/AccountEditLayout;", "accountEditLayout$delegate", "Lkotlin/Lazy;", "agreementCheckBox", "Landroid/widget/CheckBox;", "getAgreementCheckBox", "()Landroid/widget/CheckBox;", "agreementCheckBox$delegate", "agreementDialog", "Lcom/honey/account/view/AccountAlertDialog;", "agreementTv", "Landroid/widget/TextView;", "getAgreementTv", "()Landroid/widget/TextView;", "agreementTv$delegate", "otherLoginView", "Landroid/view/View;", "getOtherLoginView", "()Landroid/view/View;", "otherLoginView$delegate", "policyAgreementText", "Lcom/honey/account/view/helper/PolicyAgreementStringBuilder;", "getPolicyAgreementText", "()Lcom/honey/account/view/helper/PolicyAgreementStringBuilder;", "setPolicyAgreementText", "(Lcom/honey/account/view/helper/PolicyAgreementStringBuilder;)V", "bindView", "", "confirm", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "otherLogin", "showAgreementDialog", "agreeCallback", "Lkotlin/Function0;", "showError", "error", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class LoginActivity extends BaseCompatActivity implements View.OnClickListener {
    @NotNull
    private final Lazy accountEditLayout$delegate = LazyKt.lazy(new LoginActivity$accountEditLayout$2(this));
    @NotNull
    private final Lazy agreementCheckBox$delegate = LazyKt.lazy(new LoginActivity$agreementCheckBox$2(this));
    @Nullable
    private AccountAlertDialog agreementDialog;
    @NotNull
    private final Lazy agreementTv$delegate = LazyKt.lazy(new LoginActivity$agreementTv$2(this));
    @NotNull
    private final Lazy otherLoginView$delegate = LazyKt.lazy(new LoginActivity$otherLoginView$2(this));
    @Nullable
    private PolicyAgreementStringBuilder policyAgreementText;

    /* access modifiers changed from: private */
    public static final void bindView$lambda$2(LoginActivity loginActivity, View view) {
        Intrinsics.checkNotNullParameter(loginActivity, "this$0");
        loginActivity.startActivityForResult(new Intent(loginActivity, CountryActivity.class), 9);
    }

    private final View getOtherLoginView() {
        Object value = this.otherLoginView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (View) value;
    }

    public static /* synthetic */ void showAgreementDialog$default(LoginActivity loginActivity, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function0 = new LoginActivity$showAgreementDialog$1(loginActivity);
            }
            loginActivity.showAgreementDialog(function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAgreementDialog");
    }

    /* access modifiers changed from: private */
    public static final void showAgreementDialog$lambda$4(LoginActivity loginActivity, View view) {
        Intrinsics.checkNotNullParameter(loginActivity, "this$0");
        loginActivity.getAgreementCheckBox().setChecked(false);
        AccountAlertDialog accountAlertDialog = loginActivity.agreementDialog;
        if (accountAlertDialog != null) {
            accountAlertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void showAgreementDialog$lambda$5(LoginActivity loginActivity, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(loginActivity, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$agreeCallback");
        loginActivity.getAgreementCheckBox().setChecked(true);
        AccountAlertDialog accountAlertDialog = loginActivity.agreementDialog;
        if (accountAlertDialog != null) {
            accountAlertDialog.dismiss();
        }
        function0.invoke();
    }

    public void bindView() {
        TextView agreementTv = getAgreementTv();
        PolicyAgreementStringBuilder policyAgreementStringBuilder = this.policyAgreementText;
        agreementTv.setText(policyAgreementStringBuilder != null ? policyAgreementStringBuilder.create(R.string.agreement) : null);
        TextView agreementTv2 = getAgreementTv();
        agreementTv2.setMovementMethod(LinkMovementMethod.getInstance());
        int i = 0;
        agreementTv2.setHighlightColor(0);
        agreementTv2.setOnClickListener(this);
        View otherLoginView = getOtherLoginView();
        if (!AccountHelper.INSTANCE.isShowPasswordLogin()) {
            i = 8;
        }
        otherLoginView.setVisibility(i);
        otherLoginView.setOnClickListener(this);
        getAccountEditLayout().getAreaCodeLayout().setOnClickListener(new a(this));
    }

    public abstract void confirm();

    @NotNull
    public final AccountEditLayout getAccountEditLayout() {
        Object value = this.accountEditLayout$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (AccountEditLayout) value;
    }

    @NotNull
    public final CheckBox getAgreementCheckBox() {
        Object value = this.agreementCheckBox$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (CheckBox) value;
    }

    @NotNull
    public final TextView getAgreementTv() {
        Object value = this.agreementTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    @Nullable
    public final PolicyAgreementStringBuilder getPolicyAgreementText() {
        return this.policyAgreementText;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.honey.account.country.data.CountryData} */
    /* JADX WARNING: type inference failed for: r3v2, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r3, int r4, @org.jetbrains.annotations.Nullable android.content.Intent r5) {
        /*
            r2 = this;
            super.onActivityResult(r3, r4, r5)
            r0 = -1
            if (r4 == r0) goto L_0x0007
            return
        L_0x0007:
            if (r3 == 0) goto L_0x003f
            r4 = 1
            if (r3 == r4) goto L_0x003f
            r4 = 9
            if (r3 == r4) goto L_0x0019
            r4 = 100
            if (r3 == r4) goto L_0x0015
            goto L_0x0042
        L_0x0015:
            r2.setResultOKAndFinish(r5)
            return
        L_0x0019:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 33
            r0 = 0
            java.lang.String r1 = "CountryData"
            if (r3 < r4) goto L_0x002e
            if (r5 == 0) goto L_0x0037
            java.lang.Class<com.honey.account.country.data.CountryData> r3 = com.honey.account.country.data.CountryData.class
            java.lang.Object r3 = r5.getParcelableExtra(r1, r3)
            r0 = r3
            com.honey.account.country.data.CountryData r0 = (com.honey.account.country.data.CountryData) r0
            goto L_0x0037
        L_0x002e:
            if (r5 == 0) goto L_0x0037
            android.os.Parcelable r3 = r5.getParcelableExtra(r1)
            r0 = r3
            com.honey.account.country.data.CountryData r0 = (com.honey.account.country.data.CountryData) r0
        L_0x0037:
            com.honey.account.view.widget.AccountEditLayout r2 = r2.getAccountEditLayout()
            r2.setCountryData(r0)
            goto L_0x0042
        L_0x003f:
            r2.setResultOKAndFinish(r5)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.view.login.base.LoginActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onClick(@Nullable View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i = R.id.tv_agreement;
        if (valueOf != null && valueOf.intValue() == i) {
            getAgreementCheckBox().setChecked(!getAgreementCheckBox().isChecked());
            return;
        }
        int i2 = R.id.view_other_login;
        if (valueOf != null && valueOf.intValue() == i2) {
            otherLogin();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.policyAgreementText = new PolicyAgreementStringBuilder(this, new LoginActivity$onCreate$1(this));
    }

    public abstract void otherLogin();

    public final void setPolicyAgreementText(@Nullable PolicyAgreementStringBuilder policyAgreementStringBuilder) {
        this.policyAgreementText = policyAgreementStringBuilder;
    }

    @SuppressLint({"InflateParams"})
    public final void showAgreementDialog(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "agreeCallback");
        SpannableString spannableString = null;
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_agreement, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_dialog_agreement);
        PolicyAgreementStringBuilder policyAgreementStringBuilder = this.policyAgreementText;
        if (policyAgreementStringBuilder != null) {
            spannableString = policyAgreementStringBuilder.create(R.string.service_privacy_message);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        b bVar = new b(this);
        c cVar = new c(this, function0);
        String string = getResources().getString(R.string.service_privacy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getResources().getString(R.string.refuse);
        String string3 = getResources().getString(R.string.agree);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.agreementDialog = DialogHelperKt.showAccountDialog(this, string, inflate, string2, string3, bVar, cVar);
    }

    public void showError(@Nullable String str) {
        getAccountEditLayout().showError(str);
    }
}
