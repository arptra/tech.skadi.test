package io.ktor.client.plugins.cache.storage;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFileCacheStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileCacheStorage.kt\nio/ktor/client/plugins/cache/storage/FileCacheStorage$writeCache$2\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 Closeable.kt\nio/ktor/utils/io/core/CloseableKt\n*L\n1#1,196:1\n120#2,8:197\n129#2:222\n8#3,4:205\n22#3,4:209\n12#3,9:213\n*S KotlinDebug\n*F\n+ 1 FileCacheStorage.kt\nio/ktor/client/plugins/cache/storage/FileCacheStorage$writeCache$2\n*L\n91#1:197,8\n91#1:222\n94#1:205,4\n94#1:209,4\n94#1:213,9\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2", f = "FileCacheStorage.kt", i = {0, 0, 1, 1, 1}, l = {202, 102}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
public final class FileCacheStorage$writeCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ List<CachedResponseData> $caches;
    final /* synthetic */ String $urlHex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$writeCache$2(FileCacheStorage fileCacheStorage, String str, List<CachedResponseData> list, Continuation<? super FileCacheStorage$writeCache$2> continuation) {
        super(2, continuation);
        this.this$0 = fileCacheStorage;
        this.$urlHex = str;
        this.$caches = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FileCacheStorage$writeCache$2 fileCacheStorage$writeCache$2 = new FileCacheStorage$writeCache$2(this.this$0, this.$urlHex, this.$caches, continuation);
        fileCacheStorage$writeCache$2.L$0 = obj;
        return fileCacheStorage$writeCache$2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            r9 = 0
            if (r1 == 0) goto L_0x0047
            if (r1 == r3) goto L_0x002d
            if (r1 != r2) goto L_0x0025
            java.lang.Object r1 = r0.L$1
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r0.L$0
            r2 = r0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x0021 }
            r0 = r18
            goto L_0x00d2
        L_0x0021:
            r0 = move-exception
            r3 = r0
            goto L_0x00ee
        L_0x0025:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002d:
            java.lang.Object r1 = r0.L$4
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r4 = r0.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.L$2
            io.ktor.client.plugins.cache.storage.FileCacheStorage r5 = (io.ktor.client.plugins.cache.storage.FileCacheStorage) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r18)
            r10 = r6
        L_0x0045:
            r11 = r7
            goto L_0x007b
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r1 = r0.L$0
            r7 = r1
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            io.ktor.client.plugins.cache.storage.FileCacheStorage r1 = r0.this$0
            io.ktor.util.collections.ConcurrentMap r1 = r1.d
            java.lang.String r4 = r0.$urlHex
            io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$mutex$1 r5 = io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$mutex$1.INSTANCE
            java.lang.Object r1 = r1.c(r4, r5)
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            io.ktor.client.plugins.cache.storage.FileCacheStorage r5 = r0.this$0
            java.lang.String r4 = r0.$urlHex
            java.util.List<io.ktor.client.plugins.cache.storage.CachedResponseData> r6 = r0.$caches
            r0.L$0 = r7
            r0.L$1 = r1
            r0.L$2 = r5
            r0.L$3 = r4
            r0.L$4 = r6
            r0.label = r3
            java.lang.Object r10 = r1.c(r9, r0)
            if (r10 != r8) goto L_0x0078
            return r8
        L_0x0078:
            r10 = r1
            r1 = r6
            goto L_0x0045
        L_0x007b:
            r6 = 0
            io.ktor.utils.io.ByteChannel r3 = io.ktor.utils.io.ByteChannelKt.b(r6, r3, r9)     // Catch:{ all -> 0x0095 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0098 }
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x0098 }
            java.io.File r13 = r5.b     // Catch:{ Exception -> 0x0098 }
            r12.<init>(r13, r4)     // Catch:{ Exception -> 0x0098 }
            r7.<init>(r12)     // Catch:{ Exception -> 0x0098 }
            boolean r4 = r7 instanceof java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0098 }
            if (r4 == 0) goto L_0x009b
            java.io.BufferedOutputStream r7 = (java.io.BufferedOutputStream) r7     // Catch:{ Exception -> 0x0098 }
            goto L_0x00a3
        L_0x0095:
            r0 = move-exception
            goto L_0x011d
        L_0x0098:
            r0 = move-exception
            goto L_0x00fa
        L_0x009b:
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0098 }
            r12 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r7, r12)     // Catch:{ Exception -> 0x0098 }
            r7 = r4
        L_0x00a3:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$1$1$1 r14 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$1$1$1     // Catch:{ all -> 0x00eb }
            r14.<init>(r3, r1, r5, r9)     // Catch:{ all -> 0x00eb }
            r15 = 3
            r16 = 0
            r12 = 0
            r13 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x00eb }
            r0.L$0 = r10     // Catch:{ all -> 0x00eb }
            r0.L$1 = r7     // Catch:{ all -> 0x00eb }
            r0.L$2 = r9     // Catch:{ all -> 0x00eb }
            r0.L$3 = r9     // Catch:{ all -> 0x00eb }
            r0.L$4 = r9     // Catch:{ all -> 0x00eb }
            r0.I$0 = r6     // Catch:{ all -> 0x00eb }
            r0.label = r2     // Catch:{ all -> 0x00eb }
            r4 = 0
            r6 = 2
            r11 = 0
            r1 = r3
            r2 = r7
            r3 = r4
            r5 = r17
            r12 = r7
            r7 = r11
            java.lang.Object r0 = io.ktor.utils.io.jvm.javaio.WritingKt.b(r1, r2, r3, r5, r6, r7)     // Catch:{ all -> 0x00e6 }
            if (r0 != r8) goto L_0x00d0
            return r8
        L_0x00d0:
            r2 = r10
            r1 = r12
        L_0x00d2:
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ all -> 0x0021 }
            long r3 = r0.longValue()     // Catch:{ all -> 0x0021 }
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)     // Catch:{ all -> 0x0021 }
            r1.close()     // Catch:{ Exception -> 0x00e3, all -> 0x00e0 }
            goto L_0x0119
        L_0x00e0:
            r0 = move-exception
            r10 = r2
            goto L_0x011d
        L_0x00e3:
            r0 = move-exception
            r10 = r2
            goto L_0x00fa
        L_0x00e6:
            r0 = move-exception
        L_0x00e7:
            r3 = r0
            r2 = r10
            r1 = r12
            goto L_0x00ee
        L_0x00eb:
            r0 = move-exception
            r12 = r7
            goto L_0x00e7
        L_0x00ee:
            r1.close()     // Catch:{ all -> 0x00f2 }
            goto L_0x00f7
        L_0x00f2:
            r0 = move-exception
            r1 = r0
            io.ktor.utils.io.core.CloseableJVMKt.a(r3, r1)     // Catch:{ all -> 0x00f8 }
        L_0x00f7:
            throw r3     // Catch:{ all -> 0x00f8 }
        L_0x00f8:
            r0 = move-exception
            throw r0     // Catch:{ Exception -> 0x00e3, all -> 0x00e0 }
        L_0x00fa:
            org.slf4j.Logger r1 = io.ktor.client.plugins.cache.HttpCacheKt.c()     // Catch:{ all -> 0x0095 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r2.<init>()     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "Exception during saving a cache to a file: "
            r2.append(r3)     // Catch:{ all -> 0x0095 }
            java.lang.String r0 = kotlin.ExceptionsKt.stackTraceToString(r0)     // Catch:{ all -> 0x0095 }
            r2.append(r0)     // Catch:{ all -> 0x0095 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0095 }
            r1.trace(r0)     // Catch:{ all -> 0x0095 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0095 }
            r2 = r10
        L_0x0119:
            r2.d(r9)
            return r0
        L_0x011d:
            r10.d(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<Object> continuation) {
        return ((FileCacheStorage$writeCache$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
