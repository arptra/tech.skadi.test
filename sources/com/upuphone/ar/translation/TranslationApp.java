package com.upuphone.ar.translation;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import com.upuphone.ar.translation.audio.debug.DebugAudioBroadcastReceiver;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.activity.TranslatorBaseActivity;
import com.upuphone.ar.translation.phone.activity.TranslatorMainActivity;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import com.upuphone.ar.translation.phone.broadcast.AssistantBroadcastReceiver;
import com.upuphone.ar.translation.phone.broadcast.TimeChangeReceiver;
import com.upuphone.ar.translation.phone.helper.BleAudioHelper;
import com.upuphone.ar.translation.phone.helper.EarlyInterConnectHelper;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.helper.NetworkTimeHelper;
import com.upuphone.ar.translation.phone.helper.NoteSyncHelper;
import com.upuphone.ar.translation.phone.helper.SwitchLangHelper;
import com.upuphone.ar.translation.phone.helper.TranslatorDbHelper;
import com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper;
import com.upuphone.ar.translation.phone.helper.TranslatorSmExHelper;
import com.upuphone.ar.translation.phone.listener.UiUpdateCallback;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.runasone.uupcast.CaptureType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0J\r\u00101\u001a\u00020/H\u0001¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6J\r\u00107\u001a\u00020\u0011H\u0000¢\u0006\u0002\b8J\u000f\u00109\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0002\b:J\r\u0010;\u001a\u00020 H\u0001¢\u0006\u0002\b<J\r\u0010=\u001a\u00020\"H\u0000¢\u0006\u0002\b>J\r\u0010?\u001a\u00020'H\u0000¢\u0006\u0002\b@J\b\u0010A\u001a\u00020 H\u0007J\u000e\u0010B\u001a\u00020/2\u0006\u00104\u001a\u000205J\b\u0010C\u001a\u00020/H\u0007J'\u0010D\u001a\u00020/2\u0006\u00104\u001a\u0002052\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010FH\u0001¢\u0006\u0002\bGJ\b\u0010H\u001a\u00020\u0017H\u0002J\b\u0010I\u001a\u00020\u0017H\u0007J\r\u0010J\u001a\u00020\u0017H\u0001¢\u0006\u0002\bKJ(\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020 2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0007J\r\u0010Q\u001a\u00020\u0017H\u0001¢\u0006\u0002\bRJ\r\u0010S\u001a\u00020\u0017H\u0000¢\u0006\u0002\bTJ\u0015\u0010U\u001a\u00020/2\u0006\u0010V\u001a\u00020WH\u0001¢\u0006\u0002\bXJ!\u0010Y\u001a\u00020/\"\u0004\b\u0000\u0010Z2\f\u0010[\u001a\b\u0012\u0004\u0012\u0002HZ0\\H\u0001¢\u0006\u0002\b]J\u000f\u0010^\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b_J\r\u0010`\u001a\u00020/H\u0001¢\u0006\u0002\baJ\u0015\u0010b\u001a\u00020/2\u0006\u0010c\u001a\u00020\u000fH\u0001¢\u0006\u0002\bdJ\u001d\u0010e\u001a\u00020/2\u0006\u0010f\u001a\u00020\u00042\u0006\u0010g\u001a\u00020-H\u0001¢\u0006\u0002\bhJ\u0015\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020\u0017H\u0001¢\u0006\u0002\bkJ\u001a\u0010l\u001a\u00020/2\u0006\u0010m\u001a\u00020 2\b\u0010n\u001a\u0004\u0018\u00010\u001eH\u0007J\u0015\u0010o\u001a\u00020/2\u0006\u0010p\u001a\u00020\u0017H\u0001¢\u0006\u0002\bqJ\u0015\u0010r\u001a\u00020/2\u0006\u0010s\u001a\u00020\u0017H\u0001¢\u0006\u0002\btJ\u0015\u0010u\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0007J\u0015\u0010x\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\byJ\u0010\u0010z\u001a\u00020/2\u0006\u0010{\u001a\u000205H\u0007J\u0018\u0010|\u001a\u00020 2\u0006\u00104\u001a\u0002052\u0006\u0010N\u001a\u00020 H\u0007J\u0010\u0010}\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0007J\u0012\u0010~\u001a\u00020 2\b\b\u0002\u0010N\u001a\u00020 H\u0007J0\u0010\u001a\u00020 2\u0006\u00104\u001a\u0002052\u0006\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020 2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0007J \u0010\u001a\u00020 2\u0006\u00104\u001a\u0002052\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0007J\u000f\u0010\u0001\u001a\u00020/H\u0001¢\u0006\u0003\b\u0001J\u0017\u0010\u0001\u001a\u00020/2\u0006\u0010f\u001a\u00020\u0004H\u0001¢\u0006\u0003\b\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b(\u0010)R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020-0,X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/upuphone/ar/translation/TranslationApp;", "", "()V", "CLOSE_ASSISTANT_ACTION", "", "GLASS_UPDATE_ACTIVITY", "LAUNCH_PLATFROM", "PLATFROM_PHONE", "ROLE_VPRINT_ACTIVITY", "TAG", "isCommonLibInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isServiceInited", "mActivityStack", "Ljava/util/Stack;", "Lcom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity;", "mEarlyInterConnectHelper", "Lcom/upuphone/ar/translation/phone/helper/EarlyInterConnectHelper;", "getMEarlyInterConnectHelper", "()Lcom/upuphone/ar/translation/phone/helper/EarlyInterConnectHelper;", "mEarlyInterConnectHelper$delegate", "Lkotlin/Lazy;", "mIsActivityOn", "", "mIsConnectedSuccessMYVU", "mIsServiceOn", "mIsStartServiceToPhone", "mIsTransExited", "mIsUserAgree", "mKeepLiveNotification", "Landroid/app/Notification;", "mKeepLiveNotifyId", "", "mNetworkTimeHelper", "Lcom/upuphone/ar/translation/phone/helper/NetworkTimeHelper;", "getMNetworkTimeHelper", "()Lcom/upuphone/ar/translation/phone/helper/NetworkTimeHelper;", "mNetworkTimeHelper$delegate", "mSmartExHelper", "Lcom/upuphone/ar/translation/phone/helper/TranslatorSmExHelper;", "getMSmartExHelper", "()Lcom/upuphone/ar/translation/phone/helper/TranslatorSmExHelper;", "mSmartExHelper$delegate", "mUiUpdateCallbackMap", "", "Lcom/upuphone/ar/translation/phone/listener/UiUpdateCallback;", "clearActivity", "", "clearActivity$ar_translator_intlRelease", "clearUiUpdateCallback", "clearUiUpdateCallback$ar_translator_intlRelease", "closeAssistant", "context", "Landroid/content/Context;", "closeAssistant$ar_translator_intlRelease", "getEarlyInterConnectHelper", "getEarlyInterConnectHelper$ar_translator_intlRelease", "getKeepLiveNotification", "getKeepLiveNotification$ar_translator_intlRelease", "getKeepLiveNotifyId", "getKeepLiveNotifyId$ar_translator_intlRelease", "getNetworkTimeHelper", "getNetworkTimeHelper$ar_translator_intlRelease", "getSmartExHelper", "getSmartExHelper$ar_translator_intlRelease", "getTransCurrentState", "init", "initConnectedSuccess", "initService", "internetReadyListener", "Lkotlin/Function0;", "initService$ar_translator_intlRelease", "isActivityOn", "isServiceOn", "isStartServiceToPhone", "isStartServiceToPhone$ar_translator_intlRelease", "isSupportLanguage", "isAir", "transType", "src", "dst", "isTransExited", "isTransExited$ar_translator_intlRelease", "isUserAgree", "isUserAgree$ar_translator_intlRelease", "notifyTranslateState", "transStateEvent", "Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;", "notifyTranslateState$ar_translator_intlRelease", "notifyVariousMsg", "T", "operateMessage", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "notifyVariousMsg$ar_translator_intlRelease", "peekActivity", "peekActivity$ar_translator_intlRelease", "popActivity", "popActivity$ar_translator_intlRelease", "pushActivity", "activity", "pushActivity$ar_translator_intlRelease", "registerUiUpdateCallback", "callbackKey", "callback", "registerUiUpdateCallback$ar_translator_intlRelease", "setActivityOn", "activityOn", "setActivityOn$ar_translator_intlRelease", "setKeepLiveNotification", "notifyId", "notification", "setServiceOn", "serviceOn", "setServiceOn$ar_translator_intlRelease", "setTransExited", "transExited", "setTransExited$ar_translator_intlRelease", "startGlassUpdateInfoActivity", "startGlassUpdateInfoActivity$ar_translator_intlRelease", "startMainActivity", "startRoleVprintActivity", "startRoleVprintActivity$ar_translator_intlRelease", "startService", "ctx", "startTranslation", "stopService", "stopTranslation", "switchLang", "unInitService", "unInitService$ar_translator_intlRelease", "unRegisterUiUpdateCallback", "unRegisterUiUpdateCallback$ar_translator_intlRelease", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranslationApp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslationApp.kt\ncom/upuphone/ar/translation/TranslationApp\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,661:1\n215#2,2:662\n*S KotlinDebug\n*F\n+ 1 TranslationApp.kt\ncom/upuphone/ar/translation/TranslationApp\n*L\n352#1:662,2\n*E\n"})
public final class TranslationApp {
    @NotNull
    private static final String CLOSE_ASSISTANT_ACTION = "com.upuphone.com.CLOSE_AI_ASSISTANT_ACTION";
    @NotNull
    private static final String GLASS_UPDATE_ACTIVITY = "com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity";
    @NotNull
    public static final TranslationApp INSTANCE = new TranslationApp();
    @NotNull
    private static final String LAUNCH_PLATFROM = "platform";
    @NotNull
    private static final String PLATFROM_PHONE = "phone";
    @NotNull
    private static final String ROLE_VPRINT_ACTIVITY = "com.upuphone.xr.sapp.RoleVprintActivity";
    @NotNull
    private static final String TAG = "TransApp";
    @NotNull
    private static AtomicBoolean isCommonLibInited = new AtomicBoolean(false);
    @NotNull
    private static AtomicBoolean isServiceInited = new AtomicBoolean(false);
    @NotNull
    private static final Stack<TranslatorBaseActivity> mActivityStack = new Stack<>();
    @NotNull
    private static final Lazy mEarlyInterConnectHelper$delegate = LazyKt.lazy(TranslationApp$mEarlyInterConnectHelper$2.INSTANCE);
    private static boolean mIsActivityOn;
    private static boolean mIsConnectedSuccessMYVU;
    private static boolean mIsServiceOn;
    private static boolean mIsStartServiceToPhone;
    private static boolean mIsTransExited;
    private static boolean mIsUserAgree;
    @Nullable
    private static Notification mKeepLiveNotification;
    private static int mKeepLiveNotifyId = MSG.MSG_PREPARING_SUCCESS;
    @NotNull
    private static final Lazy mNetworkTimeHelper$delegate = LazyKt.lazy(TranslationApp$mNetworkTimeHelper$2.INSTANCE);
    @NotNull
    private static final Lazy mSmartExHelper$delegate = LazyKt.lazy(TranslationApp$mSmartExHelper$2.INSTANCE);
    @NotNull
    private static Map<String, UiUpdateCallback> mUiUpdateCallbackMap = new LinkedHashMap();

    private TranslationApp() {
    }

    @JvmStatic
    public static final void clearActivity$ar_translator_intlRelease() {
        Stack<TranslatorBaseActivity> stack = mActivityStack;
        if (stack.isEmpty()) {
            LogExt.j("clearActivity 流程正常，无数据需要被清空", TAG);
            return;
        }
        int size = stack.size();
        LogExt.j("clearActivity 流程异常，清空栈中所有内容, size=" + size, TAG);
        stack.clear();
    }

    @JvmStatic
    public static final void clearUiUpdateCallback$ar_translator_intlRelease() {
        mUiUpdateCallbackMap.clear();
    }

    @JvmStatic
    public static final void closeAssistant$ar_translator_intlRelease(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.sendBroadcast(new Intent(CLOSE_ASSISTANT_ACTION));
    }

    @JvmStatic
    @Nullable
    public static final Notification getKeepLiveNotification$ar_translator_intlRelease() {
        return mKeepLiveNotification;
    }

    @JvmStatic
    public static final int getKeepLiveNotifyId$ar_translator_intlRelease() {
        return mKeepLiveNotifyId;
    }

    private final EarlyInterConnectHelper getMEarlyInterConnectHelper() {
        return (EarlyInterConnectHelper) mEarlyInterConnectHelper$delegate.getValue();
    }

    private final NetworkTimeHelper getMNetworkTimeHelper() {
        return (NetworkTimeHelper) mNetworkTimeHelper$delegate.getValue();
    }

    private final TranslatorSmExHelper getMSmartExHelper() {
        return (TranslatorSmExHelper) mSmartExHelper$delegate.getValue();
    }

    @JvmStatic
    public static final int getTransCurrentState() {
        return SwitchLangHelper.b();
    }

    @JvmStatic
    public static final void initConnectedSuccess() {
        if (!mIsConnectedSuccessMYVU) {
            LogExt.j("initApp MYVU互联连接成功之后初始化", TAG);
            TranslationApp translationApp = INSTANCE;
            translationApp.getMEarlyInterConnectHelper().syncMessageToLauncher();
            NetworkTimeHelper.g(translationApp.getMNetworkTimeHelper(), (Function2) null, 1, (Object) null);
            mIsConnectedSuccessMYVU = true;
        }
    }

    @JvmStatic
    public static final void initService$ar_translator_intlRelease(@NotNull Context context, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = isCommonLibInited.get();
        boolean z2 = isServiceInited.get();
        boolean isServiceOn = isServiceOn();
        TranslationApp translationApp = INSTANCE;
        boolean isActivityOn = translationApp.isActivityOn();
        LogExt.g("[Init] mIsBothInit=" + z + ", mIsServiceOnlyInit=" + z2 + ", isServiceOn=" + isServiceOn + ", isActivityOn=" + isActivityOn, TAG);
        if (isCommonLibInited.compareAndSet(false, true)) {
            boolean z3 = isCommonLibInited.get();
            LogExt.j("[Init] Service和Activity中都需要初始化的操作，mIsBothInit=" + z3, TAG);
            InterConnectHelper a2 = InterConnectHelper.c.a();
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            a2.i(applicationContext);
            if (function0 != null) {
                function0.invoke();
            }
            if (!isServiceOn() || translationApp.isUserAgree$ar_translator_intlRelease()) {
                AssistantBroadcastReceiver.Companion companion = AssistantBroadcastReceiver.f6222a;
                Context applicationContext2 = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                companion.b(applicationContext2);
                TimeChangeReceiver.Companion companion2 = TimeChangeReceiver.f6224a;
                Context applicationContext3 = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
                companion2.a(applicationContext3);
                DebugAudioBroadcastReceiver.Companion companion3 = DebugAudioBroadcastReceiver.f6197a;
                Context applicationContext4 = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
                companion3.a(applicationContext4);
            } else {
                LogExt.j("[Init] 用户未授权，不允许初始化翻译官各种服务", TAG);
                isCommonLibInited.set(false);
                return;
            }
        } else if (function0 != null) {
            function0.invoke();
        }
        if (isServiceOn() && isServiceInited.compareAndSet(false, true)) {
            boolean z4 = isServiceInited.get();
            LogExt.j("[Init] Service启动之后才需要初始化，mIsServiceOnlyInit=" + z4, TAG);
            TranslationManager a3 = TranslationManager.q.a();
            Context applicationContext5 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext5, "getApplicationContext(...)");
            a3.w(applicationContext5);
            BleAudioHelper bleAudioHelper = BleAudioHelper.f6295a;
            Context applicationContext6 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext6, "getApplicationContext(...)");
            bleAudioHelper.t(applicationContext6);
            AssistantBroadcastReceiver.f6222a.a(TranslatorConstants.isAssistantRunning());
            NoteSyncHelper.t();
        }
    }

    public static /* synthetic */ void initService$ar_translator_intlRelease$default(Context context, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        initService$ar_translator_intlRelease(context, function0);
    }

    private final boolean isActivityOn() {
        return mIsActivityOn;
    }

    @JvmStatic
    public static final boolean isServiceOn() {
        return mIsServiceOn;
    }

    @JvmStatic
    public static final boolean isStartServiceToPhone$ar_translator_intlRelease() {
        return mIsStartServiceToPhone;
    }

    @JvmStatic
    public static final boolean isSupportLanguage(boolean z, int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        return SwitchLangHelper.e(z, i, str, str2);
    }

    @JvmStatic
    public static final boolean isTransExited$ar_translator_intlRelease() {
        return mIsTransExited;
    }

    @JvmStatic
    public static final void notifyTranslateState$ar_translator_intlRelease(@NotNull TransStateEvent transStateEvent) {
        Intrinsics.checkNotNullParameter(transStateEvent, "transStateEvent");
        for (Map.Entry next : mUiUpdateCallbackMap.entrySet()) {
            String str = (String) next.getKey();
            ((UiUpdateCallback) next.getValue()).notifyTranslateState(transStateEvent);
        }
    }

    @JvmStatic
    public static final <T> void notifyVariousMsg$ar_translator_intlRelease(@NotNull OperateMessage<T> operateMessage) {
        Intrinsics.checkNotNullParameter(operateMessage, "operateMessage");
        for (Map.Entry next : mUiUpdateCallbackMap.entrySet()) {
            String str = (String) next.getKey();
            ((UiUpdateCallback) next.getValue()).notifyVariousMsg(operateMessage);
        }
    }

    @JvmStatic
    @Nullable
    public static final TranslatorBaseActivity peekActivity$ar_translator_intlRelease() {
        Stack<TranslatorBaseActivity> stack = mActivityStack;
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        LogExt.j("peekActivity Activity栈中无数据", TAG);
        return null;
    }

    @JvmStatic
    public static final void popActivity$ar_translator_intlRelease() {
        Stack<TranslatorBaseActivity> stack = mActivityStack;
        if (stack.isEmpty()) {
            LogExt.j("popActivity 无Activity可出栈", TAG);
        } else {
            stack.pop();
        }
    }

    @JvmStatic
    public static final void pushActivity$ar_translator_intlRelease(@NotNull TranslatorBaseActivity translatorBaseActivity) {
        Intrinsics.checkNotNullParameter(translatorBaseActivity, "activity");
        mActivityStack.push(translatorBaseActivity);
    }

    @JvmStatic
    public static final void registerUiUpdateCallback$ar_translator_intlRelease(@NotNull String str, @NotNull UiUpdateCallback uiUpdateCallback) {
        Intrinsics.checkNotNullParameter(str, "callbackKey");
        Intrinsics.checkNotNullParameter(uiUpdateCallback, "callback");
        if (mUiUpdateCallbackMap.containsKey(str)) {
            LogExt.j("registerUiUpdateCallback " + str + " 被重复注册", TAG);
            return;
        }
        mUiUpdateCallbackMap.put(str, uiUpdateCallback);
    }

    @JvmStatic
    public static final void setActivityOn$ar_translator_intlRelease(boolean z) {
        mIsActivityOn = z;
    }

    @JvmStatic
    public static final void setKeepLiveNotification(int i, @Nullable Notification notification) {
        mKeepLiveNotifyId = i;
        mKeepLiveNotification = notification;
    }

    @JvmStatic
    public static final void setServiceOn$ar_translator_intlRelease(boolean z) {
        mIsServiceOn = z;
    }

    @JvmStatic
    public static final void setTransExited$ar_translator_intlRelease(boolean z) {
        mIsTransExited = z;
    }

    @JvmStatic
    public static final void startGlassUpdateInfoActivity$ar_translator_intlRelease(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), GLASS_UPDATE_ACTIVITY);
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            context.startActivity(intent);
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.j("startGlassUpdateInfoActivity 失败，error=" + stackTraceToString, TAG);
        }
    }

    @JvmStatic
    public static final void startMainActivity(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, TranslatorMainActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        context.startActivity(intent);
    }

    @JvmStatic
    public static final void startRoleVprintActivity$ar_translator_intlRelease(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), ROLE_VPRINT_ACTIVITY);
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            context.startActivity(intent);
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.j("startRoleVprintActivity 失败，error=" + stackTraceToString, TAG);
        }
    }

    @JvmStatic
    public static final void startService(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        LogExt.j("翻译启动: startService", TAG);
        mIsStartServiceToPhone = true;
        Intent intent = new Intent();
        intent.putExtra(LAUNCH_PLATFROM, "phone");
        intent.setClassName(context.getPackageName(), TranslatorConstants.TRANSLATION_SERVICE_CLASS);
        intent.setAction(TranslatorConstants.TRANSLATION_SERVICE_ACTION);
        context.startService(intent);
    }

    @JvmStatic
    public static final int startTranslation(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SwitchLangHelper.o(context, i, (LanguageUtils.StoredLanguage) null, 4, (Object) null);
    }

    @JvmStatic
    public static final void stopService(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.j("翻译停止: stopService", TAG);
        mIsStartServiceToPhone = false;
        setTransExited$ar_translator_intlRelease(true);
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), TranslatorConstants.TRANSLATION_SERVICE_CLASS);
        intent.setAction(TranslatorConstants.TRANSLATION_SERVICE_ACTION);
        context.stopService(intent);
    }

    @JvmStatic
    public static final int stopTranslation(int i) {
        return SwitchLangHelper.p(i);
    }

    public static /* synthetic */ int stopTranslation$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return stopTranslation(i);
    }

    @JvmStatic
    public static final int switchLang(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        return 0;
    }

    @JvmStatic
    public static final void unInitService$ar_translator_intlRelease() {
        boolean z = isCommonLibInited.get();
        boolean z2 = isServiceInited.get();
        boolean isServiceOn = isServiceOn();
        TranslationApp translationApp = INSTANCE;
        boolean isActivityOn = translationApp.isActivityOn();
        LogExt.g("[Release] mIsBothInit=" + z + ", mIsServiceOnlyInit=" + z2 + ", isServiceOn=" + isServiceOn + ", isActivityOn=" + isActivityOn, TAG);
        if (!isServiceOn() && !translationApp.isActivityOn()) {
            boolean z3 = isCommonLibInited.get();
            LogExt.j("[Release] 翻译完全结束释放功能，mIsBothInit=" + z3, TAG);
            InterConnectHelper.c.a().F();
            if (!isCommonLibInited.get()) {
                LogExt.j("[Release] 翻译各种服务未启动，无需进行释放", TAG);
                return;
            }
            DebugAudioBroadcastReceiver.f6197a.b();
            AssistantBroadcastReceiver.f6222a.c();
            TimeChangeReceiver.f6224a.b();
            isCommonLibInited.set(false);
        }
        if (!isServiceOn() && isServiceInited.compareAndSet(true, false)) {
            boolean z4 = isServiceInited.get();
            LogExt.j("[Release] 翻译服务结束释放资源，mIsServiceOnlyInit=" + z4, TAG);
            BleAudioHelper.f6295a.u();
            TranslationManager.q.a().J();
            NoteSyncHelper.t();
            LogExt.a();
            mIsStartServiceToPhone = false;
            isServiceInited.set(false);
        }
    }

    @JvmStatic
    public static final void unRegisterUiUpdateCallback$ar_translator_intlRelease(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "callbackKey");
        if (!mUiUpdateCallbackMap.containsKey(str)) {
            LogExt.j("unRegisterUiUpdateCallback " + str + " 从未被注册", TAG);
            return;
        }
        mUiUpdateCallbackMap.remove(str);
    }

    @NotNull
    public final EarlyInterConnectHelper getEarlyInterConnectHelper$ar_translator_intlRelease() {
        return getMEarlyInterConnectHelper();
    }

    @NotNull
    public final NetworkTimeHelper getNetworkTimeHelper$ar_translator_intlRelease() {
        return getMNetworkTimeHelper();
    }

    @NotNull
    public final TranslatorSmExHelper getSmartExHelper$ar_translator_intlRelease() {
        return getMSmartExHelper();
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        mIsUserAgree = true;
        TranslatorLitePalHelper.f6309a.g(context);
        TranslatorDbHelper.f6307a.c(context);
    }

    public final boolean isUserAgree$ar_translator_intlRelease() {
        return mIsUserAgree;
    }

    @JvmStatic
    public static final int switchLang(@NotNull Context context, boolean z, int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        return SwitchLangHelper.t(context, z, i, str, str2);
    }
}
