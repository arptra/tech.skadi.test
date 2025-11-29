package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.fragment.base.BaseFragmentKt;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter.SpacesItemDecoration;
import sdk.meizu.account.factor.authentication.sdk.module.BuildConfigProvider;
import sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator;

@SourceDebugExtension({"SMAP\nValidateAllFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValidateAllFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateAllFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,148:1\n172#2,9:149\n*S KotlinDebug\n*F\n+ 1 ValidateAllFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateAllFragment\n*L\n51#1:149,9\n*E\n"})
@AndroidEntryPoint
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\u001a\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateAllFragment;", "Lsdk/meizu/account/factor/authentication/sdk/fragment/base/BasicAuthFragment;", "()V", "complaintsTv", "Landroid/widget/TextView;", "navigator", "Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;", "getNavigator", "()Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;", "setNavigator", "(Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewModel", "Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel;", "getViewModel", "()Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", "view", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ValidateAllFragment extends Hilt_ValidateAllFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private TextView complaintsTv;
    @Inject
    public AuthenticationNavigator navigator;
    /* access modifiers changed from: private */
    @Nullable
    public RecyclerView recyclerView;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(FactorAuthenticationViewModel.class), new ValidateAllFragment$special$$inlined$activityViewModels$default$1(this), new ValidateAllFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new ValidateAllFragment$special$$inlined$activityViewModels$default$3(this));

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateAllFragment$Companion;", "", "()V", "newInstance", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateAllFragment;", "selectorType", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ValidateAllFragment newInstance(@NotNull BasicInfoType basicInfoType) {
            Intrinsics.checkNotNullParameter(basicInfoType, "selectorType");
            ValidateAllFragment validateAllFragment = new ValidateAllFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ConstantKt.FRAGMENT_FACTOR_PARAM_TYPE, basicInfoType);
            validateAllFragment.setArguments(bundle);
            return validateAllFragment;
        }

        private Companion() {
        }
    }

    private final FactorAuthenticationViewModel getViewModel() {
        return (FactorAuthenticationViewModel) this.viewModel$delegate.getValue();
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

    public void onAttach(@NotNull Context context) {
        TextView textView;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null && (textView = (TextView) activity.findViewById(R.id.factor_title)) != null) {
            textView.setText(getString(R.string.verification_method));
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_validate_all, viewGroup, false);
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
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.all_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.addItemDecoration(new SpacesItemDecoration(recyclerView2.getResources().getDimensionPixelOffset(R.dimen.adapter_item_spacing)));
        this.recyclerView = recyclerView2;
        TextView textView = (TextView) view.findViewById(R.id.all_complaints);
        if (textView != null) {
            String string = ContextCompat.getString(textView.getContext(), R.string.complaints);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = ContextCompat.getString(textView.getContext(), R.string._complaints);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            SpannableString spannableString = new SpannableString(string);
            String str = string;
            String str2 = string2;
            spannableString.setSpan(new ValidateAllFragment$onViewCreated$2$1$1(textView), StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null), StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null) + string2.length(), 18);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            int i = 0;
            textView.setHighlightColor(0);
            BuildConfigProvider buildConfigProvider = FactorAuthenticationUtil.INSTANCE.getBuildConfigProvider();
            if (buildConfigProvider != null && buildConfigProvider.isOverseas()) {
                i = 8;
            }
            textView.setVisibility(i);
        } else {
            textView = null;
        }
        this.complaintsTv = textView;
        BaseFragmentKt.collectLifecycleFlow(this, getViewModel().getValidateUiState(), new ValidateAllFragment$onViewCreated$3(this, (Continuation<? super ValidateAllFragment$onViewCreated$3>) null));
    }

    public final void setNavigator(@NotNull AuthenticationNavigator authenticationNavigator) {
        Intrinsics.checkNotNullParameter(authenticationNavigator, "<set-?>");
        this.navigator = authenticationNavigator;
    }
}
