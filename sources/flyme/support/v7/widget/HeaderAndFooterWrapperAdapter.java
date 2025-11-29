package flyme.support.v7.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import flyme.support.v7.widget.MzRecyclerView;
import java.util.List;

public class HeaderAndFooterWrapperAdapter<T> extends MzRecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int BASE_ITEM_TYPE_FOOTER = 200000;
    private static final int BASE_ITEM_TYPE_HEADER = 100000;
    private static final String TAG = "HeaderFooterAdapter";
    private static int mFooterIndex = 200000;
    private static int mHeadIndex = 100000;
    private final RecyclerView.AdapterDataObserver mDataObserver = new RecyclerView.AdapterDataObserver() {
        public void onChanged() {
            if (HeaderAndFooterWrapperAdapter.this.mInnerAdapter != null) {
                HeaderAndFooterWrapperAdapter.this.mInnerAdapter.notifyDataSetChanged();
            }
        }

        public void onItemRangeChanged(int i, int i2) {
            if (HeaderAndFooterWrapperAdapter.this.mInnerAdapter != null) {
                HeaderAndFooterWrapperAdapter.this.mInnerAdapter.notifyItemRangeChanged(i, i2);
            }
        }

        public void onItemRangeInserted(int i, int i2) {
            if (HeaderAndFooterWrapperAdapter.this.mInnerAdapter != null) {
                HeaderAndFooterWrapperAdapter.this.mInnerAdapter.notifyItemRangeInserted(i, i2);
            }
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            if (HeaderAndFooterWrapperAdapter.this.mInnerAdapter != null) {
                HeaderAndFooterWrapperAdapter.this.mInnerAdapter.notifyItemMoved(i, i2);
            }
        }

        public void onItemRangeRemoved(int i, int i2) {
            if (HeaderAndFooterWrapperAdapter.this.mInnerAdapter != null) {
                HeaderAndFooterWrapperAdapter.this.mInnerAdapter.notifyItemRangeRemoved(i, i2);
            }
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            if (HeaderAndFooterWrapperAdapter.this.mInnerAdapter != null) {
                HeaderAndFooterWrapperAdapter.this.mInnerAdapter.notifyItemRangeChanged(i, i2, obj);
            }
        }
    };
    /* access modifiers changed from: private */
    public SparseArrayCompat<MzRecyclerView.FixedViewInfo> mFooterViews = new SparseArrayCompat<>();
    /* access modifiers changed from: private */
    public SparseArrayCompat<MzRecyclerView.FixedViewInfo> mHeaderViews = new SparseArrayCompat<>();
    /* access modifiers changed from: private */
    public MzRecyclerView.Adapter mInnerAdapter;

    public HeaderAndFooterWrapperAdapter(RecyclerView.Adapter adapter) {
        MzRecyclerView.Adapter adapter2 = (MzRecyclerView.Adapter) adapter;
        this.mInnerAdapter = adapter2;
        setHasStableIds(adapter2.hasStableIds());
    }

    private int getRealItemCount() {
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    private boolean isFooterViewPos(int i) {
        if (i < getItemCount()) {
            return i >= getHeadersCount() + getRealItemCount();
        }
        Log.e(TAG, "HeaderAndFooterWrapperAdapter isFooterViewPos : current index is " + i + ", but total itemcount is " + getItemCount() + ", headers:" + getHeadersCount() + ", items:" + getRealItemCount() + ", footers:" + getFootersCount());
        return false;
    }

    private boolean isHeaderViewPos(int i) {
        return i < getHeadersCount();
    }

    public void addFooterView(MzRecyclerView.FixedViewInfo fixedViewInfo) {
        SparseArrayCompat<MzRecyclerView.FixedViewInfo> sparseArrayCompat = this.mFooterViews;
        int i = mFooterIndex;
        mFooterIndex = i + 1;
        sparseArrayCompat.m(i, fixedViewInfo);
    }

    public void addHeaderView(MzRecyclerView.FixedViewInfo fixedViewInfo) {
        SparseArrayCompat<MzRecyclerView.FixedViewInfo> sparseArrayCompat = this.mHeaderViews;
        int i = mHeadIndex;
        mHeadIndex = i + 1;
        sparseArrayCompat.m(i, fixedViewInfo);
    }

    public boolean areAllItemsEnabled() {
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        return adapter != null ? adapter.areAllItemsEnabled() : super.areAllItemsEnabled();
    }

    public int getFootersCount() {
        return this.mFooterViews.p();
    }

    public int getHeadersCount() {
        return this.mHeaderViews.p();
    }

    public int getItemCount() {
        return getHeadersCount() + getFootersCount() + getRealItemCount();
    }

    public long getItemId(int i) {
        int i2;
        if (isHeaderViewPos(i)) {
            return (long) this.mHeaderViews.l(i);
        }
        if (isFooterViewPos(i)) {
            return (long) this.mFooterViews.l((i - getHeadersCount()) - getRealItemCount());
        }
        int headersCount = getHeadersCount();
        if (this.mInnerAdapter == null || i < headersCount || (i2 = i - headersCount) >= getRealItemCount()) {
            return -1;
        }
        return this.mInnerAdapter.getItemId(i2);
    }

    public int getItemViewType(int i) {
        if (isHeaderViewPos(i)) {
            return this.mHeaderViews.l(i);
        }
        if (isFooterViewPos(i)) {
            return this.mFooterViews.l((i - getHeadersCount()) - getRealItemCount());
        }
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        if (adapter == null) {
            return -2;
        }
        adapter.setHeadCount(getHeadersCount());
        return this.mInnerAdapter.getItemViewType(i - getHeadersCount());
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.mInnerAdapter;
    }

    public boolean isEnabled(int i) {
        int i2;
        MzRecyclerView.FixedViewInfo fixedViewInfo;
        int headersCount = getHeadersCount();
        if (i < 0 || i >= headersCount) {
            int i3 = i - headersCount;
            if (this.mInnerAdapter == null || i < headersCount) {
                i2 = 0;
            } else {
                i2 = getRealItemCount();
                if (i3 < i2) {
                    return this.mInnerAdapter.isEnabled(i3);
                }
            }
            int i4 = i3 - i2;
            if (i4 < 0 || i4 >= getFootersCount() || (fixedViewInfo = (MzRecyclerView.FixedViewInfo) this.mFooterViews.q(i4)) == null) {
                return false;
            }
            return fixedViewInfo.isSelectable;
        }
        MzRecyclerView.FixedViewInfo fixedViewInfo2 = (MzRecyclerView.FixedViewInfo) this.mHeaderViews.q(i);
        if (fixedViewInfo2 != null) {
            return fixedViewInfo2.isSelectable;
        }
        return false;
    }

    public boolean isSelectable(int i) {
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return false;
        }
        int i2 = i - headersCount;
        if (this.mInnerAdapter == null || i < headersCount || i2 >= getRealItemCount()) {
            return false;
        }
        return this.mInnerAdapter.isSelectable(i2);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        if (adapter != null) {
            adapter.onAttachedToRecyclerView(recyclerView);
        }
        setHeaderAndFooterSpanForGridLayoutManager(recyclerView);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MzRecyclerView.Adapter adapter;
        if (!isHeaderViewPos(i) && !isFooterViewPos(i) && (adapter = this.mInnerAdapter) != null) {
            adapter.onBindViewHolder(viewHolder, i - getHeadersCount());
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mHeaderViews.g(i) != null) {
            return ((MzRecyclerView.FixedViewInfo) this.mHeaderViews.g(i)).viewHolder;
        }
        if (this.mFooterViews.g(i) != null) {
            return ((MzRecyclerView.FixedViewInfo) this.mFooterViews.g(i)).viewHolder;
        }
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        if (adapter != null) {
            return adapter.onCreateViewHolder(viewGroup, i);
        }
        return null;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        if (adapter != null) {
            adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        return adapter != null ? adapter.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams;
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        if (adapter != null) {
            adapter.onViewAttachedToWindow(viewHolder);
        }
        int layoutPosition = viewHolder.getLayoutPosition();
        if ((isHeaderViewPos(layoutPosition) || isFooterViewPos(layoutPosition)) && (layoutParams = viewHolder.itemView.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        if (adapter != null) {
            adapter.onViewDetachedFromWindow(viewHolder);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        MzRecyclerView.Adapter adapter = this.mInnerAdapter;
        if (adapter != null) {
            adapter.onViewRecycled(viewHolder);
        }
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.mInnerAdapter.registerAdapterDataObserver(adapterDataObserver);
        super.registerAdapterDataObserver(this.mDataObserver);
    }

    public boolean removeFooterView(MzRecyclerView.FixedViewInfo fixedViewInfo) {
        if (fixedViewInfo != null && this.mFooterViews.p() > 0) {
            for (int i = 0; i < this.mFooterViews.p(); i++) {
                if (fixedViewInfo == ((MzRecyclerView.FixedViewInfo) this.mFooterViews.q(i))) {
                    this.mFooterViews.n(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeHeaderView(MzRecyclerView.FixedViewInfo fixedViewInfo) {
        if (fixedViewInfo != null && this.mHeaderViews.p() > 0) {
            for (int i = 0; i < this.mHeaderViews.p(); i++) {
                if (fixedViewInfo == ((MzRecyclerView.FixedViewInfo) this.mHeaderViews.q(i))) {
                    this.mHeaderViews.n(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void setHeaderAndFooterSpanForGridLayoutManager(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                public int getSpanSize(int i) {
                    int itemViewType = HeaderAndFooterWrapperAdapter.this.getItemViewType(i);
                    if (HeaderAndFooterWrapperAdapter.this.mHeaderViews.g(itemViewType) != null) {
                        return gridLayoutManager.getSpanCount();
                    }
                    if (HeaderAndFooterWrapperAdapter.this.mFooterViews.g(itemViewType) != null) {
                        return gridLayoutManager.getSpanCount();
                    }
                    GridLayoutManager.SpanSizeLookup spanSizeLookup = spanSizeLookup;
                    if (spanSizeLookup != null) {
                        return spanSizeLookup.getSpanSize(i);
                    }
                    return 1;
                }
            });
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.mInnerAdapter.unregisterAdapterDataObserver(adapterDataObserver);
        super.unregisterAdapterDataObserver(this.mDataObserver);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List list) {
        MzRecyclerView.Adapter adapter;
        if (!isHeaderViewPos(i) && !isFooterViewPos(i) && (adapter = this.mInnerAdapter) != null) {
            adapter.onBindViewHolder(viewHolder, i - getHeadersCount(), list);
        }
    }
}
