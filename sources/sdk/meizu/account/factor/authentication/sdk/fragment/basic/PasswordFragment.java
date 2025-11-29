package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.view.PasswordEditLayout;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/PasswordFragment;", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/BasicAuthenticationFragment;", "()V", "editLayout", "Lsdk/meizu/account/factor/authentication/sdk/view/PasswordEditLayout;", "getValidateCode", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showError", "error", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@AndroidEntryPoint
public final class PasswordFragment extends Hilt_PasswordFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private PasswordEditLayout editLayout;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/PasswordFragment$Companion;", "", "()V", "newInstance", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/PasswordFragment;", "type", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PasswordFragment newInstance(@NotNull BasicInfoType basicInfoType) {
            Intrinsics.checkNotNullParameter(basicInfoType, "type");
            PasswordFragment passwordFragment = new PasswordFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ConstantKt.FRAGMENT_FACTOR_PARAM_TYPE, basicInfoType);
            passwordFragment.setArguments(bundle);
            return passwordFragment;
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getText();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getValidateCode() {
        /*
            r0 = this;
            sdk.meizu.account.factor.authentication.sdk.view.PasswordEditLayout r0 = r0.editLayout
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getText()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.fragment.basic.PasswordFragment.getValidateCode():java.lang.String");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_password, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        PasswordEditLayout passwordEditLayout = (PasswordEditLayout) view.findViewById(R.id.password_edit);
        String string = getString(R.string.password_edit_hint_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{getBasicType().getValidateAccount()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        passwordEditLayout.bindTitle(format);
        passwordEditLayout.bindTextChangedListener(new PasswordFragment$onViewCreated$1$1(this));
        this.editLayout = passwordEditLayout;
    }

    public void showError(@Nullable String str) {
        PasswordEditLayout passwordEditLayout = this.editLayout;
        if (passwordEditLayout != null) {
            passwordEditLayout.showError(str);
        }
    }
}
