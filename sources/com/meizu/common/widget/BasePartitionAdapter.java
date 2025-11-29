package com.meizu.common.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public abstract class BasePartitionAdapter extends AbsBasePartitionAdapter {
    private static final int CAPACITY_INCREMENT = 10;
    protected static final int INITIAL_CAPACITY = 10;
    public static final int ITEM_VIEW_TYPE_PARTITION_HEADER = 0;
    public static final int PARTITION_FIRST_ITEM_BG_TYPE = 1;
    public static final int PARTITION_HEADER_ITEM_BG_TYPE = 0;
    public static final int PARTITION_LAST_ITEM_BG_TYPE = 3;
    public static final int PARTITION_MIDDLE_ITEM_BG_TYPE = 2;
    public static final int PARTITION_SINGLE_ITEM_BG_TYPE = 4;
    protected boolean mCacheValid;
    protected final Context mContext;
    protected int mCount;
    protected int mItemCounts;
    private boolean mNotificationNeeded;
    private boolean mNotificationsEnabled;
    protected int mPartitionCount;
    protected Partition[] mPartitions;

    public static class Partition {
        int mCount;
        ArrayList<PartitionFixedViewInfo> mFooterViewInfos = new ArrayList<>();
        int mFooterViewsCount;
        boolean mHasHeader;
        ArrayList<PartitionFixedViewInfo> mHeaderViewInfos = new ArrayList<>();
        int mHeaderViewsCount;
        int mItemCount;
        boolean mShowIfEmpty;
        int mSize;

        public Partition(boolean z, boolean z2, int i) {
            this.mShowIfEmpty = z;
            this.mHasHeader = z2;
            this.mItemCount = i;
        }

        public String toString() {
            return "\n Partition: mShowIfEmpty: " + this.mShowIfEmpty + ",mHasHeader: " + this.mHasHeader + ",mSize: " + this.mSize + ",mCount: " + this.mCount + ",mItemCount: " + this.mItemCount + ",mHeaderViewsCount: " + this.mHeaderViewsCount + ",mFooterViewsCount: " + this.mFooterViewsCount;
        }
    }

    public class PartitionFixedViewInfo {
        public Object data;
        public boolean isSelectable;
        public View view;

        public PartitionFixedViewInfo() {
        }
    }

    public BasePartitionAdapter(Context context) {
        this(context, 10);
    }

    private boolean areAllPartitionFixedViewsSelectable(ArrayList<PartitionFixedViewInfo> arrayList) {
        Iterator<PartitionFixedViewInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!it.next().isSelectable) {
                return false;
            }
        }
        return true;
    }

    private boolean removeFixedViewInfo(View view, ArrayList<PartitionFixedViewInfo> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).view == view) {
                arrayList.remove(i);
                invalidate();
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public void addFooterView(int i, View view, Object obj, boolean z) {
        if (i < this.mPartitionCount) {
            PartitionFixedViewInfo partitionFixedViewInfo = new PartitionFixedViewInfo();
            partitionFixedViewInfo.view = view;
            partitionFixedViewInfo.data = obj;
            partitionFixedViewInfo.isSelectable = z;
            this.mPartitions[i].mFooterViewInfos.add(partitionFixedViewInfo);
            invalidate();
            notifyDataSetChanged();
            return;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public void addHeaderView(int i, View view, Object obj, boolean z) {
        if (i < this.mPartitionCount) {
            PartitionFixedViewInfo partitionFixedViewInfo = new PartitionFixedViewInfo();
            partitionFixedViewInfo.view = view;
            partitionFixedViewInfo.data = obj;
            partitionFixedViewInfo.isSelectable = z;
            this.mPartitions[i].mHeaderViewInfos.add(partitionFixedViewInfo);
            invalidate();
            notifyDataSetChanged();
            return;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public int addPartition(Partition partition) {
        int i = this.mPartitionCount;
        Partition[] partitionArr = this.mPartitions;
        if (i >= partitionArr.length) {
            Partition[] partitionArr2 = new Partition[(i + 10)];
            System.arraycopy(partitionArr, 0, partitionArr2, 0, i);
            this.mPartitions = partitionArr2;
        }
        Partition[] partitionArr3 = this.mPartitions;
        int i2 = this.mPartitionCount;
        this.mPartitionCount = i2 + 1;
        partitionArr3[i2] = partition;
        invalidate();
        notifyDataSetChanged();
        return this.mPartitionCount - 1;
    }

    public boolean areAllItemsEnabled() {
        for (int i = 0; i < this.mPartitionCount; i++) {
            Partition partition = this.mPartitions[i];
            if (partition.mHasHeader || !areAllPartitionFixedViewsSelectable(partition.mHeaderViewInfos) || !areAllPartitionFixedViewsSelectable(this.mPartitions[i].mFooterViewInfos)) {
                return false;
            }
        }
        return true;
    }

    public void bindHeaderView(View view, Context context, int i, int i2) {
    }

    public boolean canSelect(int i, int i2) {
        return true;
    }

    public void clearPartitions() {
        Arrays.fill(this.mPartitions, (Object) null);
        this.mPartitionCount = 0;
        invalidate();
        notifyDataSetChanged();
    }

    public void ensureCacheValid() {
        if (!this.mCacheValid) {
            this.mCount = 0;
            this.mItemCounts = 0;
            for (int i = 0; i < this.mPartitionCount; i++) {
                Partition partition = this.mPartitions[i];
                partition.mHeaderViewsCount = partition.mHeaderViewInfos.size();
                Partition partition2 = this.mPartitions[i];
                partition2.mFooterViewsCount = partition2.mFooterViewInfos.size();
                Partition partition3 = this.mPartitions[i];
                int i2 = partition3.mHeaderViewsCount;
                int i3 = partition3.mItemCount;
                int i4 = i2 + i3 + partition3.mFooterViewsCount;
                partition3.mCount = i4;
                if (partition3.mHasHeader && (i4 != 0 || partition3.mShowIfEmpty)) {
                    i4++;
                }
                partition3.mSize = i4;
                this.mCount += i4;
                this.mItemCounts += i3;
            }
            this.mCacheValid = true;
        }
    }

    public int getBackgroundResource(int i) {
        if (i == 1) {
            return R.drawable.mz_card_top_shade_light;
        }
        if (i == 2) {
            return R.drawable.mz_card_middle_shade_light;
        }
        if (i == 3) {
            return R.drawable.mz_card_bottom_shade_light;
        }
        if (i != 4) {
            return 0;
        }
        return R.drawable.mz_card_full_shade_light;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        ensureCacheValid();
        return this.mCount;
    }

    public int getCountForPartition(int i) {
        if (i < this.mPartitionCount) {
            ensureCacheValid();
            return this.mPartitions[i].mCount;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public int getFooterViewsCount(int i) {
        if (i < this.mPartitionCount) {
            ensureCacheValid();
            return this.mPartitions[i].mFooterViewsCount;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public View getHeaderView(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = newHeaderView(this.mContext, i, i2, viewGroup);
        }
        bindHeaderView(view, this.mContext, i, i2);
        return view;
    }

    public int getHeaderViewsCount(int i) {
        if (i < this.mPartitionCount) {
            ensureCacheValid();
            return this.mPartitions[i].mHeaderViewsCount;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public Object getItem(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            Partition partition = this.mPartitions[i2];
            int i4 = partition.mSize + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (partition.mHasHeader) {
                    i5--;
                }
                if (i5 == -1) {
                    return null;
                }
                if (isHeaderView(i2, i5)) {
                    return this.mPartitions[i2].mHeaderViewInfos.get(i5).data;
                }
                if (!isFooterView(i2, i5)) {
                    return getItem(i2, i5);
                }
                Partition partition2 = this.mPartitions[i2];
                return partition2.mFooterViewInfos.get(i5 - (partition2.mCount - partition2.mFooterViewsCount)).data;
            }
        }
        return null;
    }

    public abstract Object getItem(int i, int i2);

    public int getItemBackgroundType(int i, int i2) {
        if (i2 == -1) {
            return 0;
        }
        if (i2 == 0 && this.mPartitions[i].mCount == 1) {
            return 4;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2 == this.mPartitions[i].mCount - 1 ? 3 : 2;
    }

    public int getItemCount() {
        ensureCacheValid();
        return this.mItemCounts;
    }

    public long getItemId(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            Partition partition = this.mPartitions[i2];
            int i4 = partition.mSize + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (partition.mHasHeader) {
                    i5--;
                }
                if (i5 == -1) {
                    return 0;
                }
                if (isHeaderView(i2, i5) || isFooterView(i2, i5)) {
                    return -1;
                }
                return getItemId(i2, i5);
            }
        }
        return 0;
    }

    public abstract long getItemId(int i, int i2);

    public int getItemViewType(int i, int i2) {
        return 1;
    }

    public int getItemViewTypeCount() {
        return 1;
    }

    public int getOffsetInPartition(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            Partition partition = this.mPartitions[i2];
            int i4 = partition.mSize + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                return partition.mHasHeader ? i5 - 1 : i5;
            }
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public Partition getPartition(int i) {
        if (i < this.mPartitionCount) {
            return this.mPartitions[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public int getPartitionCount() {
        return this.mPartitionCount;
    }

    public int getPartitionForItemIndex(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            int i4 = this.mPartitions[i2].mItemCount + i3;
            if (i >= i3 && i < i4) {
                return i2;
            }
            i2++;
            i3 = i4;
        }
        return -1;
    }

    public int getPartitionForPosition(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            int i4 = this.mPartitions[i2].mSize + i3;
            if (i >= i3 && i < i4) {
                return i2;
            }
            i2++;
            i3 = i4;
        }
        return -1;
    }

    public int getPositionForPartition(int i) {
        if (i < this.mPartitionCount) {
            ensureCacheValid();
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                i2 += this.mPartitions[i3].mSize;
            }
            return i2;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public abstract View getView(int i, int i2, int i3, int i4, View view, ViewGroup viewGroup);

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            Partition partition = this.mPartitions[i2];
            int i4 = partition.mSize + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (partition.mHasHeader) {
                    i5--;
                }
                int i6 = i5;
                int itemBackgroundType = getItemBackgroundType(i2, i6);
                if (i6 == -1) {
                    view2 = getHeaderView(i, i2, view, viewGroup);
                } else if (isHeaderView(i2, i6)) {
                    view2 = this.mPartitions[i2].mHeaderViewInfos.get(i6).view;
                } else if (isFooterView(i2, i6)) {
                    Partition partition2 = this.mPartitions[i2];
                    view2 = partition2.mFooterViewInfos.get(i6 - (partition2.mCount - partition2.mFooterViewsCount)).view;
                } else {
                    view2 = getView(i, i2, i6, itemBackgroundType, view, viewGroup);
                }
                if (view2 != null) {
                    return view2;
                }
                throw new NullPointerException("View should not be null, partition: " + i2 + " position: " + i);
            }
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public int getViewTypeCount() {
        return getItemViewTypeCount() + 1;
    }

    public boolean hasHeader(int i) {
        return this.mPartitions[i].mHasHeader;
    }

    public void invalidate() {
        this.mCacheValid = false;
    }

    public boolean isEnabled(int i, int i2) {
        return true;
    }

    public boolean isFooterView(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            Partition partition = this.mPartitions[i2];
            int i4 = partition.mSize + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (partition.mHasHeader) {
                    i5--;
                }
                return isFooterView(i2, i5);
            }
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public boolean isHeaderView(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            Partition partition = this.mPartitions[i2];
            int i4 = partition.mSize + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (partition.mHasHeader) {
                    i5--;
                }
                return isHeaderView(i2, i5);
            }
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public boolean isPartitionEmpty(int i) {
        if (i < this.mPartitionCount) {
            ensureCacheValid();
            return this.mPartitions[i].mCount == 0;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public boolean isShowIfEmpty(int i) {
        return this.mPartitions[i].mShowIfEmpty;
    }

    public boolean isTopHeader() {
        int partitionForPosition = getPartitionForPosition(0);
        if (partitionForPosition < 0) {
            return false;
        }
        return this.mPartitions[partitionForPosition].mHasHeader;
    }

    public View newHeaderView(Context context, int i, int i2, ViewGroup viewGroup) {
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.mNotificationsEnabled) {
            this.mNotificationNeeded = false;
            super.notifyDataSetChanged();
            return;
        }
        this.mNotificationNeeded = true;
    }

    public boolean removeFooterView(int i, View view) {
        if (i < this.mPartitionCount) {
            return removeFixedViewInfo(view, this.mPartitions[i].mFooterViewInfos);
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public boolean removeHeaderView(int i, View view) {
        if (i < this.mPartitionCount) {
            return removeFixedViewInfo(view, this.mPartitions[i].mHeaderViewInfos);
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public void removePartition(int i) {
        int i2 = this.mPartitionCount;
        if (i < i2) {
            Partition[] partitionArr = this.mPartitions;
            System.arraycopy(partitionArr, i + 1, partitionArr, i, (i2 - i) - 1);
            Partition[] partitionArr2 = this.mPartitions;
            int i3 = this.mPartitionCount - 1;
            this.mPartitionCount = i3;
            partitionArr2[i3] = null;
            invalidate();
            notifyDataSetChanged();
            return;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public void setHasHeader(int i, boolean z) {
        this.mPartitions[i].mHasHeader = z;
        invalidate();
    }

    public void setNotificationsEnabled(boolean z) {
        this.mNotificationsEnabled = z;
        if (z && this.mNotificationNeeded) {
            notifyDataSetChanged();
        }
    }

    public void setShowIfEmpty(int i, boolean z) {
        this.mPartitions[i].mShowIfEmpty = z;
        invalidate();
    }

    public void setViewBackground(View view, int i) {
        view.setBackgroundResource(getBackgroundResource(i));
    }

    public BasePartitionAdapter(Context context, int i) {
        this.mNotificationsEnabled = true;
        this.mContext = context;
        this.mPartitions = new Partition[i];
    }

    public int getItemViewType(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            Partition partition = this.mPartitions[i2];
            int i4 = partition.mSize + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (partition.mHasHeader) {
                    i5--;
                }
                if (i5 == -1) {
                    return 0;
                }
                if (isHeaderView(i2, i5) || isFooterView(i2, i5)) {
                    return -2;
                }
                return getItemViewType(i2, i);
            }
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public boolean isEnabled(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            Partition partition = this.mPartitions[i2];
            int i4 = partition.mSize + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (partition.mHasHeader) {
                    i5--;
                }
                if (i5 == -1) {
                    return false;
                }
                if (isHeaderView(i2, i5)) {
                    return this.mPartitions[i2].mHeaderViewInfos.get(i5).isSelectable;
                }
                if (isFooterView(i2, i5)) {
                    Partition partition2 = this.mPartitions[i2];
                    return partition2.mFooterViewInfos.get(i5 - (partition2.mCount - partition2.mFooterViewsCount)).isSelectable;
                } else if (!canSelect(i2, i5)) {
                    return false;
                } else {
                    return isEnabled(i2, i5);
                }
            }
        }
        return false;
    }

    public boolean isFooterView(int i, int i2) {
        Partition partition = this.mPartitions[i];
        return i2 >= partition.mCount - partition.mFooterViewsCount;
    }

    public boolean isHeaderView(int i, int i2) {
        return i2 >= 0 && i2 < this.mPartitions[i].mHeaderViewsCount;
    }

    public void addFooterView(int i, View view) {
        addFooterView(i, view, (Object) null, true);
    }

    public void addHeaderView(int i, View view) {
        addHeaderView(i, view, (Object) null, true);
    }
}
