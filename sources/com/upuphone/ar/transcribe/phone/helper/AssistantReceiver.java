package com.upuphone.ar.transcribe.phone.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/AssistantReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AssistantReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6097a = new Companion((DefaultConstructorMarker) null);
    public static Context b;
    public static AssistantReceiver c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/AssistantReceiver$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "b", "(Landroid/content/Context;)V", "c", "", "isWakeup", "a", "(Z)V", "", "TAG", "Ljava/lang/String;", "WAKEUP_ACTION", "WAKEUP_KEY", "appContext", "Landroid/content/Context;", "Lcom/upuphone/ar/transcribe/phone/helper/AssistantReceiver;", "assistantReceiver", "Lcom/upuphone/ar/transcribe/phone/helper/AssistantReceiver;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z) {
            LogExt.g("notifyAssistant isWakeup=" + z, "AssistantReceiver");
            if (z) {
                TranscribeManager.j.a().h().M();
            } else {
                TranscribeManager.j.a().h().I();
            }
        }

        public final void b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LogExt.g("registerAssistant assistant", "AssistantReceiver");
            AssistantReceiver.b = context;
            AssistantReceiver assistantReceiver = new AssistantReceiver();
            LocalBroadcastManager.b(context).c(assistantReceiver, new IntentFilter("com.ai.voice.assistant.WAKEUP_STATUS"));
            AssistantReceiver.c = assistantReceiver;
        }

        public final void c() {
            AssistantReceiver b;
            LogExt.g("unRegisterAssistant", "AssistantReceiver");
            Context a2 = AssistantReceiver.b;
            if (!(a2 == null || (b = AssistantReceiver.c) == null)) {
                LocalBroadcastManager.b(a2).e(b);
            }
            AssistantReceiver.c = null;
            AssistantReceiver.b = null;
        }

        public Companion() {
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action == null || action.hashCode() != 1842872493 || !action.equals("com.ai.voice.assistant.WAKEUP_STATUS")) {
                String action2 = intent.getAction();
                LogExt.g("无需处理的广播action=" + action2, "AssistantReceiver");
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("isWakeup", false);
            LogExt.g("Assistant wakeup=" + booleanExtra, "AssistantReceiver");
            f6097a.a(booleanExtra);
        }
    }
}
