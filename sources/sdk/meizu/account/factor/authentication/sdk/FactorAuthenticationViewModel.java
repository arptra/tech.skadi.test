package sdk.meizu.account.factor.authentication.sdk;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.upuphone.runasone.api.ApiConstant;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;
import sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository;", "(Lsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository;)V", "_validateUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "Lsdk/meizu/account/factor/authentication/sdk/data/ResponseValidateData;", "validateUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getValidateUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getValidateTypes", "Lkotlinx/coroutines/Job;", "token", "", "data", "Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@HiltViewModel
public final class FactorAuthenticationViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "FactorAuthenticationViewModel";
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<ResultUiState<ResponseValidateData>> _validateUiState;
    /* access modifiers changed from: private */
    @NotNull
    public final FactorAuthenticationRepository repository;
    @NotNull
    private final StateFlow<ResultUiState<ResponseValidateData>> validateUiState;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public FactorAuthenticationViewModel(@NotNull FactorAuthenticationRepository factorAuthenticationRepository) {
        Intrinsics.checkNotNullParameter(factorAuthenticationRepository, "repository");
        this.repository = factorAuthenticationRepository;
        MutableStateFlow<ResultUiState<ResponseValidateData>> a2 = StateFlowKt.a(ResultUiState.Loading.INSTANCE);
        this._validateUiState = a2;
        this.validateUiState = FlowKt.c(a2);
    }

    public static /* synthetic */ Job getValidateTypes$default(FactorAuthenticationViewModel factorAuthenticationViewModel, String str, GeetestData geetestData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            geetestData = null;
        }
        return factorAuthenticationViewModel.getValidateTypes(str, geetestData);
    }

    @NotNull
    public final Job getValidateTypes(@NotNull String str, @Nullable GeetestData geetestData) {
        Intrinsics.checkNotNullParameter(str, ApiConstant.KEY_TOKEN);
        return BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new FactorAuthenticationViewModel$getValidateTypes$1(str, this, geetestData, (Continuation<? super FactorAuthenticationViewModel$getValidateTypes$1>) null), 3, (Object) null);
    }

    @NotNull
    public final StateFlow<ResultUiState<ResponseValidateData>> getValidateUiState() {
        return this.validateUiState;
    }
}
