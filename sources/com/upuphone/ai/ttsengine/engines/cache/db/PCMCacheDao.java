package com.upuphone.ai.ttsengine.engines.cache.db;

import androidx.room.Dao;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Dao
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cache/db/PCMCacheDao;", "", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheEntity;", "c", "()Lkotlinx/coroutines/flow/Flow;", "entity", "", "b", "(Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheEntity;)J", "", "word", "", "a", "(Ljava/lang/String;)I", "oldKey", "", "d", "(Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheEntity;Ljava/lang/String;)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface PCMCacheDao {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void a(PCMCacheDao pCMCacheDao, CacheEntity cacheEntity, String str) {
            Intrinsics.checkNotNullParameter(cacheEntity, "entity");
            Intrinsics.checkNotNullParameter(str, "oldKey");
            pCMCacheDao.a(str);
            pCMCacheDao.b(cacheEntity);
        }
    }

    int a(String str);

    long b(CacheEntity cacheEntity);

    Flow c();

    void d(CacheEntity cacheEntity, String str);
}
