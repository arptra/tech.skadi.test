package sdk.meizu.account.factor.authentication.sdk.captcha;

import android.app.Activity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.api.CaptchaApiService;
import sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController;
import sdk.meizu.account.factor.authentication.sdk.common.helper.NetworkUtilKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sdk.meizu.account.factor.authentication.sdk.captcha.CaptchaController$requestCaptcha$1", f = "CaptchaController.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class CaptchaController$requestCaptcha$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public CaptchaController$requestCaptcha$1(Continuation<? super CaptchaController$requestCaptcha$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CaptchaController$requestCaptcha$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Activity activity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WeakReference access$getMContextWeakReference$p = CaptchaController.mContextWeakReference;
            if (access$getMContextWeakReference$p == null || (activity = (Activity) access$getMContextWeakReference$p.get()) == null) {
                return Unit.INSTANCE;
            }
            if (!NetworkUtilKt.isNetworkConnected(activity)) {
                CaptchaController.Callback access$getMCallback$p = CaptchaController.mCallback;
                if (access$getMCallback$p != null) {
                    String string = activity.getString(R.string.not_network);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    access$getMCallback$p.onFailed(500, string);
                }
                return Unit.INSTANCE;
            }
            CaptchaApiService access$getApiService$p = CaptchaController.apiService;
            this.label = 1;
            obj = access$getApiService$p.init(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Job unused = CaptchaController.INSTANCE.handlerCaptchaData((Response) obj);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CaptchaController$requestCaptcha$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
