package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.upuphone.runasone.api.ApiConstant;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;
import sdk.meizu.account.factor.authentication.sdk.constant.Mode;
import sdk.meizu.account.factor.authentication.sdk.data.AnswerType;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0017J\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository;", "(Lsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository;)V", "_confirmAnswerUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "", "_confirmUiState", "Lsdk/meizu/account/factor/authentication/sdk/data/ConfirmValue;", "confirmAnswerUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getConfirmAnswerUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "setConfirmAnswerUiState", "(Lkotlinx/coroutines/flow/StateFlow;)V", "confirmUiState", "getConfirmUiState", "setConfirmUiState", "confirm", "", "token", "", "type", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "mode", "Lsdk/meizu/account/factor/authentication/sdk/constant/Mode;", "validate", "answerData", "", "Lsdk/meizu/account/factor/authentication/sdk/data/AnswerType;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nValidateViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValidateViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,98:1\n230#2,5:99\n230#2,5:104\n*S KotlinDebug\n*F\n+ 1 ValidateViewModel.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel\n*L\n42#1:99,5\n78#1:104,5\n*E\n"})
@HiltViewModel
public final class ValidateViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<ResultUiState<Boolean>> _confirmAnswerUiState;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<ResultUiState<ConfirmValue>> _confirmUiState;
    @NotNull
    private StateFlow<? extends ResultUiState<Boolean>> confirmAnswerUiState;
    @NotNull
    private StateFlow<? extends ResultUiState<ConfirmValue>> confirmUiState;
    /* access modifiers changed from: private */
    @NotNull
    public final FactorAuthenticationRepository repository;

    @Inject
    public ValidateViewModel(@NotNull FactorAuthenticationRepository factorAuthenticationRepository) {
        Intrinsics.checkNotNullParameter(factorAuthenticationRepository, "repository");
        this.repository = factorAuthenticationRepository;
        ResultUiState.Default defaultR = ResultUiState.Default.INSTANCE;
        MutableStateFlow<ResultUiState<ConfirmValue>> a2 = StateFlowKt.a(defaultR);
        this._confirmUiState = a2;
        this.confirmUiState = FlowKt.c(a2);
        MutableStateFlow<ResultUiState<Boolean>> a3 = StateFlowKt.a(defaultR);
        this._confirmAnswerUiState = a3;
        this.confirmAnswerUiState = FlowKt.c(a3);
    }

    public final void confirm(@NotNull String str, @NotNull BasicInfoType basicInfoType, @Nullable Mode mode, @NotNull String str2) {
        Object value;
        Intrinsics.checkNotNullParameter(str, ApiConstant.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(basicInfoType, "type");
        Intrinsics.checkNotNullParameter(str2, "validate");
        MutableStateFlow<ResultUiState<ConfirmValue>> mutableStateFlow = this._confirmUiState;
        do {
            value = mutableStateFlow.getValue();
            ResultUiState resultUiState = (ResultUiState) value;
        } while (!mutableStateFlow.compareAndSet(value, ResultUiState.Loading.INSTANCE));
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new ValidateViewModel$confirm$2(this, str, basicInfoType, mode, str2, (Continuation<? super ValidateViewModel$confirm$2>) null), 3, (Object) null);
    }

    @NotNull
    public final StateFlow<ResultUiState<Boolean>> getConfirmAnswerUiState() {
        return this.confirmAnswerUiState;
    }

    @NotNull
    public final StateFlow<ResultUiState<ConfirmValue>> getConfirmUiState() {
        return this.confirmUiState;
    }

    public final void setConfirmAnswerUiState(@NotNull StateFlow<? extends ResultUiState<Boolean>> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.confirmAnswerUiState = stateFlow;
    }

    public final void setConfirmUiState(@NotNull StateFlow<? extends ResultUiState<ConfirmValue>> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.confirmUiState = stateFlow;
    }

    public final void confirm(@NotNull List<AnswerType> list) {
        Object value;
        Intrinsics.checkNotNullParameter(list, "answerData");
        MutableStateFlow<ResultUiState<Boolean>> mutableStateFlow = this._confirmAnswerUiState;
        do {
            value = mutableStateFlow.getValue();
            ResultUiState resultUiState = (ResultUiState) value;
        } while (!mutableStateFlow.compareAndSet(value, ResultUiState.Loading.INSTANCE));
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new ValidateViewModel$confirm$4(this, list, (Continuation<? super ValidateViewModel$confirm$4>) null), 3, (Object) null);
    }
}
