package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

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
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateAllFragment$onViewCreated$3", f = "ValidateAllFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ValidateAllFragment$onViewCreated$3 extends SuspendLambda implements Function2<ResultUiState<? extends ResponseValidateData>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ValidateAllFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValidateAllFragment$onViewCreated$3(ValidateAllFragment validateAllFragment, Continuation<? super ValidateAllFragment$onViewCreated$3> continuation) {
        super(2, continuation);
        this.this$0 = validateAllFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ValidateAllFragment$onViewCreated$3 validateAllFragment$onViewCreated$3 = new ValidateAllFragment$onViewCreated$3(this.this$0, continuation);
        validateAllFragment$onViewCreated$3.L$0 = obj;
        return validateAllFragment$onViewCreated$3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r3 = r3.this$0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            if (r0 != 0) goto L_0x0040
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.Object r4 = r3.L$0
            sdk.meizu.account.factor.authentication.sdk.common.ResultUiState r4 = (sdk.meizu.account.factor.authentication.sdk.common.ResultUiState) r4
            boolean r0 = r4 instanceof sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Success
            if (r0 == 0) goto L_0x003d
            sdk.meizu.account.factor.authentication.sdk.common.ResultUiState$Success r4 = (sdk.meizu.account.factor.authentication.sdk.common.ResultUiState.Success) r4
            java.lang.Object r4 = r4.getData()
            sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData r4 = (sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData) r4
            java.util.List r4 = r4.getUserBasicInfoValidate()
            if (r4 == 0) goto L_0x003d
            sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateAllFragment r3 = r3.this$0
            androidx.recyclerview.widget.RecyclerView r0 = r3.recyclerView
            if (r0 != 0) goto L_0x0029
            goto L_0x003d
        L_0x0029:
            sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter.ValidateListAdapter r1 = new sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter.ValidateListAdapter
            sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType r2 = r3.getBasicType()
            r1.<init>(r2, r4)
            sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateAllFragment$onViewCreated$3$1$1$1 r4 = new sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateAllFragment$onViewCreated$3$1$1$1
            r4.<init>(r3)
            r1.setOnSelectedListener(r4)
            r0.setAdapter(r1)
        L_0x003d:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0040:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateAllFragment$onViewCreated$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull ResultUiState<ResponseValidateData> resultUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((ValidateAllFragment$onViewCreated$3) create(resultUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
