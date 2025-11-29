package com.honey.account.controller;

import android.app.Activity;
import android.util.Log;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.GTCaptcha4Config;
import com.honey.account.data.GeetestData;
import com.honey.account.utils.coroutine.CoroutineUtilsKt;
import com.honey.account.utils.network.Response;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0006\u0010\u0016\u001a\u00020\u000bJ\u001c\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/honey/account/controller/CaptchaController;", "", "()V", "TAG", "", "mCallback", "Lcom/honey/account/controller/CaptchaController$Callback;", "mContextWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "destroy", "", "handlerCaptchaData", "response", "Lcom/honey/account/utils/network/Response;", "init", "activity", "callback", "newCaptcha4Client", "Lcom/geetest/captcha/GTCaptcha4Client;", "context", "appId", "requestCaptcha", "showCaptcha", "Callback", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CaptchaController {
    @NotNull
    public static final CaptchaController INSTANCE = new CaptchaController();
    @NotNull
    private static final String TAG = "CaptchaManager";
    /* access modifiers changed from: private */
    @Nullable
    public static Callback mCallback;
    /* access modifiers changed from: private */
    @Nullable
    public static WeakReference<Activity> mContextWeakReference;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/honey/account/controller/CaptchaController$Callback;", "", "onFailed", "", "code", "", "msg", "", "onIgnore", "onSuccess", "geetestData", "Lcom/honey/account/data/GeetestData;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Callback {
        void onFailed(int i, @NotNull String str);

        void onIgnore();

        void onSuccess(@Nullable GeetestData geetestData);
    }

    private CaptchaController() {
    }

    private final void destroy() {
        Log.d(TAG, "CaptchaManager onDestroy. ");
        WeakReference<Activity> weakReference = mContextWeakReference;
        if (weakReference != null) {
            weakReference.clear();
        }
        mCallback = null;
    }

    /* access modifiers changed from: private */
    public final void handlerCaptchaData(Response response) {
        CoroutineUtilsKt.launchMain(new CaptchaController$handlerCaptchaData$1(response, (Continuation<? super CaptchaController$handlerCaptchaData$1>) null));
    }

    /* access modifiers changed from: private */
    public final GTCaptcha4Client newCaptcha4Client(Activity activity, String str) {
        GTCaptcha4Config.Builder t = new GTCaptcha4Config.Builder().s(false).u(10000).r(false).t(new LinkedHashMap());
        GTCaptcha4Client h = GTCaptcha4Client.h(activity);
        h.j(false);
        h.i(str, t.q());
        return h;
    }

    /* access modifiers changed from: private */
    public final void showCaptcha(Activity activity, String str) {
        CoroutineUtilsKt.launchMain(new CaptchaController$showCaptcha$1(activity, str, (Continuation<? super CaptchaController$showCaptcha$1>) null));
    }

    public final void init(@NotNull Activity activity, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        destroy();
        mContextWeakReference = new WeakReference<>(activity);
        mCallback = callback;
        Log.d(TAG, "CaptchaManager  init. activity: " + activity + ", mCallbackWeakReference: " + mCallback);
    }

    public final void requestCaptcha() {
        CoroutineUtilsKt.launchMain(new CaptchaController$requestCaptcha$1((Continuation<? super CaptchaController$requestCaptcha$1>) null));
    }
}
