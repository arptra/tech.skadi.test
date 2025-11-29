package androidx.paging;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR2\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u000b8\u0000X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Landroidx/paging/InvalidatingPagingSourceFactory;", "", "Key", "Value", "Landroidx/paging/PagingSourceFactory;", "Landroidx/paging/PagingSource;", "a", "()Landroidx/paging/PagingSource;", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "pagingSourceFactory", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getPagingSources$paging_common", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getPagingSources$paging_common$annotations", "()V", "pagingSources", "paging-common"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nInvalidatingPagingSourceFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidatingPagingSourceFactory.kt\nandroidx/paging/InvalidatingPagingSourceFactory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
public final class InvalidatingPagingSourceFactory<Key, Value> implements PagingSourceFactory<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    public final Function0 f1544a;
    public final CopyOnWriteArrayList b;

    /* renamed from: a */
    public PagingSource invoke() {
        PagingSource pagingSource = (PagingSource) this.f1544a.invoke();
        this.b.add(pagingSource);
        return pagingSource;
    }
}
