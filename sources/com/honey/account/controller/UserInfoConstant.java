package com.honey.account.controller;

import android.content.Context;
import com.honey.account.data.UpdateNickNameData;
import com.honey.account.data.UploadAvatarData;
import com.honey.account.utils.coroutine.CoroutineUtilsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/honey/account/controller/UserInfoConstant;", "", "()V", "updateNickName", "Lcom/honey/account/data/UpdateNickNameData;", "context", "Landroid/content/Context;", "nickName", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadAvatar", "Lcom/honey/account/data/UploadAvatarData;", "filePath", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UserInfoConstant {
    @NotNull
    public static final UserInfoConstant INSTANCE = new UserInfoConstant();

    private UserInfoConstant() {
    }

    @Nullable
    public final Object updateNickName(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super UpdateNickNameData> continuation) {
        return CoroutineUtilsKt.launchIO(new UserInfoConstant$updateNickName$2(context, str), continuation);
    }

    @Nullable
    public final Object uploadAvatar(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super UploadAvatarData> continuation) {
        return CoroutineUtilsKt.launchIO(new UserInfoConstant$uploadAvatar$2(context, str), continuation);
    }
}
