package com.xjsd.ai.assistant.phone;

import com.meizu.account.oauth.BuildConfig;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.phone.helper.VersionUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/xjsd/ai/assistant/phone/NewFunctionCompact;", "", "<init>", "()V", "", "b", "()Z", "d", "c", "a", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NewFunctionCompact {

    /* renamed from: a  reason: collision with root package name */
    public static final NewFunctionCompact f8521a = new NewFunctionCompact();

    public static final boolean a() {
        return b();
    }

    public static final boolean b() {
        if (DeviceUtils.c() || DeviceUtils.i()) {
            return true;
        }
        if (DeviceUtils.b() || DeviceUtils.h()) {
            return VersionUtil.f8566a.c(BuildConfig.VERSION_NAME);
        }
        return false;
    }

    public static final boolean c() {
        return b();
    }

    public static final boolean d() {
        return b();
    }
}
