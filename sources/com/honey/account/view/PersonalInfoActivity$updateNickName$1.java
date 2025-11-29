package com.honey.account.view;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.honey.account.R;
import com.honey.account.controller.UserInfoConstant;
import com.honey.account.data.UpdateNickNameData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.PersonalInfoActivity$updateNickName$1", f = "PersonalInfoActivity.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
public final class PersonalInfoActivity$updateNickName$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ PersonalInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalInfoActivity$updateNickName$1(PersonalInfoActivity personalInfoActivity, String str, Continuation<? super PersonalInfoActivity$updateNickName$1> continuation) {
        super(1, continuation);
        this.this$0 = personalInfoActivity;
        this.$name = str;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new PersonalInfoActivity$updateNickName$1(this.this$0, this.$name, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AccountAlertDialog access$getMAlertDialog$p;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UserInfoConstant userInfoConstant = UserInfoConstant.INSTANCE;
            PersonalInfoActivity personalInfoActivity = this.this$0;
            String str = this.$name;
            this.label = 1;
            obj = userInfoConstant.updateNickName(personalInfoActivity, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UpdateNickNameData updateNickNameData = (UpdateNickNameData) obj;
        TextView textView = null;
        if (updateNickNameData.getCode() == 200) {
            AccountAlertDialog access$getMAlertDialog$p2 = this.this$0.mAlertDialog;
            if (!(access$getMAlertDialog$p2 == null || !access$getMAlertDialog$p2.isShowing() || (access$getMAlertDialog$p = this.this$0.mAlertDialog) == null)) {
                access$getMAlertDialog$p.dismiss();
            }
            TextView access$getMTvName$p = this.this$0.mTvName;
            if (access$getMTvName$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvName");
                access$getMTvName$p = null;
            }
            access$getMTvName$p.setText(this.$name);
        }
        TextView access$getMTvErrorMsg$p = this.this$0.mTvErrorMsg;
        if (access$getMTvErrorMsg$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvErrorMsg");
            access$getMTvErrorMsg$p = null;
        }
        access$getMTvErrorMsg$p.setVisibility(0);
        LinearLayout access$getMEdNickNameLay$p = this.this$0.mEdNickNameLay;
        if (access$getMEdNickNameLay$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEdNickNameLay");
            access$getMEdNickNameLay$p = null;
        }
        access$getMEdNickNameLay$p.setBackground(this.this$0.getDrawable(R.drawable.ha_et_bg_err));
        TextView access$getMTvErrorMsg$p2 = this.this$0.mTvErrorMsg;
        if (access$getMTvErrorMsg$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvErrorMsg");
        } else {
            textView = access$getMTvErrorMsg$p2;
        }
        textView.setText(updateNickNameData.getMessage());
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((PersonalInfoActivity$updateNickName$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
