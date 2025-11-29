package com.upuphone.ai.ttsengine.engines.cache.cache;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.engines.cache.db.CacheEntity;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheEntity;", "", "path", "", "b", "(Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheEntity;Ljava/lang/String;)Z", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "a", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "aar_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class PcmLFUCacheKt {

    /* renamed from: a  reason: collision with root package name */
    public static final AILOG f5540a = AILOG.a("LFUCache");

    public static final boolean b(CacheEntity cacheEntity, String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        if (cacheEntity == null) {
            f5540a.c("cache is null", new Object[0]);
            return false;
        } else if (System.currentTimeMillis() - cacheEntity.getUpdateTime() >= 604800000) {
            f5540a.c("cache is not null but timeout", new Object[0]);
            return false;
        } else if (new File(str, cacheEntity.getPath()).exists()) {
            return true;
        } else {
            f5540a.c("cache is not null but file not exit", new Object[0]);
            return false;
        }
    }
}
