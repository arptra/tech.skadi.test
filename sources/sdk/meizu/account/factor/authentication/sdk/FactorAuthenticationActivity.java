package sdk.meizu.account.factor.authentication.sdk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelLazy;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;
import sdk.meizu.account.factor.authentication.sdk.constant.Mode;
import sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;
import sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData;
import sdk.meizu.account.factor.authentication.sdk.fragment.login_account.LoginAccountFragment;
import sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator;
import sdk.meizu.account.factor.authentication.sdk.navigator.Screens;
import sdk.meizu.account.factor.authentication.sdk.system.PageStyleKt;
import sdk.meizu.account.factor.authentication.sdk.view.LoadingState;
import sdk.meizu.account.factor.authentication.sdk.view.LoadingView;

@SourceDebugExtension({"SMAP\nFactorAuthenticationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FactorAuthenticationActivity.kt\nsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,299:1\n75#2,13:300\n*S KotlinDebug\n*F\n+ 1 FactorAuthenticationActivity.kt\nsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationActivity\n*L\n73#1:300,13\n*E\n"})
@AndroidEntryPoint
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020%H\u0017J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\u0012\u00105\u001a\u00020%2\n\b\u0002\u00106\u001a\u0004\u0018\u00010(R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b!\u0010\"¨\u00068"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "cancelTv", "Landroid/widget/TextView;", "getCancelTv", "()Landroid/widget/TextView;", "cancelTv$delegate", "Lkotlin/Lazy;", "frameLayout", "Landroid/widget/FrameLayout;", "getFrameLayout", "()Landroid/widget/FrameLayout;", "frameLayout$delegate", "loadingView", "Lsdk/meizu/account/factor/authentication/sdk/view/LoadingView;", "getLoadingView", "()Lsdk/meizu/account/factor/authentication/sdk/view/LoadingView;", "loadingView$delegate", "navigator", "Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;", "getNavigator", "()Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;", "setNavigator", "(Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar$delegate", "viewModel", "Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel;", "getViewModel", "()Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel;", "viewModel$delegate", "answerValidateSuccess", "", "cancelPage", "code", "", "handlerError", "", "message", "initLoading", "loadingData", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "validateSuccess", "validateCode", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FactorAuthenticationActivity extends Hilt_FactorAuthenticationActivity implements View.OnClickListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "FactorAuthenticationActivity";
    @NotNull
    private final Lazy cancelTv$delegate = LazyKt.lazy(new FactorAuthenticationActivity$cancelTv$2(this));
    @NotNull
    private final Lazy frameLayout$delegate = LazyKt.lazy(new FactorAuthenticationActivity$frameLayout$2(this));
    @NotNull
    private final Lazy loadingView$delegate = LazyKt.lazy(new FactorAuthenticationActivity$loadingView$2(this));
    @Inject
    public AuthenticationNavigator navigator;
    @NotNull
    private final Lazy toolbar$delegate = LazyKt.lazy(new FactorAuthenticationActivity$toolbar$2(this));
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(FactorAuthenticationViewModel.class), new FactorAuthenticationActivity$special$$inlined$viewModels$default$2(this), new FactorAuthenticationActivity$special$$inlined$viewModels$default$1(this), new FactorAuthenticationActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationActivity$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void cancelPage(String str) {
        Log.d(TAG, "--- cancelPage, code: " + str);
        Intent intent = new Intent();
        intent.putExtra("message", str);
        Unit unit = Unit.INSTANCE;
        setResult(0, intent);
        finish();
    }

    private final TextView getCancelTv() {
        Object value = this.cancelTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* access modifiers changed from: private */
    public final FrameLayout getFrameLayout() {
        Object value = this.frameLayout$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FrameLayout) value;
    }

    /* access modifiers changed from: private */
    public final LoadingView getLoadingView() {
        Object value = this.loadingView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (LoadingView) value;
    }

    private final Toolbar getToolbar() {
        Object value = this.toolbar$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Toolbar) value;
    }

    private final FactorAuthenticationViewModel getViewModel() {
        return (FactorAuthenticationViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean handlerError(String str) {
        if (getNavigator().currentPage() == Screens.ACCOUNT) {
            Fragment o0 = getSupportFragmentManager().o0(R.id.main_container);
            if (o0 instanceof LoginAccountFragment) {
                getLoadingView().updateState(LoadingState.SUCCESS);
                getFrameLayout().setVisibility(0);
                ((LoginAccountFragment) o0).showError(str);
                return true;
            }
        }
        return false;
    }

    private final void initLoading() {
        FactorAuthenticationActivityKt.collectLifecycleFlow(this, getViewModel().getValidateUiState(), new FactorAuthenticationActivity$initLoading$1(this, (Continuation<? super FactorAuthenticationActivity$initLoading$1>) null));
    }

    /* access modifiers changed from: private */
    public final void loadingData() {
        Intent intent = getIntent();
        Log.d(TAG, "--- loadingStart reloading. intent.data: " + intent.getExtras(), new RuntimeException());
        String stringExtra = intent.getStringExtra(ConstantKt.FACTOR_PARAMS_TOKEN);
        String str = "";
        if (stringExtra == null) {
            stringExtra = str;
        } else {
            Intrinsics.checkNotNull(stringExtra);
        }
        FactorAuthenticationActivityKt.setParamToken(stringExtra);
        String stringExtra2 = intent.getStringExtra(ConstantKt.FACTOR_PARAMS_PROCESS_NAME);
        if (stringExtra2 == null) {
            stringExtra2 = str;
        } else {
            Intrinsics.checkNotNull(stringExtra2);
        }
        FactorAuthenticationActivityKt.setParamProcessName(stringExtra2);
        String stringExtra3 = intent.getStringExtra(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        if (stringExtra3 == null) {
            stringExtra3 = str;
        } else {
            Intrinsics.checkNotNull(stringExtra3);
        }
        FactorAuthenticationActivityKt.setParamPackageName(stringExtra3);
        String stringExtra4 = intent.getStringExtra(ConstantKt.FACTOR_PARAMS_SERVICE_NAME);
        if (stringExtra4 != null) {
            Intrinsics.checkNotNull(stringExtra4);
            str = stringExtra4;
        }
        FactorAuthenticationActivityKt.setParamServiceName(str);
        String stringExtra5 = intent.getStringExtra(ConstantKt.FACTOR_PARAMS_MODE);
        Log.d(TAG, "--- loadingStart paramMode: " + stringExtra5);
        if (stringExtra5 != null && stringExtra5.length() != 0) {
            try {
                Intrinsics.checkNotNull(stringExtra5);
                FactorAuthenticationActivityKt.setParamMode(Mode.valueOf(stringExtra5));
            } catch (Throwable unused) {
                cancelPage(FactorAuthenticationUtil.CODE_ERROR_MODE_NULL);
            }
            int intExtra = intent.getIntExtra(ConstantKt.FACTOR_PARAMS_MODE_SCENARIO, 2);
            try {
                ModeScenario.Companion companion = ModeScenario.Companion;
                ModeScenario parse = companion.parse(intExtra);
                Intrinsics.checkNotNull(parse);
                FactorAuthenticationActivityKt.setParamModeScenario(parse);
                if (!companion.isLogged(FactorAuthenticationActivityKt.getParamModeScenario()) || FactorAuthenticationActivityKt.getParamToken().length() != 0) {
                    FactorAuthenticationViewModel.getValidateTypes$default(getViewModel(), FactorAuthenticationActivityKt.getParamToken(), (GeetestData) null, 2, (Object) null);
                    Log.d(TAG, "--- loadingStart paramPackageName: " + FactorAuthenticationActivityKt.getParamPackageName() + ", paramServiceName: " + FactorAuthenticationActivityKt.getParamServiceName() + ", paramModeScenario: " + FactorAuthenticationActivityKt.getParamModeScenario());
                    return;
                }
                cancelPage(FactorAuthenticationUtil.CODE_ERROR_TOKEN_NULL);
            } catch (Throwable unused2) {
                cancelPage(FactorAuthenticationUtil.CODE_ERROR_CANCEL);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static /* synthetic */ void validateSuccess$default(FactorAuthenticationActivity factorAuthenticationActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        factorAuthenticationActivity.validateSuccess(str);
    }

    public final void answerValidateSuccess() {
        Unit unit;
        ResponseValidateData responseValidateData;
        List<BasicInfoType> userBasicInfoValidate;
        BasicInfoType basicInfoType;
        Object value = getViewModel().getValidateUiState().getValue();
        ResultUiState.Success success = value instanceof ResultUiState.Success ? (ResultUiState.Success) value : null;
        if (success == null || (responseValidateData = (ResponseValidateData) success.getData()) == null || (userBasicInfoValidate = responseValidateData.getUserBasicInfoValidate()) == null || (basicInfoType = (BasicInfoType) CollectionsKt.firstOrNull(userBasicInfoValidate)) == null) {
            unit = null;
        } else {
            getNavigator().clearAll();
            getNavigator().navigateTo(basicInfoType);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            validateSuccess$default(this, (String) null, 1, (Object) null);
        }
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

    @Deprecated(message = "Deprecated in Java")
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        Log.d(TAG, "--- onBackPressed");
        if (!getNavigator().onBackPressed()) {
            cancelPage(FactorAuthenticationUtil.CODE_ERROR_CANCEL);
        }
    }

    public void onClick(@Nullable View view) {
        if (view != null && view.getId() == R.id.cancel) {
            cancelPage(FactorAuthenticationUtil.CODE_ERROR_CANCEL);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        Unit unit;
        super.onCreate(bundle);
        setContentView(R.layout.activity_factor);
        setSupportActionBar(getToolbar());
        PageStyleKt.fitStatusBarWithUiMode(this);
        Log.d(TAG, "--- onCreate, savedInstanceState: " + bundle);
        loadingData();
        getLoadingView().setLoadingListener(new FactorAuthenticationActivity$onCreate$1(this));
        getCancelTv().setOnClickListener(this);
        if (bundle != null) {
            getNavigator().restorePage();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            getNavigator().clearAll();
            initLoading();
        }
    }

    public final void setNavigator(@NotNull AuthenticationNavigator authenticationNavigator) {
        Intrinsics.checkNotNullParameter(authenticationNavigator, "<set-?>");
        this.navigator = authenticationNavigator;
    }

    public final void validateSuccess(@Nullable String str) {
        Log.d(TAG, "--- validateSuccess");
        Intent intent = new Intent();
        intent.putExtra(ConstantKt.FACTOR_RESULT_STATE, true);
        intent.putExtra("validate_code", str);
        Unit unit = Unit.INSTANCE;
        setResult(-1, intent);
        finish();
    }
}
