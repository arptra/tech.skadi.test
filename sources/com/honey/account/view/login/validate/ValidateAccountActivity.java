package com.honey.account.view.login.validate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.ViewModelLazy;
import com.honey.account.R;
import com.honey.account.manager.CaptchaManager;
import com.honey.account.usagestats.UsageEvent;
import com.honey.account.utils.network.NetworkUtilsKt;
import com.honey.account.utils.system.ExtKt;
import com.honey.account.utils.system.InputMethodUtilsKt;
import com.honey.account.view.helper.PressAnimLayout;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
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

@SourceDebugExtension({"SMAP\nValidateAccountActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValidateAccountActivity.kt\ncom/honey/account/view/login/validate/ValidateAccountActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,274:1\n75#2,13:275\n*S KotlinDebug\n*F\n+ 1 ValidateAccountActivity.kt\ncom/honey/account/view/login/validate/ValidateAccountActivity\n*L\n50#1:275,13\n*E\n"})
@AndroidEntryPoint
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u000200H\u0002J\u0012\u00103\u001a\u0002002\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u00106\u001a\u0002002\b\u00107\u001a\u0004\u0018\u000108H\u0014J\b\u00109\u001a\u000200H\u0014J\b\u0010:\u001a\u000200H\u0002J\b\u0010;\u001a\u000200H\u0002J\u0012\u0010<\u001a\u0002002\b\u0010=\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR#\u0010!\u001a\n \b*\u0004\u0018\u00010\u001d0\u001d8BX\u0002¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b\"\u0010\u001fR#\u0010$\u001a\n \b*\u0004\u0018\u00010\u001d0\u001d8BX\u0002¢\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b%\u0010\u001fR#\u0010'\u001a\n \b*\u0004\u0018\u00010\u001d0\u001d8BX\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b(\u0010\u001fR\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b,\u0010-¨\u0006?"}, d2 = {"Lcom/honey/account/view/login/validate/ValidateAccountActivity;", "Lcom/honey/account/view/BaseCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "mAccount", "", "mAnim", "Lcom/honey/account/view/helper/PressAnimLayout;", "kotlin.jvm.PlatformType", "getMAnim", "()Lcom/honey/account/view/helper/PressAnimLayout;", "mAnim$delegate", "Lkotlin/Lazy;", "mBtnLogin", "Landroid/widget/Button;", "getMBtnLogin", "()Landroid/widget/Button;", "mBtnLogin$delegate", "mEtCode", "Landroidx/appcompat/widget/AppCompatEditText;", "getMEtCode", "()Landroidx/appcompat/widget/AppCompatEditText;", "mEtCode$delegate", "value", "mMsg", "setMMsg", "(Ljava/lang/String;)V", "mPassword", "mTitleTv", "Landroid/widget/TextView;", "getMTitleTv", "()Landroid/widget/TextView;", "mTitleTv$delegate", "mTvError", "getMTvError", "mTvError$delegate", "mTvSendLoginCode", "getMTvSendLoginCode", "mTvSendLoginCode$delegate", "mTvValidatePhoneHint", "getMTvValidatePhoneHint", "mTvValidatePhoneHint$delegate", "viewModel", "Lcom/honey/account/view/login/validate/ValidateAccountViewModel;", "getViewModel", "()Lcom/honey/account/view/login/validate/ValidateAccountViewModel;", "viewModel$delegate", "initData", "", "initLoading", "login", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStartLogin", "onStopLogin", "showErrorMsg", "msg", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ValidateAccountActivity extends Hilt_ValidateAccountActivity implements View.OnClickListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String KEY_ACCOUNT = "account";
    @NotNull
    private static final String KEY_MSG = "msg";
    @NotNull
    private static final String KEY_PASSWORD = "password";
    @NotNull
    private static final String TAG = "ValidatePhoneActivity";
    /* access modifiers changed from: private */
    @Nullable
    public String mAccount;
    @NotNull
    private final Lazy mAnim$delegate = LazyKt.lazy(new ValidateAccountActivity$mAnim$2(this));
    @NotNull
    private final Lazy mBtnLogin$delegate = LazyKt.lazy(new ValidateAccountActivity$mBtnLogin$2(this));
    @NotNull
    private final Lazy mEtCode$delegate = LazyKt.lazy(new ValidateAccountActivity$mEtCode$2(this));
    @Nullable
    private String mMsg;
    @Nullable
    private String mPassword;
    @NotNull
    private final Lazy mTitleTv$delegate = LazyKt.lazy(new ValidateAccountActivity$mTitleTv$2(this));
    @NotNull
    private final Lazy mTvError$delegate = LazyKt.lazy(new ValidateAccountActivity$mTvError$2(this));
    @NotNull
    private final Lazy mTvSendLoginCode$delegate = LazyKt.lazy(new ValidateAccountActivity$mTvSendLoginCode$2(this));
    @NotNull
    private final Lazy mTvValidatePhoneHint$delegate = LazyKt.lazy(new ValidateAccountActivity$mTvValidatePhoneHint$2(this));
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ValidateAccountViewModel.class), new ValidateAccountActivity$special$$inlined$viewModels$default$2(this), new ValidateAccountActivity$special$$inlined$viewModels$default$1(this), new ValidateAccountActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/honey/account/view/login/validate/ValidateAccountActivity$Companion;", "", "()V", "KEY_ACCOUNT", "", "KEY_MSG", "KEY_PASSWORD", "TAG", "getValidatePhoneActivity", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "account", "msg", "password", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent getValidatePhoneActivity$default(Companion companion, Context context, String str, String str2, String str3, int i, Object obj) {
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.getValidatePhoneActivity(context, str, str2, str3);
        }

        @NotNull
        public final Intent getValidatePhoneActivity(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, ValidateAccountActivity.KEY_ACCOUNT);
            Intrinsics.checkNotNullParameter(str2, "msg");
            Intent intent = new Intent(context, ValidateAccountActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(ValidateAccountActivity.KEY_ACCOUNT, str);
            bundle.putString("msg", str2);
            bundle.putString("password", str3);
            Intent putExtras = intent.putExtras(bundle);
            Intrinsics.checkNotNullExpressionValue(putExtras, "putExtras(...)");
            return putExtras;
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final PressAnimLayout getMAnim() {
        return (PressAnimLayout) this.mAnim$delegate.getValue();
    }

    private final Button getMBtnLogin() {
        return (Button) this.mBtnLogin$delegate.getValue();
    }

    private final AppCompatEditText getMEtCode() {
        return (AppCompatEditText) this.mEtCode$delegate.getValue();
    }

    private final TextView getMTitleTv() {
        Object value = this.mTitleTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    private final TextView getMTvError() {
        return (TextView) this.mTvError$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TextView getMTvSendLoginCode() {
        return (TextView) this.mTvSendLoginCode$delegate.getValue();
    }

    private final TextView getMTvValidatePhoneHint() {
        return (TextView) this.mTvValidatePhoneHint$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ValidateAccountViewModel getViewModel() {
        return (ValidateAccountViewModel) this.viewModel$delegate.getValue();
    }

    private final void initData() {
        String str;
        Bundle extras = getIntent().getExtras();
        int i = 0;
        if (extras != null) {
            setMMsg(extras.getString("msg"));
            String string = extras.getString(KEY_ACCOUNT);
            if (string != null) {
                TextView mTvSendLoginCode = getMTvSendLoginCode();
                Intrinsics.checkNotNull(string);
                mTvSendLoginCode.setEnabled(string.length() > 0);
            } else {
                string = null;
            }
            this.mAccount = string;
            this.mPassword = extras.getString("password");
            TextView mTitleTv = getMTitleTv();
            String str2 = this.mPassword;
            if (str2 == null || str2.length() <= 0) {
                String str3 = this.mAccount;
                str = (str3 == null || !StringsKt.contains$default((CharSequence) str3, (CharSequence) "@", false, 2, (Object) null)) ? getString(R.string.validate_phone) : getString(R.string.validate_email);
            } else {
                str = getString(R.string.validate_identity);
            }
            mTitleTv.setText(str);
        }
        TextView mTvSendLoginCode2 = getMTvSendLoginCode();
        String str4 = this.mPassword;
        if (!(str4 == null || str4.length() == 0)) {
            i = 8;
        }
        mTvSendLoginCode2.setVisibility(i);
    }

    private final void initLoading() {
        String str = this.mPassword;
        if (str == null || str.length() == 0) {
            getViewModel().downFlow();
            collectLifecycleFlow(this, getViewModel().getVCodeTimeDownFlow(), new ValidateAccountActivity$initLoading$1(this, (Continuation<? super ValidateAccountActivity$initLoading$1>) null));
            collectLifecycleFlow(this, getViewModel().getSmsCodeUiState(), new ValidateAccountActivity$initLoading$2(this, (Continuation<? super ValidateAccountActivity$initLoading$2>) null));
        }
        collectLifecycleFlow(this, getViewModel().getLoginUiState(), new ValidateAccountActivity$initLoading$3(this, (Continuation<? super ValidateAccountActivity$initLoading$3>) null));
    }

    private final void login() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (!NetworkUtilsKt.isNetworkConnected(applicationContext)) {
            showErrorMsg(getString(R.string.not_network));
            return;
        }
        UsageEvent.onEventLib$default(UsageEvent.INSTANCE, "click_vcode_login", TAG, (Map) null, 4, (Object) null);
        String obj = StringsKt.trim((CharSequence) String.valueOf(getMEtCode().getText())).toString();
        ValidateAccountViewModel viewModel = getViewModel();
        String str = this.mAccount;
        if (str == null) {
            str = "";
        }
        viewModel.login(str, obj, this.mPassword);
    }

    /* access modifiers changed from: private */
    public final void onStartLogin() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        AppCompatEditText mEtCode = getMEtCode();
        Intrinsics.checkNotNullExpressionValue(mEtCode, "<get-mEtCode>(...)");
        InputMethodUtilsKt.closeInputMethod(applicationContext, mEtCode);
        showErrorMsg((String) null);
        getMAnim().setEnabled(false);
        getMBtnLogin().setText(R.string.logining);
    }

    /* access modifiers changed from: private */
    public final void onStopLogin() {
        getMAnim().setEnabled(true);
        getMBtnLogin().setText(R.string.login);
    }

    private final void setMMsg(String str) {
        this.mMsg = str;
        if (str != null && str.length() > 0) {
            getMTvValidatePhoneHint().setText(str);
        }
    }

    /* access modifiers changed from: private */
    public final void showErrorMsg(String str) {
        getMTvError().setText(str);
        getMTvError().setVisibility((str == null || str.length() == 0) ? 8 : 0);
    }

    public void onClick(@Nullable View view) {
        if (view != null && view.getId() == R.id.btn_login) {
            login();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_validate_phone_layout);
        initData();
        getMBtnLogin().setOnClickListener(this);
        initLoading();
        getMAnim().setEnabled(false);
        AppCompatEditText mEtCode = getMEtCode();
        Intrinsics.checkNotNullExpressionValue(mEtCode, "<get-mEtCode>(...)");
        ExtKt.doAfterTextChanged(mEtCode, new ValidateAccountActivity$onCreate$1(this));
    }

    public void onStart() {
        super.onStart();
        String str = this.mPassword;
        if (str == null || str.length() == 0) {
            CaptchaManager captchaManager = CaptchaManager.INSTANCE;
            TextView mTvSendLoginCode = getMTvSendLoginCode();
            Intrinsics.checkNotNullExpressionValue(mTvSendLoginCode, "<get-mTvSendLoginCode>(...)");
            captchaManager.bind(this, mTvSendLoginCode, new ValidateAccountActivity$onStart$1(this));
        }
    }
}
