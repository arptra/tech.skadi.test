package com.xjsd.ai.assistant.core.api.cache;

import androidx.annotation.NonNull;
import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;

@AbilityKey("cache")
public interface CacheAbility extends Ability {
    <V> void cache(String str, V v);

    Object getCache(String str);

    <V> V getCache(String str, Class<V> cls);

    <V> V getCacheWithDefault(String str, @NonNull V v);

    String getPersistValue(String str);

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    void persist(String str, String str2);

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    void remove(String str);
}
