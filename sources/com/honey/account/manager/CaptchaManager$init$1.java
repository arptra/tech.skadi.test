package com.honey.account.manager;

import com.honey.account.controller.CaptchaController;
import com.honey.account.data.GeetestData;
import com.honey.account.manager.CaptchaManager;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/honey/account/manager/CaptchaManager$init$1", "Lcom/honey/account/controller/CaptchaController$Callback;", "onFailed", "", "code", "", "msg", "", "onIgnore", "onSuccess", "geetestData", "Lcom/honey/account/data/GeetestData;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CaptchaManager$init$1 implements CaptchaController.Callback {
    public void onFailed(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        CaptchaManager.Callback access$getMCallback$p = CaptchaManager.mCallback;
        if (access$getMCallback$p != null) {
            access$getMCallback$p.onFail(str);
        }
    }

    public void onIgnore() {
        CaptchaManager.Callback access$getMCallback$p = CaptchaManager.mCallback;
        if (access$getMCallback$p != null) {
            CaptchaManager.Callback.DefaultImpls.onSuccess$default(access$getMCallback$p, (GeetestData) null, 1, (Object) null);
        }
    }

    public void onSuccess(@Nullable GeetestData geetestData) {
        CaptchaManager.Callback access$getMCallback$p = CaptchaManager.mCallback;
        if (access$getMCallback$p != null) {
            access$getMCallback$p.onSuccess(geetestData);
        }
    }
}
