package sdk.meizu.account.factor.authentication.sdk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;
import sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "uiState", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "Lsdk/meizu/account/factor/authentication/sdk/data/ResponseValidateData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity$initLoading$1", f = "FactorAuthenticationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FactorAuthenticationActivity$initLoading$1 extends SuspendLambda implements Function2<ResultUiState<? extends ResponseValidateData>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FactorAuthenticationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FactorAuthenticationActivity$initLoading$1(FactorAuthenticationActivity factorAuthenticationActivity, Continuation<? super FactorAuthenticationActivity$initLoading$1> continuation) {
        super(2, continuation);
        this.this$0 = factorAuthenticationActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FactorAuthenticationActivity$initLoading$1 factorAuthenticationActivity$initLoading$1 = new FactorAuthenticationActivity$initLoading$1(this.this$0, continuation);
        factorAuthenticationActivity$initLoading$1.L$0 = obj;
        return factorAuthenticationActivity$initLoading$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b4, code lost:
        if (r8.equals(sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil.CODE_INVALID_TOKEN) != false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bd, code lost:
        if (r8.equals(sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil.CODE_INVALID_TOKEN_STATUS) == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cc, code lost:
        r7.this$0.cancelPage(sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil.CODE_INVALID_TOKEN);
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r7.label
            if (r0 != 0) goto L_0x0144
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            sdk.meizu.account.factor.authentication.sdk.common.ResultUiState r8 = (sdk.meizu.account.factor.authentication.sdk.common.ResultUiState) r8
            boolean r0 = r8 instanceof sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Default
            r1 = 1
            if (r0 == 0) goto L_0x0015
            r0 = r1
            goto L_0x001b
        L_0x0015:
            sdk.meizu.account.factor.authentication.sdk.common.ResultUiState$Loading r0 = sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Loading.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)
        L_0x001b:
            java.lang.String r2 = "FactorAuthenticationActivity"
            if (r0 == 0) goto L_0x003c
            java.lang.String r8 = "--- initLoading, loading state. "
            android.util.Log.d(r2, r8)
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r8 = r7.this$0
            android.widget.FrameLayout r8 = r8.getFrameLayout()
            r0 = 8
            r8.setVisibility(r0)
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r7 = r7.this$0
            sdk.meizu.account.factor.authentication.sdk.view.LoadingView r7 = r7.getLoadingView()
            sdk.meizu.account.factor.authentication.sdk.view.LoadingState r8 = sdk.meizu.account.factor.authentication.sdk.view.LoadingState.LOADING
            r7.updateState(r8)
            goto L_0x0141
        L_0x003c:
            boolean r0 = r8 instanceof sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Error
            r3 = 2
            r4 = 0
            r5 = 0
            if (r0 == 0) goto L_0x00d2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "--- initLoading, error state. "
            r0.append(r1)
            sdk.meizu.account.factor.authentication.sdk.common.ResultUiState$Error r8 = (sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Error) r8
            java.lang.String r1 = r8.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r2, r0)
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r0 = r7.this$0
            java.lang.String r1 = r8.getMessage()
            boolean r0 = r0.handlerError(r1)
            if (r0 == 0) goto L_0x006c
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x006c:
            java.lang.String r8 = r8.getMessage()
            int r0 = r8.hashCode()
            r1 = 51509(0xc935, float:7.218E-41)
            java.lang.String r2 = "198001"
            if (r0 == r1) goto L_0x00b7
            r1 = 1457185057(0x56dae121, float:1.20330228E14)
            if (r0 == r1) goto L_0x00b0
            r1 = 1801366588(0x6b5eac3c, float:2.6919489E26)
            if (r0 == r1) goto L_0x0086
            goto L_0x00bf
        L_0x0086:
            java.lang.String r0 = "geetest code error"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x008f
            goto L_0x00bf
        L_0x008f:
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r8 = r7.this$0
            sdk.meizu.account.factor.authentication.sdk.view.LoadingView r8 = r8.getLoadingView()
            sdk.meizu.account.factor.authentication.sdk.view.LoadingState r0 = sdk.meizu.account.factor.authentication.sdk.view.LoadingState.SUCCESS
            r8.updateState(r0)
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r8 = r7.this$0
            android.widget.FrameLayout r8 = r8.getFrameLayout()
            r8.setVisibility(r4)
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r7 = r7.this$0
            sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator r7 = r7.getNavigator()
            sdk.meizu.account.factor.authentication.sdk.navigator.Screens r8 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.ACCOUNT
            sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator.DefaultImpls.navigateTo$default(r7, r8, r5, r3, r5)
            goto L_0x0141
        L_0x00b0:
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x00bf
            goto L_0x00cc
        L_0x00b7:
            java.lang.String r0 = "401"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00cc
        L_0x00bf:
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r7 = r7.this$0
            sdk.meizu.account.factor.authentication.sdk.view.LoadingView r7 = r7.getLoadingView()
            sdk.meizu.account.factor.authentication.sdk.view.LoadingState r8 = sdk.meizu.account.factor.authentication.sdk.view.LoadingState.ERROR
            r7.updateState(r8)
            goto L_0x0141
        L_0x00cc:
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r7 = r7.this$0
            r7.cancelPage(r2)
            goto L_0x0141
        L_0x00d2:
            boolean r0 = r8 instanceof sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Success
            if (r0 == 0) goto L_0x0141
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "--- initLoading, success state.types: "
            r0.append(r6)
            sdk.meizu.account.factor.authentication.sdk.common.ResultUiState$Success r8 = (sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Success) r8
            java.lang.Object r6 = r8.getData()
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r2, r0)
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r0 = r7.this$0
            sdk.meizu.account.factor.authentication.sdk.view.LoadingView r0 = r0.getLoadingView()
            sdk.meizu.account.factor.authentication.sdk.view.LoadingState r2 = sdk.meizu.account.factor.authentication.sdk.view.LoadingState.SUCCESS
            r0.updateState(r2)
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r0 = r7.this$0
            android.widget.FrameLayout r0 = r0.getFrameLayout()
            r0.setVisibility(r4)
            java.lang.Object r0 = r8.getData()
            sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData r0 = (sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData) r0
            java.util.List r0 = r0.getUserAnswerValidate()
            if (r0 == 0) goto L_0x0118
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0117
            goto L_0x0118
        L_0x0117:
            r1 = r4
        L_0x0118:
            sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity r7 = r7.this$0
            if (r1 != 0) goto L_0x0126
            sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator r7 = r7.getNavigator()
            sdk.meizu.account.factor.authentication.sdk.navigator.Screens r8 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.ANSWER
            sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator.DefaultImpls.navigateTo$default(r7, r8, r5, r3, r5)
            goto L_0x0141
        L_0x0126:
            java.lang.Object r8 = r8.getData()
            sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData r8 = (sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData) r8
            java.util.List r8 = r8.getUserBasicInfoValidate()
            if (r8 == 0) goto L_0x0141
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
            sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType r8 = (sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType) r8
            if (r8 == 0) goto L_0x0141
            sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator r7 = r7.getNavigator()
            r7.navigateTo(r8)
        L_0x0141:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0144:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity$initLoading$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull ResultUiState<ResponseValidateData> resultUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((FactorAuthenticationActivity$initLoading$1) create(resultUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
