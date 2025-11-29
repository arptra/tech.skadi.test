package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nAsyncPagedListDiffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncPagedListDiffer.kt\nandroidx/paging/AsyncPagedListDiffer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,594:1\n1855#2,2:595\n*S KotlinDebug\n*F\n+ 1 AsyncPagedListDiffer.kt\nandroidx/paging/AsyncPagedListDiffer\n*L\n505#1:595,2\n*E\n"})
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\"#R\"\u0010\n\u001a\u00020\u00038\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\u0011\u0010\r\u0012\u0004\b\u0012\u0010\u000fR2\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00150\u00148\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u0011\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u001dR\"\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b8VX\u0004¢\u0006\f\u0012\u0004\b \u0010\u000f\u001a\u0004\b\u0004\u0010\u001f¨\u0006$"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer;", "", "T", "Landroidx/recyclerview/widget/ListUpdateCallback;", "a", "Landroidx/recyclerview/widget/ListUpdateCallback;", "d", "()Landroidx/recyclerview/widget/ListUpdateCallback;", "setUpdateCallback$paging_runtime_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;)V", "updateCallback", "Landroidx/paging/PagedList;", "b", "Landroidx/paging/PagedList;", "getPagedList$annotations", "()V", "pagedList", "c", "getSnapshot$annotations", "snapshot", "", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "", "Ljava/util/List;", "()Ljava/util/List;", "loadStateListeners", "", "()I", "itemCount", "()Landroidx/paging/PagedList;", "getCurrentList$annotations", "currentList", "OnCurrentListChangedWrapper", "PagedListListener", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "AsyncPagedListDiffer is deprecated and has been replaced by AsyncPagingDataDiffer", replaceWith = @ReplaceWith(expression = "AsyncPagingDataDiffer<T>", imports = {"androidx.paging.AsyncPagingDataDiffer"}))
public class AsyncPagedListDiffer<T> {

    /* renamed from: a  reason: collision with root package name */
    public ListUpdateCallback f1513a;
    public PagedList b;
    public PagedList c;
    public final List d;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003R9\u0010\n\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$OnCurrentListChangedWrapper;", "", "T", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "Lkotlin/Function2;", "Landroidx/paging/PagedList;", "", "a", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "callback", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class OnCurrentListChangedWrapper<T> implements PagedListListener<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Function2 f1514a;

        public final Function2 a() {
            return this.f1514a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0001ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "", "T", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
    public interface PagedListListener<T> {
    }

    public PagedList a() {
        PagedList pagedList = this.c;
        return pagedList == null ? this.b : pagedList;
    }

    public int b() {
        PagedList a2 = a();
        if (a2 != null) {
            return a2.size();
        }
        return 0;
    }

    public final List c() {
        return this.d;
    }

    public final ListUpdateCallback d() {
        ListUpdateCallback listUpdateCallback = this.f1513a;
        if (listUpdateCallback != null) {
            return listUpdateCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateCallback");
        return null;
    }
}
