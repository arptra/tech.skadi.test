package com.honey.account.view;

import android.util.Log;
import com.honey.account.data.AccountData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.common.ResultUiState;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "uiState", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "Lcom/honey/account/data/AccountData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.PersonalInfoActivity$onCreate$1", f = "PersonalInfoActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PersonalInfoActivity$onCreate$1 extends SuspendLambda implements Function2<ResultUiState<? extends AccountData>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PersonalInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalInfoActivity$onCreate$1(PersonalInfoActivity personalInfoActivity, Continuation<? super PersonalInfoActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = personalInfoActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PersonalInfoActivity$onCreate$1 personalInfoActivity$onCreate$1 = new PersonalInfoActivity$onCreate$1(this.this$0, continuation);
        personalInfoActivity$onCreate$1.L$0 = obj;
        return personalInfoActivity$onCreate$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ResultUiState resultUiState = (ResultUiState) this.L$0;
            if (!(resultUiState instanceof ResultUiState.Default ? true : Intrinsics.areEqual((Object) resultUiState, (Object) ResultUiState.Loading.INSTANCE))) {
                if (resultUiState instanceof ResultUiState.Error) {
                    Log.e("PersonalInfoActivity", "Account detail fail." + ((ResultUiState.Error) resultUiState).getMessage());
                } else if (resultUiState instanceof ResultUiState.Success) {
                    this.this$0.updateAccountUiState((AccountData) ((ResultUiState.Success) resultUiState).getData());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull ResultUiState<AccountData> resultUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((PersonalInfoActivity$onCreate$1) create(resultUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
