package com.honey.account.controller;

import android.app.Activity;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.controller.CaptchaController;
import com.honey.account.utils.network.Response;
import java.lang.ref.WeakReference;
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
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.controller.CaptchaController$handlerCaptchaData$1", f = "CaptchaController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptchaController$handlerCaptchaData$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Response $response;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CaptchaController$handlerCaptchaData$1(Response response, Continuation<? super CaptchaController$handlerCaptchaData$1> continuation) {
        super(1, continuation);
        this.$response = response;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new CaptchaController$handlerCaptchaData$1(this.$response, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Log.d("CaptchaManager", "geetest4 request. body: " + this.$response.getBody());
            String body = this.$response.getBody();
            String str = "";
            if (body == null || body.length() == 0 || this.$response.getCode() != 200) {
                CaptchaController.Callback access$getMCallback$p = CaptchaController.mCallback;
                if (access$getMCallback$p != null) {
                    int code = this.$response.getCode();
                    String message = this.$response.getMessage();
                    if (message != null) {
                        str = message;
                    }
                    access$getMCallback$p.onFailed(code, str);
                }
                return Unit.INSTANCE;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.$response.getBody());
                int optInt = jSONObject.optInt("code");
                if (optInt == 200) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(AccountConstantKt.RESPONSE_VALUE);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("gt");
                        CaptchaController captchaController = CaptchaController.INSTANCE;
                        WeakReference access$getMContextWeakReference$p = CaptchaController.mContextWeakReference;
                        captchaController.showCaptcha(access$getMContextWeakReference$p != null ? (Activity) access$getMContextWeakReference$p.get() : null, optString);
                    }
                } else if (optInt != 130001) {
                    CaptchaController.Callback access$getMCallback$p2 = CaptchaController.mCallback;
                    if (access$getMCallback$p2 != null) {
                        int code2 = this.$response.getCode();
                        String message2 = this.$response.getMessage();
                        if (message2 == null) {
                            message2 = str;
                        }
                        access$getMCallback$p2.onFailed(code2, message2);
                    }
                } else {
                    CaptchaController.Callback access$getMCallback$p3 = CaptchaController.mCallback;
                    if (access$getMCallback$p3 != null) {
                        access$getMCallback$p3.onIgnore();
                    }
                }
            } catch (JSONException e) {
                Log.e("CaptchaManager", "request captcha fail. ", e);
                CaptchaController.Callback access$getMCallback$p4 = CaptchaController.mCallback;
                if (access$getMCallback$p4 != null) {
                    int code3 = this.$response.getCode();
                    String message3 = this.$response.getMessage();
                    if (message3 != null) {
                        str = message3;
                    }
                    access$getMCallback$p4.onFailed(code3, str);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((CaptchaController$handlerCaptchaData$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
