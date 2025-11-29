package com.meizu.common.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.widget.BasePartitionAdapter;
import java.util.List;

public abstract class MultiArrayPartitionAdapter<T> extends BasePartitionAdapter {

    public static class ArrayPartition extends BasePartitionAdapter.Partition {
        List mObjects;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ArrayPartition(boolean z, boolean z2, List list) {
            super(z, z2, list == null ? 0 : list.size());
            this.mObjects = list;
        }
    }

    public MultiArrayPartitionAdapter(Context context) {
        super(context);
    }

    public int addPartition(boolean z, boolean z2, List<T> list) {
        return addPartition(new ArrayPartition(z, z2, list));
    }

    public void addPartitions(List<T>... listArr) {
        if (listArr != null && listArr.length > 0) {
            setNotificationsEnabled(false);
            for (List<T> addPartition : listArr) {
                addPartition(false, true, addPartition);
            }
            setNotificationsEnabled(true);
        }
    }

    public abstract void bindView(View view, Context context, int i, int i2, T t, int i3, int i4);

    public void changePartition(int i, List<T> list) {
        ArrayPartition partition = getPartition(i);
        partition.mObjects = list;
        partition.mItemCount = list == null ? 0 : list.size();
        invalidate();
        notifyDataSetChanged();
    }

    public int getDataPosition(int i) {
        ensureCacheValid();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mPartitionCount) {
            BasePartitionAdapter.Partition partition = this.mPartitions[i2];
            int i4 = partition.mSize + i3;
            if (i < i3 || i >= i4) {
                i2++;
                i3 = i4;
            } else {
                int i5 = i - i3;
                if (partition.mHasHeader) {
                    i5--;
                }
                int i6 = partition.mCount - partition.mFooterViewsCount;
                if (i5 < partition.mHeaderViewsCount || i5 >= i6) {
                    return -1;
                }
                return getDataPosition(i2, i5);
            }
        }
        return -1;
    }

    public T getItem(int i, int i2) {
        int dataPosition;
        List list = getPartition(i).mObjects;
        if (list != null && (dataPosition = getDataPosition(i, i2)) >= 0) {
            return list.get(dataPosition);
        }
        return null;
    }

    public long getItemId(int i, int i2) {
        int dataPosition;
        if (getPartition(i).mObjects != null && (dataPosition = getDataPosition(i, i2)) >= 0) {
            return (long) dataPosition;
        }
        return 0;
    }

    public List<T> getPartitionData(int i) {
        return getPartition(i).mObjects;
    }

    public View getView(int i, int i2, int i3, int i4, View view, ViewGroup viewGroup) {
        View view2;
        int i5 = i2;
        List list = getPartition(i2).mObjects;
        if (list == null) {
            throw new IllegalStateException("the partition " + i2 + " list is null");
        } else if (list.size() > 0) {
            int dataPosition = getDataPosition(i2, i3);
            if (dataPosition < list.size()) {
                Object obj = list.get(dataPosition);
                if (view == null) {
                    view2 = newView(this.mContext, i, i2, obj, i3, i4, viewGroup);
                } else {
                    view2 = view;
                }
                bindView(view2, this.mContext, i, i2, obj, i3, i4);
                return view2;
            }
            Log.w("IndexOutOfBounds", "MultiArrayPartitionAdapter getView exception, List partition item size :" + list.size() + ", listIndex :" + dataPosition);
            throw new IndexOutOfBoundsException("APP越界操作:当前数据集大小为:" + list.size() + ",有效访问范围为:0~" + (list.size() + -1) + ",当前访问序号为:" + dataPosition + ",非法,请处理！");
        } else {
            Log.w("IndexOutOfBounds", "MultiArrayPartitionAdapter getView exception, List partition item size :" + list.size());
            throw new IndexOutOfBoundsException("APP数据集为空:请先检查数据集中书否有数据,然后再访问!");
        }
    }

    public abstract View newView(Context context, int i, int i2, T t, int i3, int i4, ViewGroup viewGroup);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiArrayPartitionAdapter(Context context, List<T>... listArr) {
        super(context, (listArr == null || listArr.length <= 0) ? 10 : listArr.length);
        addPartitions(listArr);
    }

    public int addPartition(ArrayPartition arrayPartition) {
        return super.addPartition(arrayPartition);
    }

    public ArrayPartition getPartition(int i) {
        return (ArrayPartition) super.getPartition(i);
    }

    public int getDataPosition(int i, int i2) {
        return i2 - this.mPartitions[i].mHeaderViewsCount;
    }
}
