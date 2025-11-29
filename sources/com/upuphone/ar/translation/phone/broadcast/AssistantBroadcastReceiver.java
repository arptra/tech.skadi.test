package com.upuphone.ar.translation.phone.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/translation/phone/broadcast/AssistantBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AssistantBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6222a = new Companion((DefaultConstructorMarker) null);
    public static Context b;
    public static AssistantBroadcastReceiver c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/translation/phone/broadcast/AssistantBroadcastReceiver$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "b", "(Landroid/content/Context;)V", "c", "", "isWakeup", "a", "(Z)V", "", "TAG", "Ljava/lang/String;", "WAKEUP_ACTION", "WAKEUP_KEY", "mAppContext", "Landroid/content/Context;", "Lcom/upuphone/ar/translation/phone/broadcast/AssistantBroadcastReceiver;", "mAssistantReceiver", "Lcom/upuphone/ar/translation/phone/broadcast/AssistantBroadcastReceiver;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z) {
            LogExt.j("notifyAssistant isWakeup=" + z, "AssistantBroadcastReceiver");
            if (z) {
                TranslateStateManager p = TranslationManager.q.a().p();
                if (p != null) {
                    p.G();
                    return;
                }
                return;
            }
            TranslateStateManager p2 = TranslationManager.q.a().p();
            if (p2 != null) {
                p2.C();
            }
        }

        public final void b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            boolean isAssistantRunning = TranslatorConstants.isAssistantRunning();
            LogExt.j("registerAssistant assistant running=" + isAssistantRunning, "AssistantBroadcastReceiver");
            AssistantBroadcastReceiver.b = context;
            AssistantBroadcastReceiver assistantBroadcastReceiver = new AssistantBroadcastReceiver();
            LocalBroadcastManager.b(context).c(assistantBroadcastReceiver, new IntentFilter("com.ai.voice.assistant.WAKEUP_STATUS"));
            AssistantBroadcastReceiver.c = assistantBroadcastReceiver;
        }

        public final void c() {
            AssistantBroadcastReceiver b;
            LogExt.j("unRegisterAssistant", "AssistantBroadcastReceiver");
            Context a2 = AssistantBroadcastReceiver.b;
            if (!(a2 == null || (b = AssistantBroadcastReceiver.c) == null)) {
                LocalBroadcastManager.b(a2).e(b);
            }
            AssistantBroadcastReceiver.c = null;
            AssistantBroadcastReceiver.b = null;
        }

        public Companion() {
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (Intrinsics.areEqual((Object) action, (Object) "com.ai.voice.assistant.WAKEUP_STATUS")) {
                boolean booleanExtra = intent.getBooleanExtra("isWakeup", false);
                LogExt.j("Assistant wakeup=" + booleanExtra, "AssistantBroadcastReceiver");
                f6222a.a(booleanExtra);
                return;
            }
            LogExt.j("无需处理的广播action=" + action, "AssistantBroadcastReceiver");
        }
    }
}
