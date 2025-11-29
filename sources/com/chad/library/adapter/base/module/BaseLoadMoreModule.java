package com.chad.library.adapter.base.module;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.LoadMoreListenerImp;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\bJ\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020$8\u0006@BX\u000e¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R$\u0010,\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010\u0019R\"\u00104\u001a\u00020-8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00108\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\"\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u00107R\"\u00109\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u0010\"\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u00107R\"\u0010;\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u00107R*\u0010B\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00108\u0006@FX\u000e¢\u0006\u0012\n\u0004\b0\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010\u001cR*\u0010D\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\bC\u0010\"\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u00107R\u001c\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010FR\u0011\u0010G\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bC\u0010@¨\u0006H"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "Lcom/chad/library/adapter/base/listener/LoadMoreListenerImp;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "baseQuickAdapter", "<init>", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "", "m", "()V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "llm", "", "n", "(Landroidx/recyclerview/widget/LinearLayoutManager;)Z", "", "numbers", "", "k", "([I)I", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "viewHolder", "p", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "o", "l", "()Z", "position", "f", "(I)V", "Lcom/chad/library/adapter/base/listener/OnLoadMoreListener;", "a", "Lcom/chad/library/adapter/base/listener/OnLoadMoreListener;", "mLoadMoreListener", "b", "Z", "mNextLoadEnable", "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "<set-?>", "c", "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "h", "()Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "loadMoreStatus", "d", "isLoadEndMoreGone", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "e", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "i", "()Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "setLoadMoreView", "(Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;)V", "loadMoreView", "g", "setEnableLoadMoreEndClick", "(Z)V", "enableLoadMoreEndClick", "isAutoLoadMore", "setAutoLoadMore", "isEnableLoadMoreIfNotFullPage", "setEnableLoadMoreIfNotFullPage", "value", "I", "getPreLoadNumber", "()I", "setPreLoadNumber", "preLoadNumber", "j", "isEnableLoadMore", "setEnableLoadMore", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "loadMoreViewPosition", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public class BaseLoadMoreModule implements LoadMoreListenerImp {

    /* renamed from: a  reason: collision with root package name */
    public OnLoadMoreListener f2796a;
    public boolean b = true;
    public LoadMoreStatus c = LoadMoreStatus.Complete;
    public boolean d;
    public BaseLoadMoreView e = LoadMoreModuleConfig.a();
    public boolean f;
    public boolean g = true;
    public boolean h = true;
    public int i = 1;
    public boolean j;
    public final BaseQuickAdapter k;

    public BaseLoadMoreModule(BaseQuickAdapter baseQuickAdapter) {
        this.k = baseQuickAdapter;
    }

    public final void f(int i2) {
        LoadMoreStatus loadMoreStatus;
        if (this.g && l() && i2 >= this.k.getItemCount() - this.i && (loadMoreStatus = this.c) == LoadMoreStatus.Complete && loadMoreStatus != LoadMoreStatus.Loading && this.b) {
            m();
        }
    }

    public final boolean g() {
        return this.f;
    }

    public final LoadMoreStatus h() {
        return this.c;
    }

    public final BaseLoadMoreView i() {
        return this.e;
    }

    public final int j() {
        if (this.k.X()) {
            return -1;
        }
        BaseQuickAdapter baseQuickAdapter = this.k;
        return baseQuickAdapter.M() + baseQuickAdapter.getData().size() + baseQuickAdapter.K();
    }

    public final int k(int[] iArr) {
        int i2 = -1;
        if (!(iArr == null || iArr.length == 0)) {
            for (int i3 : iArr) {
                if (i3 > i2) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    public final boolean l() {
        if (this.f2796a == null || !this.j) {
            return false;
        }
        if (this.c != LoadMoreStatus.End || !this.d) {
            return !this.k.getData().isEmpty();
        }
        return false;
    }

    public final void m() {
        this.c = LoadMoreStatus.Loading;
        RecyclerView S = this.k.S();
        if (S != null) {
            S.post(new BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1(this));
            return;
        }
        OnLoadMoreListener onLoadMoreListener = this.f2796a;
        if (onLoadMoreListener != null) {
            onLoadMoreListener.a();
        }
    }

    public final boolean n(LinearLayoutManager linearLayoutManager) {
        return (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == this.k.getItemCount() && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) ? false : true;
    }

    public final void o() {
        LoadMoreStatus loadMoreStatus = this.c;
        LoadMoreStatus loadMoreStatus2 = LoadMoreStatus.Loading;
        if (loadMoreStatus != loadMoreStatus2) {
            this.c = loadMoreStatus2;
            this.k.notifyItemChanged(j());
            m();
        }
    }

    public final void p(BaseViewHolder baseViewHolder) {
        baseViewHolder.itemView.setOnClickListener(new BaseLoadMoreModule$setupViewHolder$1(this));
    }
}
