package flyme.support.v7.widget.PinnedHeader;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import flyme.support.v7.widget.MzRecyclerView;
import flyme.support.v7.widget.PinnedHeader.helper.DimensionCalculator;
import flyme.support.v7.widget.PinnedHeader.helper.LinearLayoutOrientationProvider;
import flyme.support.v7.widget.PinnedHeader.helper.OrientationProvider;
import flyme.support.v7.widget.PinnedHeader.helper.PinnedHeaderProvider;
import flyme.support.v7.widget.PinnedHeader.helper.PinnedHeaderRenderer;
import flyme.support.v7.widget.PinnedHeader.helper.PinnedHeaderViewCache;

public class RecyclerPinnedHeaderDecoration extends MzRecyclerView.ItemDecoration {
    private long mCurrentHeaderId;
    private int mCurrentPosition;
    private final DimensionCalculator mDimensionCalculator;
    private final RecyclerPinnedHeaderAdapter mHeaderAdapter;
    private final PinnedHeaderPositionCalculator mHeaderPositionCalculator;
    private final PinnedHeaderProvider mHeaderProvider;
    private final SparseArray<Rect> mHeaderRects;
    private View mLastHeader;
    private long mLastHeaderId;
    private int mLastPosition;
    private OnPinnedHeaderChangeListener mOnPinnedHeaderChangeListener;
    private final OrientationProvider mOrientationProvider;
    private MzRecyclerView mRecyclerView;
    private final PinnedHeaderRenderer mRenderer;
    private final Rect mTempRect;

    public interface OnPinnedHeaderChangeListener {
        void OnPinnedHeaderChange(RecyclerView recyclerView, View view, int i, long j, View view2, int i2, long j2);
    }

    public RecyclerPinnedHeaderDecoration(RecyclerPinnedHeaderAdapter recyclerPinnedHeaderAdapter) {
        this(recyclerPinnedHeaderAdapter, new LinearLayoutOrientationProvider(), new DimensionCalculator());
    }

    private void checkIfMzRecyclerView(RecyclerView recyclerView) {
        if (!(recyclerView instanceof MzRecyclerView)) {
            String str = RecyclerPinnedHeaderDecoration.class.getSimpleName() + " only surport MzRecyclerView.";
            Log.e("lijinqian", "RecyclerPinnedHeaderDecoration IllegalStateException : " + str);
            throw new IllegalStateException(str);
        }
    }

    private void setItemOffsetsForHeader(Rect rect, View view, int i) {
        this.mDimensionCalculator.initMargins(this.mTempRect, view);
        if (i == 1) {
            int height = view.getHeight();
            Rect rect2 = this.mTempRect;
            rect.top = height + rect2.top + rect2.bottom;
            return;
        }
        int width = view.getWidth();
        Rect rect3 = this.mTempRect;
        rect.left = width + rect3.left + rect3.right;
    }

    public int findHeaderPositionUnder(int i, int i2) {
        int i3;
        MzRecyclerView mzRecyclerView = this.mRecyclerView;
        if (mzRecyclerView == null || !(mzRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            i3 = 0;
        } else {
            i3 = ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            if (i3 < 0) {
                return -1;
            }
        }
        while (i3 < this.mHeaderRects.size()) {
            SparseArray<Rect> sparseArray = this.mHeaderRects;
            if (sparseArray.get(sparseArray.keyAt(i3)).contains(i, i2)) {
                return this.mHeaderRects.keyAt(i3);
            }
            i3++;
        }
        return -1;
    }

    public RecyclerPinnedHeaderAdapter getAdapter() {
        if (this.mRecyclerView.getAdapter() instanceof RecyclerPinnedHeaderAdapter) {
            return (RecyclerPinnedHeaderAdapter) this.mRecyclerView.getAdapter();
        }
        throw new IllegalStateException("MzRecyclerView with " + RecyclerPinnedHeaderDecoration.class.getSimpleName() + " requires a " + RecyclerPinnedHeaderAdapter.class.getSimpleName());
    }

    public View getHeaderView(MzRecyclerView mzRecyclerView, int i) {
        return this.mHeaderProvider.getHeader(mzRecyclerView, i);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        checkIfMzRecyclerView(recyclerView);
        MzRecyclerView mzRecyclerView = (MzRecyclerView) recyclerView;
        int childAdapterPosition = mzRecyclerView.getChildAdapterPosition(view) - mzRecyclerView.getHeaderViewsCount();
        if (childAdapterPosition != -1 && this.mHeaderPositionCalculator.hasNewHeader(childAdapterPosition, this.mOrientationProvider.isReverseLayout(mzRecyclerView))) {
            setItemOffsetsForHeader(rect, getHeaderView(mzRecyclerView, childAdapterPosition), this.mOrientationProvider.getOrientation(mzRecyclerView));
        }
    }

    public LinearLayoutManager getLinearLayoutManager() {
        if (this.mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            return (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        }
        throw new IllegalStateException("MzRecyclerView with " + RecyclerPinnedHeaderDecoration.class.getSimpleName() + " requires a " + LinearLayoutManager.class.getSimpleName());
    }

    public void invalidateHeaders() {
        this.mHeaderProvider.invalidate();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDrawUnderForeground(android.graphics.Canvas r20, androidx.recyclerview.widget.RecyclerView r21, androidx.recyclerview.widget.RecyclerView.State r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            super.onDrawUnderForeground(r20, r21, r22)
            r11 = r1
            flyme.support.v7.widget.MzRecyclerView r11 = (flyme.support.v7.widget.MzRecyclerView) r11
            r0.mRecyclerView = r11
            r0.checkIfMzRecyclerView(r1)
            int r12 = r11.getChildCount()
            if (r12 <= 0) goto L_0x00e0
            flyme.support.v7.widget.PinnedHeader.RecyclerPinnedHeaderAdapter r1 = r0.mHeaderAdapter
            int r1 = r1.getItemCount()
            if (r1 > 0) goto L_0x001f
            goto L_0x00e0
        L_0x001f:
            r1 = 0
            r13 = r1
        L_0x0021:
            if (r13 >= r12) goto L_0x00e0
            android.view.View r14 = r11.getChildAt(r13)
            int r1 = r11.getChildAdapterPosition(r14)
            flyme.support.v7.widget.MzRecyclerView r2 = r0.mRecyclerView
            int r2 = r2.getHeaderViewsCount()
            int r15 = r1 - r2
            r1 = -1
            if (r15 != r1) goto L_0x003a
        L_0x0036:
            r2 = r20
            goto L_0x00dc
        L_0x003a:
            flyme.support.v7.widget.PinnedHeader.PinnedHeaderPositionCalculator r1 = r0.mHeaderPositionCalculator
            flyme.support.v7.widget.PinnedHeader.helper.OrientationProvider r2 = r0.mOrientationProvider
            int r2 = r2.getOrientation(r11)
            boolean r16 = r1.hasPinnedHeader(r14, r2, r15)
            if (r16 != 0) goto L_0x0056
            flyme.support.v7.widget.PinnedHeader.PinnedHeaderPositionCalculator r1 = r0.mHeaderPositionCalculator
            flyme.support.v7.widget.PinnedHeader.helper.OrientationProvider r2 = r0.mOrientationProvider
            boolean r2 = r2.isReverseLayout(r11)
            boolean r1 = r1.hasNewHeader(r15, r2)
            if (r1 == 0) goto L_0x0036
        L_0x0056:
            flyme.support.v7.widget.PinnedHeader.helper.PinnedHeaderProvider r1 = r0.mHeaderProvider
            android.view.View r9 = r1.getHeader(r11, r15)
            flyme.support.v7.widget.PinnedHeader.RecyclerPinnedHeaderDecoration$OnPinnedHeaderChangeListener r1 = r0.mOnPinnedHeaderChangeListener
            if (r1 == 0) goto L_0x00b0
            androidx.recyclerview.widget.LinearLayoutManager r1 = r19.getLinearLayoutManager()
            int r1 = r1.findFirstVisibleItemPosition()
            r0.mCurrentPosition = r1
            flyme.support.v7.widget.PinnedHeader.RecyclerPinnedHeaderAdapter r1 = r19.getAdapter()
            int r2 = r0.mCurrentPosition
            long r1 = r1.getHeaderId(r2)
            r0.mCurrentHeaderId = r1
            flyme.support.v7.widget.PinnedHeader.RecyclerPinnedHeaderAdapter r1 = r19.getAdapter()
            int r2 = r0.mLastPosition
            long r1 = r1.getHeaderId(r2)
            r0.mLastHeaderId = r1
            flyme.support.v7.widget.PinnedHeader.helper.PinnedHeaderProvider r1 = r0.mHeaderProvider
            int r2 = r0.mLastPosition
            android.view.View r7 = r1.getHeader(r11, r2)
            r0.mLastHeader = r7
            long r5 = r0.mCurrentHeaderId
            long r3 = r0.mLastHeaderId
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00b0
            flyme.support.v7.widget.PinnedHeader.RecyclerPinnedHeaderDecoration$OnPinnedHeaderChangeListener r1 = r0.mOnPinnedHeaderChangeListener
            int r8 = r0.mCurrentPosition
            int r10 = r0.mLastPosition
            r2 = r11
            r17 = r3
            r3 = r9
            r4 = r8
            r8 = r10
            r21 = r9
            r9 = r17
            r1.OnPinnedHeaderChange(r2, r3, r4, r5, r7, r8, r9)
            long r1 = r0.mCurrentHeaderId
            r0.mLastHeaderId = r1
            int r1 = r0.mCurrentPosition
            r0.mLastPosition = r1
            goto L_0x00b2
        L_0x00b0:
            r21 = r9
        L_0x00b2:
            android.util.SparseArray<android.graphics.Rect> r1 = r0.mHeaderRects
            java.lang.Object r1 = r1.get(r15)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            if (r1 != 0) goto L_0x00c6
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            android.util.SparseArray<android.graphics.Rect> r2 = r0.mHeaderRects
            r2.put(r15, r1)
        L_0x00c6:
            r7 = r1
            flyme.support.v7.widget.PinnedHeader.PinnedHeaderPositionCalculator r1 = r0.mHeaderPositionCalculator
            r2 = r7
            r3 = r11
            r4 = r21
            r5 = r14
            r6 = r16
            r1.initHeaderBounds(r2, r3, r4, r5, r6)
            flyme.support.v7.widget.PinnedHeader.helper.PinnedHeaderRenderer r1 = r0.mRenderer
            r2 = r20
            r3 = r21
            r1.drawHeader(r11, r2, r3, r7)
        L_0x00dc:
            int r13 = r13 + 1
            goto L_0x0021
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.PinnedHeader.RecyclerPinnedHeaderDecoration.onDrawUnderForeground(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public void setPinnedHeaderListener(OnPinnedHeaderChangeListener onPinnedHeaderChangeListener) {
        this.mOnPinnedHeaderChangeListener = onPinnedHeaderChangeListener;
    }

    private RecyclerPinnedHeaderDecoration(RecyclerPinnedHeaderAdapter recyclerPinnedHeaderAdapter, OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator) {
        this(recyclerPinnedHeaderAdapter, orientationProvider, dimensionCalculator, new PinnedHeaderRenderer(orientationProvider), new PinnedHeaderViewCache(recyclerPinnedHeaderAdapter, orientationProvider));
    }

    private RecyclerPinnedHeaderDecoration(RecyclerPinnedHeaderAdapter recyclerPinnedHeaderAdapter, OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator, PinnedHeaderRenderer pinnedHeaderRenderer, PinnedHeaderProvider pinnedHeaderProvider) {
        this(recyclerPinnedHeaderAdapter, pinnedHeaderRenderer, orientationProvider, dimensionCalculator, pinnedHeaderProvider, new PinnedHeaderPositionCalculator(recyclerPinnedHeaderAdapter, pinnedHeaderProvider, orientationProvider, dimensionCalculator));
    }

    private RecyclerPinnedHeaderDecoration(RecyclerPinnedHeaderAdapter recyclerPinnedHeaderAdapter, PinnedHeaderRenderer pinnedHeaderRenderer, OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator, PinnedHeaderProvider pinnedHeaderProvider, PinnedHeaderPositionCalculator pinnedHeaderPositionCalculator) {
        this.mHeaderRects = new SparseArray<>();
        this.mTempRect = new Rect();
        this.mLastHeaderId = -2147483648L;
        this.mHeaderAdapter = recyclerPinnedHeaderAdapter;
        this.mHeaderProvider = pinnedHeaderProvider;
        this.mOrientationProvider = orientationProvider;
        this.mRenderer = pinnedHeaderRenderer;
        this.mDimensionCalculator = dimensionCalculator;
        this.mHeaderPositionCalculator = pinnedHeaderPositionCalculator;
        this.mLastPosition = 0;
    }
}
