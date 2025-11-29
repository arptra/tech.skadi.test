package com.airbnb.epoxy.preload;

import com.airbnb.epoxy.preload.PreloadRequestHolder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/airbnb/epoxy/preload/PreloadTargetProvider;", "Lcom/airbnb/epoxy/preload/PreloadRequestHolder;", "P", "", "", "maxPreload", "Lkotlin/Function0;", "requestHolderFactory", "<init>", "(ILkotlin/jvm/functions/Function0;)V", "b", "()Lcom/airbnb/epoxy/preload/PreloadRequestHolder;", "", "a", "()V", "Ljava/util/ArrayDeque;", "Ljava/util/ArrayDeque;", "queue", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPreloadTargetProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreloadTargetProvider.kt\ncom/airbnb/epoxy/preload/PreloadTargetProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n1549#2:38\n1620#2,3:39\n1855#2,2:42\n*S KotlinDebug\n*F\n+ 1 PreloadTargetProvider.kt\ncom/airbnb/epoxy/preload/PreloadTargetProvider\n*L\n9#1:38\n9#1:39,3\n19#1:42,2\n*E\n"})
public final class PreloadTargetProvider<P extends PreloadRequestHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f2327a;

    public PreloadTargetProvider(int i, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "requestHolderFactory");
        IntRange until = RangesKt.until(0, i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add((PreloadRequestHolder) function0.invoke());
        }
        this.f2327a = new ArrayDeque(arrayList);
    }

    public final void a() {
        for (PreloadRequestHolder clear : this.f2327a) {
            clear.clear();
        }
    }

    public final PreloadRequestHolder b() {
        PreloadRequestHolder preloadRequestHolder = (PreloadRequestHolder) this.f2327a.poll();
        this.f2327a.offer(preloadRequestHolder);
        preloadRequestHolder.clear();
        Intrinsics.checkNotNullExpressionValue(preloadRequestHolder, "result");
        return preloadRequestHolder;
    }
}
