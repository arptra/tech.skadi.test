package com.xjmz.myvu.flutter.pigeon.impl;

import android.content.Context;
import android.content.Intent;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.checknavi.CheckNaviSupportManager;
import com.upuphone.xr.interconnect.checknavi.NaviNotSupportCallback;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.TodoManageActivity;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.contract.ModulePrivacyManagerKt;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.dialog.LoginFragmentDialog;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.time.DateUtils;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00140\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/AppApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$AppApi;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$AppRequest;", "request", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$Result;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$AppReply;", "result", "", "f", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$AppRequest;Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$Result;)V", "i", "", "r", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$Result;)V", "k", "h", "", "s", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "b", "J", "lastNavigationTime", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public class AppApiHandler implements AndroidAppApi.AppApi {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f8345a;
    public long b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/AppApiHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AppApiHandler(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8345a = context;
    }

    public void f(AndroidAppApi.AppRequest appRequest, AndroidAppApi.Result result) {
        Intrinsics.checkNotNullParameter(appRequest, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("AppApiHandler", "openAnyNativeActivity() called with: request = " + appRequest + ", result = " + result);
        try {
            this.f8345a.startActivity(new Intent(this.f8345a, Class.forName(appRequest.b())));
        } catch (Exception e) {
            ULog.f6446a.p("AppApiHandler", "openAnyNativeActivity: ", e);
            new AndroidAppApi.AppReply.Builder().b(-1L).c("").a();
        }
        result.success(new AndroidAppApi.AppReply.Builder().b(200L).c("").a());
    }

    public void h(AndroidAppApi.Result result) {
        AndroidAppApi.Result result2 = result;
        Intrinsics.checkNotNullParameter(result2, "result");
        if (SdkContext.f6675a.c().f()) {
            boolean C = PermissionAndStateCheckUtils.f7907a.C(this.f8345a);
            DataStoreUtils.Companion companion = DataStoreUtils.e;
            DataStoreUtils a2 = companion.a();
            Boolean bool = Boolean.FALSE;
            boolean booleanValue = ((Boolean) DataStoreUtils.i(a2, "automatic-start", bool, (Context) null, 4, (Object) null)).booleanValue();
            Boolean bool2 = bool;
            boolean booleanValue2 = ((Boolean) DataStoreUtils.i(companion.a(), "lock-background", bool2, (Context) null, 4, (Object) null)).booleanValue();
            boolean booleanValue3 = ((Boolean) DataStoreUtils.i(companion.a(), "check_device_help_action", bool2, (Context) null, 4, (Object) null)).booleanValue();
            if (C && booleanValue && booleanValue2) {
                result2.success(bool);
            } else if (!booleanValue3) {
                result2.success(Boolean.TRUE);
            } else if (System.currentTimeMillis() - ((Number) DataStoreUtils.i(companion.a(), "check_device_help_time", 0L, (Context) null, 4, (Object) null)).longValue() >= DateUtils.MILLIS_PER_DAY) {
                companion.a().o("check_device_help_action", bool);
                result2.success(Boolean.TRUE);
            } else {
                result2.success(bool);
            }
        } else {
            result2.success(Boolean.FALSE);
        }
    }

    public void i(AndroidAppApi.AppRequest appRequest, AndroidAppApi.Result result) {
        MYVUActivity r;
        Intrinsics.checkNotNullParameter(appRequest, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        String b2 = appRequest.b();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppApiHandler", "openNamedPage: name->" + b2);
        if (b2 != null) {
            switch (b2.hashCode()) {
                case -1747753563:
                    if (b2.equals("login_page") && (r = MainApplication.k.f().r()) != null) {
                        LoginFragmentDialog.d.a(r);
                        return;
                    }
                    return;
                case -1729759755:
                    if (b2.equals("transcribe")) {
                        TranscribeApp.startMainActivity(this.f8345a);
                        return;
                    }
                    return;
                case -1721943526:
                    if (b2.equals("translator") && !ModulePrivacyManagerKt.l(MainApplication.k.f().r(), b2, (Function0) null, 4, (Object) null)) {
                        TranslationApp.startMainActivity(this.f8345a);
                        return;
                    }
                    return;
                case -799233858:
                    if (b2.equals("recorder")) {
                        FastRecordManager.Companion.getInstance().startMainActivity(this.f8345a);
                        return;
                    }
                    return;
                case 3559835:
                    if (b2.equals("tici") && !ModulePrivacyManagerKt.l(MainApplication.k.f().r(), b2, (Function0) null, 4, (Object) null)) {
                        TiciApp.b.t(this.f8345a);
                        return;
                    }
                    return;
                case 3565638:
                    if (b2.equals(VuiModelType.TODO)) {
                        Context context = this.f8345a;
                        Intent intent = new Intent(this.f8345a, TodoManageActivity.class);
                        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                        context.startActivity(intent);
                        return;
                    }
                    return;
                case 1862666772:
                    if (b2.equals(VuiModelType.NAVIGATION)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.b < AssistantConstants.TIMEOUT_VAD_MUTE) {
                            delegate.a("AppApiHandler", "忽略本次操作");
                            return;
                        }
                        this.b = currentTimeMillis;
                        boolean z = this.f8345a.getSharedPreferences("navi_support_preferences", 0).getBoolean("isSupport", true);
                        delegate.a("AppApiHandler", "--isSupport-- " + z);
                        if (z) {
                            MainApplication.Companion companion = MainApplication.k;
                            if (!ModulePrivacyManagerKt.l(companion.f().r(), b2, (Function0) null, 4, (Object) null)) {
                                NaviManager.getInstance(companion.f()).startMap(companion.f());
                                return;
                            }
                            return;
                        }
                        NaviNotSupportCallback callBack = CheckNaviSupportManager.INSTANCE.getCallBack();
                        if (callBack != null) {
                            callBack.naviNotSupport(1);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void k(AndroidAppApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        result.success(Boolean.valueOf(SdkContext.f6675a.c().f()));
    }

    public void r(AndroidAppApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        result.success(Boolean.valueOf(SdkContext.f6675a.c().e()));
    }

    public void s(AndroidAppApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        result.success(AppUtils.f7842a.e());
    }
}
