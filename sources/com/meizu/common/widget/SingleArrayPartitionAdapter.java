package com.meizu.common.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.widget.BasePartitionAdapter;
import java.util.Arrays;
import java.util.List;

public abstract class SingleArrayPartitionAdapter<T> extends BasePartitionAdapter {
    protected List<T> mObjects;

    public SingleArrayPartitionAdapter(Context context) {
        super(context);
    }

    private void addPartitions(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            setNotificationsEnabled(false);
            for (int addPartition : iArr) {
                addPartition(false, true, addPartition);
            }
            setNotificationsEnabled(true);
        }
    }

    public void addItem(int i, T t) {
        int partitionForItemIndex = getPartitionForItemIndex(i);
        if (-1 == partitionForItemIndex) {
            Log.w("lijinqian", "ArrayIndexOutOfBoundsException,object size is " + this.mObjects.size() + ", current item index is " + i + "![SingleArrayPartitionAdapter$addItem]");
            return;
        }
        setNotificationsEnabled(false);
        this.mObjects.add(i, t);
        BasePartitionAdapter.Partition partition = this.mPartitions[partitionForItemIndex];
        partition.mSize++;
        partition.mCount++;
        partition.mItemCount++;
        invalidate();
        notifyDataSetChanged();
        setNotificationsEnabled(true);
    }

    public int addPartition(boolean z, boolean z2, int i) {
        return addPartition(new BasePartitionAdapter.Partition(z, z2, i));
    }

    public abstract void bindView(View view, Context context, int i, int i2, T t, int i3, int i4);

    public void changePartitions(List<T> list, BasePartitionAdapter.Partition... partitionArr) {
        this.mObjects = list;
        setNotificationsEnabled(false);
        clearPartitions();
        if (partitionArr != null && partitionArr.length > 0) {
            for (BasePartitionAdapter.Partition addPartition : partitionArr) {
                addPartition(addPartition);
            }
        }
        setNotificationsEnabled(true);
    }

    public int getDataPosition(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < this.mPartitionCount) {
            BasePartitionAdapter.Partition partition = this.mPartitions[i2];
            int i5 = partition.mSize + i3;
            if (i < i3 || i >= i5) {
                i4 += partition.mItemCount;
                i2++;
                i3 = i5;
            } else {
                int i6 = i - i3;
                if (partition.mHasHeader) {
                    i6--;
                }
                int i7 = partition.mCount - partition.mFooterViewsCount;
                int i8 = partition.mHeaderViewsCount;
                if (i6 < i8 || i6 >= i7) {
                    return -1;
                }
                return i4 + (i6 - i8);
            }
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public T getItem(int i, int i2) {
        if (this.mObjects == null) {
            return null;
        }
        return this.mObjects.get(getDataPosition(i, i2));
    }

    public long getItemId(int i, int i2) {
        if (this.mObjects == null) {
            return 0;
        }
        return (long) getDataPosition(i, i2);
    }

    public List<T> getPartitionData() {
        return this.mObjects;
    }

    public View getView(int i, int i2, int i3, int i4, View view, ViewGroup viewGroup) {
        View view2;
        if (this.mObjects != null) {
            int i5 = i2;
            T t = this.mObjects.get(getDataPosition(i2, i3));
            if (view == null) {
                view2 = newView(this.mContext, i, i2, t, i3, i4, viewGroup);
            } else {
                view2 = view;
            }
            bindView(view2, this.mContext, i, i2, t, i3, i4);
            return view2;
        }
        throw new IllegalStateException("the list is null");
    }

    public abstract View newView(Context context, int i, int i2, T t, int i3, int i4, ViewGroup viewGroup);

    public void removeItem(int i) {
        int partitionForItemIndex = getPartitionForItemIndex(i);
        if (-1 == partitionForItemIndex) {
            Log.w("lijinqian", "ArrayIndexOutOfBoundsException,object size is " + this.mObjects.size() + ", current item index is " + i + "![SingleArrayPartitionAdapter$removeItem]");
            return;
        }
        setNotificationsEnabled(false);
        this.mObjects.remove(i);
        BasePartitionAdapter.Partition partition = this.mPartitions[partitionForItemIndex];
        partition.mSize--;
        partition.mCount--;
        partition.mItemCount--;
        invalidate();
        notifyDataSetChanged();
        setNotificationsEnabled(true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleArrayPartitionAdapter(Context context, List<T> list, int... iArr) {
        super(context, (iArr == null || iArr.length <= 0) ? 10 : iArr.length);
        this.mObjects = list;
        addPartitions(iArr);
    }

    public int addPartition(BasePartitionAdapter.Partition partition) {
        return super.addPartition(partition);
    }

    public void changePartitions(List<T> list, int... iArr) {
        int i;
        this.mObjects = list;
        setNotificationsEnabled(false);
        if (iArr == null) {
            i = 0;
        } else {
            i = iArr.length;
        }
        int i2 = this.mPartitionCount;
        if (i <= i2) {
            i2 = i;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            this.mPartitions[i3].mItemCount = iArr[i3];
        }
        int i4 = this.mPartitionCount;
        if (i4 > i2) {
            Arrays.fill(this.mPartitions, i2, i4, (Object) null);
            this.mPartitionCount = i2;
        } else if (i > i2) {
            int i5 = i - i2;
            for (int i6 = 0; i6 < i5; i6++) {
                addPartition(false, true, iArr[i2 + i6]);
            }
        }
        invalidate();
        notifyDataSetChanged();
        setNotificationsEnabled(true);
    }

    public int getDataPosition(int i, int i2) {
        String str;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += this.mPartitions[i4].mItemCount;
        }
        int i5 = i3 + (i2 - this.mPartitions[i].mHeaderViewsCount);
        List<T> list = this.mObjects;
        if (list == null || i5 < list.size()) {
            return i5;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Different data source: ");
        if (this.mObjects == null) {
            str = "mObjects null";
        } else {
            str = "mObjects.size: " + this.mObjects.size();
        }
        sb.append(str);
        sb.append(Arrays.toString(this.mPartitions));
        throw new IllegalStateException(sb.toString());
    }
}
