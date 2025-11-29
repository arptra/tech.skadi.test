package com.meizu.common.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.widget.BasePartitionAdapter;
import java.util.List;

public abstract class PinnedHeaderIndexerArrayAdapter<T> extends PinnedHeaderArrayAdapter<T> implements SectionIndexer {
    protected Context mContext;
    private View mHeader;
    private SparseIntArray mHeaderMap;
    private int mIndexedPartition = 0;
    private SectionIndexer mIndexer;
    private int mLastSection = -1;
    private int mLastSectionOverScrollDistance = 0;
    private Placement mPlacementCache = new Placement();
    private boolean mSectionHeaderDisplayEnabled;
    private boolean mShowSectionHeaders;

    public static final class Placement {
        public boolean firstInSection;
        public boolean lastInSection;
        /* access modifiers changed from: private */
        public int position = -1;
        public String sectionHeader;

        public void invalidate() {
            this.position = -1;
        }
    }

    public PinnedHeaderIndexerArrayAdapter(Context context) {
        super(context);
        this.mContext = context;
        this.mHeaderMap = new SparseIntArray(getSections().length);
    }

    private void ensureSectionHeaders() {
        this.mHeaderMap.clear();
        if (this.mShowSectionHeaders && this.mIndexer != null) {
            BasePartitionAdapter.Partition partition = this.mPartitions[this.mIndexedPartition];
            if (partition.mItemCount > 0) {
                int i = partition.mHeaderViewsCount;
                int i2 = -1;
                int i3 = 0;
                while (i3 < this.mPartitions[this.mIndexedPartition].mItemCount) {
                    try {
                        int sectionForPosition = this.mIndexer.getSectionForPosition(i3);
                        if (i2 == sectionForPosition || sectionForPosition <= i2) {
                            break;
                        }
                        this.mHeaderMap.put(sectionForPosition, i3 + i + this.mHeaderMap.size());
                        int positionForSection = this.mIndexer.getPositionForSection(sectionForPosition + 1);
                        if (i3 == positionForSection) {
                            break;
                        }
                        i3 = positionForSection;
                        i2 = sectionForPosition;
                    } catch (CursorIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
                int size = this.mHeaderMap.size();
                BasePartitionAdapter.Partition partition2 = this.mPartitions[this.mIndexedPartition];
                partition2.mCount += size;
                partition2.mSize += size;
                this.mCount += size;
            }
        }
    }

    private int getSectionPosition(int i) {
        int positionForPartition = getPositionForPartition(this.mIndexedPartition);
        if (hasHeader(this.mIndexedPartition)) {
            positionForPartition++;
        }
        return positionForPartition + getPositionForSection(i);
    }

    public boolean areAllItemsEnabled() {
        ensureCacheValid();
        if (!this.mShowSectionHeaders || this.mHeaderMap.size() <= 0) {
            return super.areAllItemsEnabled();
        }
        return false;
    }

    public void bindSectionHeaderView(View view, Context context, int i, int i2) {
        view.setVisibility(0);
        ((TextView) view.findViewById(R.id.mc_header_text1)).setText((String) getSections()[i2]);
        if (i == 0) {
            view.setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.mz_pinned_top_header_minHeight));
        } else {
            view.setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.mz_pinned_interval_header_minHeight));
        }
    }

    public boolean canSelect(int i, int i2) {
        if (this.mIndexedPartition != i || !this.mShowSectionHeaders || this.mHeaderMap.indexOfValue(i2) < 0) {
            return super.canSelect(i, i2);
        }
        return false;
    }

    public void configureItemHeader(ListView listView, int i, int i2, boolean z) {
    }

    public void configurePinnedHeaders(PinnedHeaderListView pinnedHeaderListView) {
        int partitionForPosition;
        int offsetInPartition;
        super.configurePinnedHeaders(pinnedHeaderListView);
        if (isSectionHeaderDisplayEnabled()) {
            int currentOverScrollDistance = pinnedHeaderListView.getCurrentOverScrollDistance();
            boolean z = true;
            int i = 0;
            boolean z2 = currentOverScrollDistance <= 0 && pinnedHeaderListView.getFirstVisiblePosition() == 0;
            if (z2 && this.mLastSectionOverScrollDistance >= 0) {
                configureItemHeader(pinnedHeaderListView, getSectionPosition(0) + pinnedHeaderListView.getHeaderViewsCount(), 0, true);
            }
            this.mLastSectionOverScrollDistance = currentOverScrollDistance;
            int pinnedHeaderCount = getPinnedHeaderCount() - 1;
            if (this.mIndexer == null || getCount() == 0 || z2) {
                pinnedHeaderListView.setHeaderInvisible(pinnedHeaderCount, false);
                this.mLastSection = -1;
                return;
            }
            int positionAt = pinnedHeaderListView.getPositionAt(pinnedHeaderListView.getTotalTopPinnedHeaderHeight());
            int headerViewsCount = positionAt - pinnedHeaderListView.getHeaderViewsCount();
            int sectionForPosition = (pinnedHeaderListView.getChildAt(0) == null || pinnedHeaderListView.getChildAt(0).getTop() - pinnedHeaderListView.getDividerHeight() > pinnedHeaderListView.getHeaderPaddingTop() || (partitionForPosition = getPartitionForPosition(headerViewsCount)) != this.mIndexedPartition || (offsetInPartition = getOffsetInPartition(headerViewsCount)) < this.mPartitions[partitionForPosition].mHeaderViewsCount) ? -1 : getSectionForPosition(offsetInPartition);
            if (this.mLastSection == sectionForPosition && sectionForPosition != -1 && getSectionPosition(sectionForPosition) == headerViewsCount) {
                configureItemHeader(pinnedHeaderListView, positionAt, sectionForPosition, false);
            }
            int i2 = this.mLastSection;
            if (i2 > sectionForPosition) {
                while (i2 > sectionForPosition) {
                    configureItemHeader(pinnedHeaderListView, getSectionPosition(i2) + pinnedHeaderListView.getHeaderViewsCount(), i2, true);
                    i2--;
                }
            } else if (i2 < sectionForPosition) {
                for (int i3 = i2 + 1; i3 <= sectionForPosition; i3++) {
                    configureItemHeader(pinnedHeaderListView, getSectionPosition(i3) + pinnedHeaderListView.getHeaderViewsCount(), i3, false);
                }
            }
            this.mLastSection = sectionForPosition;
            if (sectionForPosition == -1 || !isPinnedSectionHeaderVisible(sectionForPosition)) {
                pinnedHeaderListView.setHeaderInvisible(pinnedHeaderCount, false);
                return;
            }
            setPinnedSectionHeaderView(this.mHeader, sectionForPosition);
            if (headerViewsCount != getSectionPosition(sectionForPosition + 1) - 1) {
                z = false;
            }
            if (z && pinnedHeaderListView.getChildAt(0).getBottom() < pinnedHeaderListView.getPinnedHeaderHeight(pinnedHeaderCount)) {
                i = pinnedHeaderListView.getChildAt(0).getBottom() - pinnedHeaderListView.getPinnedHeaderHeight(pinnedHeaderCount);
            }
            pinnedHeaderListView.setTranslateHeader(pinnedHeaderCount, i);
        }
    }

    public View createPinnedSectionHeaderView(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mc_pinned_header_view, viewGroup, false);
        if (inflate != null) {
            ((ImageView) inflate.findViewById(16908288)).setVisibility(8);
        }
        return inflate;
    }

    public void ensureCacheValid() {
        if (!this.mCacheValid) {
            super.ensureCacheValid();
            ensureSectionHeaders();
        }
    }

    public int getDataPosition(int i, int i2) {
        if (this.mIndexedPartition != i || !this.mShowSectionHeaders) {
            return super.getDataPosition(i, i2);
        }
        if (this.mHeaderMap.indexOfValue(i2) >= 0) {
            return -1;
        }
        int i3 = i2 - this.mPartitions[this.mIndexedPartition].mHeaderViewsCount;
        int i4 = 0;
        while (i4 < this.mHeaderMap.size() && this.mHeaderMap.valueAt(i4) <= i2) {
            i3--;
            i4++;
        }
        return i3;
    }

    public int getIndexedPartition() {
        return this.mIndexedPartition;
    }

    public SectionIndexer getIndexer() {
        return this.mIndexer;
    }

    public int getItemBackgroundType(int i, int i2) {
        int i3 = this.mIndexedPartition;
        if (i3 != i || i2 < 0 || this.mIndexer == null) {
            return super.getItemBackgroundType(i, i2);
        }
        if (isHeaderView(i3, i2)) {
            int i4 = this.mPartitions[this.mIndexedPartition].mHeaderViewsCount;
            if (i4 == 1) {
                return 4;
            }
            if (i2 == 0) {
                return 1;
            }
            return i2 == i4 - 1 ? 3 : 2;
        } else if (isFooterView(this.mIndexedPartition, i2)) {
            BasePartitionAdapter.Partition partition = this.mPartitions[this.mIndexedPartition];
            int i5 = partition.mFooterViewsCount;
            int i6 = partition.mCount - i5;
            if (i5 == 1) {
                return 4;
            }
            if (i2 == i6) {
                return 1;
            }
            return i2 - i6 == i5 - 1 ? 3 : 2;
        } else {
            int sectionForPosition = getSectionForPosition(i2);
            int positionForSection = getPositionForSection(sectionForPosition);
            int countForPartition = sectionForPosition == getSections().length - 1 ? getCountForPartition(i) : getPositionForSection(sectionForPosition + 1);
            if (this.mShowSectionHeaders) {
                if (i2 == positionForSection) {
                    return 0;
                }
                positionForSection++;
            }
            if (i2 == positionForSection && countForPartition - positionForSection == 1) {
                return 4;
            }
            if (i2 == positionForSection) {
                return 1;
            }
            return i2 == countForPartition - 1 ? 3 : 2;
        }
    }

    public Placement getItemPlacementInSection(int i) {
        if (this.mPlacementCache.position == i) {
            return this.mPlacementCache;
        }
        int unused = this.mPlacementCache.position = i;
        boolean z = false;
        if (isSectionHeaderDisplayEnabled()) {
            int sectionForPosition = getSectionForPosition(i);
            if (sectionForPosition == -1 || getPositionForSection(sectionForPosition) != i) {
                Placement placement = this.mPlacementCache;
                placement.firstInSection = false;
                placement.sectionHeader = null;
            } else {
                Placement placement2 = this.mPlacementCache;
                placement2.firstInSection = true;
                placement2.sectionHeader = (String) getSections()[sectionForPosition];
            }
            Placement placement3 = this.mPlacementCache;
            if (getPositionForSection(sectionForPosition + 1) - 1 == i) {
                z = true;
            }
            placement3.lastInSection = z;
        } else {
            Placement placement4 = this.mPlacementCache;
            placement4.firstInSection = false;
            placement4.lastInSection = false;
            placement4.sectionHeader = null;
        }
        return this.mPlacementCache;
    }

    public int getItemViewType(int i, int i2) {
        if (this.mIndexedPartition == i && this.mShowSectionHeaders && this.mHeaderMap.size() > 0) {
            if (this.mHeaderMap.indexOfValue(getOffsetInPartition(i2)) >= 0) {
                return getViewTypeCount() - 1;
            }
        }
        return super.getItemViewType(i, i2);
    }

    public int getPinnedHeaderCount() {
        return isSectionHeaderDisplayEnabled() ? super.getPinnedHeaderCount() + 1 : super.getPinnedHeaderCount();
    }

    public View getPinnedHeaderView(int i, View view, ViewGroup viewGroup) {
        if (!isSectionHeaderDisplayEnabled() || i != getPinnedHeaderCount() - 1) {
            return super.getPinnedHeaderView(i, view, viewGroup);
        }
        if (this.mHeader == null) {
            this.mHeader = createPinnedSectionHeaderView(this.mContext, viewGroup);
        }
        return this.mHeader;
    }

    public int getPositionForSection(int i) {
        SectionIndexer sectionIndexer = this.mIndexer;
        if (sectionIndexer == null) {
            return -1;
        }
        if (i < 0) {
            return 0;
        }
        int positionForSection = sectionIndexer.getPositionForSection(i) + this.mPartitions[this.mIndexedPartition].mHeaderViewsCount;
        if (this.mShowSectionHeaders) {
            for (int i2 = 0; i2 < i; i2++) {
                if (this.mHeaderMap.indexOfKey(i2) >= 0) {
                    positionForSection++;
                }
            }
        }
        return positionForSection;
    }

    public int getSectionForPosition(int i) {
        if (this.mIndexer == null) {
            return -1;
        }
        if (!isFooterView(this.mIndexedPartition, i)) {
            BasePartitionAdapter.Partition partition = this.mPartitions[this.mIndexedPartition];
            if (i <= partition.mCount - 1) {
                int i2 = i - partition.mHeaderViewsCount;
                if (i2 < 0) {
                    return -1;
                }
                if (this.mShowSectionHeaders) {
                    int i3 = 0;
                    while (i3 < this.mHeaderMap.size() && this.mHeaderMap.valueAt(i3) < i) {
                        i2--;
                        i3++;
                    }
                }
                return this.mIndexer.getSectionForPosition(i2);
            }
        }
        return getSections().length - 1;
    }

    public View getSectionHeaderView(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = newSectionHeaderView(this.mContext, i, i2, viewGroup);
        }
        bindSectionHeaderView(view, this.mContext, i, i2);
        return view;
    }

    public Object[] getSections() {
        SectionIndexer sectionIndexer = this.mIndexer;
        return sectionIndexer == null ? new String[]{" "} : sectionIndexer.getSections();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = r1.mHeaderMap.indexOfValue(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r2, int r3, int r4, int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r1 = this;
            int r0 = r1.mIndexedPartition
            if (r0 != r3) goto L_0x001b
            boolean r0 = r1.mShowSectionHeaders
            if (r0 == 0) goto L_0x001b
            android.util.SparseIntArray r0 = r1.mHeaderMap
            int r0 = r0.indexOfValue(r4)
            if (r0 < 0) goto L_0x001b
            android.util.SparseIntArray r2 = r1.mHeaderMap
            int r2 = r2.keyAt(r0)
            android.view.View r1 = r1.getSectionHeaderView(r4, r2, r6, r7)
            return r1
        L_0x001b:
            android.view.View r1 = super.getView(r2, r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.PinnedHeaderIndexerArrayAdapter.getView(int, int, int, int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    public boolean isEnabled(int i, int i2) {
        if (this.mIndexedPartition != i || !this.mShowSectionHeaders || this.mHeaderMap.indexOfValue(i2) < 0) {
            return super.isEnabled(i, i2);
        }
        return false;
    }

    public boolean isPinnedSectionHeaderVisible(int i) {
        return true;
    }

    public boolean isSectionHeaderDisplayEnabled() {
        return this.mSectionHeaderDisplayEnabled;
    }

    public View newSectionHeaderView(Context context, int i, int i2, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.mc_pinned_group_header, viewGroup, false);
    }

    public void setIndexedPartition(int i) {
        this.mIndexedPartition = i;
        if (this.mShowSectionHeaders) {
            invalidate();
        }
    }

    public void setIndexer(SectionIndexer sectionIndexer) {
        this.mIndexer = sectionIndexer;
        this.mPlacementCache.invalidate();
        if (this.mShowSectionHeaders) {
            invalidate();
        }
    }

    public void setPinnedSectionHeaderView(View view, int i) {
        if (view != null) {
            ((TextView) view.findViewById(R.id.mc_header_text1)).setText((String) getSections()[i]);
        }
    }

    public void setSectionHeaderDisplayEnabled(boolean z) {
        this.mSectionHeaderDisplayEnabled = z;
    }

    public void showSectionHeaders(boolean z) {
        this.mShowSectionHeaders = z;
        invalidate();
    }

    public PinnedHeaderIndexerArrayAdapter(Context context, List<T>... listArr) {
        super(context, listArr);
        this.mContext = context;
        this.mHeaderMap = new SparseIntArray(getSections().length);
    }
}
