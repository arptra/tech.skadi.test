package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "<init>", "()V", "Lio/ktor/http/Url;", "requestUrl", "", "Lio/ktor/http/Cookie;", "O", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cookie", "", "o0", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "timestamp", "a", "(J)V", "", "Ljava/util/List;", "container", "Lkotlinx/coroutines/sync/Mutex;", "b", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAcceptAllCookiesStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AcceptAllCookiesStorage.kt\nio/ktor/client/plugins/cookies/AcceptAllCookiesStorage\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n120#2,8:61\n129#2:72\n120#2,10:73\n766#3:69\n857#3,2:70\n1789#3,2:83\n1791#3:86\n1#4:85\n*S KotlinDebug\n*F\n+ 1 AcceptAllCookiesStorage.kt\nio/ktor/client/plugins/cookies/AcceptAllCookiesStorage\n*L\n23#1:61,8\n23#1:72\n30#1:73,10\n27#1:69\n27#1:70,2\n53#1:83,2\n53#1:86\n*E\n"})
public final class AcceptAllCookiesStorage implements CookiesStorage {

    /* renamed from: a  reason: collision with root package name */
    public final List f8898a = new ArrayList();
    public final Mutex b = MutexKt.b(false, 1, (Object) null);
    @NotNull
    private volatile /* synthetic */ long oldestCookie = 0;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e A[Catch:{ all -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075 A[Catch:{ all -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object O(io.ktor.http.Url r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r0.L$1
            io.ktor.http.Url r6 = (io.ktor.http.Url) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r5
            r5 = r0
            goto L_0x0054
        L_0x0038:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.b
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r0 = r7.c(r4, r0)
            if (r0 != r1) goto L_0x0054
            return r1
        L_0x0054:
            long r0 = io.ktor.util.date.DateJvmKt.d()     // Catch:{ all -> 0x0062 }
            long r2 = r5.oldestCookie     // Catch:{ all -> 0x0062 }
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0064
            r5.a(r0)     // Catch:{ all -> 0x0062 }
            goto L_0x0064
        L_0x0062:
            r5 = move-exception
            goto L_0x008a
        L_0x0064:
            java.util.List r5 = r5.f8898a     // Catch:{ all -> 0x0062 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0062 }
            r0.<init>()     // Catch:{ all -> 0x0062 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0062 }
        L_0x006f:
            boolean r1 = r5.hasNext()     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0086
            java.lang.Object r1 = r5.next()     // Catch:{ all -> 0x0062 }
            r2 = r1
            io.ktor.http.Cookie r2 = (io.ktor.http.Cookie) r2     // Catch:{ all -> 0x0062 }
            boolean r2 = io.ktor.client.plugins.cookies.CookiesStorageKt.b(r2, r6)     // Catch:{ all -> 0x0062 }
            if (r2 == 0) goto L_0x006f
            r0.add(r1)     // Catch:{ all -> 0x0062 }
            goto L_0x006f
        L_0x0086:
            r7.d(r4)
            return r0
        L_0x008a:
            r7.d(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.O(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(long j) {
        CollectionsKt.removeAll(this.f8898a, new AcceptAllCookiesStorage$cleanup$1(j));
        long j2 = LongCompanionObject.MAX_VALUE;
        for (Cookie e : this.f8898a) {
            GMTDate e2 = e.e();
            if (e2 != null) {
                j2 = Math.min(j2, e2.d());
            }
        }
        this.oldestCookie = j2;
    }

    public void close() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: io.ktor.http.Cookie} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object o0(io.ktor.http.Url r6, io.ktor.http.Cookie r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r5 = r0.L$3
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r0.L$2
            r7 = r6
            io.ktor.http.Cookie r7 = (io.ktor.http.Cookie) r7
            java.lang.Object r6 = r0.L$1
            io.ktor.http.Url r6 = (io.ktor.http.Url) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage) r0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r5
            r5 = r0
            goto L_0x005b
        L_0x003d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r5.b
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r8
            r0.label = r3
            java.lang.Object r0 = r8.c(r4, r0)
            if (r0 != r1) goto L_0x005b
            return r1
        L_0x005b:
            java.lang.String r0 = r7.f()     // Catch:{ all -> 0x008b }
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x008d
            java.util.List r0 = r5.f8898a     // Catch:{ all -> 0x008b }
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$2$2 r1 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$2$2     // Catch:{ all -> 0x008b }
            r1.<init>(r7, r6)     // Catch:{ all -> 0x008b }
            kotlin.collections.CollectionsKt.removeAll(r0, r1)     // Catch:{ all -> 0x008b }
            java.util.List r0 = r5.f8898a     // Catch:{ all -> 0x008b }
            io.ktor.http.Cookie r6 = io.ktor.client.plugins.cookies.CookiesStorageKt.a(r7, r6)     // Catch:{ all -> 0x008b }
            r0.add(r6)     // Catch:{ all -> 0x008b }
            io.ktor.util.date.GMTDate r6 = r7.e()     // Catch:{ all -> 0x008b }
            if (r6 == 0) goto L_0x008d
            long r6 = r6.d()     // Catch:{ all -> 0x008b }
            long r0 = r5.oldestCookie     // Catch:{ all -> 0x008b }
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r5.oldestCookie = r6     // Catch:{ all -> 0x008b }
            goto L_0x008d
        L_0x008b:
            r5 = move-exception
            goto L_0x0095
        L_0x008d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008b }
            r8.d(r4)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0095:
            r8.d(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.o0(io.ktor.http.Url, io.ktor.http.Cookie, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
