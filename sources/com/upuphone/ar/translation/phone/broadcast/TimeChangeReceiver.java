package com.upuphone.ar.translation.phone.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/translation/phone/broadcast/TimeChangeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TimeChangeReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6224a = new Companion((DefaultConstructorMarker) null);
    public static Context b;
    public static TimeChangeReceiver c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/translation/phone/broadcast/TimeChangeReceiver$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "b", "", "TAG", "Ljava/lang/String;", "mAppContext", "Landroid/content/Context;", "Lcom/upuphone/ar/translation/phone/broadcast/TimeChangeReceiver;", "mTimeChangeReceiver", "Lcom/upuphone/ar/translation/phone/broadcast/TimeChangeReceiver;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LogExt.j("registerTimeChangeReceiver", "TimeChangeReceiver");
            TimeChangeReceiver.b = context;
            TimeChangeReceiver timeChangeReceiver = new TimeChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            Unit unit = Unit.INSTANCE;
            context.registerReceiver(timeChangeReceiver, intentFilter);
            TimeChangeReceiver.c = timeChangeReceiver;
        }

        public final void b() {
            TimeChangeReceiver b;
            LogExt.j("unRegisterTimeChangeReceiver", "TimeChangeReceiver");
            Context a2 = TimeChangeReceiver.b;
            if (!(a2 == null || (b = TimeChangeReceiver.c) == null)) {
                a2.unregisterReceiver(b);
            }
            TimeChangeReceiver.c = null;
            TimeChangeReceiver.b = null;
        }

        public Companion() {
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (Intrinsics.areEqual((Object) action, (Object) "android.intent.action.TIME_SET")) {
                LogExt.j("System time has been changed", "TimeChangeReceiver");
                TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(1006));
            } else if (Intrinsics.areEqual((Object) action, (Object) "android.intent.action.TIMEZONE_CHANGED")) {
                LogExt.j("System time zone has been changed", "TimeChangeReceiver");
            } else {
                LogExt.j("无需处理的广播action=" + action, "TimeChangeReceiver");
            }
        }
    }
}
