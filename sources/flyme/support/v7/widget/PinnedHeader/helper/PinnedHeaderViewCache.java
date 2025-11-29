package flyme.support.v7.widget.PinnedHeader.helper;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
import flyme.support.v7.widget.MzRecyclerView;
import flyme.support.v7.widget.PinnedHeader.RecyclerPinnedHeaderAdapter;

public class PinnedHeaderViewCache implements PinnedHeaderProvider {
    private final RecyclerPinnedHeaderAdapter mHeaderAdapter;
    private final LongSparseArray<View> mHeaderViews = new LongSparseArray<>();
    private final OrientationProvider mOrientationProvider;

    public PinnedHeaderViewCache(RecyclerPinnedHeaderAdapter recyclerPinnedHeaderAdapter, OrientationProvider orientationProvider) {
        this.mHeaderAdapter = recyclerPinnedHeaderAdapter;
        this.mOrientationProvider = orientationProvider;
    }

    public View getHeader(MzRecyclerView mzRecyclerView, int i) {
        int i2;
        int i3;
        long headerId = this.mHeaderAdapter.getHeaderId(i);
        View view = this.mHeaderViews.get(headerId);
        if (view == null) {
            RecyclerView.ViewHolder onCreateHeaderViewHolder = this.mHeaderAdapter.onCreateHeaderViewHolder(mzRecyclerView);
            this.mHeaderAdapter.onBindHeaderViewHolder(onCreateHeaderViewHolder, i);
            view = onCreateHeaderViewHolder.itemView;
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            if (this.mOrientationProvider.getOrientation(mzRecyclerView) == 1) {
                i2 = View.MeasureSpec.makeMeasureSpec(mzRecyclerView.getWidth(), 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec(mzRecyclerView.getHeight(), 0);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(mzRecyclerView.getWidth(), 0);
                i3 = View.MeasureSpec.makeMeasureSpec(mzRecyclerView.getHeight(), 1073741824);
            }
            view.measure(ViewGroup.getChildMeasureSpec(i2, mzRecyclerView.getPaddingLeft() + mzRecyclerView.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(i3, mzRecyclerView.getPaddingTop() + mzRecyclerView.getPaddingBottom(), view.getLayoutParams().height));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            this.mHeaderViews.put(headerId, view);
        }
        return view;
    }

    public void invalidate() {
        this.mHeaderViews.clear();
    }
}
