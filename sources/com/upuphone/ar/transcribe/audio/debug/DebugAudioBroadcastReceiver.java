package com.upuphone.ar.transcribe.audio.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.transcribe.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/transcribe/audio/debug/DebugAudioBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DebugAudioBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6023a = new Companion((DefaultConstructorMarker) null);
    public static Context b;
    public static DebugAudioBroadcastReceiver c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/transcribe/audio/debug/DebugAudioBroadcastReceiver$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "b", "", "DEBUG_STATE", "Ljava/lang/String;", "TAG", "appContext", "Landroid/content/Context;", "Lcom/upuphone/ar/transcribe/audio/debug/DebugAudioBroadcastReceiver;", "receiver", "Lcom/upuphone/ar/transcribe/audio/debug/DebugAudioBroadcastReceiver;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            DebugAudioBroadcastReceiver.b = context;
            DebugAudioBroadcastReceiver.c = new DebugAudioBroadcastReceiver();
            Context a2 = DebugAudioBroadcastReceiver.b;
            if (a2 != null) {
                a2.registerReceiver(DebugAudioBroadcastReceiver.c, new IntentFilter("com.upuphone.ar.transcribe.audio.debugAudio"), 4);
            }
        }

        public final void b() {
            Context a2 = DebugAudioBroadcastReceiver.b;
            if (a2 != null) {
                a2.unregisterReceiver(DebugAudioBroadcastReceiver.c);
            }
            AudioDebugHelper.f6022a.k();
            DebugAudioBroadcastReceiver.c = null;
            DebugAudioBroadcastReceiver.b = null;
        }

        public Companion() {
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            LogExt.g("开启调试音频广播异常！", "DebugAudioBroadcastReceiver");
            return;
        }
        String action = intent.getAction();
        LogExt.g("action:: " + action, "DebugAudioBroadcastReceiver");
        if (Intrinsics.areEqual((Object) action, (Object) "com.upuphone.ar.transcribe.audio.debugAudio")) {
            String stringExtra = intent.getStringExtra("state");
            if (stringExtra == null) {
                stringExtra = "";
            }
            LogExt.g("debug state:: " + stringExtra, "DebugAudioBroadcastReceiver");
            int hashCode = stringExtra.hashCode();
            if (hashCode != 3540994) {
                if (hashCode != 94746185) {
                    if (hashCode == 109757538 && stringExtra.equals(MzContactsContract.START_PARAM_KEY)) {
                        AudioDebugHelper.b(context);
                    }
                } else if (stringExtra.equals("clean")) {
                    AudioDebugHelper.c();
                }
            } else if (stringExtra.equals("stop")) {
                AudioDebugHelper.f6022a.k();
            }
        }
    }
}
