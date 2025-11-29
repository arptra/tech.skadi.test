package com.upuphone.xr.sapp.assistant;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.service.notification.StatusBarNotification;
import com.upuphone.runasone.relay.api.IntentKey;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/assistant/VoiceAssistantDelegate;", "", "<init>", "()V", "Landroid/app/Application;", "application", "", "a", "(Landroid/app/Application;)V", "Landroid/service/notification/StatusBarNotification;", "sbn", "b", "(Landroid/service/notification/StatusBarNotification;)V", "", "reason", "c", "(Landroid/service/notification/StatusBarNotification;I)V", "Landroid/content/Context;", "context", "", "key", "value", "d", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "info", "e", "(Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/phone/VoiceAssistantApi;", "Lcom/xjsd/ai/assistant/phone/VoiceAssistantApi;", "voiceAssistantApi", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VoiceAssistantDelegate {

    /* renamed from: a  reason: collision with root package name */
    public static final VoiceAssistantDelegate f6640a = new VoiceAssistantDelegate();
    public static final VoiceAssistantApi b = new VoiceAssistantApi();

    public final void a(Application application) {
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        b.init(application);
    }

    public final void b(StatusBarNotification statusBarNotification) {
        b.onReceiveNotification(statusBarNotification);
    }

    public final void c(StatusBarNotification statusBarNotification, int i) {
        b.onRemoveNotification(statusBarNotification, i);
    }

    public final void d(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences("assistant", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        sharedPreferences.edit().putString(str, str2).commit();
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "info");
        b.syncAccountInfo(str);
    }
}
