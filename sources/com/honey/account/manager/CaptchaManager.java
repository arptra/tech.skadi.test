package com.honey.account.manager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.honey.account.AccountHelper;
import com.honey.account.R;
import com.honey.account.controller.CaptchaController;
import com.honey.account.data.GeetestData;
import com.honey.account.utils.network.NetworkUtilsKt;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/honey/account/manager/CaptchaManager;", "Landroid/view/View$OnClickListener;", "()V", "mApplication", "Landroid/content/Context;", "mCallback", "Lcom/honey/account/manager/CaptchaManager$Callback;", "mCodeTv", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "bind", "", "activity", "Landroid/app/Activity;", "vCodeTv", "callBack", "destroy", "init", "onClick", "v", "requestCaptcha", "application", "Callback", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CaptchaManager implements View.OnClickListener {
    @NotNull
    public static final CaptchaManager INSTANCE = new CaptchaManager();
    @Nullable
    private static Context mApplication;
    /* access modifiers changed from: private */
    @Nullable
    public static Callback mCallback;
    @Nullable
    private static WeakReference<View> mCodeTv;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/honey/account/manager/CaptchaManager$Callback;", "", "getAccount", "", "isAgreement", "", "agreeCallback", "Lkotlin/Function0;", "", "onFail", "msg", "onSuccess", "data", "Lcom/honey/account/data/GeetestData;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Callback {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onSuccess$default(Callback callback, GeetestData geetestData, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        geetestData = null;
                    }
                    callback.onSuccess(geetestData);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
            }
        }

        @NotNull
        String getAccount();

        boolean isAgreement(@NotNull Function0<Unit> function0);

        void onFail(@Nullable String str);

        void onSuccess(@Nullable GeetestData geetestData);
    }

    private CaptchaManager() {
    }

    private final void destroy() {
        mCallback = null;
    }

    private final void init(Activity activity) {
        View view;
        CaptchaController.INSTANCE.init(activity, new CaptchaManager$init$1());
        WeakReference<View> weakReference = mCodeTv;
        if (weakReference != null && (view = weakReference.get()) != null) {
            view.setOnClickListener(this);
        }
    }

    public final void bind(@NotNull Activity activity, @NotNull View view, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "vCodeTv");
        Intrinsics.checkNotNullParameter(callback, "callBack");
        destroy();
        mCodeTv = new WeakReference<>(view);
        mApplication = AccountHelper.INSTANCE.getMApplicationContext();
        mCallback = callback;
        init(activity);
    }

    public void onClick(@Nullable View view) {
        Callback callback;
        Context context = mApplication;
        if (context != null && (callback = mCallback) != null && callback.isAgreement(new CaptchaManager$onClick$1$1(context))) {
            INSTANCE.requestCaptcha(context);
        }
    }

    public final void requestCaptcha(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, VuiModelType.APPLICATION);
        if (!NetworkUtilsKt.isNetworkConnected(context)) {
            Callback callback = mCallback;
            if (callback != null) {
                callback.onFail(context.getString(R.string.not_network));
                return;
            }
            return;
        }
        CaptchaController.INSTANCE.requestCaptcha();
    }
}
