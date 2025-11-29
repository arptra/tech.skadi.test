package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.upuphone.runasone.api.ApiConstant;
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
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001b"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/VerificationCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository;", "(Lsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository;)V", "_vCodeTimeDownFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_vCodeUiState", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "", "vCodeTimeDownFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getVCodeTimeDownFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "setVCodeTimeDownFlow", "(Lkotlinx/coroutines/flow/StateFlow;)V", "vCodeUiState", "getVCodeUiState", "downFlow", "", "getVCode", "token", "type", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "data", "Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@HiltViewModel
public final class VerificationCodeViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<Integer> _vCodeTimeDownFlow;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<ResultUiState<String>> _vCodeUiState;
    /* access modifiers changed from: private */
    @NotNull
    public final FactorAuthenticationRepository repository;
    @NotNull
    private StateFlow<Integer> vCodeTimeDownFlow;
    @NotNull
    private final StateFlow<ResultUiState<String>> vCodeUiState;

    @Inject
    public VerificationCodeViewModel(@NotNull FactorAuthenticationRepository factorAuthenticationRepository) {
        Intrinsics.checkNotNullParameter(factorAuthenticationRepository, "repository");
        this.repository = factorAuthenticationRepository;
        MutableStateFlow<Integer> a2 = StateFlowKt.a(100);
        this._vCodeTimeDownFlow = a2;
        this.vCodeTimeDownFlow = FlowKt.c(a2);
        MutableStateFlow<ResultUiState<String>> a3 = StateFlowKt.a(ResultUiState.Default.INSTANCE);
        this._vCodeUiState = a3;
        this.vCodeUiState = FlowKt.c(a3);
    }

    public final void downFlow() {
        this._vCodeTimeDownFlow.setValue(60);
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VerificationCodeViewModel$downFlow$1(this, (Continuation<? super VerificationCodeViewModel$downFlow$1>) null), 3, (Object) null);
    }

    public final void getVCode(@NotNull String str, @NotNull BasicInfoType basicInfoType, @Nullable GeetestData geetestData) {
        Intrinsics.checkNotNullParameter(str, ApiConstant.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(basicInfoType, "type");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VerificationCodeViewModel$getVCode$1(this, str, basicInfoType, geetestData, (Continuation<? super VerificationCodeViewModel$getVCode$1>) null), 3, (Object) null);
    }

    @NotNull
    public final StateFlow<Integer> getVCodeTimeDownFlow() {
        return this.vCodeTimeDownFlow;
    }

    @NotNull
    public final StateFlow<ResultUiState<String>> getVCodeUiState() {
        return this.vCodeUiState;
    }

    public final void setVCodeTimeDownFlow(@NotNull StateFlow<Integer> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.vCodeTimeDownFlow = stateFlow;
    }
}
