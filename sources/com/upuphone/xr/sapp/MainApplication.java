package com.upuphone.xr.sapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import androidx.collection.ArrayMapKt;
import com.tencent.mmkv.MMKV;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.checknavi.CheckNaviSupportManager;
import com.upuphone.xr.interconnect.util.XrSdkDeviceUtil;
import com.upuphone.xr.sapp.ability.PhoneNaviAbility;
import com.upuphone.xr.sapp.ability.PhoneSappAbility;
import com.upuphone.xr.sapp.ability.PhoneTransAbility;
import com.upuphone.xr.sapp.asmhook.PowerMonitor;
import com.upuphone.xr.sapp.assistant.VoiceAssistantDelegate;
import com.upuphone.xr.sapp.common.AccountContextImpl;
import com.upuphone.xr.sapp.common.ActivityLifecycleManager;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.context.DataStoreContextImpl;
import com.upuphone.xr.sapp.context.PermissionContextImpl;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.contract.NaviNotSupportHelper;
import com.upuphone.xr.sapp.contract.ProtocolActivity;
import com.upuphone.xr.sapp.datatrack.DataTrackContextImpl;
import com.upuphone.xr.sapp.debug.DebugConfigUtil;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.glass.GlassContextImpl;
import com.upuphone.xr.sapp.superconnect.ui.SplashActivity;
import com.upuphone.xr.sapp.unicron.RingContextImpl;
import com.upuphone.xr.sapp.utils.BuglyManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.WebViewPool;
import com.upuphone.xr.sapp.vu.receiver.UsbAttachDetachReceiver;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.crash.DefaultCrashHandler;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.flutter.FlutterEngineManager;
import com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler;
import com.xjsd.ai.assistant.adapt.ImDelegator;
import com.xjsd.ai.assistant.phone.AssistantLifecycle;
import dagger.hilt.android.HiltAndroidApp;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@SourceDebugExtension({"SMAP\nMainApplication.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainApplication.kt\ncom/upuphone/xr/sapp/MainApplication\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,417:1\n533#2,6:418\n*S KotlinDebug\n*F\n+ 1 MainApplication.kt\ncom/upuphone/xr/sapp/MainApplication\n*L\n167#1:418,6\n*E\n"})
@HiltAndroidApp
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001YB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u0019\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010#J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b&\u0010#J\u001f\u0010(\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001eH\u0016¢\u0006\u0004\b(\u0010!J\u0017\u0010)\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b)\u0010#J\r\u0010*\u001a\u00020\b¢\u0006\u0004\b*\u0010\u0005J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\nJ\r\u0010-\u001a\u00020\b¢\u0006\u0004\b-\u0010\u0005R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R2\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020302j\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u000203`48\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c088\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R(\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001c088\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010:\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010I\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010O\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010\nR\"\u0010S\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010\nR\u0014\u0010W\u001a\u00020T8\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Z"}, d2 = {"Lcom/upuphone/xr/sapp/MainApplication;", "Lcom/upuphone/xr/sapp/BaseApplication;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Lcom/upuphone/xr/interconnect/InterconnectManager$OnStarrySdkStateChangeListener;", "<init>", "()V", "", "foreground", "", "y", "(Z)V", "B", "u", "Landroid/content/Context;", "context", "w", "(Landroid/content/Context;)Z", "", "s", "(Landroid/content/Context;)Ljava/lang/String;", "o", "base", "attachBaseContext", "(Landroid/content/Context;)V", "onCreate", "Lcom/xjmz/myvu/MYVUActivity;", "r", "()Lcom/xjmz/myvu/MYVUActivity;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "p", "enable", "onStateChanged", "t", "", "c", "I", "mActivityCount", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "activityMap", "", "e", "Ljava/util/List;", "activityList", "f", "q", "()Ljava/util/List;", "setMCurrentActivityList", "(Ljava/util/List;)V", "mCurrentActivityList", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "g", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "getMConnectInfo", "()Lcom/upuphone/xr/sapp/entity/NetDevice;", "z", "(Lcom/upuphone/xr/sapp/entity/NetDevice;)V", "mConnectInfo", "h", "Z", "v", "()Z", "setForeground", "isForeground", "i", "x", "A", "isStartCold", "Lkotlinx/coroutines/CoroutineScope;", "j", "Lkotlinx/coroutines/CoroutineScope;", "naviSupportScope", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MainApplication extends Hilt_MainApplication implements Application.ActivityLifecycleCallbacks, InterconnectManager.OnStarrySdkStateChangeListener {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public static MainApplication l;
    public static boolean m;
    public static boolean n;
    public static String o;
    public static boolean p;
    public static boolean q;
    public static boolean r;
    public static final FlutterEngineManager s = new FlutterEngineManager();
    public int c;
    public HashMap d = new HashMap();
    public final List e = new CopyOnWriteArrayList();
    public List f = new ArrayList();
    public NetDevice g;
    public boolean h;
    public boolean i;
    public final CoroutineScope j = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u0016R\"\u0010$\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u0016R\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u0016R\u0014\u0010*\u001a\u00020\u001a8\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u001cR\u0014\u0010+\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/upuphone/xr/sapp/MainApplication$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/MainApplication;", "d", "()Lcom/upuphone/xr/sapp/MainApplication;", "Lcom/xjmz/myvu/flutter/FlutterEngineManager;", "e", "()Lcom/xjmz/myvu/flutter/FlutterEngineManager;", "", "j", "()Z", "instance", "Lcom/upuphone/xr/sapp/MainApplication;", "f", "n", "(Lcom/upuphone/xr/sapp/MainApplication;)V", "closeSuperServiceByUser", "Z", "b", "k", "(Z)V", "superViewModelState", "h", "p", "", "connectDeviceID", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "isConnecting", "i", "m", "mConnectFail", "g", "o", "abilityInit", "a", "setAbilityInit", "TAG", "engineManager", "Lcom/xjmz/myvu/flutter/FlutterEngineManager;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return MainApplication.r;
        }

        public final boolean b() {
            return MainApplication.m;
        }

        public final String c() {
            return MainApplication.o;
        }

        public final MainApplication d() {
            return f();
        }

        public final FlutterEngineManager e() {
            return MainApplication.s;
        }

        public final MainApplication f() {
            MainApplication mainApplication = MainApplication.l;
            if (mainApplication != null) {
                return mainApplication;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        public final boolean g() {
            return MainApplication.q;
        }

        public final boolean h() {
            return MainApplication.n;
        }

        public final boolean i() {
            return MainApplication.p;
        }

        public final boolean j() {
            return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_user_agreement_state", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        }

        public final void k(boolean z) {
            MainApplication.m = z;
        }

        public final void l(String str) {
            MainApplication.o = str;
        }

        public final void m(boolean z) {
            MainApplication.p = z;
        }

        public final void n(MainApplication mainApplication) {
            Intrinsics.checkNotNullParameter(mainApplication, "<set-?>");
            MainApplication.l = mainApplication;
        }

        public final void o(boolean z) {
            MainApplication.q = z;
        }

        public final void p(boolean z) {
            MainApplication.n = z;
        }

        public Companion() {
        }
    }

    public final void A(boolean z) {
        this.i = z;
    }

    public final void B() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        int intValue = ((Number) DataStoreUtils.i(companion.a(), "app_startup_myvuapp", 1, (Context) null, 4, (Object) null)).intValue();
        DataTrackUtil.f7875a.i("app_startup_myvuapp", MapsKt.toMap(ArrayMapKt.a(TuplesKt.to(RtspHeaders.Values.TIME, String.valueOf(intValue)))));
        companion.a().o("app_startup_myvuapp", Integer.valueOf(intValue + 1));
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("boot-SAS@MainApplication", "attachBaseContext->start");
        k.n(this);
        delegate.a("boot-SAS@MainApplication", "attachBaseContext->end");
    }

    public final void o() {
        List b = ConnectExtKt.b();
        if (this.e.isEmpty() && b.isEmpty() && !BuildConfig.b.booleanValue()) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("boot-SAS@MainApplication", "checkNeedCloseApp");
            if (PermissionAndStateCheckUtils.f7907a.g(this)) {
                delegate.a("boot-SAS@MainApplication", "Notification Listener Permission is Open");
                return;
            }
            StaticMethodUtilsKt.W(this);
            ImDelegator.f8381a.d().b(this);
            Object systemService = getSystemService("jobscheduler");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
            ((JobScheduler) systemService).cancelAll();
            Process.killProcess(Process.myPid());
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("SAS@MainApplication", "onActivityCreated::activity is: " + activity);
        this.d.put(activity, Long.valueOf(System.currentTimeMillis()));
        this.e.add(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!this.e.isEmpty()) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("SAS@MainApplication", "onActivityDestroyed::activity is: " + activity);
            this.e.remove(activity);
        }
        if (((Long) this.d.get(activity)) != null) {
            Long l2 = (Long) this.d.remove(activity);
        }
        o();
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("SAS@MainApplication", "onActivityResumed::activity->" + activity);
        if (this.g != null) {
            ArrayList arrayListOf = CollectionsKt.arrayListOf(141);
            NetDevice netDevice = this.g;
            Intrinsics.checkNotNull(netDevice);
            StaticMethodUtilsKt.F(activity, arrayListOf, MapsKt.hashMapOf(TuplesKt.to(141, netDevice)), false, false, 12, (Object) null);
            this.g = null;
        }
        if (!this.f.contains(activity)) {
            this.f.add(0, activity);
        }
        Long l2 = (Long) this.d.get(activity);
        if (l2 != null) {
            delegate.a("SAS@MainApplication", "activity->" + activity + " 耗时->" + (System.currentTimeMillis() - l2.longValue()) + " ms");
            Long l3 = (Long) this.d.remove(activity);
        }
        if ((activity instanceof MYVUActivity) || (activity instanceof SplashActivity) || (activity instanceof ProtocolActivity)) {
            delegate.a("SAS@MainApplication", "activity->ignore");
        } else {
            StarryNetHelper.f7917a.f();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 != 0) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("SAS@MainApplication", "super app in front activity is: " + activity + " mActivityCount is: " + i2);
            y(true);
            if (!k.j()) {
                delegate.a("SAS@MainApplication", "onActivityStarted-> 没有同意用户协议返回");
                return;
            }
            InterconnectManager.getInstance().getStarryNetDeviceManager().interceptConnectProcess(true);
            if (this.c == 1) {
                DataTrackUtil.f7875a.i("app_onceuse_myvuapp", MapsKt.toMap(ArrayMapKt.a(TuplesKt.to(RtspHeaders.Values.TIME, String.valueOf(System.currentTimeMillis())))));
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("SAS@MainApplication", "onActivityStopped::activity->" + activity);
        if (this.f.contains(activity)) {
            this.f.remove(activity);
        }
        int i2 = this.c - 1;
        this.c = i2;
        if (i2 == 0) {
            delegate.a("SAS@MainApplication", "super app in background");
            y(false);
            if (!BuildConfig.b.booleanValue()) {
                InterconnectManager.getInstance().getStarryNetDeviceManager().interceptConnectProcess(false);
            }
            Map map = MapsKt.toMap(ArrayMapKt.a(TuplesKt.to("time_out", String.valueOf(System.currentTimeMillis()))));
            DataTrackUtil dataTrackUtil = DataTrackUtil.f7875a;
            dataTrackUtil.i("app_onceuse_myvuapp", map);
            dataTrackUtil.h(this);
        }
    }

    public void onCreate() {
        super.onCreate();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("boot-SAS@MainApplication", "onCreate->start");
        Boolean bool = BuildConfig.f6575a;
        delegate.a("SAS@MainApplication", "appConfig->\n isIntl: " + bool + ", \n FLAVOR: intl, \n version: 2040051\n sdk_context_version: com.upuphone.xr.sapp:context:0.28.11-SNAPSHOT\n myvu_flutter_version: com.xjmz.myvu:flutter_release:2.40.0-SNAPSHOT\n xr_sdk_version: GlassAndRing-4.0.1.0");
        this.i = true;
        if (w(this)) {
            MMKV.y(this);
            DebugConfigUtil.f6929a.a(this);
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            XrSdkDeviceUtil.setIsIntl(bool.booleanValue());
            Boolean bool2 = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool2, "THIRD_PLATFOM");
            XrSdkDeviceUtil.setThirdPhone(bool2.booleanValue());
            NetConfig.f6666a.x();
            SdkContext sdkContext = SdkContext.f6675a;
            sdkContext.i(new AppContextImpl());
            sdkContext.l(GlassContextImpl.f7047a);
            if (k.j()) {
                t();
                StarryNetHelper starryNetHelper = StarryNetHelper.f7917a;
                starryNetHelper.f();
                starryNetHelper.g();
            }
            DefaultCrashHandler.f8232a.a(this);
            registerActivityLifecycleCallbacks(this);
            registerActivityLifecycleCallbacks(ActivityLifecycleManager.f6654a);
            registerActivityLifecycleCallbacks(new AssistantLifecycle());
            UsbAttachDetachReceiver.b.a(this);
            CheckNaviSupportManager checkNaviSupportManager = CheckNaviSupportManager.INSTANCE;
            NaviNotSupportHelper.Companion companion = NaviNotSupportHelper.f6695a;
            checkNaviSupportManager.registerCallback(companion.a());
            VoiceCheckNaviSupportManager.f42a.b(companion.a());
            delegate.a("boot-SAS@MainApplication", "onCreate->end");
        }
    }

    public void onStateChanged(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("SAS@MainApplication", "initStarrySDK::starrySdkState is : " + z);
        if (z) {
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (bool.booleanValue()) {
                delegate.a("SAS@MainApplication", "initStarrySDK::do startDiscovery");
                StarryNetHelper starryNetHelper = StarryNetHelper.f7917a;
                StarryNetHelper.StartDiscoveryCondition e2 = starryNetHelper.e();
                e2.d(true);
                starryNetHelper.i(e2);
            }
        }
    }

    public final void p() {
        for (Activity finish : this.e) {
            finish.finish();
        }
    }

    public final List q() {
        return this.f;
    }

    public final MYVUActivity r() {
        Object obj;
        List list = this.e;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((Activity) obj) instanceof MYVUActivity) {
                break;
            }
        }
        if (obj instanceof MYVUActivity) {
            return (MYVUActivity) obj;
        }
        return null;
    }

    public final String s(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return null;
    }

    public final void t() {
        if (r) {
            ULog.f6446a.a("SAS@MainApplication", "initAllAbility-> already inited");
            return;
        }
        BuglyManager buglyManager = BuglyManager.f7849a;
        buglyManager.n();
        buglyManager.j();
        PowerMonitor.k();
        s.e(this);
        StarryNetApiHandler.m.b();
        InterconnectManager.getInstance().registerOnStarrySdkStateChangeListener(this);
        u();
        ULog.Delegate delegate = ULog.f6446a;
        ULog.Delegate.r(delegate, this, false, false, 6, (Object) null);
        delegate.a("boot-SAS@MainApplication", "initAllAbility->start");
        r = true;
        InterconnectManager.getInstance();
        new PhoneNaviAbility(this).a();
        PhoneSappAbility.Companion companion = PhoneSappAbility.h;
        companion.a().h(this);
        companion.a().e();
        new PhoneTransAbility(this).a();
        WebViewPool.Companion companion2 = WebViewPool.e;
        companion2.a().j(Integer.min(Runtime.getRuntime().availableProcessors(), 3));
        WebViewPool.g(companion2.a(), this, 0, 2, (Object) null);
        DataTrackUtil.f7875a.g(this);
        B();
        VoiceAssistantDelegate.f6640a.a(this);
        TiciApp.b.m(new MainApplication$initAllAbility$1());
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new MainApplication$initAllAbility$2((Continuation<? super MainApplication$initAllAbility$2>) null), 3, (Object) null);
        TranslationApp.INSTANCE.init(this);
        delegate.a("boot-SAS@MainApplication", "initAllAbility->end");
    }

    public final void u() {
        SdkContext sdkContext = SdkContext.f6675a;
        sdkContext.k(new DataTrackContextImpl());
        sdkContext.n(RingContextImpl.f7830a);
        sdkContext.j(new DataStoreContextImpl());
        sdkContext.h(AccountContextImpl.f6652a);
        sdkContext.m(new PermissionContextImpl());
    }

    public final boolean v() {
        return this.h;
    }

    public final boolean w(Context context) {
        return Intrinsics.areEqual((Object) context.getPackageName(), (Object) s(context));
    }

    public final boolean x() {
        return this.i;
    }

    public final void y(boolean z) {
        Intent intent = new Intent("action_notify_foreground");
        intent.putExtra("foreground_state", z);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("SAS@MainApplication", "notifyForegroundState to navi and others ::foreground is: " + z);
        this.h = z;
        if (!k.j()) {
            delegate.a("SAS@MainApplication", "notifyForegroundState-> 没有同意用户协议返回");
            return;
        }
        sendBroadcast(intent);
        if (!this.h) {
            DataTrackUtil.f7875a.w();
        }
        NaviManager.getInstance(this).setAppForeground(z);
    }

    public final void z(NetDevice netDevice) {
        this.g = netDevice;
    }
}
