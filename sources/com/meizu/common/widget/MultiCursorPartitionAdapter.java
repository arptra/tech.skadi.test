package com.meizu.common.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.widget.BasePartitionAdapter;

public abstract class MultiCursorPartitionAdapter extends BasePartitionAdapter {

    public static class CursorPartition extends BasePartitionAdapter.Partition {
        Cursor mCursor;
        int mRowIDColumnIndex;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CursorPartition(boolean z, boolean z2, Cursor cursor) {
            super(z, z2, cursor == null ? 0 : cursor.getCount());
            this.mCursor = cursor;
        }
    }

    public MultiCursorPartitionAdapter(Context context) {
        super(context);
    }

    public int addPartition(boolean z, boolean z2, Cursor cursor) {
        return addPartition(new CursorPartition(z, z2, cursor));
    }

    public abstract void bindView(View view, Context context, int i, int i2, Cursor cursor, int i3, int i4);

    public void changeCursor(int i, Cursor cursor) {
        Cursor swapCursor = swapCursor(i, cursor);
        if (swapCursor != null && !swapCursor.isClosed()) {
            swapCursor.close();
        }
    }

    public void clearCursors() {
        for (int i = 0; i < this.mPartitionCount; i++) {
            CursorPartition partition = getPartition(i);
            partition.mCursor = null;
            partition.mItemCount = 0;
        }
        invalidate();
        notifyDataSetChanged();
    }

    public void clearPartitions() {
        for (int i = 0; i < this.mPartitionCount; i++) {
            CursorPartition partition = getPartition(i);
            Cursor cursor = partition.mCursor;
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                partition.mCursor = null;
            }
        }
        super.clearPartitions();
    }

    public Cursor getCursor(int i) {
        return getPartition(i).mCursor;
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

    public Object getItem(int i, int i2) {
        int dataPosition;
        Cursor cursor = getPartition(i).mCursor;
        if (cursor == null || cursor.isClosed() || (dataPosition = getDataPosition(i, i2)) < 0 || !cursor.moveToPosition(dataPosition)) {
            return null;
        }
        return cursor;
    }

    public long getItemId(int i, int i2) {
        Cursor cursor;
        int dataPosition;
        CursorPartition partition = getPartition(i);
        if (partition.mRowIDColumnIndex != -1 && (cursor = partition.mCursor) != null && !cursor.isClosed() && (dataPosition = getDataPosition(i, i2)) >= 0 && cursor.moveToPosition(dataPosition)) {
            return cursor.getLong(partition.mRowIDColumnIndex);
        }
        return 0;
    }

    public View getView(int i, int i2, int i3, int i4, View view, ViewGroup viewGroup) {
        Cursor cursor = getPartition(i2).mCursor;
        if (cursor != null) {
            int dataPosition = getDataPosition(i2, i3);
            if (cursor.moveToPosition(dataPosition)) {
                if (view == null) {
                    view = newView(this.mContext, i, i2, cursor, i3, i4, viewGroup);
                }
                bindView(view, this.mContext, i, i2, cursor, i3, i4);
                return view;
            }
            throw new IllegalStateException("Couldn't move cursor to position " + dataPosition);
        }
        throw new IllegalStateException("the partition " + i2 + " cursor is null");
    }

    public abstract View newView(Context context, int i, int i2, Cursor cursor, int i3, int i4, ViewGroup viewGroup);

    public void removePartition(int i) {
        CursorPartition partition = getPartition(i);
        Cursor cursor = partition.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
            partition.mCursor = null;
        }
        super.removePartition(i);
    }

    public Cursor swapCursor(int i, Cursor cursor) {
        CursorPartition partition = getPartition(i);
        Cursor cursor2 = partition.mCursor;
        if (cursor2 == cursor) {
            return null;
        }
        partition.mCursor = cursor;
        int i2 = 0;
        if (cursor != null) {
            partition.mRowIDColumnIndex = cursor.getColumnIndex("_id");
            if (!cursor.isClosed()) {
                i2 = cursor.getCount();
            }
            partition.mItemCount = i2;
        } else {
            partition.mItemCount = 0;
        }
        invalidate();
        notifyDataSetChanged();
        return cursor2;
    }

    public MultiCursorPartitionAdapter(Context context, int i) {
        super(context, i);
    }

    public int addPartition(CursorPartition cursorPartition) {
        return super.addPartition(cursorPartition);
    }

    public CursorPartition getPartition(int i) {
        return (CursorPartition) super.getPartition(i);
    }

    public int getDataPosition(int i, int i2) {
        return i2 - this.mPartitions[i].mHeaderViewsCount;
    }
}
