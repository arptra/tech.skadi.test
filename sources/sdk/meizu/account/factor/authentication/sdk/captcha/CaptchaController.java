package sdk.meizu.account.factor.authentication.sdk.captcha;

import android.app.Activity;
import android.util.Log;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.utils.GT3ServiceNode;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import retrofit2.Response;
import sdk.meizu.account.factor.authentication.sdk.api.CaptchaApiService;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;
import sdk.meizu.account.factor.authentication.sdk.module.NetworkModule;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u0016\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/captcha/CaptchaController;", "", "()V", "RESULT_CODE_ERROR_GEETEST_NOT_OPEN", "", "TAG", "", "TIMEOUT_DEFAULT", "apiService", "Lsdk/meizu/account/factor/authentication/sdk/api/CaptchaApiService;", "mCallback", "Lsdk/meizu/account/factor/authentication/sdk/captcha/CaptchaController$Callback;", "mContextWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mGt3ApiParam", "Lorg/json/JSONObject;", "mGt3ConfigBean", "Lcom/geetest/sdk/GT3ConfigBean;", "mGt3GeetestUtils", "Lcom/geetest/sdk/GT3GeetestUtils;", "bindCaptcha", "", "destroy", "handlerCaptchaData", "Lkotlinx/coroutines/Job;", "response", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "init", "activity", "callback", "requestCaptcha", "Callback", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CaptchaController {
    @NotNull
    public static final CaptchaController INSTANCE = new CaptchaController();
    private static final int RESULT_CODE_ERROR_GEETEST_NOT_OPEN = 130001;
    @NotNull
    private static final String TAG = "CaptchaManager";
    private static final int TIMEOUT_DEFAULT = 10000;
    /* access modifiers changed from: private */
    @NotNull
    public static final CaptchaApiService apiService;
    /* access modifiers changed from: private */
    @Nullable
    public static Callback mCallback;
    /* access modifiers changed from: private */
    @Nullable
    public static WeakReference<Activity> mContextWeakReference;
    /* access modifiers changed from: private */
    @Nullable
    public static JSONObject mGt3ApiParam;
    /* access modifiers changed from: private */
    @Nullable
    public static GT3ConfigBean mGt3ConfigBean;
    /* access modifiers changed from: private */
    @Nullable
    public static GT3GeetestUtils mGt3GeetestUtils;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/captcha/CaptchaController$Callback;", "", "onFailed", "", "code", "", "msg", "", "onIgnore", "onSuccess", "geetestData", "Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Callback {
        void onFailed(int i, @NotNull String str);

        void onIgnore();

        void onSuccess(@Nullable GeetestData geetestData);
    }

    static {
        NetworkModule networkModule = NetworkModule.INSTANCE;
        apiService = networkModule.provideGeetestService(networkModule.provideRetrofit());
    }

    private CaptchaController() {
    }

    private final void bindCaptcha() {
        Activity activity;
        WeakReference<Activity> weakReference = mContextWeakReference;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            mGt3GeetestUtils = new GT3GeetestUtils(activity);
            GT3ConfigBean gT3ConfigBean = new GT3ConfigBean();
            gT3ConfigBean.y(1);
            gT3ConfigBean.s(true);
            gT3ConfigBean.z(false);
            gT3ConfigBean.w((String) null);
            gT3ConfigBean.A(10000);
            gT3ConfigBean.B(10000);
            gT3ConfigBean.v(GT3ServiceNode.NODE_CHINA);
            gT3ConfigBean.t((int) Math.abs(0.0d));
            gT3ConfigBean.u(0);
            gT3ConfigBean.x(new CaptchaController$bindCaptcha$1$1());
            mGt3ConfigBean = gT3ConfigBean;
            GT3GeetestUtils gT3GeetestUtils = mGt3GeetestUtils;
            if (gT3GeetestUtils != null) {
                gT3GeetestUtils.d(gT3ConfigBean);
            }
        }
    }

    private final void destroy() {
        Log.d(TAG, "CaptchaManager onDestroy. ");
        mGt3ConfigBean = null;
        GT3GeetestUtils gT3GeetestUtils = mGt3GeetestUtils;
        if (gT3GeetestUtils != null) {
            gT3GeetestUtils.a();
        }
        mGt3GeetestUtils = null;
        WeakReference<Activity> weakReference = mContextWeakReference;
        if (weakReference != null) {
            weakReference.clear();
        }
        mCallback = null;
    }

    /* access modifiers changed from: private */
    public final Job handlerCaptchaData(Response<ResponseBody> response) {
        return BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new CaptchaController$handlerCaptchaData$1(response, (Continuation<? super CaptchaController$handlerCaptchaData$1>) null), 3, (Object) null);
    }

    public final void init(@NotNull Activity activity, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        destroy();
        mContextWeakReference = new WeakReference<>(activity);
        mCallback = callback;
        bindCaptcha();
        Log.d(TAG, "CaptchaManager  init. activity: " + activity + ", mCallbackWeakReference: " + mCallback);
    }

    @NotNull
    public final Job requestCaptcha() {
        return BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new CaptchaController$requestCaptcha$1((Continuation<? super CaptchaController$requestCaptcha$1>) null), 3, (Object) null);
    }
}
