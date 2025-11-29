package com.meizu.common.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.widget.PinnedHeaderListView;
import java.util.List;

public abstract class PinnedHeaderArrayAdapter<T> extends MultiArrayPartitionAdapter<T> implements PinnedHeaderListView.PinnedHeaderAdapter {
    public static final int PARTITION_HEADER_TYPE = 0;
    private boolean[] mHeaderVisibility;
    private boolean mPinnedPartitionHeadersEnabled;

    public PinnedHeaderArrayAdapter(Context context) {
        super(context);
    }

    public void configurePinnedHeaders(PinnedHeaderListView pinnedHeaderListView) {
        int partitionForPosition;
        if (this.mPinnedPartitionHeadersEnabled) {
            int partitionCount = getPartitionCount();
            boolean[] zArr = this.mHeaderVisibility;
            if (zArr == null || zArr.length != partitionCount) {
                this.mHeaderVisibility = new boolean[partitionCount];
            }
            for (int i = 0; i < partitionCount; i++) {
                boolean isPinnedPartitionHeaderVisible = isPinnedPartitionHeaderVisible(i);
                this.mHeaderVisibility[i] = isPinnedPartitionHeaderVisible;
                if (!isPinnedPartitionHeaderVisible) {
                    pinnedHeaderListView.setHeaderInvisible(i, true);
                }
            }
            int headerViewsCount = pinnedHeaderListView.getHeaderViewsCount();
            int i2 = 0;
            int i3 = -1;
            for (int i4 = 0; i4 < partitionCount; i4++) {
                if (this.mHeaderVisibility[i4]) {
                    if (i4 > getPartitionForPosition(pinnedHeaderListView.getPositionAt(i2) - headerViewsCount)) {
                        break;
                    }
                    pinnedHeaderListView.setHeaderPinnedAtTop(i4, i2, false);
                    i2 += pinnedHeaderListView.getPinnedHeaderHeight(i4);
                    i3 = i4;
                }
            }
            int height = pinnedHeaderListView.getHeight();
            int i5 = partitionCount;
            int i6 = 0;
            while (true) {
                partitionCount--;
                if (partitionCount > i3) {
                    if (this.mHeaderVisibility[partitionCount]) {
                        int positionAt = pinnedHeaderListView.getPositionAt(height - i6) - headerViewsCount;
                        if (positionAt < 0 || (partitionForPosition = getPartitionForPosition(positionAt - 1)) == -1 || partitionCount <= partitionForPosition) {
                            break;
                        }
                        i6 += pinnedHeaderListView.getPinnedHeaderHeight(partitionCount);
                        pinnedHeaderListView.setHeaderPinnedAtBottom(partitionCount, height - i6, positionAt < getPositionForPartition(partitionCount));
                        i5 = partitionCount;
                    }
                } else {
                    break;
                }
            }
            for (int i7 = i3 + 1; i7 < i5; i7++) {
                if (this.mHeaderVisibility[i7]) {
                    pinnedHeaderListView.setHeaderInvisible(i7, isPartitionEmpty(i7));
                }
            }
        }
    }

    public int getPinnedHeaderCount() {
        if (this.mPinnedPartitionHeadersEnabled) {
            return getPartitionCount();
        }
        return 0;
    }

    public View getPinnedHeaderView(int i, View view, ViewGroup viewGroup) {
        Integer num;
        if (!hasHeader(i)) {
            return null;
        }
        if (view == null || (num = (Integer) view.getTag()) == null || num.intValue() != 0) {
            view = null;
        }
        int positionForPartition = getPositionForPartition(i);
        if (view == null) {
            view = newHeaderView(this.mContext, positionForPartition, i, viewGroup);
            view.setTag(0);
            view.setFocusable(false);
            view.setEnabled(false);
        }
        bindHeaderView(view, this.mContext, positionForPartition, i);
        return view;
    }

    public boolean getPinnedPartitionHeadersEnabled() {
        return this.mPinnedPartitionHeadersEnabled;
    }

    public int getScrollPositionForHeader(int i) {
        return getPositionForPartition(i);
    }

    public boolean isPinnedPartitionHeaderVisible(int i) {
        return this.mPinnedPartitionHeadersEnabled && hasHeader(i) && !isPartitionEmpty(i);
    }

    public void setPinnedPartitionHeadersEnabled(boolean z) {
        this.mPinnedPartitionHeadersEnabled = z;
    }

    public PinnedHeaderArrayAdapter(Context context, List<T>... listArr) {
        super(context, listArr);
    }
}
