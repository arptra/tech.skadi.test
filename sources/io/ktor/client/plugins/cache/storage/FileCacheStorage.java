package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import io.ktor.util.CryptoKt;
import io.ktor.util.collections.ConcurrentMap;
import java.io.File;
import java.security.MessageDigest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0013\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010'R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020*0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lio/ktor/client/plugins/cache/storage/FileCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "data", "", "a", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "b", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "(Lio/ktor/http/Url;)Ljava/lang/String;", "urlHex", "", "caches", "", "o", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteChannel;", "channel", "cache", "n", "(Lio/ktor/utils/io/ByteChannel;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "l", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "Ljava/io/File;", "directory", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lio/ktor/util/collections/ConcurrentMap;", "Lkotlinx/coroutines/sync/Mutex;", "d", "Lio/ktor/util/collections/ConcurrentMap;", "mutexes", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFileCacheStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileCacheStorage.kt\nio/ktor/client/plugins/cache/storage/FileCacheStorage\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 Closeable.kt\nio/ktor/utils/io/core/CloseableKt\n*L\n1#1,196:1\n167#2,3:197\n120#3,10:200\n8#4,4:210\n22#4,2:214\n12#4,9:216\n*S KotlinDebug\n*F\n+ 1 FileCacheStorage.kt\nio/ktor/client/plugins/cache/storage/FileCacheStorage\n*L\n83#1:197,3\n112#1:200,10\n117#1:210,4\n117#1:214,2\n117#1:216,9\n*E\n"})
final class FileCacheStorage implements CacheStorage {
    public final File b;
    public final CoroutineDispatcher c;
    public final ConcurrentMap d;

    public Object a(Url url, CachedResponseData cachedResponseData, Continuation continuation) {
        Object g = BuildersKt.g(this.c, new FileCacheStorage$store$2(this, url, cachedResponseData, (Continuation<? super FileCacheStorage$store$2>) null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(io.ktor.http.Url r5, java.util.Map r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            r6 = r4
            java.util.Map r6 = (java.util.Map) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0048
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r5 = r4.k(r5)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r4.m(r5, r0)
            if (r7 != r1) goto L_0x0048
            return r1
        L_0x0048:
            java.util.Set r7 = (java.util.Set) r7
            java.util.Iterator r4 = r7.iterator()
        L_0x004e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0091
            java.lang.Object r5 = r4.next()
            r7 = r5
            io.ktor.client.plugins.cache.storage.CachedResponseData r7 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r7
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0062
            goto L_0x0092
        L_0x0062:
            java.util.Set r0 = r6.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x006a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0092
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Map r3 = r7.i()
            java.lang.Object r2 = r3.get(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x006a
            goto L_0x004e
        L_0x0091:
            r5 = 0
        L_0x0092:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.b(io.ktor.http.Url, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object c(io.ktor.http.Url r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r5 = r4.k(r5)
            r0.label = r3
            java.lang.Object r6 = r4.m(r5, r0)
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Set r4 = kotlin.collections.CollectionsKt.toSet(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.c(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String k(Url url) {
        byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(StringsKt.encodeToByteArray(url.toString()));
        Intrinsics.checkNotNullExpressionValue(digest, "getInstance(\"MD5\").diges…ng().encodeToByteArray())");
        return CryptoKt.c(digest);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00c2, code lost:
        r21 = r13;
        r13 = r6;
        r6 = r12;
        r12 = r7;
        r7 = r21;
        r22 = r15;
        r15 = r8;
        r8 = r14;
        r14 = r9;
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x01b7, code lost:
        r21 = r11;
        r11 = r7;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x023d, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r1 = (java.lang.String) r1;
        r2.L$0 = r0;
        r2.L$1 = r1;
        r2.label = 2;
        r4 = r0.n(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x024d, code lost:
        if (r4 != r3) goto L_0x0250;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x024f, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0250, code lost:
        r6 = r0;
        r21 = r4;
        r4 = r1;
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0256, code lost:
        r0 = ((java.lang.Number) r1).intValue();
        r2.L$0 = r6;
        r2.L$1 = r4;
        r2.I$0 = r0;
        r2.label = 3;
        r1 = io.ktor.utils.io.ByteReadChannelKt.i(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0269, code lost:
        if (r1 != r3) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x026b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x026c, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r7 = new io.ktor.http.HttpStatusCode(r0, (java.lang.String) r1);
        r0 = io.ktor.http.HttpProtocolVersion.d;
        r2.L$0 = r6;
        r2.L$1 = r4;
        r2.L$2 = r7;
        r2.L$3 = r0;
        r2.label = 4;
        r1 = io.ktor.utils.io.ByteReadChannelKt.i(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0287, code lost:
        if (r1 != r3) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0289, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x028a, code lost:
        r21 = r6;
        r6 = r4;
        r4 = r7;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0290, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r0 = r0.e((java.lang.CharSequence) r1);
        r2.L$0 = r7;
        r2.L$1 = r6;
        r2.L$2 = r4;
        r2.L$3 = r0;
        r2.label = 5;
        r1 = r7.n(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x02a8, code lost:
        if (r1 != r3) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x02aa, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x02ab, code lost:
        r1 = ((java.lang.Number) r1).intValue();
        r10 = null;
        r8 = new io.ktor.http.HeadersBuilder(0, 1, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x02b9, code lost:
        if (r9 >= r1) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x02bb, code lost:
        r2.L$0 = r7;
        r2.L$1 = r6;
        r2.L$2 = r4;
        r2.L$3 = r0;
        r2.L$4 = r8;
        r2.L$5 = r10;
        r2.I$0 = r1;
        r2.I$1 = r9;
        r2.label = 6;
        r10 = io.ktor.utils.io.ByteReadChannelKt.i(r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x02d2, code lost:
        if (r10 != r3) goto L_0x02d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x02d4, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x02d5, code lost:
        r11 = r7;
        r7 = r8;
        r8 = r0;
        r0 = r9;
        r9 = r4;
        r4 = r1;
        r1 = r10;
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x02dd, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r6 = (java.lang.String) r1;
        r2.L$0 = r11;
        r2.L$1 = r10;
        r2.L$2 = r9;
        r2.L$3 = r8;
        r2.L$4 = r7;
        r2.L$5 = r6;
        r2.I$0 = r4;
        r2.I$1 = r0;
        r2.label = 7;
        r1 = io.ktor.utils.io.ByteReadChannelKt.i(r11, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x02fa, code lost:
        if (r1 != r3) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x02fc, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x02fd, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r11.e(r6, (java.lang.String) r1);
        r1 = r4;
        r4 = r9;
        r6 = r10;
        r10 = null;
        r9 = r0 + 1;
        r0 = r8;
        r8 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x030f, code lost:
        r2.L$0 = r7;
        r2.L$1 = r6;
        r2.L$2 = r4;
        r2.L$3 = r0;
        r2.L$4 = r8;
        r2.L$5 = null;
        r2.label = 8;
        r1 = r7.E(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0324, code lost:
        if (r1 != r3) goto L_0x0327;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0326, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0327, code lost:
        r9 = r7;
        r7 = r4;
        r4 = r8;
        r8 = r6;
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x032c, code lost:
        r0 = io.ktor.util.date.DateJvmKt.b((java.lang.Long) r1);
        r2.L$0 = r9;
        r2.L$1 = r8;
        r2.L$2 = r7;
        r2.L$3 = r6;
        r2.L$4 = r4;
        r2.L$5 = r0;
        r2.label = 9;
        r1 = r9.E(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0346, code lost:
        if (r1 != r3) goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0348, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0349, code lost:
        r1 = io.ktor.util.date.DateJvmKt.b((java.lang.Long) r1);
        r2.L$0 = r9;
        r2.L$1 = r8;
        r2.L$2 = r7;
        r2.L$3 = r6;
        r2.L$4 = r4;
        r2.L$5 = r0;
        r2.L$6 = r1;
        r2.label = 10;
        r10 = r9.E(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0365, code lost:
        if (r10 != r3) goto L_0x0368;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0367, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0368, code lost:
        r11 = r9;
        r9 = r7;
        r7 = r4;
        r4 = r1;
        r1 = r10;
        r10 = r8;
        r8 = r6;
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0370, code lost:
        r0 = io.ktor.util.date.DateJvmKt.b((java.lang.Long) r1);
        r2.L$0 = r11;
        r2.L$1 = r10;
        r2.L$2 = r9;
        r2.L$3 = r8;
        r2.L$4 = r7;
        r2.L$5 = r6;
        r2.L$6 = r4;
        r2.L$7 = r0;
        r2.label = 11;
        r1 = r11.n(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x038e, code lost:
        if (r1 != r3) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0390, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0391, code lost:
        r1 = ((java.lang.Number) r1).intValue();
        r12 = kotlin.collections.MapsKt.createMapBuilder();
        r13 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x039c, code lost:
        if (r5 >= r1) goto L_0x040f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x039e, code lost:
        r2.L$0 = r11;
        r2.L$1 = r10;
        r2.L$2 = r9;
        r2.L$3 = r8;
        r2.L$4 = r7;
        r2.L$5 = r6;
        r2.L$6 = r4;
        r2.L$7 = r0;
        r2.L$8 = r12;
        r2.L$9 = r13;
        r2.L$10 = null;
        r2.I$0 = r1;
        r2.I$1 = r5;
        r2.label = 12;
        r14 = io.ktor.utils.io.ByteReadChannelKt.i(r11, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x03c1, code lost:
        if (r14 != r3) goto L_0x03c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x03c3, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x03c4, code lost:
        r15 = r9;
        r9 = r12;
        r12 = r6;
        r6 = r11;
        r11 = r4;
        r4 = r1;
        r1 = r14;
        r14 = r8;
        r8 = r13;
        r13 = r7;
        r7 = r10;
        r10 = r0;
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x03d1, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r5 = (java.lang.String) r1;
        r2.L$0 = r6;
        r2.L$1 = r7;
        r2.L$2 = r15;
        r2.L$3 = r14;
        r2.L$4 = r13;
        r2.L$5 = r12;
        r2.L$6 = r11;
        r2.L$7 = r10;
        r2.L$8 = r9;
        r2.L$9 = r8;
        r2.L$10 = r5;
        r2.I$0 = r4;
        r2.I$1 = r0;
        r2.label = 13;
        r1 = io.ktor.utils.io.ByteReadChannelKt.i(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x03f9, code lost:
        if (r1 != r3) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x03fb, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x03fc, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r15.put(r5, (java.lang.String) r1);
        r5 = r0 + 1;
        r1 = r4;
        r0 = r10;
        r4 = r11;
        r10 = r12;
        r11 = r13;
        r12 = r14;
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x040f, code lost:
        r1 = kotlin.collections.MapsKt.build(r12);
        r2.L$0 = r11;
        r2.L$1 = r10;
        r2.L$2 = r9;
        r2.L$3 = r8;
        r2.L$4 = r7;
        r2.L$5 = r6;
        r2.L$6 = r4;
        r2.L$7 = r0;
        r2.L$8 = r1;
        r2.L$9 = null;
        r2.L$10 = null;
        r2.label = 14;
        r5 = r11.n(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0432, code lost:
        if (r5 != r3) goto L_0x0435;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0434, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0435, code lost:
        r21 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r5;
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x043c, code lost:
        r1 = new byte[((java.lang.Number) r1).intValue()];
        r2.L$0 = r10;
        r2.L$1 = r9;
        r2.L$2 = r8;
        r2.L$3 = r7;
        r2.L$4 = r6;
        r2.L$5 = r5;
        r2.L$6 = r4;
        r2.L$7 = r0;
        r2.L$8 = r1;
        r2.label = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x045e, code lost:
        if (io.ktor.utils.io.ByteReadChannelKt.h(r11, r1, r2) != r3) goto L_0x0461;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0460, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0461, code lost:
        r19 = r0;
        r20 = r1;
        r17 = r4;
        r15 = r5;
        r14 = r6;
        r16 = r8;
        r13 = r9;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x047b, code lost:
        return new io.ktor.client.plugins.cache.storage.CachedResponseData(io.ktor.http.URLUtilsKt.d(r2), r13, r14, r15, r16, r17, r7.n(), r19, r20);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(io.ktor.utils.io.ByteReadChannel r24, kotlin.coroutines.Continuation r25) {
        /*
            r23 = this;
            r0 = r24
            r1 = r25
            boolean r2 = r1 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3
            if (r2 == 0) goto L_0x0017
            r2 = r1
            io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3 r2 = (io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001e
        L_0x0017:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3 r2 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3
            r3 = r23
            r2.<init>(r3, r1)
        L_0x001e:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            switch(r4) {
                case 0: goto L_0x022e;
                case 1: goto L_0x0226;
                case 2: goto L_0x0218;
                case 3: goto L_0x020a;
                case 4: goto L_0x01f5;
                case 5: goto L_0x01e0;
                case 6: goto L_0x01be;
                case 7: goto L_0x0198;
                case 8: goto L_0x017a;
                case 9: goto L_0x015d;
                case 10: goto L_0x0135;
                case 11: goto L_0x0110;
                case 12: goto L_0x00d2;
                case 13: goto L_0x008f;
                case 14: goto L_0x0066;
                case 15: goto L_0x0032;
                default: goto L_0x002a;
            }
        L_0x002a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            java.lang.Object r0 = r2.L$8
            byte[] r0 = (byte[]) r0
            java.lang.Object r3 = r2.L$7
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r4 = r2.L$6
            io.ktor.util.date.GMTDate r4 = (io.ktor.util.date.GMTDate) r4
            java.lang.Object r5 = r2.L$5
            io.ktor.util.date.GMTDate r5 = (io.ktor.util.date.GMTDate) r5
            java.lang.Object r6 = r2.L$4
            io.ktor.util.date.GMTDate r6 = (io.ktor.util.date.GMTDate) r6
            java.lang.Object r7 = r2.L$3
            io.ktor.http.HeadersBuilder r7 = (io.ktor.http.HeadersBuilder) r7
            java.lang.Object r8 = r2.L$2
            io.ktor.http.HttpProtocolVersion r8 = (io.ktor.http.HttpProtocolVersion) r8
            java.lang.Object r9 = r2.L$1
            io.ktor.http.HttpStatusCode r9 = (io.ktor.http.HttpStatusCode) r9
            java.lang.Object r2 = r2.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r20 = r0
            r19 = r3
            r17 = r4
            r15 = r5
            r14 = r6
            r16 = r8
            r13 = r9
            goto L_0x046d
        L_0x0066:
            java.lang.Object r0 = r2.L$8
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r4 = r2.L$7
            io.ktor.util.date.GMTDate r4 = (io.ktor.util.date.GMTDate) r4
            java.lang.Object r5 = r2.L$6
            io.ktor.util.date.GMTDate r5 = (io.ktor.util.date.GMTDate) r5
            java.lang.Object r6 = r2.L$5
            io.ktor.util.date.GMTDate r6 = (io.ktor.util.date.GMTDate) r6
            java.lang.Object r7 = r2.L$4
            io.ktor.http.HeadersBuilder r7 = (io.ktor.http.HeadersBuilder) r7
            java.lang.Object r8 = r2.L$3
            io.ktor.http.HttpProtocolVersion r8 = (io.ktor.http.HttpProtocolVersion) r8
            java.lang.Object r9 = r2.L$2
            io.ktor.http.HttpStatusCode r9 = (io.ktor.http.HttpStatusCode) r9
            java.lang.Object r10 = r2.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r11 = (io.ktor.utils.io.ByteReadChannel) r11
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x043c
        L_0x008f:
            int r0 = r2.I$1
            int r4 = r2.I$0
            java.lang.Object r5 = r2.L$10
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r8 = r2.L$9
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r9 = r2.L$8
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r10 = r2.L$7
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            java.lang.Object r11 = r2.L$6
            io.ktor.util.date.GMTDate r11 = (io.ktor.util.date.GMTDate) r11
            java.lang.Object r12 = r2.L$5
            io.ktor.util.date.GMTDate r12 = (io.ktor.util.date.GMTDate) r12
            java.lang.Object r13 = r2.L$4
            io.ktor.http.HeadersBuilder r13 = (io.ktor.http.HeadersBuilder) r13
            java.lang.Object r14 = r2.L$3
            io.ktor.http.HttpProtocolVersion r14 = (io.ktor.http.HttpProtocolVersion) r14
            java.lang.Object r15 = r2.L$2
            io.ktor.http.HttpStatusCode r15 = (io.ktor.http.HttpStatusCode) r15
            java.lang.Object r7 = r2.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.ResultKt.throwOnFailure(r1)
        L_0x00c2:
            r21 = r13
            r13 = r6
            r6 = r12
            r12 = r7
            r7 = r21
            r22 = r15
            r15 = r8
            r8 = r14
            r14 = r9
            r9 = r22
            goto L_0x03fc
        L_0x00d2:
            int r0 = r2.I$1
            int r4 = r2.I$0
            java.lang.Object r5 = r2.L$9
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r2.L$8
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r7 = r2.L$7
            io.ktor.util.date.GMTDate r7 = (io.ktor.util.date.GMTDate) r7
            java.lang.Object r8 = r2.L$6
            io.ktor.util.date.GMTDate r8 = (io.ktor.util.date.GMTDate) r8
            java.lang.Object r9 = r2.L$5
            io.ktor.util.date.GMTDate r9 = (io.ktor.util.date.GMTDate) r9
            java.lang.Object r10 = r2.L$4
            io.ktor.http.HeadersBuilder r10 = (io.ktor.http.HeadersBuilder) r10
            java.lang.Object r11 = r2.L$3
            io.ktor.http.HttpProtocolVersion r11 = (io.ktor.http.HttpProtocolVersion) r11
            java.lang.Object r12 = r2.L$2
            io.ktor.http.HttpStatusCode r12 = (io.ktor.http.HttpStatusCode) r12
            java.lang.Object r13 = r2.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r14 = (io.ktor.utils.io.ByteReadChannel) r14
            kotlin.ResultKt.throwOnFailure(r1)
            r15 = r12
            r12 = r9
            r9 = r6
            r6 = r14
            r14 = r11
            r11 = r8
            r8 = r5
            r21 = r10
            r10 = r7
            r7 = r13
            r13 = r21
            goto L_0x03d1
        L_0x0110:
            java.lang.Object r0 = r2.L$7
            io.ktor.util.date.GMTDate r0 = (io.ktor.util.date.GMTDate) r0
            java.lang.Object r4 = r2.L$6
            io.ktor.util.date.GMTDate r4 = (io.ktor.util.date.GMTDate) r4
            java.lang.Object r6 = r2.L$5
            io.ktor.util.date.GMTDate r6 = (io.ktor.util.date.GMTDate) r6
            java.lang.Object r7 = r2.L$4
            io.ktor.http.HeadersBuilder r7 = (io.ktor.http.HeadersBuilder) r7
            java.lang.Object r8 = r2.L$3
            io.ktor.http.HttpProtocolVersion r8 = (io.ktor.http.HttpProtocolVersion) r8
            java.lang.Object r9 = r2.L$2
            io.ktor.http.HttpStatusCode r9 = (io.ktor.http.HttpStatusCode) r9
            java.lang.Object r10 = r2.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r11 = (io.ktor.utils.io.ByteReadChannel) r11
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0391
        L_0x0135:
            java.lang.Object r0 = r2.L$6
            io.ktor.util.date.GMTDate r0 = (io.ktor.util.date.GMTDate) r0
            java.lang.Object r4 = r2.L$5
            io.ktor.util.date.GMTDate r4 = (io.ktor.util.date.GMTDate) r4
            java.lang.Object r6 = r2.L$4
            io.ktor.http.HeadersBuilder r6 = (io.ktor.http.HeadersBuilder) r6
            java.lang.Object r7 = r2.L$3
            io.ktor.http.HttpProtocolVersion r7 = (io.ktor.http.HttpProtocolVersion) r7
            java.lang.Object r8 = r2.L$2
            io.ktor.http.HttpStatusCode r8 = (io.ktor.http.HttpStatusCode) r8
            java.lang.Object r9 = r2.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r10 = (io.ktor.utils.io.ByteReadChannel) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r4
            r4 = r0
            goto L_0x0370
        L_0x015d:
            java.lang.Object r0 = r2.L$5
            io.ktor.util.date.GMTDate r0 = (io.ktor.util.date.GMTDate) r0
            java.lang.Object r4 = r2.L$4
            io.ktor.http.HeadersBuilder r4 = (io.ktor.http.HeadersBuilder) r4
            java.lang.Object r6 = r2.L$3
            io.ktor.http.HttpProtocolVersion r6 = (io.ktor.http.HttpProtocolVersion) r6
            java.lang.Object r7 = r2.L$2
            io.ktor.http.HttpStatusCode r7 = (io.ktor.http.HttpStatusCode) r7
            java.lang.Object r8 = r2.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r9 = (io.ktor.utils.io.ByteReadChannel) r9
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0349
        L_0x017a:
            java.lang.Object r0 = r2.L$4
            io.ktor.http.HeadersBuilder r0 = (io.ktor.http.HeadersBuilder) r0
            java.lang.Object r4 = r2.L$3
            io.ktor.http.HttpProtocolVersion r4 = (io.ktor.http.HttpProtocolVersion) r4
            java.lang.Object r6 = r2.L$2
            io.ktor.http.HttpStatusCode r6 = (io.ktor.http.HttpStatusCode) r6
            java.lang.Object r7 = r2.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
            kotlin.ResultKt.throwOnFailure(r1)
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r4
            r4 = r0
            goto L_0x032c
        L_0x0198:
            int r0 = r2.I$1
            int r4 = r2.I$0
            java.lang.Object r6 = r2.L$5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.L$4
            io.ktor.http.HeadersBuilder r7 = (io.ktor.http.HeadersBuilder) r7
            java.lang.Object r8 = r2.L$3
            io.ktor.http.HttpProtocolVersion r8 = (io.ktor.http.HttpProtocolVersion) r8
            java.lang.Object r9 = r2.L$2
            io.ktor.http.HttpStatusCode r9 = (io.ktor.http.HttpStatusCode) r9
            java.lang.Object r10 = r2.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r11 = (io.ktor.utils.io.ByteReadChannel) r11
            kotlin.ResultKt.throwOnFailure(r1)
        L_0x01b7:
            r21 = r11
            r11 = r7
            r7 = r21
            goto L_0x02fd
        L_0x01be:
            int r0 = r2.I$1
            int r4 = r2.I$0
            java.lang.Object r6 = r2.L$4
            io.ktor.http.HeadersBuilder r6 = (io.ktor.http.HeadersBuilder) r6
            java.lang.Object r7 = r2.L$3
            io.ktor.http.HttpProtocolVersion r7 = (io.ktor.http.HttpProtocolVersion) r7
            java.lang.Object r8 = r2.L$2
            io.ktor.http.HttpStatusCode r8 = (io.ktor.http.HttpStatusCode) r8
            java.lang.Object r9 = r2.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r10 = (io.ktor.utils.io.ByteReadChannel) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L_0x02dd
        L_0x01e0:
            java.lang.Object r0 = r2.L$3
            io.ktor.http.HttpProtocolVersion r0 = (io.ktor.http.HttpProtocolVersion) r0
            java.lang.Object r4 = r2.L$2
            io.ktor.http.HttpStatusCode r4 = (io.ktor.http.HttpStatusCode) r4
            java.lang.Object r6 = r2.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x02ab
        L_0x01f5:
            java.lang.Object r0 = r2.L$3
            io.ktor.http.HttpProtocolVersion$Companion r0 = (io.ktor.http.HttpProtocolVersion.Companion) r0
            java.lang.Object r4 = r2.L$2
            io.ktor.http.HttpStatusCode r4 = (io.ktor.http.HttpStatusCode) r4
            java.lang.Object r6 = r2.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0290
        L_0x020a:
            int r0 = r2.I$0
            java.lang.Object r4 = r2.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x026c
        L_0x0218:
            java.lang.Object r0 = r2.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r4 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = r4
            r4 = r0
            goto L_0x0256
        L_0x0226:
            java.lang.Object r0 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x023d
        L_0x022e:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.L$0 = r0
            r1 = 1
            r2.label = r1
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannelKt.i(r0, r2)
            if (r1 != r3) goto L_0x023d
            return r3
        L_0x023d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            r2.L$0 = r0
            r2.L$1 = r1
            r4 = 2
            r2.label = r4
            java.lang.Object r4 = r0.n(r2)
            if (r4 != r3) goto L_0x0250
            return r3
        L_0x0250:
            r6 = r0
            r21 = r4
            r4 = r1
            r1 = r21
        L_0x0256:
            java.lang.Number r1 = (java.lang.Number) r1
            int r0 = r1.intValue()
            r2.L$0 = r6
            r2.L$1 = r4
            r2.I$0 = r0
            r1 = 3
            r2.label = r1
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannelKt.i(r6, r2)
            if (r1 != r3) goto L_0x026c
            return r3
        L_0x026c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            io.ktor.http.HttpStatusCode r7 = new io.ktor.http.HttpStatusCode
            r7.<init>(r0, r1)
            io.ktor.http.HttpProtocolVersion$Companion r0 = io.ktor.http.HttpProtocolVersion.d
            r2.L$0 = r6
            r2.L$1 = r4
            r2.L$2 = r7
            r2.L$3 = r0
            r1 = 4
            r2.label = r1
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannelKt.i(r6, r2)
            if (r1 != r3) goto L_0x028a
            return r3
        L_0x028a:
            r21 = r6
            r6 = r4
            r4 = r7
            r7 = r21
        L_0x0290:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            io.ktor.http.HttpProtocolVersion r0 = r0.e(r1)
            r2.L$0 = r7
            r2.L$1 = r6
            r2.L$2 = r4
            r2.L$3 = r0
            r1 = 5
            r2.label = r1
            java.lang.Object r1 = r7.n(r2)
            if (r1 != r3) goto L_0x02ab
            return r3
        L_0x02ab:
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            io.ktor.http.HeadersBuilder r8 = new io.ktor.http.HeadersBuilder
            r9 = 1
            r10 = 0
            r8.<init>(r5, r9, r10)
            r9 = r5
        L_0x02b9:
            if (r9 >= r1) goto L_0x030f
            r2.L$0 = r7
            r2.L$1 = r6
            r2.L$2 = r4
            r2.L$3 = r0
            r2.L$4 = r8
            r2.L$5 = r10
            r2.I$0 = r1
            r2.I$1 = r9
            r10 = 6
            r2.label = r10
            java.lang.Object r10 = io.ktor.utils.io.ByteReadChannelKt.i(r7, r2)
            if (r10 != r3) goto L_0x02d5
            return r3
        L_0x02d5:
            r11 = r7
            r7 = r8
            r8 = r0
            r0 = r9
            r9 = r4
            r4 = r1
            r1 = r10
            r10 = r6
        L_0x02dd:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r9
            r2.L$3 = r8
            r2.L$4 = r7
            r2.L$5 = r6
            r2.I$0 = r4
            r2.I$1 = r0
            r1 = 7
            r2.label = r1
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannelKt.i(r11, r2)
            if (r1 != r3) goto L_0x01b7
            return r3
        L_0x02fd:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            r11.e(r6, r1)
            r1 = 1
            int r0 = r0 + r1
            r1 = r4
            r4 = r9
            r6 = r10
            r10 = 0
            r9 = r0
            r0 = r8
            r8 = r11
            goto L_0x02b9
        L_0x030f:
            r2.L$0 = r7
            r2.L$1 = r6
            r2.L$2 = r4
            r2.L$3 = r0
            r2.L$4 = r8
            r1 = 0
            r2.L$5 = r1
            r1 = 8
            r2.label = r1
            java.lang.Object r1 = r7.E(r2)
            if (r1 != r3) goto L_0x0327
            return r3
        L_0x0327:
            r9 = r7
            r7 = r4
            r4 = r8
            r8 = r6
            r6 = r0
        L_0x032c:
            java.lang.Long r1 = (java.lang.Long) r1
            io.ktor.util.date.GMTDate r0 = io.ktor.util.date.DateJvmKt.b(r1)
            r2.L$0 = r9
            r2.L$1 = r8
            r2.L$2 = r7
            r2.L$3 = r6
            r2.L$4 = r4
            r2.L$5 = r0
            r1 = 9
            r2.label = r1
            java.lang.Object r1 = r9.E(r2)
            if (r1 != r3) goto L_0x0349
            return r3
        L_0x0349:
            java.lang.Long r1 = (java.lang.Long) r1
            io.ktor.util.date.GMTDate r1 = io.ktor.util.date.DateJvmKt.b(r1)
            r2.L$0 = r9
            r2.L$1 = r8
            r2.L$2 = r7
            r2.L$3 = r6
            r2.L$4 = r4
            r2.L$5 = r0
            r2.L$6 = r1
            r10 = 10
            r2.label = r10
            java.lang.Object r10 = r9.E(r2)
            if (r10 != r3) goto L_0x0368
            return r3
        L_0x0368:
            r11 = r9
            r9 = r7
            r7 = r4
            r4 = r1
            r1 = r10
            r10 = r8
            r8 = r6
            r6 = r0
        L_0x0370:
            java.lang.Long r1 = (java.lang.Long) r1
            io.ktor.util.date.GMTDate r0 = io.ktor.util.date.DateJvmKt.b(r1)
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r9
            r2.L$3 = r8
            r2.L$4 = r7
            r2.L$5 = r6
            r2.L$6 = r4
            r2.L$7 = r0
            r1 = 11
            r2.label = r1
            java.lang.Object r1 = r11.n(r2)
            if (r1 != r3) goto L_0x0391
            return r3
        L_0x0391:
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.util.Map r12 = kotlin.collections.MapsKt.createMapBuilder()
            r13 = r12
        L_0x039c:
            if (r5 >= r1) goto L_0x040f
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r9
            r2.L$3 = r8
            r2.L$4 = r7
            r2.L$5 = r6
            r2.L$6 = r4
            r2.L$7 = r0
            r2.L$8 = r12
            r2.L$9 = r13
            r14 = 0
            r2.L$10 = r14
            r2.I$0 = r1
            r2.I$1 = r5
            r14 = 12
            r2.label = r14
            java.lang.Object r14 = io.ktor.utils.io.ByteReadChannelKt.i(r11, r2)
            if (r14 != r3) goto L_0x03c4
            return r3
        L_0x03c4:
            r15 = r9
            r9 = r12
            r12 = r6
            r6 = r11
            r11 = r4
            r4 = r1
            r1 = r14
            r14 = r8
            r8 = r13
            r13 = r7
            r7 = r10
            r10 = r0
            r0 = r5
        L_0x03d1:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            r2.L$0 = r6
            r2.L$1 = r7
            r2.L$2 = r15
            r2.L$3 = r14
            r2.L$4 = r13
            r2.L$5 = r12
            r2.L$6 = r11
            r2.L$7 = r10
            r2.L$8 = r9
            r2.L$9 = r8
            r2.L$10 = r5
            r2.I$0 = r4
            r2.I$1 = r0
            r1 = 13
            r2.label = r1
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannelKt.i(r6, r2)
            if (r1 != r3) goto L_0x00c2
            return r3
        L_0x03fc:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            r15.put(r5, r1)
            r1 = 1
            int r5 = r0 + 1
            r1 = r4
            r0 = r10
            r4 = r11
            r10 = r12
            r11 = r13
            r12 = r14
            r13 = r15
            goto L_0x039c
        L_0x040f:
            java.util.Map r1 = kotlin.collections.MapsKt.build(r12)
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r9
            r2.L$3 = r8
            r2.L$4 = r7
            r2.L$5 = r6
            r2.L$6 = r4
            r2.L$7 = r0
            r2.L$8 = r1
            r5 = 0
            r2.L$9 = r5
            r2.L$10 = r5
            r5 = 14
            r2.label = r5
            java.lang.Object r5 = r11.n(r2)
            if (r5 != r3) goto L_0x0435
            return r3
        L_0x0435:
            r21 = r4
            r4 = r0
            r0 = r1
            r1 = r5
            r5 = r21
        L_0x043c:
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            byte[] r1 = new byte[r1]
            r2.L$0 = r10
            r2.L$1 = r9
            r2.L$2 = r8
            r2.L$3 = r7
            r2.L$4 = r6
            r2.L$5 = r5
            r2.L$6 = r4
            r2.L$7 = r0
            r2.L$8 = r1
            r12 = 15
            r2.label = r12
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannelKt.h(r11, r1, r2)
            if (r2 != r3) goto L_0x0461
            return r3
        L_0x0461:
            r19 = r0
            r20 = r1
            r17 = r4
            r15 = r5
            r14 = r6
            r16 = r8
            r13 = r9
            r2 = r10
        L_0x046d:
            io.ktor.client.plugins.cache.storage.CachedResponseData r0 = new io.ktor.client.plugins.cache.storage.CachedResponseData
            io.ktor.http.Url r12 = io.ktor.http.URLUtilsKt.d(r2)
            io.ktor.http.Headers r18 = r7.n()
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.l(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d9 A[Catch:{ all -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e4 A[SYNTHETIC, Splitter:B:42:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012f A[SYNTHETIC, Splitter:B:59:0x012f] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0161 A[SYNTHETIC, Splitter:B:69:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m(java.lang.String r18, kotlin.coroutines.Continuation r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r2 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1 r3 = (io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1 r3 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 4
            r8 = 2
            r9 = 3
            r10 = 1
            r11 = 0
            if (r5 == 0) goto L_0x00b0
            if (r5 == r10) goto L_0x009e
            if (r5 == r8) goto L_0x007c
            if (r5 == r9) goto L_0x0053
            if (r5 != r7) goto L_0x004b
            java.lang.Object r0 = r3.L$2
            java.util.Set r0 = (java.util.Set) r0
            java.lang.Object r1 = r3.L$1
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r3 = r3.L$0
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0047 }
            goto L_0x017a
        L_0x0047:
            r0 = move-exception
        L_0x0048:
            r2 = r0
            goto L_0x018f
        L_0x004b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0053:
            int r0 = r3.I$2
            int r1 = r3.I$1
            int r5 = r3.I$0
            java.lang.Object r6 = r3.L$5
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Object r8 = r3.L$4
            java.util.Set r8 = (java.util.Set) r8
            java.lang.Object r12 = r3.L$3
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            java.lang.Object r13 = r3.L$2
            java.io.Closeable r13 = (java.io.Closeable) r13
            java.lang.Object r14 = r3.L$1
            kotlinx.coroutines.sync.Mutex r14 = (kotlinx.coroutines.sync.Mutex) r14
            java.lang.Object r15 = r3.L$0
            io.ktor.client.plugins.cache.storage.FileCacheStorage r15 = (io.ktor.client.plugins.cache.storage.FileCacheStorage) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0076 }
            goto L_0x0153
        L_0x0076:
            r0 = move-exception
            r2 = r0
            r1 = r13
            r3 = r14
            goto L_0x018f
        L_0x007c:
            int r0 = r3.I$0
            java.lang.Object r1 = r3.L$3
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            java.lang.Object r5 = r3.L$2
            java.io.Closeable r5 = (java.io.Closeable) r5
            java.lang.Object r8 = r3.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r12 = r3.L$0
            io.ktor.client.plugins.cache.storage.FileCacheStorage r12 = (io.ktor.client.plugins.cache.storage.FileCacheStorage) r12
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0098 }
            r16 = r5
            r5 = r1
            r1 = r16
            goto L_0x0119
        L_0x0098:
            r0 = move-exception
            r2 = r0
            r1 = r5
        L_0x009b:
            r3 = r8
            goto L_0x018f
        L_0x009e:
            java.lang.Object r0 = r3.L$2
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r1 = r3.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$0
            io.ktor.client.plugins.cache.storage.FileCacheStorage r5 = (io.ktor.client.plugins.cache.storage.FileCacheStorage) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r5
            goto L_0x00cc
        L_0x00b0:
            kotlin.ResultKt.throwOnFailure(r2)
            io.ktor.util.collections.ConcurrentMap r2 = r0.d
            io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$mutex$1 r5 = io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$mutex$1.INSTANCE
            java.lang.Object r2 = r2.c(r1, r5)
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r2
            r3.label = r10
            java.lang.Object r5 = r2.c(r11, r3)
            if (r5 != r4) goto L_0x00cc
            return r4
        L_0x00cc:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00e1 }
            java.io.File r12 = r0.b     // Catch:{ all -> 0x00e1 }
            r5.<init>(r12, r1)     // Catch:{ all -> 0x00e1 }
            boolean r1 = r5.exists()     // Catch:{ all -> 0x00e1 }
            if (r1 != 0) goto L_0x00e4
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()     // Catch:{ all -> 0x00e1 }
            r2.d(r11)
            return r0
        L_0x00e1:
            r0 = move-exception
            goto L_0x01bf
        L_0x00e4:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00f0 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x00f0 }
            boolean r5 = r1 instanceof java.io.BufferedInputStream     // Catch:{ Exception -> 0x00f0 }
            if (r5 == 0) goto L_0x00f3
            java.io.BufferedInputStream r1 = (java.io.BufferedInputStream) r1     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00fb
        L_0x00f0:
            r0 = move-exception
            goto L_0x019b
        L_0x00f3:
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00f0 }
            r12 = 8192(0x2000, float:1.14794E-41)
            r5.<init>(r1, r12)     // Catch:{ Exception -> 0x00f0 }
            r1 = r5
        L_0x00fb:
            io.ktor.utils.io.ByteReadChannel r5 = io.ktor.utils.io.jvm.javaio.ReadingKt.e(r1, r11, r11, r9, r11)     // Catch:{ all -> 0x018b }
            r3.L$0 = r0     // Catch:{ all -> 0x018b }
            r3.L$1 = r2     // Catch:{ all -> 0x018b }
            r3.L$2 = r1     // Catch:{ all -> 0x018b }
            r3.L$3 = r5     // Catch:{ all -> 0x018b }
            r3.I$0 = r6     // Catch:{ all -> 0x018b }
            r3.label = r8     // Catch:{ all -> 0x018b }
            java.lang.Object r8 = r5.n(r3)     // Catch:{ all -> 0x018b }
            if (r8 != r4) goto L_0x0112
            return r4
        L_0x0112:
            r12 = r0
            r0 = r6
            r16 = r8
            r8 = r2
            r2 = r16
        L_0x0119:
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x0187 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0187 }
            java.util.LinkedHashSet r13 = new java.util.LinkedHashSet     // Catch:{ all -> 0x0187 }
            r13.<init>()     // Catch:{ all -> 0x0187 }
            r15 = r12
            r12 = r5
            r5 = r0
            r0 = r13
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x012d:
            if (r6 >= r1) goto L_0x0161
            r3.L$0 = r15     // Catch:{ all -> 0x015c }
            r3.L$1 = r8     // Catch:{ all -> 0x015c }
            r3.L$2 = r2     // Catch:{ all -> 0x015c }
            r3.L$3 = r12     // Catch:{ all -> 0x015c }
            r3.L$4 = r0     // Catch:{ all -> 0x015c }
            r3.L$5 = r0     // Catch:{ all -> 0x015c }
            r3.I$0 = r5     // Catch:{ all -> 0x015c }
            r3.I$1 = r1     // Catch:{ all -> 0x015c }
            r3.I$2 = r6     // Catch:{ all -> 0x015c }
            r3.label = r9     // Catch:{ all -> 0x015c }
            java.lang.Object r13 = r15.l(r12, r3)     // Catch:{ all -> 0x015c }
            if (r13 != r4) goto L_0x014a
            return r4
        L_0x014a:
            r14 = r8
            r8 = r0
            r0 = r6
            r6 = r8
            r16 = r13
            r13 = r2
            r2 = r16
        L_0x0153:
            r6.add(r2)     // Catch:{ all -> 0x0076 }
            int r6 = r0 + 1
            r0 = r8
            r2 = r13
            r8 = r14
            goto L_0x012d
        L_0x015c:
            r0 = move-exception
            r1 = r2
            r3 = r8
            goto L_0x0048
        L_0x0161:
            r3.L$0 = r8     // Catch:{ all -> 0x015c }
            r3.L$1 = r2     // Catch:{ all -> 0x015c }
            r3.L$2 = r0     // Catch:{ all -> 0x015c }
            r3.L$3 = r11     // Catch:{ all -> 0x015c }
            r3.L$4 = r11     // Catch:{ all -> 0x015c }
            r3.L$5 = r11     // Catch:{ all -> 0x015c }
            r3.I$0 = r5     // Catch:{ all -> 0x015c }
            r3.label = r7     // Catch:{ all -> 0x015c }
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannelKt.e(r12, r3)     // Catch:{ all -> 0x015c }
            if (r1 != r4) goto L_0x0178
            return r4
        L_0x0178:
            r1 = r2
            r3 = r8
        L_0x017a:
            r1.close()     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
            r3.d(r11)
            return r0
        L_0x0181:
            r0 = move-exception
            r2 = r3
            goto L_0x01bf
        L_0x0184:
            r0 = move-exception
            r2 = r3
            goto L_0x019b
        L_0x0187:
            r0 = move-exception
            r2 = r0
            goto L_0x009b
        L_0x018b:
            r0 = move-exception
            r3 = r2
            goto L_0x0048
        L_0x018f:
            r1.close()     // Catch:{ all -> 0x0193 }
            goto L_0x0198
        L_0x0193:
            r0 = move-exception
            r1 = r0
            io.ktor.utils.io.core.CloseableJVMKt.a(r2, r1)     // Catch:{ all -> 0x0199 }
        L_0x0198:
            throw r2     // Catch:{ all -> 0x0199 }
        L_0x0199:
            r0 = move-exception
            throw r0     // Catch:{ Exception -> 0x0184, all -> 0x0181 }
        L_0x019b:
            org.slf4j.Logger r1 = io.ktor.client.plugins.cache.HttpCacheKt.c()     // Catch:{ all -> 0x00e1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
            r3.<init>()     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = "Exception during cache lookup in a file: "
            r3.append(r4)     // Catch:{ all -> 0x00e1 }
            java.lang.String r0 = kotlin.ExceptionsKt.stackTraceToString(r0)     // Catch:{ all -> 0x00e1 }
            r3.append(r0)     // Catch:{ all -> 0x00e1 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00e1 }
            r1.trace(r0)     // Catch:{ all -> 0x00e1 }
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()     // Catch:{ all -> 0x00e1 }
            r2.d(r11)
            return r0
        L_0x01bf:
            r2.d(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.m(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: io.ktor.client.plugins.cache.storage.CachedResponseData} */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0050, code lost:
        r8 = r9;
        r9 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e6, code lost:
        r1 = r9;
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0134, code lost:
        r7 = r9.g().h0();
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0147, code lost:
        if (r8.O(r7, r0) != r10) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0149, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x014a, code lost:
        r6 = r9;
        r9 = r8;
        r8 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x014d, code lost:
        r7 = r8.g().g0() + 10;
        r0.L$0 = r9;
        r0.L$1 = r8;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x016f, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.d(r9, r7, r0) != r10) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0171, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0172, code lost:
        r7 = new java.lang.StringBuilder();
        r7.append(r8.j());
        r7.append(10);
        r7 = r7.toString();
        r0.L$0 = r9;
        r0.L$1 = r8;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0190, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.d(r9, r7, r0) != r10) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0192, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0193, code lost:
        r8 = io.ktor.util.StringValuesKt.f(r9.d());
        r7 = r8.size();
        r0.L$0 = r1;
        r0.L$1 = r9;
        r0.L$2 = r8;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01ac, code lost:
        if (r1.O(r7, r0) != r10) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01ae, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01af, code lost:
        r7 = r8.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01b7, code lost:
        if (r7.hasNext() == false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01b9, code lost:
        r8 = (kotlin.Pair) r7.next();
        r8 = (java.lang.String) r8.component2();
        r4 = ((java.lang.String) r8.component1()) + 10;
        r0.L$0 = r1;
        r0.L$1 = r9;
        r0.L$2 = r7;
        r0.L$3 = r8;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01e9, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.d(r1, r4, r0) != r10) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01eb, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01ec, code lost:
        r8 = r8 + 10;
        r0.L$0 = r1;
        r0.L$1 = r9;
        r0.L$2 = r7;
        r0.L$3 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x020a, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.d(r1, r8, r0) != r10) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x020c, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x020d, code lost:
        r7 = r9.e().d();
        r0.L$0 = r1;
        r0.L$1 = r9;
        r0.L$2 = null;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0223, code lost:
        if (r1.H(r7, r0) != r10) goto L_0x0226;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0225, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0226, code lost:
        r8 = r9;
        r9 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0228, code lost:
        r4 = r8.f().d();
        r0.L$0 = r9;
        r0.L$1 = r8;
        r0.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x023c, code lost:
        if (r9.H(r4, r0) != r10) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x023e, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x023f, code lost:
        r4 = r8.c().d();
        r0.L$0 = r9;
        r0.L$1 = r8;
        r0.label = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0251, code lost:
        if (r9.H(r4, r0) != r10) goto L_0x0254;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0253, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0254, code lost:
        r7 = r8.i().size();
        r0.L$0 = r9;
        r0.L$1 = r8;
        r0.label = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0268, code lost:
        if (r9.O(r7, r0) != r10) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x026a, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x026b, code lost:
        r7 = r8.i().entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x027b, code lost:
        if (r7.hasNext() == false) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x027d, code lost:
        r1 = (java.util.Map.Entry) r7.next();
        r1 = (java.lang.String) r1.getValue();
        r4 = ((java.lang.String) r1.getKey()) + 10;
        r0.L$0 = r9;
        r0.L$1 = r8;
        r0.L$2 = r7;
        r0.L$3 = r1;
        r0.label = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02ae, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.d(r9, r4, r0) != r10) goto L_0x02b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02b0, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02b1, code lost:
        r6 = r9;
        r9 = r8;
        r8 = r1;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02b5, code lost:
        r8 = r8 + 10;
        r0.L$0 = r1;
        r0.L$1 = r9;
        r0.L$2 = r7;
        r0.L$3 = null;
        r0.label = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02d4, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.d(r1, r8, r0) != r10) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02d6, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02d7, code lost:
        r7 = r8.b().length;
        r0.L$0 = r9;
        r0.L$1 = r8;
        r0.L$2 = null;
        r0.label = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02ea, code lost:
        if (r9.O(r7, r0) != r10) goto L_0x02ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02ec, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02ed, code lost:
        r7 = r8.b();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x02fd, code lost:
        if (io.ktor.utils.io.ByteWriteChannelKt.b(r9, r7, r0) != r10) goto L_0x0300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02ff, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0302, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(io.ktor.utils.io.ByteChannel r8, io.ktor.client.plugins.cache.storage.CachedResponseData r9, kotlin.coroutines.Continuation r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$3
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$3 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$3 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$3
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 0
            r3 = 10
            switch(r1) {
                case 0: goto L_0x0110;
                case 1: goto L_0x0103;
                case 2: goto L_0x00f7;
                case 3: goto L_0x00ea;
                case 4: goto L_0x00db;
                case 5: goto L_0x00ca;
                case 6: goto L_0x00b2;
                case 7: goto L_0x00a0;
                case 8: goto L_0x0093;
                case 9: goto L_0x0086;
                case 10: goto L_0x0079;
                case 11: goto L_0x006c;
                case 12: goto L_0x0054;
                case 13: goto L_0x0040;
                case 14: goto L_0x0033;
                case 15: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0300
        L_0x0033:
            java.lang.Object r8 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannel r9 = (io.ktor.utils.io.ByteChannel) r9
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x02ed
        L_0x0040:
            java.lang.Object r8 = r0.L$2
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r9 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r9
            java.lang.Object r1 = r0.L$0
            io.ktor.utils.io.ByteChannel r1 = (io.ktor.utils.io.ByteChannel) r1
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r8
        L_0x0050:
            r8 = r9
            r9 = r1
            goto L_0x0277
        L_0x0054:
            java.lang.Object r8 = r0.L$3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r1 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r1 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r1
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannel r4 = (io.ktor.utils.io.ByteChannel) r4
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r9
            r9 = r1
            r1 = r4
            goto L_0x02b5
        L_0x006c:
            java.lang.Object r8 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannel r9 = (io.ktor.utils.io.ByteChannel) r9
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x026b
        L_0x0079:
            java.lang.Object r8 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannel r9 = (io.ktor.utils.io.ByteChannel) r9
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0254
        L_0x0086:
            java.lang.Object r8 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannel r9 = (io.ktor.utils.io.ByteChannel) r9
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x023f
        L_0x0093:
            java.lang.Object r8 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannel r9 = (io.ktor.utils.io.ByteChannel) r9
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0228
        L_0x00a0:
            java.lang.Object r8 = r0.L$2
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r9 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r9
            java.lang.Object r1 = r0.L$0
            io.ktor.utils.io.ByteChannel r1 = (io.ktor.utils.io.ByteChannel) r1
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r8
            goto L_0x01b3
        L_0x00b2:
            java.lang.Object r8 = r0.L$3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r1 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r1 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r1
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannel r4 = (io.ktor.utils.io.ByteChannel) r4
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r9
            r9 = r1
            r1 = r4
            goto L_0x01ec
        L_0x00ca:
            java.lang.Object r8 = r0.L$2
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r9 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r9
            java.lang.Object r1 = r0.L$0
            io.ktor.utils.io.ByteChannel r1 = (io.ktor.utils.io.ByteChannel) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x01af
        L_0x00db:
            java.lang.Object r8 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannel r9 = (io.ktor.utils.io.ByteChannel) r9
            kotlin.ResultKt.throwOnFailure(r7)
        L_0x00e6:
            r1 = r9
            r9 = r8
            goto L_0x0193
        L_0x00ea:
            java.lang.Object r8 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannel r9 = (io.ktor.utils.io.ByteChannel) r9
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0172
        L_0x00f7:
            java.lang.Object r8 = r0.L$1
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannel r9 = (io.ktor.utils.io.ByteChannel) r9
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x014d
        L_0x0103:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            io.ktor.client.plugins.cache.storage.CachedResponseData r9 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r9
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannel r8 = (io.ktor.utils.io.ByteChannel) r8
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0134
        L_0x0110:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            io.ktor.http.Url r1 = r9.h()
            r7.append(r1)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            r0.L$0 = r8
            r0.L$1 = r9
            r1 = 1
            r0.label = r1
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelKt.d(r8, r7, r0)
            if (r7 != r10) goto L_0x0134
            return r10
        L_0x0134:
            io.ktor.http.HttpStatusCode r7 = r9.g()
            int r7 = r7.h0()
            r0.L$0 = r8
            r0.L$1 = r9
            r1 = 2
            r0.label = r1
            java.lang.Object r7 = r8.O(r7, r0)
            if (r7 != r10) goto L_0x014a
            return r10
        L_0x014a:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x014d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            io.ktor.http.HttpStatusCode r1 = r8.g()
            java.lang.String r1 = r1.g0()
            r7.append(r1)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            r0.L$0 = r9
            r0.L$1 = r8
            r1 = 3
            r0.label = r1
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelKt.d(r9, r7, r0)
            if (r7 != r10) goto L_0x0172
            return r10
        L_0x0172:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            io.ktor.http.HttpProtocolVersion r1 = r8.j()
            r7.append(r1)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            r0.L$0 = r9
            r0.L$1 = r8
            r1 = 4
            r0.label = r1
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelKt.d(r9, r7, r0)
            if (r7 != r10) goto L_0x00e6
            return r10
        L_0x0193:
            io.ktor.http.Headers r7 = r9.d()
            java.util.List r8 = io.ktor.util.StringValuesKt.f(r7)
            int r7 = r8.size()
            r0.L$0 = r1
            r0.L$1 = r9
            r0.L$2 = r8
            r4 = 5
            r0.label = r4
            java.lang.Object r7 = r1.O(r7, r0)
            if (r7 != r10) goto L_0x01af
            return r10
        L_0x01af:
            java.util.Iterator r7 = r8.iterator()
        L_0x01b3:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x020d
            java.lang.Object r8 = r7.next()
            kotlin.Pair r8 = (kotlin.Pair) r8
            java.lang.Object r4 = r8.component1()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r8.component2()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = r5.toString()
            r0.L$0 = r1
            r0.L$1 = r9
            r0.L$2 = r7
            r0.L$3 = r8
            r5 = 6
            r0.label = r5
            java.lang.Object r4 = io.ktor.utils.io.ByteWriteChannelKt.d(r1, r4, r0)
            if (r4 != r10) goto L_0x01ec
            return r10
        L_0x01ec:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            r4.append(r3)
            java.lang.String r8 = r4.toString()
            r0.L$0 = r1
            r0.L$1 = r9
            r0.L$2 = r7
            r0.L$3 = r2
            r4 = 7
            r0.label = r4
            java.lang.Object r8 = io.ktor.utils.io.ByteWriteChannelKt.d(r1, r8, r0)
            if (r8 != r10) goto L_0x01b3
            return r10
        L_0x020d:
            io.ktor.util.date.GMTDate r7 = r9.e()
            long r7 = r7.d()
            r0.L$0 = r1
            r0.L$1 = r9
            r0.L$2 = r2
            r4 = 8
            r0.label = r4
            java.lang.Object r7 = r1.H(r7, r0)
            if (r7 != r10) goto L_0x0226
            return r10
        L_0x0226:
            r8 = r9
            r9 = r1
        L_0x0228:
            io.ktor.util.date.GMTDate r7 = r8.f()
            long r4 = r7.d()
            r0.L$0 = r9
            r0.L$1 = r8
            r7 = 9
            r0.label = r7
            java.lang.Object r7 = r9.H(r4, r0)
            if (r7 != r10) goto L_0x023f
            return r10
        L_0x023f:
            io.ktor.util.date.GMTDate r7 = r8.c()
            long r4 = r7.d()
            r0.L$0 = r9
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = r9.H(r4, r0)
            if (r7 != r10) goto L_0x0254
            return r10
        L_0x0254:
            java.util.Map r7 = r8.i()
            int r7 = r7.size()
            r0.L$0 = r9
            r0.L$1 = r8
            r1 = 11
            r0.label = r1
            java.lang.Object r7 = r9.O(r7, r0)
            if (r7 != r10) goto L_0x026b
            return r10
        L_0x026b:
            java.util.Map r7 = r8.i()
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0277:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x02d7
            java.lang.Object r1 = r7.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r4 = r1.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = r5.toString()
            r0.L$0 = r9
            r0.L$1 = r8
            r0.L$2 = r7
            r0.L$3 = r1
            r5 = 12
            r0.label = r5
            java.lang.Object r4 = io.ktor.utils.io.ByteWriteChannelKt.d(r9, r4, r0)
            if (r4 != r10) goto L_0x02b1
            return r10
        L_0x02b1:
            r6 = r9
            r9 = r8
            r8 = r1
            r1 = r6
        L_0x02b5:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            r4.append(r3)
            java.lang.String r8 = r4.toString()
            r0.L$0 = r1
            r0.L$1 = r9
            r0.L$2 = r7
            r0.L$3 = r2
            r4 = 13
            r0.label = r4
            java.lang.Object r8 = io.ktor.utils.io.ByteWriteChannelKt.d(r1, r8, r0)
            if (r8 != r10) goto L_0x0050
            return r10
        L_0x02d7:
            byte[] r7 = r8.b()
            int r7 = r7.length
            r0.L$0 = r9
            r0.L$1 = r8
            r0.L$2 = r2
            r1 = 14
            r0.label = r1
            java.lang.Object r7 = r9.O(r7, r0)
            if (r7 != r10) goto L_0x02ed
            return r10
        L_0x02ed:
            byte[] r7 = r8.b()
            r0.L$0 = r2
            r0.L$1 = r2
            r8 = 15
            r0.label = r8
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelKt.b(r9, r7, r0)
            if (r7 != r10) goto L_0x0300
            return r10
        L_0x0300:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.n(io.ktor.utils.io.ByteChannel, io.ktor.client.plugins.cache.storage.CachedResponseData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object o(String str, List list, Continuation continuation) {
        return CoroutineScopeKt.f(new FileCacheStorage$writeCache$2(this, str, list, (Continuation<? super FileCacheStorage$writeCache$2>) null), continuation);
    }
}
