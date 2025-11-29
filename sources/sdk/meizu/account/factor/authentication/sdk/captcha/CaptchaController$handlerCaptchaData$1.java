package sdk.meizu.account.factor.authentication.sdk.captcha;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController$handlerCaptchaData$1", f = "CaptchaController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptchaController$handlerCaptchaData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Response<ResponseBody> $response;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CaptchaController$handlerCaptchaData$1(Response<ResponseBody> response, Continuation<? super CaptchaController$handlerCaptchaData$1> continuation) {
        super(2, continuation);
        this.$response = response;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CaptchaController$handlerCaptchaData$1 captchaController$handlerCaptchaData$1 = new CaptchaController$handlerCaptchaData$1(this.$response, continuation);
        captchaController$handlerCaptchaData$1.L$0 = obj;
        return captchaController$handlerCaptchaData$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
        if (r3 == null) goto L_0x00aa;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            if (r0 != 0) goto L_0x00e3
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "geetest3 request. body: "
            r6.append(r0)
            retrofit2.Response<okhttp3.ResponseBody> r0 = r5.$response
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "CaptchaManager"
            android.util.Log.d(r0, r6)
            retrofit2.Response<okhttp3.ResponseBody> r6 = r5.$response
            boolean r6 = r6.isSuccessful()
            java.lang.String r1 = "message(...)"
            if (r6 != 0) goto L_0x004b
            sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController$Callback r6 = sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController.mCallback
            if (r6 == 0) goto L_0x0048
            retrofit2.Response<okhttp3.ResponseBody> r0 = r5.$response
            int r0 = r0.code()
            retrofit2.Response<okhttp3.ResponseBody> r5 = r5.$response
            java.lang.String r5 = r5.message()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            r6.onFailed(r0, r5)
        L_0x0048:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x004b:
            retrofit2.Response<okhttp3.ResponseBody> r6 = r5.$response     // Catch:{ JSONException -> 0x0083 }
            java.lang.Object r6 = r6.body()     // Catch:{ JSONException -> 0x0083 }
            okhttp3.ResponseBody r6 = (okhttp3.ResponseBody) r6     // Catch:{ JSONException -> 0x0083 }
            if (r6 == 0) goto L_0x00aa
            java.lang.String r6 = r6.string()     // Catch:{ JSONException -> 0x0083 }
            if (r6 == 0) goto L_0x00aa
            retrofit2.Response<okhttp3.ResponseBody> r2 = r5.$response     // Catch:{ JSONException -> 0x0083 }
            sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController r3 = sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController.INSTANCE     // Catch:{ JSONException -> 0x0083 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0083 }
            r3.<init>(r6)     // Catch:{ JSONException -> 0x0083 }
            sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController.mGt3ApiParam = r3     // Catch:{ JSONException -> 0x0083 }
            org.json.JSONObject r6 = sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController.mGt3ApiParam     // Catch:{ JSONException -> 0x0083 }
            r3 = 0
            if (r6 == 0) goto L_0x0085
            java.lang.String r4 = "success"
            int r6 = r6.optInt(r4)     // Catch:{ JSONException -> 0x0083 }
            r4 = 1
            if (r6 != r4) goto L_0x0085
            com.geetest.sdk.GT3GeetestUtils r6 = sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController.mGt3GeetestUtils     // Catch:{ JSONException -> 0x0083 }
            if (r6 == 0) goto L_0x00a8
            r6.f()     // Catch:{ JSONException -> 0x0083 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ JSONException -> 0x0083 }
            goto L_0x00a8
        L_0x0083:
            r6 = move-exception
            goto L_0x00c3
        L_0x0085:
            sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController$Callback r6 = sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController.mCallback     // Catch:{ JSONException -> 0x0083 }
            if (r6 == 0) goto L_0x00a8
            int r2 = r2.code()     // Catch:{ JSONException -> 0x0083 }
            org.json.JSONObject r4 = sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController.mGt3ApiParam     // Catch:{ JSONException -> 0x0083 }
            if (r4 == 0) goto L_0x009b
            java.lang.String r3 = "msg"
            java.lang.String r3 = r4.optString(r3)     // Catch:{ JSONException -> 0x0083 }
        L_0x009b:
            if (r3 != 0) goto L_0x00a0
            java.lang.String r3 = ""
            goto L_0x00a3
        L_0x00a0:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ JSONException -> 0x0083 }
        L_0x00a3:
            r6.onFailed(r2, r3)     // Catch:{ JSONException -> 0x0083 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ JSONException -> 0x0083 }
        L_0x00a8:
            if (r3 != 0) goto L_0x00e0
        L_0x00aa:
            retrofit2.Response<okhttp3.ResponseBody> r6 = r5.$response     // Catch:{ JSONException -> 0x0083 }
            sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController$Callback r2 = sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController.mCallback     // Catch:{ JSONException -> 0x0083 }
            if (r2 == 0) goto L_0x00e0
            int r3 = r6.code()     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r6 = r6.message()     // Catch:{ JSONException -> 0x0083 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch:{ JSONException -> 0x0083 }
            r2.onFailed(r3, r6)     // Catch:{ JSONException -> 0x0083 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ JSONException -> 0x0083 }
            goto L_0x00e0
        L_0x00c3:
            java.lang.String r2 = "request captcha fail. "
            android.util.Log.e(r0, r2, r6)
            sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController$Callback r6 = sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController.mCallback
            if (r6 == 0) goto L_0x00e0
            retrofit2.Response<okhttp3.ResponseBody> r0 = r5.$response
            int r0 = r0.code()
            retrofit2.Response<okhttp3.ResponseBody> r5 = r5.$response
            java.lang.String r5 = r5.message()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            r6.onFailed(r0, r5)
        L_0x00e0:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x00e3:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController$handlerCaptchaData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CaptchaController$handlerCaptchaData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
