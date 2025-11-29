package com.honey.account.view.login.vcode;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.lifecycle.ViewModelLazy;
import com.honey.account.R;
import com.honey.account.manager.CaptchaManager;
import com.honey.account.view.helper.ActivityGotoHelperKt;
import com.honey.account.view.login.base.VerificationCodeViewModel;
import com.honey.account.view.widget.AccountEditLayout;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000fH\u0014J\b\u0010\u0019\u001a\u00020\u000fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/honey/account/view/login/vcode/VCodeLoginActivity;", "Lcom/honey/account/view/login/base/LoginActivity;", "()V", "getVCodeBtn", "Landroid/widget/Button;", "getGetVCodeBtn", "()Landroid/widget/Button;", "getVCodeBtn$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/honey/account/view/login/base/VerificationCodeViewModel;", "getViewModel", "()Lcom/honey/account/view/login/base/VerificationCodeViewModel;", "viewModel$delegate", "bindView", "", "confirm", "initData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onStart", "otherLogin", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVCodeLoginActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VCodeLoginActivity.kt\ncom/honey/account/view/login/vcode/VCodeLoginActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,125:1\n75#2,13:126\n*S KotlinDebug\n*F\n+ 1 VCodeLoginActivity.kt\ncom/honey/account/view/login/vcode/VCodeLoginActivity\n*L\n27#1:126,13\n*E\n"})
@AndroidEntryPoint
public final class VCodeLoginActivity extends Hilt_VCodeLoginActivity {
    @NotNull
    private final Lazy getVCodeBtn$delegate = LazyKt.lazy(new VCodeLoginActivity$getVCodeBtn$2(this));
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VerificationCodeViewModel.class), new VCodeLoginActivity$special$$inlined$viewModels$default$2(this), new VCodeLoginActivity$special$$inlined$viewModels$default$1(this), new VCodeLoginActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    /* access modifiers changed from: private */
    public final Button getGetVCodeBtn() {
        Object value = this.getVCodeBtn$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* access modifiers changed from: private */
    public final VerificationCodeViewModel getViewModel() {
        return (VerificationCodeViewModel) this.viewModel$delegate.getValue();
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

    public void bindView() {
        super.bindView();
        getAccountEditLayout().setTextWatcher(new VCodeLoginActivity$bindView$1(this));
    }

    public void confirm() {
        CaptchaManager.INSTANCE.requestCaptcha(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vcode_login);
        bindView();
        initData();
        collectLifecycleFlow(this, getViewModel().getSmsCodeUiState(), new VCodeLoginActivity$onCreate$1(this, (Continuation<? super VCodeLoginActivity$onCreate$1>) null));
    }

    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        initData();
    }

    public void onStart() {
        super.onStart();
        CaptchaManager.INSTANCE.bind(this, getGetVCodeBtn(), new VCodeLoginActivity$onStart$1(this));
    }

    public void otherLogin() {
        ActivityGotoHelperKt.startPasswordLoginActivityForResult(this, getAccountEditLayout().getAccount());
    }
}
