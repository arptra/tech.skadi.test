package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.common.widget.MzButton;
import sdk.meizu.account.factor.authentication.sdk.fragment.base.BaseFragmentKt;
import sdk.meizu.account.factor.authentication.sdk.fragment.base.BasicAuthFragment;
import sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator;
import sdk.meizu.account.factor.authentication.sdk.navigator.Screens;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H&J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u0019H&R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/BasicAuthenticationFragment;", "Lsdk/meizu/account/factor/authentication/sdk/fragment/base/BasicAuthFragment;", "Landroid/view/View$OnClickListener;", "()V", "navigator", "Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;", "getNavigator", "()Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;", "setNavigator", "(Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;)V", "nextBtn", "Lsdk/meizu/account/factor/authentication/sdk/common/widget/MzButton;", "getNextBtn", "()Lsdk/meizu/account/factor/authentication/sdk/common/widget/MzButton;", "setNextBtn", "(Lsdk/meizu/account/factor/authentication/sdk/common/widget/MzButton;)V", "otherValidateTv", "Landroid/widget/TextView;", "viewModel", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel;", "getViewModel", "()Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getValidateCode", "", "onClick", "", "v", "Landroid/view/View;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "showError", "error", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBasicAuthenticationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicAuthenticationFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/BasicAuthenticationFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,92:1\n106#2,15:93\n*S KotlinDebug\n*F\n+ 1 BasicAuthenticationFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/BasicAuthenticationFragment\n*L\n25#1:93,15\n*E\n"})
public abstract class BasicAuthenticationFragment extends BasicAuthFragment implements View.OnClickListener {
    @Inject
    public AuthenticationNavigator navigator;
    @Nullable
    private MzButton nextBtn;
    @Nullable
    private TextView otherValidateTv;
    @NotNull
    private final Lazy viewModel$delegate;

    public BasicAuthenticationFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BasicAuthenticationFragment$special$$inlined$viewModels$default$2(new BasicAuthenticationFragment$special$$inlined$viewModels$default$1(this)));
        this.viewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(ValidateViewModel.class), new BasicAuthenticationFragment$special$$inlined$viewModels$default$3(lazy), new BasicAuthenticationFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new BasicAuthenticationFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    private final ValidateViewModel getViewModel() {
        return (ValidateViewModel) this.viewModel$delegate.getValue();
    }

    @NotNull
    public final AuthenticationNavigator getNavigator() {
        AuthenticationNavigator authenticationNavigator = this.navigator;
        if (authenticationNavigator != null) {
            return authenticationNavigator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @Nullable
    public final MzButton getNextBtn() {
        return this.nextBtn;
    }

    @NotNull
    public abstract String getValidateCode();

    public void onClick(@Nullable View view) {
        if (view != null && view.getId() == R.id.other_authentication) {
            getNavigator().navigateTo(Screens.ALL, getBasicType());
        } else if (view != null && view.getId() == R.id.next) {
            getViewModel().confirm(FactorAuthenticationActivityKt.getParamToken(), getBasicType(), FactorAuthenticationActivityKt.getParamMode(), getValidateCode());
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.other_authentication);
        textView.setOnClickListener(this);
        this.otherValidateTv = textView;
        MzButton mzButton = (MzButton) view.findViewById(R.id.next);
        mzButton.setOnClickListener(this);
        mzButton.setEnabled(false);
        this.nextBtn = mzButton;
        BaseFragmentKt.collectLifecycleFlow(this, getViewModel().getConfirmUiState(), new BasicAuthenticationFragment$onViewCreated$3(this, (Continuation<? super BasicAuthenticationFragment$onViewCreated$3>) null));
    }

    public final void setNavigator(@NotNull AuthenticationNavigator authenticationNavigator) {
        Intrinsics.checkNotNullParameter(authenticationNavigator, "<set-?>");
        this.navigator = authenticationNavigator;
    }

    public final void setNextBtn(@Nullable MzButton mzButton) {
        this.nextBtn = mzButton;
    }

    public abstract void showError(@Nullable String str);
}
