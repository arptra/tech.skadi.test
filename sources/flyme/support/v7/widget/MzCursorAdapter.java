package flyme.support.v7.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import flyme.support.v7.widget.MzCursorFilter;
import flyme.support.v7.widget.MzRecyclerView;

public abstract class MzCursorAdapter<VH extends RecyclerView.ViewHolder> extends MzRecyclerView.Adapter<VH> implements Filterable, MzCursorFilter.CursorFilterClient {
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected MzCursorAdapter<VH>.ChangeObserver mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected MzCursorFilter mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    /* access modifiers changed from: private */
    public ItemContentCompareListener mItemContentCompareListener;
    /* access modifiers changed from: private */
    public MzRecyclerView mRecyclerView;
    protected int mRowIDColumn;

    public class ChangeObserver extends ContentObserver {
        public ChangeObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            MzCursorAdapter.this.onContentChanged();
        }
    }

    public class CustomUpdateCallBack implements ListUpdateCallback {
        public CustomUpdateCallBack() {
        }

        public void onChanged(int i, int i2, @Nullable Object obj) {
            MzCursorAdapter mzCursorAdapter = MzCursorAdapter.this;
            mzCursorAdapter.notifyItemRangeChanged(i + mzCursorAdapter.mRecyclerView.getHeaderViewsCount(), i2, obj);
        }

        public void onInserted(int i, int i2) {
            MzCursorAdapter mzCursorAdapter = MzCursorAdapter.this;
            mzCursorAdapter.notifyItemRangeInserted(i + mzCursorAdapter.mRecyclerView.getHeaderViewsCount(), i2);
        }

        public void onMoved(int i, int i2) {
            MzCursorAdapter mzCursorAdapter = MzCursorAdapter.this;
            mzCursorAdapter.notifyItemMoved(i + mzCursorAdapter.mRecyclerView.getHeaderViewsCount(), i2 + MzCursorAdapter.this.mRecyclerView.getHeaderViewsCount());
        }

        public void onRemoved(int i, int i2) {
            MzCursorAdapter mzCursorAdapter = MzCursorAdapter.this;
            mzCursorAdapter.notifyItemRangeRemoved(i + mzCursorAdapter.mRecyclerView.getHeaderViewsCount(), i2);
        }
    }

    public class DiffCallBack extends DiffUtil.Callback {
        private Cursor mNewCursor;
        private Cursor mOldCursor;

        public DiffCallBack(Cursor cursor, Cursor cursor2) {
            this.mNewCursor = cursor;
            this.mOldCursor = cursor2;
        }

        public boolean areContentsTheSame(int i, int i2) {
            if (MzCursorAdapter.this.mItemContentCompareListener != null) {
                return MzCursorAdapter.this.mItemContentCompareListener.areContentsTheSame(this.mOldCursor, i, this.mNewCursor, i2);
            }
            return true;
        }

        public boolean areItemsTheSame(int i, int i2) {
            return MzCursorAdapter.this.getIdForPosition(this.mOldCursor, i) == MzCursorAdapter.this.getIdForPosition(this.mNewCursor, i2);
        }

        public int getNewListSize() {
            Cursor cursor = this.mNewCursor;
            if (cursor != null) {
                return cursor.getCount();
            }
            return 0;
        }

        public int getOldListSize() {
            Cursor cursor = this.mOldCursor;
            if (cursor != null) {
                return cursor.getCount();
            }
            return 0;
        }
    }

    public interface ItemContentCompareListener {
        boolean areContentsTheSame(Cursor cursor, int i, Cursor cursor2, int i2);
    }

    public class MyDataSetObserver extends DataSetObserver {
        private MyDataSetObserver() {
        }

        public void onChanged() {
            MzCursorAdapter mzCursorAdapter = MzCursorAdapter.this;
            mzCursorAdapter.mDataValid = true;
            mzCursorAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            MzCursorAdapter mzCursorAdapter = MzCursorAdapter.this;
            mzCursorAdapter.mDataValid = false;
            mzCursorAdapter.notifyDataSetChanged();
        }
    }

    public MzCursorAdapter(Context context, Cursor cursor) {
        init(context, cursor, 2);
    }

    /* access modifiers changed from: private */
    public long getIdForPosition(Cursor cursor, int i) {
        if (!this.mDataValid || this.mCursor == null || !cursor.moveToPosition(i)) {
            return 0;
        }
        return cursor.getLong(this.mRowIDColumn);
    }

    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new MzCursorFilter(this);
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public Object getItem(int i) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.mCursor;
    }

    public int getItemCount() {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public long getItemId(int i) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null || !cursor.moveToPosition(i)) {
            return 0;
        }
        return this.mCursor.getLong(this.mRowIDColumn);
    }

    public void init(Context context, Cursor cursor, int i) {
        boolean z = cursor != null;
        this.mCursor = cursor;
        this.mDataValid = z;
        this.mContext = context;
        this.mRowIDColumn = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.mChangeObserver = new ChangeObserver();
            this.mDataSetObserver = new MyDataSetObserver();
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z) {
            MzCursorAdapter<VH>.ChangeObserver changeObserver = this.mChangeObserver;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
        setHasStableIds(true);
    }

    public void offsetHeaderPositionWhenDataChange(MzRecyclerView mzRecyclerView) {
        this.mRecyclerView = mzRecyclerView;
    }

    public void onBindViewHolder(VH vh, int i) {
        super.onBindViewHolder(vh, i);
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.mCursor.moveToPosition(i)) {
            onBindViewHolder(vh, this.mCursor);
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public abstract void onBindViewHolder(VH vh, Cursor cursor);

    public void onContentChanged() {
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public void setItemContentCompareListener(ItemContentCompareListener itemContentCompareListener) {
        this.mItemContentCompareListener = itemContentCompareListener;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            MzCursorAdapter<VH>.ChangeObserver changeObserver = this.mChangeObserver;
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
            MzCursorAdapter<VH>.ChangeObserver changeObserver2 = this.mChangeObserver;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetChanged();
        }
        return cursor2;
    }

    public Cursor swapCursorWithAnimation(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            MzCursorAdapter<VH>.ChangeObserver changeObserver = this.mChangeObserver;
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
            MzCursorAdapter<VH>.ChangeObserver changeObserver2 = this.mChangeObserver;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffCallBack(cursor, cursor2), false);
            if (this.mRecyclerView != null) {
                calculateDiff.dispatchUpdatesTo((ListUpdateCallback) new CustomUpdateCallBack());
            } else {
                calculateDiff.dispatchUpdatesTo((RecyclerView.Adapter) this);
            }
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            DiffUtil.DiffResult calculateDiff2 = DiffUtil.calculateDiff(new DiffCallBack(cursor, cursor2), false);
            if (this.mRecyclerView != null) {
                calculateDiff2.dispatchUpdatesTo((ListUpdateCallback) new CustomUpdateCallBack());
            } else {
                calculateDiff2.dispatchUpdatesTo((RecyclerView.Adapter) this);
            }
        }
        return cursor2;
    }

    public MzCursorAdapter(Context context, Cursor cursor, int i) {
        init(context, cursor, i);
    }
}
