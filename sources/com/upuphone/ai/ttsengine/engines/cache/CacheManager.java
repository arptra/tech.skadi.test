package com.upuphone.ai.ttsengine.engines.cache;

import android.content.Context;
import com.upuphone.ai.ttsengine.base.bean.CacheKey;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.StringUtilsKt;
import com.upuphone.ai.ttsengine.base.utils.TtsAudioUtils;
import com.upuphone.ai.ttsengine.engines.cache.cache.PcmLFUCache;
import com.upuphone.ai.ttsengine.engines.cache.cache.PcmLFUCacheKt;
import com.upuphone.ai.ttsengine.engines.cache.db.CacheEntity;
import com.upuphone.runasone.relay.api.IntentKey;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u00013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0016H\u0002¢\u0006\u0004\b \u0010!R\u001c\u0010%\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0007\u0010/R\u0016\u00102\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u00101¨\u00064"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cache/CacheManager;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "f", "(Landroid/content/Context;)V", "Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;", "key", "", "type", "b", "(Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;I)V", "", "data", "len", "a", "(Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;[BI)V", "g", "(Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;)V", "", "c", "(Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;)Ljava/lang/String;", "", "h", "(Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;)Z", "Ljava/io/File;", "d", "(Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;)Ljava/io/File;", "fileName", "e", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Ljava/lang/String;", "cachePath", "Lcom/upuphone/ai/ttsengine/engines/cache/CacheManager$TextFileMap;", "Lcom/upuphone/ai/ttsengine/engines/cache/CacheManager$TextFileMap;", "cacheMap", "Lcom/upuphone/ai/ttsengine/engines/cache/cache/PcmLFUCache;", "Lcom/upuphone/ai/ttsengine/engines/cache/cache/PcmLFUCache;", "cache", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Z", "initialized", "TextFileMap", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CacheManager {

    /* renamed from: a  reason: collision with root package name */
    public static final CacheManager f5534a = new CacheManager();
    public static final AILOG b = AILOG.a("CacheManager");
    public static String c;
    public static final TextFileMap d = new TextFileMap((String) null, (String) null, 0, 7, (DefaultConstructorMarker) null);
    public static PcmLFUCache e;
    public static CoroutineScope f;
    public static volatile boolean g;

    public final void a(CacheKey cacheKey, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (!g) {
            b.c("cache manager not available", new Object[0]);
            return;
        }
        TextFileMap textFileMap = d;
        if (!textFileMap.f() || !Intrinsics.areEqual((Object) cacheKey.b(), (Object) textFileMap.d())) {
            AILOG ailog = b;
            String b2 = cacheKey.b();
            ailog.c("appendData but text changed, origin: " + textFileMap + ", new: " + b2, new Object[0]);
            return;
        }
        String c2 = textFileMap.c();
        Intrinsics.checkNotNull(c2);
        TtsAudioUtils.e(e(c2), bArr, i, true);
    }

    public final void b(CacheKey cacheKey, int i) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        if (!g) {
            b.c("cache manager not available", new Object[0]);
        } else if (cacheKey.c().length() == 0) {
            b.c("text is null", new Object[0]);
        } else {
            TextFileMap textFileMap = d;
            if (textFileMap.f()) {
                b.c("beginCache remove last", new Object[0]);
                String c2 = textFileMap.c();
                Intrinsics.checkNotNull(c2);
                TtsAudioUtils.d(e(c2));
                textFileMap.a();
            }
            String str = "pcm_" + StringUtilsKt.b(cacheKey.b()) + ".bak";
            textFileMap.b(cacheKey.b(), str, i);
            b.c("beginCache: " + textFileMap, new Object[0]);
            TtsAudioUtils.d(e(str));
            TtsAudioUtils.c(e(str), 1, true);
        }
    }

    public final String c(CacheKey cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        PcmLFUCache pcmLFUCache = null;
        if (!g) {
            b.c("cache manager not available", new Object[0]);
            return null;
        }
        AILOG ailog = b;
        TextFileMap textFileMap = d;
        ailog.c("endCache: " + textFileMap, new Object[0]);
        if (!textFileMap.f() || !Intrinsics.areEqual((Object) cacheKey.b(), (Object) textFileMap.d())) {
            ailog.c("end cache but cache not match", new Object[0]);
            return null;
        }
        String c2 = textFileMap.c();
        Intrinsics.checkNotNull(c2);
        String e2 = e(c2);
        if (TtsAudioUtils.a(e2, true, false, -1)) {
            String c3 = textFileMap.c();
            Intrinsics.checkNotNull(c3);
            String replace$default = StringsKt.replace$default(c3, ".bak", textFileMap.e() == 0 ? "" : ".mp3", false, 4, (Object) null);
            File file = new File(e2);
            if (file.exists()) {
                file.renameTo(new File(c, replace$default));
            }
            PcmLFUCache pcmLFUCache2 = e;
            if (pcmLFUCache2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cache");
            } else {
                pcmLFUCache = pcmLFUCache2;
            }
            pcmLFUCache.f(StringUtilsKt.b(cacheKey.b()), replace$default);
            textFileMap.a();
            String str = c;
            return str + "/" + replace$default;
        }
        ailog.c("endCache but close data failed", new Object[0]);
        TtsAudioUtils.d(e2);
        textFileMap.a();
        return null;
    }

    public final File d(CacheKey cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        if (!g) {
            b.c("cache manager not available", new Object[0]);
            return null;
        }
        PcmLFUCache pcmLFUCache = e;
        if (pcmLFUCache == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cache");
            pcmLFUCache = null;
        }
        CacheEntity c2 = pcmLFUCache.c(StringUtilsKt.b(cacheKey.b()));
        b.c(cacheKey.b() + ", get cache: " + c2, new Object[0]);
        if (c2 != null) {
            return new File(c, c2.getPath());
        }
        return null;
    }

    public final String e(String str) {
        String str2 = c;
        return str2 + "/" + str;
    }

    public final void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = context.getFilesDir().getPath() + "/pcm";
        c = str;
        Intrinsics.checkNotNull(str);
        e = new PcmLFUCache(context, str, 50);
        f = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
        g = true;
    }

    public final void g(CacheKey cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        if (!g) {
            b.c("cache manager not available", new Object[0]);
            return;
        }
        TextFileMap textFileMap = d;
        if (textFileMap.f()) {
            AILOG ailog = b;
            String b2 = cacheKey.b();
            ailog.c("interrupt cache text: " + b2, new Object[0]);
            String c2 = textFileMap.c();
            Intrinsics.checkNotNull(c2);
            String e2 = e(c2);
            TtsAudioUtils.a(e2, true, false, -1);
            TtsAudioUtils.d(e2);
            textFileMap.a();
        }
    }

    public final boolean h(CacheKey cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        if (!g) {
            b.c("cache manager not available", new Object[0]);
            return false;
        }
        PcmLFUCache pcmLFUCache = e;
        if (pcmLFUCache == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cache");
            pcmLFUCache = null;
        }
        CacheEntity d2 = pcmLFUCache.d(StringUtilsKt.b(cacheKey.b()));
        String str = c;
        Intrinsics.checkNotNull(str);
        return PcmLFUCacheKt.b(d2, str);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\bJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u001cR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u001cR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001f\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cache/CacheManager$TextFileMap;", "", "", "text", "fileName", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "word", "name", "", "b", "", "f", "()Z", "a", "()V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "d", "setText", "(Ljava/lang/String;)V", "c", "setFileName", "I", "e", "setType", "(I)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class TextFileMap {

        /* renamed from: a  reason: collision with root package name */
        public String f5535a;
        public String b;
        public int c;

        public TextFileMap(String str, String str2, int i) {
            this.f5535a = str;
            this.b = str2;
            this.c = i;
        }

        public final void a() {
            this.f5535a = null;
            this.b = null;
        }

        public final void b(String str, String str2, int i) {
            this.f5535a = str;
            this.b = str2;
            this.c = i;
        }

        public final String c() {
            return this.b;
        }

        public final String d() {
            return this.f5535a;
        }

        public final int e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextFileMap)) {
                return false;
            }
            TextFileMap textFileMap = (TextFileMap) obj;
            return Intrinsics.areEqual((Object) this.f5535a, (Object) textFileMap.f5535a) && Intrinsics.areEqual((Object) this.b, (Object) textFileMap.b) && this.c == textFileMap.c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r1 = r1.b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean f() {
            /*
                r1 = this;
                java.lang.String r0 = r1.f5535a
                if (r0 == 0) goto L_0x0016
                int r0 = r0.length()
                if (r0 <= 0) goto L_0x0016
                java.lang.String r1 = r1.b
                if (r1 == 0) goto L_0x0016
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0016
                r1 = 1
                goto L_0x0017
            L_0x0016:
                r1 = 0
            L_0x0017:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cache.CacheManager.TextFileMap.f():boolean");
        }

        public int hashCode() {
            String str = this.f5535a;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return ((hashCode + i) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            String str = this.f5535a;
            String str2 = this.b;
            int i = this.c;
            return "TextFileMap(text=" + str + ", fileName=" + str2 + ", type=" + i + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TextFileMap(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? 0 : i);
        }
    }
}
