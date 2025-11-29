package com.meizu.common.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.widget.BasePartitionAdapter;
import java.util.Arrays;

public abstract class SingleCursorPartitionAdapter extends BasePartitionAdapter {
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 1;
    protected ChangeObserver mChangeObserver;
    protected Cursor mCursor;
    protected DataSetObserver mDataSetObserver;
    protected int mRowIDColumnIndex;

    public class ChangeObserver extends ContentObserver {
        public ChangeObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            SingleCursorPartitionAdapter.this.onContentChanged();
        }
    }

    public class MyDataSetObserver extends DataSetObserver {
        private MyDataSetObserver() {
        }

        public void onChanged() {
            SingleCursorPartitionAdapter.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            SingleCursorPartitionAdapter.this.notifyDataSetInvalidated();
        }
    }

    public SingleCursorPartitionAdapter(Context context, int i) {
        super(context);
        init((Cursor) null, i);
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

    private void init(Cursor cursor, int i) {
        boolean z = cursor != null;
        this.mCursor = cursor;
        this.mRowIDColumnIndex = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 1) == 1) {
            this.mChangeObserver = new ChangeObserver();
            this.mDataSetObserver = new MyDataSetObserver();
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z) {
            ChangeObserver changeObserver = this.mChangeObserver;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public int addPartition(boolean z, boolean z2, int i) {
        return addPartition(new BasePartitionAdapter.Partition(z, z2, i));
    }

    public abstract void bindView(View view, Context context, int i, int i2, Cursor cursor, int i3, int i4);

    public void changeCursor(Cursor cursor, BasePartitionAdapter.Partition... partitionArr) {
        Cursor swapCursor = swapCursor(cursor, partitionArr);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public Cursor getCursor() {
        return this.mCursor;
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

    public Object getItem(int i, int i2) {
        Cursor cursor = this.mCursor;
        if (cursor == null || cursor.isClosed() || this.mCursor.getCount() == 0) {
            return null;
        }
        if (!this.mCursor.moveToPosition(getDataPosition(i, i2))) {
            return null;
        }
        return this.mCursor;
    }

    public long getItemId(int i, int i2) {
        Cursor cursor;
        if (this.mRowIDColumnIndex == -1 || (cursor = this.mCursor) == null || cursor.isClosed() || this.mCursor.getCount() == 0) {
            return 0;
        }
        if (!this.mCursor.moveToPosition(getDataPosition(i, i2))) {
            return 0;
        }
        return this.mCursor.getLong(this.mRowIDColumnIndex);
    }

    public View getView(int i, int i2, int i3, int i4, View view, ViewGroup viewGroup) {
        View view2;
        if (this.mCursor != null) {
            int i5 = i2;
            int i6 = i3;
            int dataPosition = getDataPosition(i2, i3);
            if (this.mCursor.moveToPosition(dataPosition)) {
                if (view == null) {
                    view2 = newView(this.mContext, i, i2, this.mCursor, i3, i4, viewGroup);
                } else {
                    view2 = view;
                }
                bindView(view2, this.mContext, i, i2, this.mCursor, i3, i4);
                return view2;
            }
            throw new IllegalStateException("Couldn't move cursor to position " + dataPosition);
        }
        throw new IllegalStateException("the cursor is null");
    }

    public boolean hasStableIds() {
        return true;
    }

    public abstract View newView(Context context, int i, int i2, Cursor cursor, int i3, int i4, ViewGroup viewGroup);

    public void onContentChanged() {
    }

    public Cursor swapCursor(Cursor cursor, BasePartitionAdapter.Partition... partitionArr) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                ChangeObserver changeObserver = this.mChangeObserver;
                if (changeObserver != null) {
                    cursor2.unregisterContentObserver(changeObserver);
                }
                DataSetObserver dataSetObserver = this.mDataSetObserver;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.mCursor = cursor;
            if (cursor != null) {
                ChangeObserver changeObserver2 = this.mChangeObserver;
                if (changeObserver2 != null) {
                    cursor.registerContentObserver(changeObserver2);
                }
                DataSetObserver dataSetObserver2 = this.mDataSetObserver;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.mRowIDColumnIndex = cursor.getColumnIndexOrThrow("_id");
            } else {
                this.mRowIDColumnIndex = -1;
            }
        }
        setNotificationsEnabled(false);
        clearPartitions();
        if (partitionArr != null && partitionArr.length > 0) {
            for (BasePartitionAdapter.Partition addPartition : partitionArr) {
                addPartition(addPartition);
            }
        }
        setNotificationsEnabled(true);
        return cursor2;
    }

    public int addPartition(BasePartitionAdapter.Partition partition) {
        return super.addPartition(partition);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleCursorPartitionAdapter(Context context, Cursor cursor, int[] iArr, int i) {
        super(context, (iArr == null || iArr.length <= 0) ? 10 : iArr.length);
        init(cursor, i);
        addPartitions(iArr);
    }

    public void changeCursor(Cursor cursor, int... iArr) {
        Cursor swapCursor = swapCursor(cursor, iArr);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public int getDataPosition(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += this.mPartitions[i4].mItemCount;
        }
        return i3 + (i2 - this.mPartitions[i].mHeaderViewsCount);
    }

    public Cursor swapCursor(Cursor cursor, int... iArr) {
        int i;
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                ChangeObserver changeObserver = this.mChangeObserver;
                if (changeObserver != null) {
                    cursor2.unregisterContentObserver(changeObserver);
                }
                DataSetObserver dataSetObserver = this.mDataSetObserver;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.mCursor = cursor;
            if (cursor != null) {
                ChangeObserver changeObserver2 = this.mChangeObserver;
                if (changeObserver2 != null) {
                    cursor.registerContentObserver(changeObserver2);
                }
                DataSetObserver dataSetObserver2 = this.mDataSetObserver;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.mRowIDColumnIndex = cursor.getColumnIndexOrThrow("_id");
            } else {
                this.mRowIDColumnIndex = -1;
            }
        }
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
        return cursor2;
    }
}
