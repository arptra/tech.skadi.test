package com.honey.account.view;

import com.honey.account.controller.UserInfoConstant;
import com.honey.account.data.UploadAvatarData;
import com.honey.account.utils.log.LogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.PersonalInfoActivity$uploadAvatar$1", f = "PersonalInfoActivity.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
public final class PersonalInfoActivity$uploadAvatar$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uploadPath;
    int label;
    final /* synthetic */ PersonalInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalInfoActivity$uploadAvatar$1(PersonalInfoActivity personalInfoActivity, String str, Continuation<? super PersonalInfoActivity$uploadAvatar$1> continuation) {
        super(1, continuation);
        this.this$0 = personalInfoActivity;
        this.$uploadPath = str;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new PersonalInfoActivity$uploadAvatar$1(this.this$0, this.$uploadPath, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String icon;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UserInfoConstant userInfoConstant = UserInfoConstant.INSTANCE;
            PersonalInfoActivity personalInfoActivity = this.this$0;
            String str = this.$uploadPath;
            this.label = 1;
            obj = userInfoConstant.uploadAvatar(personalInfoActivity, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UploadAvatarData uploadAvatarData = (UploadAvatarData) obj;
        if (uploadAvatarData.getCode() != 200 || (icon = uploadAvatarData.getIcon()) == null || icon.length() == 0) {
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.e("PersonalInfoActivity", "uploadAvatar error, result:" + uploadAvatarData + ".message");
        } else {
            this.this$0.uploadAvatarSuccess(this.$uploadPath);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((PersonalInfoActivity$uploadAvatar$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
