package com.xjsd.ai.assistant.common.util;

import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/xjsd/ai/assistant/common/util/CacheUtil;", "", "<init>", "()V", "", "name", "", "a", "(Ljava/lang/String;)V", "b", "()Ljava/lang/String;", "", "c", "()Z", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CacheUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final CacheUtil f8443a = new CacheUtil();

    public static final void a(String str) {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            if (str == null) {
                str = "";
            }
            cacheAbility.cache("last_context", str);
        }
    }

    public static final String b() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        String str = cacheAbility != null ? (String) cacheAbility.getCacheWithDefault("last_context", "") : null;
        return str == null ? "" : str;
    }

    public static final boolean c() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        String str = "";
        String str2 = cacheAbility != null ? (String) cacheAbility.getCacheWithDefault("last_context", str) : null;
        if (str2 != null) {
            str = str2;
        }
        return StringsKt.equals("WeatherSearch", str, true) || StringsKt.equals("TrafficRestrictionSearch", str, true);
    }
}
