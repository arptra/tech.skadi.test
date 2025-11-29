package com.upuphone.ai.ttsengine.engines.cache.cache;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.TtsAudioUtils;
import com.upuphone.ai.ttsengine.engines.cache.db.CacheDatabase;
import com.upuphone.ai.ttsengine.engines.cache.db.CacheEntity;
import com.upuphone.ai.ttsengine.engines.cache.db.PCMCacheDao;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001e¨\u0006 "}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cache/cache/PcmLFUCache;", "", "Landroid/content/Context;", "context", "", "catchPath", "", "capacity", "<init>", "(Landroid/content/Context;Ljava/lang/String;I)V", "key", "value", "", "f", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheEntity;", "c", "(Ljava/lang/String;)Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheEntity;", "d", "", "e", "()V", "a", "Ljava/lang/String;", "b", "I", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "cache", "Lcom/upuphone/ai/ttsengine/engines/cache/db/PCMCacheDao;", "Lcom/upuphone/ai/ttsengine/engines/cache/db/PCMCacheDao;", "cacheDao", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPcmLFUCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PcmLFUCache.kt\ncom/upuphone/ai/ttsengine/engines/cache/cache/PcmLFUCache\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,113:1\n288#2,2:114\n288#2,2:116\n288#2,2:118\n*S KotlinDebug\n*F\n+ 1 PcmLFUCache.kt\ncom/upuphone/ai/ttsengine/engines/cache/cache/PcmLFUCache\n*L\n45#1:114,2\n82#1:116,2\n86#1:118,2\n*E\n"})
public final class PcmLFUCache {

    /* renamed from: a  reason: collision with root package name */
    public final String f5538a;
    public final int b;
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public final PCMCacheDao d;

    public PcmLFUCache(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "catchPath");
        this.f5538a = str;
        this.b = i;
        this.d = CacheDatabase.f5541a.a(context).g();
        e();
    }

    public final synchronized CacheEntity c(String str) {
        Object obj;
        try {
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            AILOG a2 = PcmLFUCacheKt.f5540a;
            a2.c("get: " + str, new Object[0]);
            Iterator it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((CacheEntity) obj).getWord(), (Object) str)) {
                    break;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (CacheEntity) obj;
    }

    public final CacheEntity d(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((CacheEntity) obj).getWord(), (Object) str)) {
                break;
            }
        }
        CacheEntity cacheEntity = (CacheEntity) obj;
        if (cacheEntity == null) {
            return null;
        }
        PcmLFUCacheKt.f5540a.c("getAndInc: " + str + " ,found: " + cacheEntity, new Object[0]);
        PCMCacheDao pCMCacheDao = this.d;
        String path = cacheEntity.getPath();
        long currentTimeMillis = System.currentTimeMillis();
        cacheEntity.setCount(cacheEntity.getCount() + 1);
        pCMCacheDao.b(new CacheEntity(str, path, currentTimeMillis, cacheEntity.getCount()));
        return cacheEntity;
    }

    public final void e() {
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.b(), (CoroutineStart) null, new PcmLFUCache$loadCache$1(this, (Continuation<? super PcmLFUCache$loadCache$1>) null), 2, (Object) null);
    }

    public final boolean f(String str, String str2) {
        Object obj;
        String str3;
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        PcmLFUCacheKt.f5540a.c("cache: " + str, new Object[0]);
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((CacheEntity) obj).getWord(), (Object) str)) {
                break;
            }
        }
        CacheEntity cacheEntity = (CacheEntity) obj;
        if (cacheEntity == null) {
            CacheEntity cacheEntity2 = new CacheEntity(str, str2, System.currentTimeMillis(), 1);
            PcmLFUCacheKt.f5540a.c("cache size: " + this.c.size() + ", capacity: " + this.b, new Object[0]);
            if (this.c.size() >= this.b) {
                CacheEntity cacheEntity3 = (CacheEntity) CollectionsKt.removeLast(this.c);
                this.d.d(cacheEntity2, cacheEntity3.getWord());
                if (StringsKt.contains$default((CharSequence) cacheEntity3.getPath(), (CharSequence) this.f5538a, false, 2, (Object) null)) {
                    str3 = cacheEntity3.getPath();
                } else {
                    str3 = this.f5538a + "/" + cacheEntity3 + ".path";
                }
                TtsAudioUtils.d(str3);
                PcmLFUCacheKt.f5540a.c("cache is full remove last element: " + cacheEntity3, new Object[0]);
                return true;
            }
            this.d.b(cacheEntity2);
            return true;
        } else if (Intrinsics.areEqual((Object) str2, (Object) cacheEntity.getPath())) {
            return true;
        } else {
            this.d.b(new CacheEntity(str, str2, cacheEntity.getUpdateTime(), cacheEntity.getCount()));
            return true;
        }
    }
}
