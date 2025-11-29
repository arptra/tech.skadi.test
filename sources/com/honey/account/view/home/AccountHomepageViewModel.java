package com.honey.account.view.home;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.honey.account.data.AccountData;
import com.honey.account.view.oauth.TokenRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\fR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/honey/account/view/home/AccountHomepageViewModel;", "Landroidx/lifecycle/ViewModel;", "accountRepository", "Lcom/honey/account/view/home/AccountRepository;", "tokenRepository", "Lcom/honey/account/view/oauth/TokenRepository;", "(Lcom/honey/account/view/home/AccountRepository;Lcom/honey/account/view/oauth/TokenRepository;)V", "_accountState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "Lcom/honey/account/data/AccountData;", "_logoutState", "", "accountState", "Lkotlinx/coroutines/flow/StateFlow;", "getAccountState", "()Lkotlinx/coroutines/flow/StateFlow;", "setAccountState", "(Lkotlinx/coroutines/flow/StateFlow;)V", "logoutState", "getLogoutState", "setLogoutState", "getDetail", "Lkotlinx/coroutines/Job;", "logout", "code", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@HiltViewModel
public final class AccountHomepageViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<ResultUiState<AccountData>> _accountState;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<ResultUiState<String>> _logoutState;
    /* access modifiers changed from: private */
    @NotNull
    public final AccountRepository accountRepository;
    @NotNull
    private StateFlow<? extends ResultUiState<AccountData>> accountState;
    @NotNull
    private StateFlow<? extends ResultUiState<String>> logoutState;
    @NotNull
    private final TokenRepository tokenRepository;

    @Inject
    public AccountHomepageViewModel(@NotNull AccountRepository accountRepository2, @NotNull TokenRepository tokenRepository2) {
        Intrinsics.checkNotNullParameter(accountRepository2, "accountRepository");
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        this.accountRepository = accountRepository2;
        this.tokenRepository = tokenRepository2;
        ResultUiState.Default defaultR = ResultUiState.Default.INSTANCE;
        MutableStateFlow<ResultUiState<String>> a2 = StateFlowKt.a(defaultR);
        this._logoutState = a2;
        this.logoutState = FlowKt.c(a2);
        MutableStateFlow<ResultUiState<AccountData>> a3 = StateFlowKt.a(defaultR);
        this._accountState = a3;
        this.accountState = FlowKt.c(a3);
    }

    @NotNull
    public final StateFlow<ResultUiState<AccountData>> getAccountState() {
        return this.accountState;
    }

    @NotNull
    public final Job getDetail() {
        return BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new AccountHomepageViewModel$getDetail$1(this, (Continuation<? super AccountHomepageViewModel$getDetail$1>) null), 3, (Object) null);
    }

    @NotNull
    public final StateFlow<ResultUiState<String>> getLogoutState() {
        return this.logoutState;
    }

    @NotNull
    public final Job logout(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "code");
        return BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new AccountHomepageViewModel$logout$1(this, str, (Continuation<? super AccountHomepageViewModel$logout$1>) null), 3, (Object) null);
    }

    public final void setAccountState(@NotNull StateFlow<? extends ResultUiState<AccountData>> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.accountState = stateFlow;
    }

    public final void setLogoutState(@NotNull StateFlow<? extends ResultUiState<String>> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.logoutState = stateFlow;
    }
}
