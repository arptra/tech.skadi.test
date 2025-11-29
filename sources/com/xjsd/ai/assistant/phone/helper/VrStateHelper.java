package com.xjsd.ai.assistant.phone.helper;

import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/VrStateHelper;", "", "<init>", "()V", "", "a", "()Z", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVrStateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VrStateHelper.kt\ncom/xjsd/ai/assistant/phone/helper/VrStateHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,26:1\n1#2:27\n*E\n"})
public final class VrStateHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final VrStateHelper f8567a = new VrStateHelper();

    public final boolean a() {
        Boolean bool;
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility == null || (bool = (Boolean) cacheAbility.getCacheWithDefault("isVrRunning", Boolean.FALSE)) == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
