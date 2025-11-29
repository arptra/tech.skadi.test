package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaManager;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.fragment.base.BaseFragmentKt;
import sdk.meizu.account.factor.authentication.sdk.view.VCodeEditLayout;

@SourceDebugExtension({"SMAP\nVerificationCodeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerificationCodeFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,104:1\n106#2,15:105\n*S KotlinDebug\n*F\n+ 1 VerificationCodeFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeFragment\n*L\n37#1:105,15\n*E\n"})
@AndroidEntryPoint
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeFragment;", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/BasicAuthenticationFragment;", "()V", "editLayout", "Lsdk/meizu/account/factor/authentication/sdk/view/VCodeEditLayout;", "vCodeModel", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeViewModel;", "getVCodeModel", "()Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeViewModel;", "vCodeModel$delegate", "Lkotlin/Lazy;", "getValidateCode", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showError", "error", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VerificationCodeFragment extends Hilt_VerificationCodeFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public VCodeEditLayout editLayout;
    @NotNull
    private final Lazy vCodeModel$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeFragment$Companion;", "", "()V", "newInstance", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeFragment;", "type", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VerificationCodeFragment newInstance(@NotNull BasicInfoType basicInfoType) {
            Intrinsics.checkNotNullParameter(basicInfoType, "type");
            VerificationCodeFragment verificationCodeFragment = new VerificationCodeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ConstantKt.FRAGMENT_FACTOR_PARAM_TYPE, basicInfoType);
            verificationCodeFragment.setArguments(bundle);
            return verificationCodeFragment;
        }

        private Companion() {
        }
    }

    public VerificationCodeFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new VerificationCodeFragment$special$$inlined$viewModels$default$2(new VerificationCodeFragment$special$$inlined$viewModels$default$1(this)));
        this.vCodeModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(VerificationCodeViewModel.class), new VerificationCodeFragment$special$$inlined$viewModels$default$3(lazy), new VerificationCodeFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new VerificationCodeFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    /* access modifiers changed from: private */
    public final VerificationCodeViewModel getVCodeModel() {
        return (VerificationCodeViewModel) this.vCodeModel$delegate.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getText();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getValidateCode() {
        /*
            r0 = this;
            sdk.meizu.account.factor.authentication.sdk.view.VCodeEditLayout r0 = r0.editLayout
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getText()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeFragment.getValidateCode():java.lang.String");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_verification_code, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        VCodeEditLayout vCodeEditLayout = (VCodeEditLayout) view.findViewById(R.id.vcode_edit);
        String string = getString(R.string.vcode_edit_hint_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{getBasicType().getValidateAccount()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        vCodeEditLayout.bindTitle(format);
        vCodeEditLayout.bindTextChangedListener(new VerificationCodeFragment$onViewCreated$1$1(this));
        this.editLayout = vCodeEditLayout;
        TextView textView = null;
        BaseFragmentKt.collectLifecycleFlow(this, getVCodeModel().getVCodeTimeDownFlow(), new VerificationCodeFragment$onViewCreated$2(this, (Continuation<? super VerificationCodeFragment$onViewCreated$2>) null));
        BaseFragmentKt.collectLifecycleFlow(this, getVCodeModel().getVCodeUiState(), new VerificationCodeFragment$onViewCreated$3(this, (Continuation<? super VerificationCodeFragment$onViewCreated$3>) null));
        CaptchaManager captchaManager = CaptchaManager.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        VCodeEditLayout vCodeEditLayout2 = this.editLayout;
        if (vCodeEditLayout2 != null) {
            textView = vCodeEditLayout2.getSendVCodeTv();
        }
        Intrinsics.checkNotNull(textView);
        captchaManager.bind(requireActivity, textView, new VerificationCodeFragment$onViewCreated$4(this));
    }

    public void showError(@Nullable String str) {
        VCodeEditLayout vCodeEditLayout = this.editLayout;
        if (vCodeEditLayout != null) {
            vCodeEditLayout.showError(str);
        }
    }
}
