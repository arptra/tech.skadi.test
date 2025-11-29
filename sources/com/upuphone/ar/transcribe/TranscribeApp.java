package com.upuphone.ar.transcribe;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import com.upuphone.ar.transcribe.audio.debug.DebugAudioBroadcastReceiver;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.activity.TranscribeBaseActivity;
import com.upuphone.ar.transcribe.phone.activity.TranscribeStartActivity;
import com.upuphone.ar.transcribe.phone.bean.OperateMessage;
import com.upuphone.ar.transcribe.phone.bean.TransStateEvent;
import com.upuphone.ar.transcribe.phone.db.entity.MessageEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.helper.AssistantReceiver;
import com.upuphone.ar.transcribe.phone.helper.BleAudioManager;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.phone.helper.SwitchLangHelper;
import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
import com.upuphone.ar.transcribe.phone.listener.UiUpdateCallback;
import com.upuphone.ar.transcribe.utils.LanguageUtils;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.runasone.uupcast.CaptureType;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020\u001fH\u0007J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\tH\u0007J\n\u0010#\u001a\u0004\u0018\u00010\u0015H\u0007J\b\u0010$\u001a\u00020\u0017H\u0007J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\tH\u0007J\n\u0010&\u001a\u0004\u0018\u00010\u001aH\u0007J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\tH\u0007J\"\u0010'\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\t2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010)H\u0007J\b\u0010*\u001a\u00020\u0011H\u0002J\b\u0010+\u001a\u00020\u0011H\u0007J \u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004H\u0007J\b\u00100\u001a\u00020\u0011H\u0007J\u000e\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0017J\u001e\u00103\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\t2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0007J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u000209H\u0007J\u001c\u0010:\u001a\u00020\u001f\"\u0004\b\u0000\u0010;2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H;0=H\u0007J\n\u0010>\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010?\u001a\u00020\u001fH\u0007J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u000fH\u0007J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001aH\u0007J\u0018\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u001dH\u0007J\b\u0010G\u001a\u00020\u001fH\u0007J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020\u0011H\u0007J\u001a\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020\u00172\b\u0010L\u001a\u0004\u0018\u00010\u0015H\u0007J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u0011H\u0007J\u0010\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020\u0011H\u0007J\u0010\u0010Q\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\tH\u0007J\u0010\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\tH\u0007J\u0010\u0010T\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\tH\u0007J\u0010\u0010U\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\tH\u0007J\b\u0010V\u001a\u00020\u0017H\u0007J(\u0010W\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004H\u0007J\b\u0010X\u001a\u00020\u001fH\u0007J\u0010\u0010Y\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/upuphone/ar/transcribe/TranscribeApp;", "", "()V", "CLOSE_ASSISTANT_ACTION", "", "LAUNCH_PLATFROM", "PLATFROM_PHONE", "TAG", "application", "Landroid/content/Context;", "isCommonLibInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isServiceInited", "mActivityStack", "Ljava/util/Stack;", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeBaseActivity;", "mIsActivityOn", "", "mIsServiceOn", "mIsTransExited", "mKeepLiveNotification", "Landroid/app/Notification;", "mKeepLiveNotifyId", "", "mTranscribeStartActivity", "Ljava/lang/ref/SoftReference;", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeStartActivity;", "mUiUpdateCallbackMap", "", "Lcom/upuphone/ar/transcribe/phone/listener/UiUpdateCallback;", "clearActivity", "", "clearUiUpdateCallback", "closeAssistant", "context", "getKeepLiveNotification", "getKeepLiveNotifyId", "getTransCurrentState", "getTransStartActivity", "init", "internetReadyListener", "Lkotlin/Function0;", "isActivityOn", "isServiceOn", "isSupportLanguage", "isAir", "src", "dst", "isTransExited", "isTranscribe", "transType", "migrateDb", "trans", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "notifyTranslateState", "transStateEvent", "Lcom/upuphone/ar/transcribe/phone/bean/TransStateEvent;", "notifyVariousMsg", "T", "operateMessage", "Lcom/upuphone/ar/transcribe/phone/bean/OperateMessage;", "peekActivity", "popActivity", "pushActivity", "activity", "registerTransStartActivity", "transcribeStartActivity", "registerUiUpdateCallback", "callbackKey", "callback", "release", "setActivityOn", "activityOn", "setKeepLiveNotification", "notifyId", "notification", "setServiceOn", "serviceOn", "setTransExited", "transExited", "startMainActivity", "startService", "ctx", "startTranslation", "stopService", "stopTranslation", "switchLang", "unRegisterTransStartActivity", "unRegisterUiUpdateCallback", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranscribeApp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeApp.kt\ncom/upuphone/ar/transcribe/TranscribeApp\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,512:1\n215#2,2:513\n1855#3,2:515\n13374#4,3:517\n*S KotlinDebug\n*F\n+ 1 TranscribeApp.kt\ncom/upuphone/ar/transcribe/TranscribeApp\n*L\n485#1:513,2\n494#1:515,2\n505#1:517,3\n*E\n"})
public final class TranscribeApp {
    @NotNull
    private static final String CLOSE_ASSISTANT_ACTION = "com.upuphone.com.CLOSE_AI_ASSISTANT_ACTION";
    @NotNull
    public static final TranscribeApp INSTANCE = new TranscribeApp();
    @NotNull
    private static final String LAUNCH_PLATFROM = "platform";
    @NotNull
    private static final String PLATFROM_PHONE = "phone";
    @NotNull
    private static final String TAG = "TranscribeApp";
    @Nullable
    private static Context application;
    @NotNull
    private static AtomicBoolean isCommonLibInited = new AtomicBoolean(false);
    @NotNull
    private static AtomicBoolean isServiceInited = new AtomicBoolean(false);
    @NotNull
    private static final Stack<TranscribeBaseActivity> mActivityStack = new Stack<>();
    private static boolean mIsActivityOn;
    private static boolean mIsServiceOn;
    private static boolean mIsTransExited;
    @Nullable
    private static Notification mKeepLiveNotification;
    private static int mKeepLiveNotifyId = MSG.MSG_PREPARING_SUCCESS;
    @Nullable
    private static SoftReference<TranscribeStartActivity> mTranscribeStartActivity;
    @NotNull
    private static Map<String, UiUpdateCallback> mUiUpdateCallbackMap = new LinkedHashMap();

    private TranscribeApp() {
    }

    @JvmStatic
    public static final void clearActivity() {
        Stack<TranscribeBaseActivity> stack = mActivityStack;
        if (stack.isEmpty()) {
            LogExt.g("clearActivity 流程正常，无数据需要被清空", TAG);
            return;
        }
        int size = stack.size();
        LogExt.g("clearActivity 流程异常，清空栈中所有内容, size=" + size, TAG);
        stack.clear();
    }

    @JvmStatic
    public static final void clearUiUpdateCallback() {
        mUiUpdateCallbackMap.clear();
    }

    @JvmStatic
    public static final void closeAssistant(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.sendBroadcast(new Intent(CLOSE_ASSISTANT_ACTION));
    }

    @JvmStatic
    @Nullable
    public static final Notification getKeepLiveNotification() {
        return mKeepLiveNotification;
    }

    @JvmStatic
    public static final int getKeepLiveNotifyId() {
        return mKeepLiveNotifyId;
    }

    @JvmStatic
    public static final int getTransCurrentState(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SwitchLangHelper.e(context);
    }

    @JvmStatic
    @Nullable
    public static final TranscribeStartActivity getTransStartActivity() {
        SoftReference<TranscribeStartActivity> softReference = mTranscribeStartActivity;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    @JvmStatic
    public static final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, (Function0<Unit>) null);
    }

    public static /* synthetic */ void init$default(Context context, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        init(context, function0);
    }

    private final boolean isActivityOn() {
        return mIsActivityOn;
    }

    @JvmStatic
    public static final boolean isServiceOn() {
        return mIsServiceOn;
    }

    @JvmStatic
    public static final boolean isSupportLanguage(boolean z, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        return SwitchLangHelper.h(z, str, str2);
    }

    @JvmStatic
    public static final boolean isTransExited() {
        return mIsTransExited;
    }

    @JvmStatic
    public static final void migrateDb(@NotNull Context context, @NotNull List<TranscribeBean> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "trans");
        LogExt.d("Update transcribe db trans size: " + list.size(), TAG);
        ArrayList arrayList = new ArrayList();
        for (TranscribeBean transcribeBean : list) {
            String title = transcribeBean.getTitle();
            if (title == null) {
                title = "";
            }
            arrayList.add(new MessageEntity((Long) null, title, 0, transcribeBean.getRecordTime(), -1, 1, (DefaultConstructorMarker) null));
        }
        TranscribeDBHelper transcribeDBHelper = TranscribeDBHelper.f6108a;
        transcribeDBHelper.n(context);
        Long[] p = transcribeDBHelper.p(list);
        int length = p.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            ((MessageEntity) arrayList.get(i2)).setTranscribeId(p[i].longValue());
            i++;
            i2++;
        }
        TranscribeDBHelper.f6108a.o(arrayList);
    }

    @JvmStatic
    public static final void notifyTranslateState(@NotNull TransStateEvent transStateEvent) {
        Intrinsics.checkNotNullParameter(transStateEvent, "transStateEvent");
        for (Map.Entry next : mUiUpdateCallbackMap.entrySet()) {
            String str = (String) next.getKey();
            ((UiUpdateCallback) next.getValue()).notifyTranslateState(transStateEvent);
        }
    }

    @JvmStatic
    public static final <T> void notifyVariousMsg(@NotNull OperateMessage<T> operateMessage) {
        Intrinsics.checkNotNullParameter(operateMessage, "operateMessage");
        for (Map.Entry next : mUiUpdateCallbackMap.entrySet()) {
            String str = (String) next.getKey();
            ((UiUpdateCallback) next.getValue()).notifyVariousMsg(operateMessage);
        }
    }

    @JvmStatic
    @Nullable
    public static final TranscribeBaseActivity peekActivity() {
        Stack<TranscribeBaseActivity> stack = mActivityStack;
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        LogExt.g("peekActivity Activity栈中无数据", TAG);
        return null;
    }

    @JvmStatic
    public static final void popActivity() {
        Stack<TranscribeBaseActivity> stack = mActivityStack;
        if (stack.isEmpty()) {
            LogExt.g("popActivity 无Activity可出栈", TAG);
        } else {
            stack.pop();
        }
    }

    @JvmStatic
    public static final void pushActivity(@NotNull TranscribeBaseActivity transcribeBaseActivity) {
        Intrinsics.checkNotNullParameter(transcribeBaseActivity, "activity");
        mActivityStack.push(transcribeBaseActivity);
    }

    @JvmStatic
    public static final void registerTransStartActivity(@NotNull TranscribeStartActivity transcribeStartActivity) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "transcribeStartActivity");
        mTranscribeStartActivity = new SoftReference<>(transcribeStartActivity);
    }

    @JvmStatic
    public static final void registerUiUpdateCallback(@NotNull String str, @NotNull UiUpdateCallback uiUpdateCallback) {
        Intrinsics.checkNotNullParameter(str, "callbackKey");
        Intrinsics.checkNotNullParameter(uiUpdateCallback, "callback");
        if (mUiUpdateCallbackMap.containsKey(str)) {
            LogExt.g("registerUiUpdateCallback " + str + " 被重复注册", TAG);
            return;
        }
        mUiUpdateCallbackMap.put(str, uiUpdateCallback);
    }

    @JvmStatic
    public static final void release() {
        boolean z = isCommonLibInited.get();
        boolean z2 = isServiceInited.get();
        boolean isServiceOn = isServiceOn();
        TranscribeApp transcribeApp = INSTANCE;
        boolean isActivityOn = transcribeApp.isActivityOn();
        LogExt.d("Release: mIsBothInit=" + z + ", mIsServiceOnlyInit=" + z2 + ", isServiceOn=" + isServiceOn + ", isActivityOn=" + isActivityOn, TAG);
        if (!isServiceOn() && !transcribeApp.isActivityOn()) {
            boolean z3 = isCommonLibInited.get();
            LogExt.g("Release: 转写完全结束释放功能，mIsBothInit=" + z3, TAG);
            DebugAudioBroadcastReceiver.f6023a.b();
            InterConnectHelper.c.a().D();
            isCommonLibInited.set(false);
        }
        if (!isServiceOn() && isServiceInited.compareAndSet(true, false)) {
            boolean z4 = isServiceInited.get();
            LogExt.g("Release: 转写服务结束释放资源，mIsServiceOnlyInit=" + z4, TAG);
            BleAudioManager.g.a().j();
            TranscribeManager.j.a().u();
            TranscribeDBHelper.f6108a.v();
            LogExt.a();
            AssistantReceiver.f6097a.c();
            isServiceInited.set(false);
        }
        SwitchLangHelper switchLangHelper = SwitchLangHelper.f6106a;
        if (switchLangHelper.d() && application != null) {
            LogExt.g("Release: 切换语言退出后重新启动", TAG);
            switchLangHelper.l(false);
            Context context = application;
            Intrinsics.checkNotNull(context);
            startService(context);
        }
    }

    @JvmStatic
    public static final void setActivityOn(boolean z) {
        mIsActivityOn = z;
    }

    @JvmStatic
    public static final void setKeepLiveNotification(int i, @Nullable Notification notification) {
        mKeepLiveNotifyId = i;
        mKeepLiveNotification = notification;
    }

    @JvmStatic
    public static final void setServiceOn(boolean z) {
        mIsServiceOn = z;
    }

    @JvmStatic
    public static final void setTransExited(boolean z) {
        mIsTransExited = z;
    }

    @JvmStatic
    public static final void startMainActivity(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.g("startMainActivity...启动activity", TAG);
        Intent intent = new Intent(context, TranscribeStartActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        context.startActivity(intent);
    }

    @JvmStatic
    public static final void startService(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        LogExt.g("转写启动: startService", TAG);
        Intent intent = new Intent();
        intent.putExtra(LAUNCH_PLATFROM, "phone");
        intent.setClassName(context.getPackageName(), "com.upuphone.ar.transcribe.phone.TranscribeService");
        intent.setAction("com.upuphone.ar.transcribe.action");
        context.startService(intent);
    }

    @JvmStatic
    public static final int startTranslation(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SwitchLangHelper.o(context, (LanguageUtils.StoredLanguage) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void stopService(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.g("转写停止: stopService", TAG);
        setTransExited(true);
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.upuphone.ar.transcribe.phone.TranscribeService");
        intent.setAction("com.upuphone.ar.transcribe.action");
        context.stopService(intent);
    }

    @JvmStatic
    public static final int stopTranslation() {
        return SwitchLangHelper.p();
    }

    @JvmStatic
    public static final int switchLang(@NotNull Context context, boolean z, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        return SwitchLangHelper.s(context, z, str, str2);
    }

    @JvmStatic
    public static final void unRegisterTransStartActivity() {
        SoftReference<TranscribeStartActivity> softReference = mTranscribeStartActivity;
        if (softReference != null) {
            softReference.clear();
        }
        mTranscribeStartActivity = null;
    }

    @JvmStatic
    public static final void unRegisterUiUpdateCallback(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "callbackKey");
        if (!mUiUpdateCallbackMap.containsKey(str)) {
            LogExt.g("unRegisterUiUpdateCallback " + str + " 从未被注册", TAG);
            return;
        }
        mUiUpdateCallbackMap.remove(str);
    }

    public final boolean isTranscribe(int i) {
        return 1 == i;
    }

    @JvmStatic
    public static final void init(@NotNull Context context, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = isCommonLibInited.get();
        boolean z2 = isServiceInited.get();
        boolean isServiceOn = isServiceOn();
        boolean isActivityOn = INSTANCE.isActivityOn();
        LogExt.d("Init: mIsBothInit=" + z + ", mIsServiceOnlyInit=" + z2 + ", isServiceOn=" + isServiceOn + ", isActivityOn=" + isActivityOn, TAG);
        application = context.getApplicationContext();
        if (isCommonLibInited.compareAndSet(false, true)) {
            boolean z3 = isCommonLibInited.get();
            LogExt.g("Init: Service和Activity中都需要初始化的操作，mIsBothInit=" + z3, TAG);
            TranscribeDBHelper transcribeDBHelper = TranscribeDBHelper.f6108a;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            transcribeDBHelper.n(applicationContext);
            InterConnectHelper a2 = InterConnectHelper.c.a();
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            a2.i(applicationContext2);
            if (function0 != null) {
                function0.invoke();
            }
            DebugAudioBroadcastReceiver.Companion companion = DebugAudioBroadcastReceiver.f6023a;
            Context applicationContext3 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
            companion.a(applicationContext3);
        } else if (function0 != null) {
            function0.invoke();
        }
        if (isServiceOn() && isServiceInited.compareAndSet(false, true)) {
            boolean z4 = isServiceInited.get();
            LogExt.g("Init: Service启动之后才需要初始化，mIsServiceOnlyInit=" + z4, TAG);
            TranscribeManager a3 = TranscribeManager.j.a();
            Context applicationContext4 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
            a3.m(applicationContext4);
            BleAudioManager a4 = BleAudioManager.g.a();
            Context applicationContext5 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext5, "getApplicationContext(...)");
            a4.i(applicationContext5);
            AssistantReceiver.Companion companion2 = AssistantReceiver.f6097a;
            companion2.a(TranscribeConstants.f6027a.k());
            TranscribeDBHelper.f6108a.v();
            Context applicationContext6 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext6, "getApplicationContext(...)");
            companion2.b(applicationContext6);
        }
    }
}
