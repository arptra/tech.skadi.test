package com.honey.account.view.login.pwd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.honey.account.R;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.n2.a;
import com.honey.account.usagestats.UsageEvent;
import com.honey.account.utils.coroutine.CoroutineUtilsKt;
import com.honey.account.utils.network.NetworkUtilsKt;
import com.honey.account.utils.system.InputMethodUtilsKt;
import com.honey.account.view.helper.ActivityGotoHelperKt;
import com.honey.account.view.login.base.LoginActivity;
import com.honey.account.view.widget.AccountEditLayout;
import com.honey.account.view.widget.PasswordEditLayout;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u000f\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\"\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u001aH\u0014J\b\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0016J\u0012\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006*"}, d2 = {"Lcom/honey/account/view/login/pwd/PasswordLoginActivity;", "Lcom/honey/account/view/login/base/LoginActivity;", "()V", "loginBtn", "Landroid/widget/Button;", "getLoginBtn", "()Landroid/widget/Button;", "loginBtn$delegate", "Lkotlin/Lazy;", "passwordEdit", "Lcom/honey/account/view/widget/PasswordEditLayout;", "getPasswordEdit", "()Lcom/honey/account/view/widget/PasswordEditLayout;", "passwordEdit$delegate", "textWatch", "com/honey/account/view/login/pwd/PasswordLoginActivity$textWatch$1", "Lcom/honey/account/view/login/pwd/PasswordLoginActivity$textWatch$1;", "bindView", "", "confirm", "initData", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onStartLogin", "onStopLogin", "otherLogin", "showError", "error", "", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class PasswordLoginActivity extends Hilt_PasswordLoginActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "PasswordLoginActivity";
    @NotNull
    private final Lazy loginBtn$delegate = LazyKt.lazy(new PasswordLoginActivity$loginBtn$2(this));
    @NotNull
    private final Lazy passwordEdit$delegate = LazyKt.lazy(new PasswordLoginActivity$passwordEdit$2(this));
    @NotNull
    private final PasswordLoginActivity$textWatch$1 textWatch = new PasswordLoginActivity$textWatch$1(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/honey/account/view/login/pwd/PasswordLoginActivity$Companion;", "", "()V", "TAG", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final Button getLoginBtn() {
        Object value = this.loginBtn$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* access modifiers changed from: private */
    public final PasswordEditLayout getPasswordEdit() {
        Object value = this.passwordEdit$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PasswordEditLayout) value;
    }

    private final void initData() {
        String stringExtra = getIntent().getStringExtra("phone");
        AccountEditLayout accountEditLayout = getAccountEditLayout();
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNull(stringExtra);
        accountEditLayout.setAccount(stringExtra);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(PasswordLoginActivity passwordLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(passwordLoginActivity, "this$0");
        UsageEvent.onEventLib$default(UsageEvent.INSTANCE, "click_reset_psw", TAG, (Map) null, 4, (Object) null);
        ActivityGotoHelperKt.startForgetPasswordActivity(passwordLoginActivity);
    }

    private final void onStartLogin() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        EditText edit = getAccountEditLayout().getEdit();
        EditText edit2 = getPasswordEdit().getEdit();
        Intrinsics.checkNotNullExpressionValue(edit2, "getEdit(...)");
        InputMethodUtilsKt.closeInputMethod(applicationContext, edit, edit2);
        showError((String) null);
        getLoginBtn().setText(R.string.logining);
    }

    /* access modifiers changed from: private */
    public final void onStopLogin() {
        getLoginBtn().setText(R.string.login);
    }

    public void bindView() {
        super.bindView();
        getAccountEditLayout().setTextWatcher(this.textWatch);
        getPasswordEdit().addPasswordEditTextWatcher(this.textWatch);
    }

    public void confirm() {
        if (!getAgreementCheckBox().isChecked()) {
            LoginActivity.showAgreementDialog$default(this, (Function0) null, 1, (Object) null);
            return;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (!NetworkUtilsKt.isNetworkConnected(applicationContext)) {
            showError(getString(R.string.not_network));
            return;
        }
        UsageEvent.onEventLib$default(UsageEvent.INSTANCE, "click_pwd_login", TAG, (Map) null, 4, (Object) null);
        String accountInAreaCode = getAccountEditLayout().getAccountInAreaCode();
        String text = getPasswordEdit().getText();
        onStartLogin();
        CoroutineUtilsKt.launchMain(new PasswordLoginActivity$confirm$1(this, accountInAreaCode, text, (Continuation<? super PasswordLoginActivity$confirm$1>) null));
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str;
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 3) {
            String str2 = "";
            if (intent == null || (str = intent.getStringExtra("phone")) == null) {
                str = str2;
            }
            if (!(intent == null || (stringExtra = intent.getStringExtra(AccountConstantKt.INTENT_PARAM_PASSWORD)) == null)) {
                str2 = stringExtra;
            }
            getAccountEditLayout().setAccount(str);
            getPasswordEdit().getEdit().setText(str2);
        }
    }

    public void onClick(@Nullable View view) {
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i = R.id.btn_login;
        if (valueOf != null && valueOf.intValue() == i) {
            confirm();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_password_login);
        bindView();
        initData();
        getLoginBtn().setOnClickListener(this);
        getPasswordEdit().setOnForgetClickListener(new a(this));
        getPasswordEdit().setOnEditorActionListener(new PasswordLoginActivity$onCreate$2(this));
    }

    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        initData();
    }

    public void otherLogin() {
        ActivityGotoHelperKt.startVerificationCodeLoginActivityForResult(this, getAccountEditLayout().getAccount());
    }

    public void showError(@Nullable String str) {
        getPasswordEdit().showError(str);
    }
}
