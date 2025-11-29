package sdk.meizu.account.factor.authentication.sdk.fragment.login_account;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaManager;
import sdk.meizu.account.factor.authentication.sdk.common.widget.MzButton;

@SourceDebugExtension({"SMAP\nLoginAccountFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoginAccountFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/login_account/LoginAccountFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,106:1\n172#2,9:107\n*S KotlinDebug\n*F\n+ 1 LoginAccountFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/login_account/LoginAccountFragment\n*L\n34#1:107,9\n*E\n"})
@AndroidEntryPoint
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/login_account/LoginAccountFragment;", "Lsdk/meizu/account/factor/authentication/sdk/fragment/base/BaseFragment;", "()V", "accountEdit", "Landroid/widget/EditText;", "errorTv", "Landroid/widget/TextView;", "nextBtn", "Lsdk/meizu/account/factor/authentication/sdk/common/widget/MzButton;", "viewModel", "Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel;", "getViewModel", "()Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", "view", "showError", "error", "", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LoginAccountFragment extends Hilt_LoginAccountFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public EditText accountEdit;
    @Nullable
    private TextView errorTv;
    @Nullable
    private MzButton nextBtn;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(FactorAuthenticationViewModel.class), new LoginAccountFragment$special$$inlined$activityViewModels$default$1(this), new LoginAccountFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new LoginAccountFragment$special$$inlined$activityViewModels$default$3(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/login_account/LoginAccountFragment$Companion;", "", "()V", "newInstance", "Lsdk/meizu/account/factor/authentication/sdk/fragment/login_account/LoginAccountFragment;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LoginAccountFragment newInstance() {
            return new LoginAccountFragment();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final FactorAuthenticationViewModel getViewModel() {
        return (FactorAuthenticationViewModel) this.viewModel$delegate.getValue();
    }

    public void onAttach(@NotNull Context context) {
        TextView textView;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null && (textView = (TextView) activity.findViewById(R.id.factor_title)) != null) {
            textView.setText(getString(R.string.enter_account));
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_login_account, viewGroup, false);
    }

    public void onDetach() {
        TextView textView;
        super.onDetach();
        FragmentActivity activity = getActivity();
        if (activity != null && (textView = (TextView) activity.findViewById(R.id.factor_title)) != null) {
            textView.setText(getString(R.string.verify_identity));
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.accountEdit = (EditText) view.findViewById(R.id.login_account_edit);
        this.errorTv = (TextView) view.findViewById(R.id.login_account_error);
        this.nextBtn = (MzButton) view.findViewById(R.id.next);
        CaptchaManager captchaManager = CaptchaManager.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        MzButton mzButton = this.nextBtn;
        Intrinsics.checkNotNull(mzButton);
        captchaManager.bind(requireActivity, mzButton, new LoginAccountFragment$onViewCreated$1(this));
    }

    public final void showError(@Nullable String str) {
        if (str != null) {
            TextView textView = this.errorTv;
            if (textView != null) {
                textView.setText(str);
                textView.setVisibility(0);
            } else {
                textView = null;
            }
            if (textView != null) {
                return;
            }
        }
        TextView textView2 = this.errorTv;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }
}
