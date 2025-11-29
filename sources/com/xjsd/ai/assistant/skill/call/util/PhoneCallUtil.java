package com.xjsd.ai.assistant.skill.call.util;

import android.app.KeyguardManager;
import android.content.Context;
import android.provider.Settings;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.AssistantLifecycle;
import com.xjsd.ai.assistant.phone.BuildConfig;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/util/PhoneCallUtil;", "", "<init>", "()V", "", "h", "()Z", "Landroid/content/Context;", "context", "i", "(Landroid/content/Context;)Z", "g", "c", "d", "f", "e", "a", "b", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneCallUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final PhoneCallUtil f8679a = new PhoneCallUtil();

    public static final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return PopBackgroundPermissionUtil.f8680a.f(context);
    }

    public static final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return PopBackgroundPermissionUtil.f8680a.g(context);
    }

    public static final boolean c() {
        return !VoiceAssistantApi.isOversea && !d();
    }

    public static final boolean d() {
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "isThird");
        return bool.booleanValue();
    }

    public static final boolean e() {
        return !f();
    }

    public static final boolean f() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            Object cacheWithDefault = cacheAbility.getCacheWithDefault("XJ_APP_IN_FOREGROUND", Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(cacheWithDefault, "getCacheWithDefault(...)");
            return ((Boolean) cacheWithDefault).booleanValue() && AssistantLifecycle.a();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final boolean g() {
        InterconnectAbility interconnectAbility = (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
        Boolean bluetoothScoState = interconnectAbility != null ? interconnectAbility.bluetoothScoState() : null;
        if (bluetoothScoState == null) {
            return false;
        }
        return bluetoothScoState.booleanValue();
    }

    public static final boolean h() {
        try {
            return Settings.Global.getInt(ContextHelper.a().getContentResolver(), "airplane_mode_on", -1) == 1;
        } catch (Exception e) {
            ILog.h("PhoneCallUtil", "isFlightMode error", e);
            return false;
        }
    }

    public static final boolean i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        return ((KeyguardManager) systemService).inKeyguardRestrictedInputMode();
    }
}
