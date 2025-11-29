package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00050\u000bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/paging/FlattenedPageController;", "", "T", "<init>", "()V", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "event", "", "c", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$Insert;", "a", "()Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/FlattenedPageEventStorage;", "Landroidx/paging/FlattenedPageEventStorage;", "list", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/sync/Mutex;", "lock", "", "I", "maxEventIndex", "paging-common"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCachedPageEventFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CachedPageEventFlow.kt\nandroidx/paging/FlattenedPageController\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,282:1\n107#2,10:283\n107#2,8:293\n116#2:306\n115#2:307\n1559#3:301\n1590#3,4:302\n*S KotlinDebug\n*F\n+ 1 CachedPageEventFlow.kt\nandroidx/paging/FlattenedPageController\n*L\n128#1:283,10\n138#1:293,8\n138#1:306\n138#1:307\n142#1:301\n142#1:302,4\n*E\n"})
final class FlattenedPageController<T> {

    /* renamed from: a  reason: collision with root package name */
    public final FlattenedPageEventStorage f1533a = new FlattenedPageEventStorage();
    public final Mutex b = MutexKt.b(false, 1, (Object) null);
    public int c = -1;

    public final PageEvent.Insert a() {
        PageEvent pageEvent = (PageEvent) CollectionsKt.firstOrNull(this.f1533a.b());
        if (pageEvent == null || !(pageEvent instanceof PageEvent.Insert)) {
            return null;
        }
        PageEvent.Insert insert = (PageEvent.Insert) pageEvent;
        if (insert.j() == LoadType.REFRESH) {
            return insert;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.paging.FlattenedPageController$getStateAsEvents$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.paging.FlattenedPageController$getStateAsEvents$1 r0 = (androidx.paging.FlattenedPageController$getStateAsEvents$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.FlattenedPageController$getStateAsEvents$1 r0 = new androidx.paging.FlattenedPageController$getStateAsEvents$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r0 = r0.L$0
            androidx.paging.FlattenedPageController r0 = (androidx.paging.FlattenedPageController) r0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            r7 = r0
            goto L_0x004e
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.b
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r0 = r8.c(r4, r0)
            if (r0 != r1) goto L_0x004e
            return r1
        L_0x004e:
            androidx.paging.FlattenedPageEventStorage r0 = r7.f1533a     // Catch:{ all -> 0x007e }
            java.util.List r0 = r0.b()     // Catch:{ all -> 0x007e }
            int r7 = r7.c     // Catch:{ all -> 0x007e }
            int r1 = r0.size()     // Catch:{ all -> 0x007e }
            int r7 = r7 - r1
            int r7 = r7 + r3
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x007e }
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)     // Catch:{ all -> 0x007e }
            r1.<init>(r2)     // Catch:{ all -> 0x007e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x007e }
            r2 = 0
        L_0x006c:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x007e }
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x007e }
            int r5 = r2 + 1
            if (r2 >= 0) goto L_0x0080
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ all -> 0x007e }
            goto L_0x0080
        L_0x007e:
            r7 = move-exception
            goto L_0x0091
        L_0x0080:
            androidx.paging.PageEvent r3 = (androidx.paging.PageEvent) r3     // Catch:{ all -> 0x007e }
            kotlin.collections.IndexedValue r6 = new kotlin.collections.IndexedValue     // Catch:{ all -> 0x007e }
            int r2 = r2 + r7
            r6.<init>(r2, r3)     // Catch:{ all -> 0x007e }
            r1.add(r6)     // Catch:{ all -> 0x007e }
            r2 = r5
            goto L_0x006c
        L_0x008d:
            r8.d(r4)
            return r1
        L_0x0091:
            r8.d(r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(kotlin.collections.IndexedValue r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.paging.FlattenedPageController$record$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.paging.FlattenedPageController$record$1 r0 = (androidx.paging.FlattenedPageController$record$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.FlattenedPageController$record$1 r0 = new androidx.paging.FlattenedPageController$record$1
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
            kotlin.collections.IndexedValue r6 = (kotlin.collections.IndexedValue) r6
            java.lang.Object r0 = r0.L$0
            androidx.paging.FlattenedPageController r0 = (androidx.paging.FlattenedPageController) r0
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
            int r0 = r6.getIndex()     // Catch:{ all -> 0x006d }
            r5.c = r0     // Catch:{ all -> 0x006d }
            androidx.paging.FlattenedPageEventStorage r5 = r5.f1533a     // Catch:{ all -> 0x006d }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x006d }
            androidx.paging.PageEvent r6 = (androidx.paging.PageEvent) r6     // Catch:{ all -> 0x006d }
            r5.a(r6)     // Catch:{ all -> 0x006d }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006d }
            r7.d(r4)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x006d:
            r5 = move-exception
            r7.d(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.c(kotlin.collections.IndexedValue, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
