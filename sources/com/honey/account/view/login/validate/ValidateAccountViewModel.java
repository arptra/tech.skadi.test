package com.honey.account.view.login.validate;

import android.annotation.SuppressLint;
import androidx.lifecycle.ViewModelKt;
import com.honey.account.AccountHelper;
import com.honey.account.R;
import com.honey.account.common.ResultUiState;
import com.honey.account.view.login.base.VerificationCodeViewModel;
import com.honey.account.view.login.repository.LoginRepository;
import com.honey.account.view.oauth.TokenRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nValidateAccountViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValidateAccountViewModel.kt\ncom/honey/account/view/login/validate/ValidateAccountViewModel\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,158:1\n230#2,5:159\n230#2,5:164\n*S KotlinDebug\n*F\n+ 1 ValidateAccountViewModel.kt\ncom/honey/account/view/login/validate/ValidateAccountViewModel\n*L\n57#1:159,5\n60#1:164,5\n*E\n"})
@SuppressLint({"LongLogTag"})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0003J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/honey/account/view/login/validate/ValidateAccountViewModel;", "Lcom/honey/account/view/login/base/VerificationCodeViewModel;", "loginRepository", "Lcom/honey/account/view/login/repository/LoginRepository;", "tokenRepository", "Lcom/honey/account/view/oauth/TokenRepository;", "(Lcom/honey/account/view/login/repository/LoginRepository;Lcom/honey/account/view/oauth/TokenRepository;)V", "_loginUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/honey/account/common/ResultUiState;", "", "loginUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getLoginUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "setLoginUiState", "(Lkotlinx/coroutines/flow/StateFlow;)V", "login", "", "account", "vCode", "password", "loginByEmail", "Lkotlinx/coroutines/Job;", "loginByPassword", "loginByPhone", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@HiltViewModel
public final class ValidateAccountViewModel extends VerificationCodeViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "ValidateAccountViewModel";
    /* access modifiers changed from: private */
    @NotNull
    public MutableStateFlow<ResultUiState<String>> _loginUiState;
    /* access modifiers changed from: private */
    @NotNull
    public final LoginRepository loginRepository;
    @NotNull
    private StateFlow<? extends ResultUiState<String>> loginUiState;
    /* access modifiers changed from: private */
    @NotNull
    public final TokenRepository tokenRepository;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/honey/account/view/login/validate/ValidateAccountViewModel$Companion;", "", "()V", "TAG", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ValidateAccountViewModel(@NotNull LoginRepository loginRepository2, @NotNull TokenRepository tokenRepository2) {
        super(loginRepository2);
        Intrinsics.checkNotNullParameter(loginRepository2, "loginRepository");
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        this.loginRepository = loginRepository2;
        this.tokenRepository = tokenRepository2;
        MutableStateFlow<ResultUiState<String>> a2 = StateFlowKt.a(ResultUiState.Default.INSTANCE);
        this._loginUiState = a2;
        this.loginUiState = FlowKt.c(a2);
    }

    public static /* synthetic */ void login$default(ValidateAccountViewModel validateAccountViewModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        validateAccountViewModel.login(str, str2, str3);
    }

    @SuppressLint({"LongLogTag"})
    private final Job loginByEmail(String str, String str2) {
        return BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new ValidateAccountViewModel$loginByEmail$1(this, str, str2, (Continuation<? super ValidateAccountViewModel$loginByEmail$1>) null), 3, (Object) null);
    }

    private final Job loginByPassword(String str, String str2, String str3) {
        return BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new ValidateAccountViewModel$loginByPassword$1(str, str3, str2, this, (Continuation<? super ValidateAccountViewModel$loginByPassword$1>) null), 3, (Object) null);
    }

    private final Job loginByPhone(String str, String str2) {
        return BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new ValidateAccountViewModel$loginByPhone$1(str, str2, this, (Continuation<? super ValidateAccountViewModel$loginByPhone$1>) null), 3, (Object) null);
    }

    @NotNull
    public final StateFlow<ResultUiState<String>> getLoginUiState() {
        return this.loginUiState;
    }

    public final void login(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Object value;
        Object value2;
        String string;
        Intrinsics.checkNotNullParameter(str, "account");
        Intrinsics.checkNotNullParameter(str2, "vCode");
        MutableStateFlow<ResultUiState<String>> mutableStateFlow = this._loginUiState;
        do {
            value = mutableStateFlow.getValue();
            ResultUiState resultUiState = (ResultUiState) value;
        } while (!mutableStateFlow.compareAndSet(value, ResultUiState.Loading.INSTANCE));
        if (str.length() == 0 || str2.length() == 0) {
            MutableStateFlow<ResultUiState<String>> mutableStateFlow2 = this._loginUiState;
            do {
                value2 = mutableStateFlow2.getValue();
                ResultUiState resultUiState2 = (ResultUiState) value2;
                string = AccountHelper.INSTANCE.getMApplicationContext().getString(R.string.gt4_parameter_config_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            } while (!mutableStateFlow2.compareAndSet(value2, new ResultUiState.Error(string)));
        } else if (str3 != null && str3.length() > 0) {
            loginByPassword(str, str2, str3);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "@", false, 2, (Object) null)) {
            loginByEmail(str, str2);
        } else {
            loginByPhone(str, str2);
        }
    }

    public final void setLoginUiState(@NotNull StateFlow<? extends ResultUiState<String>> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.loginUiState = stateFlow;
    }
}
