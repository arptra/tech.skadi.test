package flyme.support.v7.widget.PinnedHeader;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import flyme.support.v7.widget.MzRecyclerView;
import flyme.support.v7.widget.PinnedHeader.helper.DimensionCalculator;
import flyme.support.v7.widget.PinnedHeader.helper.OrientationProvider;
import flyme.support.v7.widget.PinnedHeader.helper.PinnedHeaderProvider;

public class PinnedHeaderPositionCalculator {
    private final DimensionCalculator mDimensionCalculator;
    private final RecyclerPinnedHeaderAdapter mHeaderAdapter;
    private final PinnedHeaderProvider mHeaderProvider;
    private final OrientationProvider mOrientationProvider;
    private final Rect mTempRect1 = new Rect();
    private final Rect mTempRect2 = new Rect();

    public PinnedHeaderPositionCalculator(RecyclerPinnedHeaderAdapter recyclerPinnedHeaderAdapter, PinnedHeaderProvider pinnedHeaderProvider, OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator) {
        this.mHeaderAdapter = recyclerPinnedHeaderAdapter;
        this.mHeaderProvider = pinnedHeaderProvider;
        this.mOrientationProvider = orientationProvider;
        this.mDimensionCalculator = dimensionCalculator;
    }

    private View getFirstViewUnobscuredByHeader(MzRecyclerView mzRecyclerView, View view) {
        boolean isReverseLayout = this.mOrientationProvider.isReverseLayout(mzRecyclerView);
        int i = isReverseLayout ? -1 : 1;
        int childCount = isReverseLayout ? mzRecyclerView.getChildCount() - 1 : 0;
        while (childCount >= 0 && childCount <= mzRecyclerView.getChildCount() - 1) {
            View childAt = mzRecyclerView.getChildAt(childCount);
            if (!itemIsObscuredByHeader(mzRecyclerView, childAt, view, this.mOrientationProvider.getOrientation(mzRecyclerView))) {
                return childAt;
            }
            childCount += i;
        }
        return null;
    }

    private int getListLeft(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    private int getListTop(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    private boolean indexOutOfBounds(int i) {
        return i < 0 || i >= this.mHeaderAdapter.getItemCount();
    }

    private void initDefaultHeaderOffset(Rect rect, RecyclerView recyclerView, View view, View view2, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        this.mDimensionCalculator.initMargins(this.mTempRect1, view);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i2 = marginLayoutParams.leftMargin;
            i3 = marginLayoutParams.topMargin;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i == 1) {
            i4 = (view2.getLeft() - i2) + this.mTempRect1.left;
            i5 = Math.max(((view2.getTop() - i3) - view.getHeight()) - this.mTempRect1.bottom, getListTop(recyclerView) + this.mTempRect1.top);
        } else {
            int top2 = (view2.getTop() - i3) + this.mTempRect1.top;
            i4 = Math.max(((view2.getLeft() - i2) - view.getWidth()) - this.mTempRect1.right, getListLeft(recyclerView) + this.mTempRect1.left);
            i5 = top2;
        }
        rect.set(i4, i5, view.getWidth() + i4, view.getHeight() + i5);
    }

    private boolean isStickyHeaderBeingPushedOffscreen(MzRecyclerView mzRecyclerView, View view) {
        View firstViewUnobscuredByHeader = getFirstViewUnobscuredByHeader(mzRecyclerView, view);
        int childAdapterPosition = mzRecyclerView.getChildAdapterPosition(firstViewUnobscuredByHeader) - mzRecyclerView.getHeaderViewsCount();
        if (childAdapterPosition == -1) {
            return false;
        }
        boolean isReverseLayout = this.mOrientationProvider.isReverseLayout(mzRecyclerView);
        if (childAdapterPosition <= 0 || !hasNewHeader(childAdapterPosition, isReverseLayout)) {
            return false;
        }
        View header = this.mHeaderProvider.getHeader(mzRecyclerView, childAdapterPosition);
        this.mDimensionCalculator.initMargins(this.mTempRect1, header);
        this.mDimensionCalculator.initMargins(this.mTempRect2, view);
        if (this.mOrientationProvider.getOrientation(mzRecyclerView) == 1) {
            int top2 = ((firstViewUnobscuredByHeader.getTop() - this.mTempRect1.bottom) - header.getHeight()) - this.mTempRect1.top;
            Rect rect = this.mTempRect2;
            return top2 < ((mzRecyclerView.getPaddingTop() + view.getBottom()) + rect.top) + rect.bottom;
        }
        int left = ((firstViewUnobscuredByHeader.getLeft() - this.mTempRect1.right) - header.getWidth()) - this.mTempRect1.left;
        Rect rect2 = this.mTempRect2;
        return left < ((mzRecyclerView.getPaddingLeft() + view.getRight()) + rect2.left) + rect2.right;
    }

    private boolean itemIsObscuredByHeader(MzRecyclerView mzRecyclerView, View view, View view2, int i) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        this.mDimensionCalculator.initMargins(this.mTempRect1, view2);
        int childAdapterPosition = mzRecyclerView.getChildAdapterPosition(view) - mzRecyclerView.getHeaderViewsCount();
        if (childAdapterPosition == -1 || this.mHeaderProvider.getHeader(mzRecyclerView, childAdapterPosition) != view2) {
            return false;
        }
        if (i == 1) {
            int top2 = view.getTop() - layoutParams.topMargin;
            int bottom = view2.getBottom();
            Rect rect = this.mTempRect1;
            return top2 <= (bottom + rect.bottom) + rect.top;
        }
        int left = view.getLeft() - layoutParams.leftMargin;
        int right = view2.getRight();
        Rect rect2 = this.mTempRect1;
        return left <= (right + rect2.right) + rect2.left;
    }

    private void translateHeaderWithNextHeader(MzRecyclerView mzRecyclerView, int i, Rect rect, View view, View view2, View view3) {
        this.mDimensionCalculator.initMargins(this.mTempRect1, view3);
        this.mDimensionCalculator.initMargins(this.mTempRect2, view);
        if (i == 1) {
            int listTop = getListTop(mzRecyclerView);
            Rect rect2 = this.mTempRect2;
            int i2 = listTop + rect2.top + rect2.bottom;
            Rect rect3 = this.mTempRect1;
            int top2 = ((((view2.getTop() - view3.getHeight()) - rect3.bottom) - rect3.top) - view.getHeight()) - i2;
            if (top2 < i2) {
                rect.top += top2;
                rect.bottom += top2;
                return;
            }
            return;
        }
        int listLeft = getListLeft(mzRecyclerView);
        Rect rect4 = this.mTempRect2;
        int i3 = listLeft + rect4.left + rect4.right;
        Rect rect5 = this.mTempRect1;
        int left = ((((view2.getLeft() - view3.getWidth()) - rect5.right) - rect5.left) - view.getWidth()) - i3;
        if (left < i3) {
            rect.left += left;
            rect.right += left;
        }
    }

    public boolean hasNewHeader(int i, boolean z) {
        if (indexOutOfBounds(i)) {
            return false;
        }
        long headerId = this.mHeaderAdapter.getHeaderId(i);
        if (headerId < 0) {
            return false;
        }
        int i2 = (z ? 1 : -1) + i;
        return i == (z ? this.mHeaderAdapter.getItemCount() - 1 : 0) || headerId != (!indexOutOfBounds(i2) ? this.mHeaderAdapter.getHeaderId(i2) : -1);
    }

    public boolean hasPinnedHeader(View view, int i, int i2) {
        int i3;
        int i4;
        this.mDimensionCalculator.initMargins(this.mTempRect1, view);
        if (i == 1) {
            i4 = view.getTop();
            i3 = this.mTempRect1.top;
        } else {
            i4 = view.getLeft();
            i3 = this.mTempRect1.left;
        }
        return i4 <= i3 && this.mHeaderAdapter.getHeaderId(i2) >= 0;
    }

    public void initHeaderBounds(Rect rect, MzRecyclerView mzRecyclerView, View view, View view2, boolean z) {
        initDefaultHeaderOffset(rect, mzRecyclerView, view, view2, this.mOrientationProvider.getOrientation(mzRecyclerView));
        if (z && isStickyHeaderBeingPushedOffscreen(mzRecyclerView, view)) {
            View firstViewUnobscuredByHeader = getFirstViewUnobscuredByHeader(mzRecyclerView, view);
            MzRecyclerView mzRecyclerView2 = mzRecyclerView;
            translateHeaderWithNextHeader(mzRecyclerView2, this.mOrientationProvider.getOrientation(mzRecyclerView), rect, view, firstViewUnobscuredByHeader, this.mHeaderProvider.getHeader(mzRecyclerView, mzRecyclerView.getChildAdapterPosition(firstViewUnobscuredByHeader)));
        }
    }
}
