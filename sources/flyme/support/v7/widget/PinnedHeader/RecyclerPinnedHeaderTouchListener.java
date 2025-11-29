package flyme.support.v7.widget.PinnedHeader;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import flyme.support.v7.widget.HeaderAndFooterWrapperAdapter;
import flyme.support.v7.widget.MzRecyclerView;

public class RecyclerPinnedHeaderTouchListener implements RecyclerView.OnItemTouchListener {
    /* access modifiers changed from: private */
    public final RecyclerPinnedHeaderDecoration mDecor;
    /* access modifiers changed from: private */
    public OnHeaderClickListener mOnHeaderClickListener;
    /* access modifiers changed from: private */
    public final MzRecyclerView mRecyclerView;
    private final GestureDetector mTapDetector;

    public interface OnHeaderClickListener {
        void onHeaderClick(View view, int i, long j, MotionEvent motionEvent);
    }

    public class SingleTapDetector extends GestureDetector.SimpleOnGestureListener {
        private SingleTapDetector() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            int findHeaderPositionUnder = RecyclerPinnedHeaderTouchListener.this.mDecor.findHeaderPositionUnder((int) motionEvent.getX(), (int) motionEvent.getY());
            if (findHeaderPositionUnder == -1) {
                return false;
            }
            View headerView = RecyclerPinnedHeaderTouchListener.this.mDecor.getHeaderView(RecyclerPinnedHeaderTouchListener.this.mRecyclerView, findHeaderPositionUnder);
            RecyclerPinnedHeaderTouchListener.this.mOnHeaderClickListener.onHeaderClick(headerView, findHeaderPositionUnder, RecyclerPinnedHeaderTouchListener.this.getAdapter().getHeaderId(findHeaderPositionUnder), motionEvent);
            RecyclerPinnedHeaderTouchListener.this.mRecyclerView.playSoundEffect(0);
            headerView.onTouchEvent(motionEvent);
            return true;
        }
    }

    public RecyclerPinnedHeaderTouchListener(MzRecyclerView mzRecyclerView, RecyclerPinnedHeaderDecoration recyclerPinnedHeaderDecoration) {
        this.mTapDetector = new GestureDetector(mzRecyclerView.getContext(), new SingleTapDetector());
        this.mRecyclerView = mzRecyclerView;
        this.mDecor = recyclerPinnedHeaderDecoration;
    }

    public RecyclerPinnedHeaderAdapter getAdapter() {
        if ((this.mRecyclerView.getAdapter() instanceof HeaderAndFooterWrapperAdapter) && (((HeaderAndFooterWrapperAdapter) this.mRecyclerView.getAdapter()).getWrappedAdapter() instanceof RecyclerPinnedHeaderAdapter)) {
            return (RecyclerPinnedHeaderAdapter) ((HeaderAndFooterWrapperAdapter) this.mRecyclerView.getAdapter()).getWrappedAdapter();
        }
        if (this.mRecyclerView.getAdapter() instanceof RecyclerPinnedHeaderAdapter) {
            return (RecyclerPinnedHeaderAdapter) this.mRecyclerView.getAdapter();
        }
        String str = "MzRecyclerView with " + RecyclerPinnedHeaderTouchListener.class.getSimpleName() + " requires a " + RecyclerPinnedHeaderAdapter.class.getSimpleName();
        Log.e("lijinqian", "RecyclerPinnedHeaderTouchListener IllegalStateException : " + str);
        throw new IllegalStateException(str);
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.mOnHeaderClickListener == null) {
            return false;
        }
        if (this.mTapDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        return motionEvent.getAction() == 0 && this.mDecor.findHeaderPositionUnder((int) motionEvent.getX(), (int) motionEvent.getY()) != -1;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.mOnHeaderClickListener = onHeaderClickListener;
    }
}
