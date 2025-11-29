package com.honey.account.view.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModelLazy;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.honey.account.R;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.controller.LoginController;
import com.honey.account.data.AccountData;
import com.honey.account.l2.a;
import com.honey.account.utils.coroutine.CoroutineUtilsKt;
import com.honey.account.utils.network.NetworkUtilsKt;
import com.honey.account.view.helper.ActivityGotoHelperKt;
import com.honey.account.view.web.WebActivity;
import com.honey.account.view.widget.OptionItemLayout;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import dagger.hilt.android.AndroidEntryPoint;
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
import sdk.meizu.account.factor.authentication.sdk.constant.Mode;
import sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario;

@SourceDebugExtension({"SMAP\nAccountHomepageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountHomepageActivity.kt\ncom/honey/account/view/home/AccountHomepageActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,289:1\n75#2,13:290\n*S KotlinDebug\n*F\n+ 1 AccountHomepageActivity.kt\ncom/honey/account/view/home/AccountHomepageActivity\n*L\n45#1:290,13\n*E\n"})
@AndroidEntryPoint
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\"\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/honey/account/view/home/AccountHomepageActivity;", "Lcom/honey/account/view/BaseCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "mIvAvatar", "Landroid/widget/ImageView;", "mLlAbout", "Lcom/honey/account/view/widget/OptionItemLayout;", "mLlAccountInfo", "Landroid/widget/LinearLayout;", "mLlBindEmail", "mLlBindPhone", "mLlChangePwd", "mLlLoginOut", "mTvAccount", "Landroid/widget/TextView;", "mTvNickName", "mViewStub", "Landroid/view/ViewStub;", "viewModel", "Lcom/honey/account/view/home/AccountHomepageViewModel;", "getViewModel", "()Lcom/honey/account/view/home/AccountHomepageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initData", "", "initView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateAccountUiState", "accountData", "Lcom/honey/account/data/AccountData;", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountHomepageActivity extends Hilt_AccountHomepageActivity implements View.OnClickListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "AccountHomepageActivity";
    private ImageView mIvAvatar;
    private OptionItemLayout mLlAbout;
    private LinearLayout mLlAccountInfo;
    private OptionItemLayout mLlBindEmail;
    private OptionItemLayout mLlBindPhone;
    private OptionItemLayout mLlChangePwd;
    private OptionItemLayout mLlLoginOut;
    private TextView mTvAccount;
    private TextView mTvNickName;
    @Nullable
    private ViewStub mViewStub;
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AccountHomepageViewModel.class), new AccountHomepageActivity$special$$inlined$viewModels$default$2(this), new AccountHomepageActivity$special$$inlined$viewModels$default$1(this), new AccountHomepageActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/honey/account/view/home/AccountHomepageActivity$Companion;", "", "()V", "TAG", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final AccountHomepageViewModel getViewModel() {
        return (AccountHomepageViewModel) this.viewModel$delegate.getValue();
    }

    private final void initData() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (NetworkUtilsKt.isNetworkConnected(applicationContext)) {
            ViewStub viewStub = this.mViewStub;
            if (viewStub != null) {
                Intrinsics.checkNotNull(viewStub);
                viewStub.setVisibility(8);
            }
            LoginController loginController = LoginController.INSTANCE;
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            String rememberMe = loginController.getRememberMe(applicationContext2);
            if (rememberMe == null || StringsKt.isBlank(rememberMe)) {
                Context applicationContext3 = getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
                startActivityForResult(ActivityGotoHelperKt.getVerificationCodeLoginIntent(applicationContext3), 0);
                return;
            }
            CoroutineUtilsKt.launchMain(new AccountHomepageActivity$initData$2(this, rememberMe, (Continuation<? super AccountHomepageActivity$initData$2>) null));
        } else if (this.mViewStub == null) {
            ViewStub viewStub2 = (ViewStub) findViewById(R.id.stub_error);
            this.mViewStub = viewStub2;
            Intrinsics.checkNotNull(viewStub2);
            viewStub2.inflate();
            View findViewById = findViewById(R.id.error_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            findViewById.setOnClickListener(new a(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void initData$lambda$1(AccountHomepageActivity accountHomepageActivity, View view) {
        Intrinsics.checkNotNullParameter(accountHomepageActivity, "this$0");
        accountHomepageActivity.initData();
    }

    private final void initView() {
        View findViewById = findViewById(R.id.ll_account_info);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mLlAccountInfo = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.ll_change_pwd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mLlChangePwd = (OptionItemLayout) findViewById2;
        View findViewById3 = findViewById(R.id.ll_bind_phone);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mLlBindPhone = (OptionItemLayout) findViewById3;
        View findViewById4 = findViewById(R.id.ll_bind_email);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mLlBindEmail = (OptionItemLayout) findViewById4;
        View findViewById5 = findViewById(R.id.ll_account_about);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mLlAbout = (OptionItemLayout) findViewById5;
        View findViewById6 = findViewById(R.id.ll_login_out);
        OptionItemLayout optionItemLayout = (OptionItemLayout) findViewById6;
        optionItemLayout.setMainTitleColor(ResourcesCompat.d(optionItemLayout.getResources(), R.color.honey_error, getTheme()));
        Intrinsics.checkNotNullExpressionValue(findViewById6, "apply(...)");
        this.mLlLoginOut = optionItemLayout;
        View findViewById7 = findViewById(R.id.iv_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.mIvAvatar = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.tv_nick_name);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.mTvNickName = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.tv_account);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.mTvAccount = (TextView) findViewById9;
        LinearLayout linearLayout = this.mLlAccountInfo;
        OptionItemLayout optionItemLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlAccountInfo");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        OptionItemLayout optionItemLayout3 = this.mLlChangePwd;
        if (optionItemLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlChangePwd");
            optionItemLayout3 = null;
        }
        optionItemLayout3.setOnClickListener(this);
        OptionItemLayout optionItemLayout4 = this.mLlBindPhone;
        if (optionItemLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlBindPhone");
            optionItemLayout4 = null;
        }
        optionItemLayout4.setOnClickListener(this);
        OptionItemLayout optionItemLayout5 = this.mLlBindEmail;
        if (optionItemLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlBindEmail");
            optionItemLayout5 = null;
        }
        optionItemLayout5.setOnClickListener(this);
        OptionItemLayout optionItemLayout6 = this.mLlAbout;
        if (optionItemLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlAbout");
            optionItemLayout6 = null;
        }
        optionItemLayout6.setOnClickListener(this);
        OptionItemLayout optionItemLayout7 = this.mLlLoginOut;
        if (optionItemLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlLoginOut");
        } else {
            optionItemLayout2 = optionItemLayout7;
        }
        optionItemLayout2.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public final void updateAccountUiState(AccountData accountData) {
        RequestBuilder requestBuilder = (RequestBuilder) Glide.u(this).s(accountData.getIcon()).e();
        ImageView imageView = this.mIvAvatar;
        OptionItemLayout optionItemLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvAvatar");
            imageView = null;
        }
        requestBuilder.z0(imageView);
        TextView textView = this.mTvNickName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickName");
            textView = null;
        }
        textView.setText(accountData.getNickname());
        TextView textView2 = this.mTvAccount;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvAccount");
            textView2 = null;
        }
        textView2.setText(accountData.getPhone());
        OptionItemLayout optionItemLayout2 = this.mLlBindPhone;
        if (optionItemLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlBindPhone");
            optionItemLayout2 = null;
        }
        optionItemLayout2.setEndMessage(accountData.getPhone());
        OptionItemLayout optionItemLayout3 = this.mLlBindEmail;
        if (optionItemLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlBindEmail");
            optionItemLayout3 = null;
        }
        String email = accountData.getEmail();
        if (email == null || email.length() == 0) {
            optionItemLayout3.setMainTitle(R.string.setting_email);
            optionItemLayout3.setEndMessage(getString(R.string.not_config));
        } else {
            optionItemLayout3.setMainTitle(R.string.update_email);
            optionItemLayout3.setEndMessage(accountData.getEmail());
        }
        OptionItemLayout optionItemLayout4 = this.mLlChangePwd;
        if (optionItemLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlChangePwd");
        } else {
            optionItemLayout = optionItemLayout4;
        }
        optionItemLayout.setEndMessage(!accountData.isSelfSetPassword() ? getResources().getString(R.string.not_config) : "");
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (i != 7) {
                if (i != 10) {
                    if (i == 300) {
                        FactorAuthenticationUtil.INSTANCE.factorValidate(intent, new AccountHomepageActivity$onActivityResult$1(this));
                        return;
                    } else if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                getViewModel().getDetail();
                                return;
                            }
                            return;
                        }
                    } else if (i2 == -1) {
                        Context applicationContext = getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        startActivityForResult(ActivityGotoHelperKt.getVerificationCodeLoginIntent(applicationContext), 0);
                        return;
                    } else {
                        return;
                    }
                }
                if (i2 == -1) {
                    LoginController loginController = LoginController.INSTANCE;
                    Context applicationContext2 = getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                    String rememberMe = loginController.getRememberMe(applicationContext2);
                    if (rememberMe == null || StringsKt.isBlank(rememberMe)) {
                        Context applicationContext3 = getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
                        startActivityForResult(ActivityGotoHelperKt.getVerificationCodeLoginIntent(applicationContext3), 0);
                        return;
                    }
                    CoroutineUtilsKt.launchMain(new AccountHomepageActivity$onActivityResult$2(this, rememberMe, (Continuation<? super AccountHomepageActivity$onActivityResult$2>) null));
                }
            } else if (i2 == -1) {
                Context applicationContext4 = getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
                startActivityForResult(ActivityGotoHelperKt.getVerificationCodeLoginIntent(applicationContext4), 0);
            }
        } else if (i2 == -1) {
            getViewModel().getDetail();
        } else {
            finish();
        }
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        int id = view.getId();
        if (id == R.id.ll_account_info) {
            ActivityGotoHelperKt.startPersonalInfoActivity(this);
        } else if (id == R.id.ll_change_pwd) {
            WebActivity.Companion companion = WebActivity.Companion;
            OptionItemLayout optionItemLayout = this.mLlChangePwd;
            if (optionItemLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLlChangePwd");
                optionItemLayout = null;
            }
            startActivityForResult(companion.openPage(AccountConstantKt.URL_SETTING_PWD, optionItemLayout.getMainTitle()), 7);
        } else if (id == R.id.ll_bind_phone) {
            ActivityGotoHelperKt.startChangeBindPhoneActivityAfterLogin(this);
        } else if (id == R.id.ll_bind_email) {
            ActivityGotoHelperKt.startChangeBindEmailActivityAfterLogin(this);
        } else if (id == R.id.ll_login_out) {
            FactorAuthenticationUtil factorAuthenticationUtil = FactorAuthenticationUtil.INSTANCE;
            ModeScenario modeScenario = ModeScenario.LOGGED_ACCOUNT;
            String authToken = LoginController.INSTANCE.getAuthToken(this);
            if (authToken == null) {
                authToken = "";
            }
            String packageName = getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            Intent validateMode$default = FactorAuthenticationUtil.getValidateMode$default(factorAuthenticationUtil, modeScenario, authToken, packageName, (String) null, (String) null, (Mode) null, 56, (Object) null);
            validateMode$default.setPackage(getPackageName());
            startActivityForResult(validateMode$default, 300);
        } else if (id == R.id.ll_account_about) {
            ActivityGotoHelperKt.startAccountAboutActivity(this);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_account_home_page);
        initView();
        initData();
        collectLifecycleFlow(this, getViewModel().getLogoutState(), new AccountHomepageActivity$onCreate$1(this, (Continuation<? super AccountHomepageActivity$onCreate$1>) null));
        collectLifecycleFlow(this, getViewModel().getAccountState(), new AccountHomepageActivity$onCreate$2(this, (Continuation<? super AccountHomepageActivity$onCreate$2>) null));
    }
}
