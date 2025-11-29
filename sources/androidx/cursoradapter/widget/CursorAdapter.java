package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.cursoradapter.widget.CursorFilter;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    /* renamed from: a  reason: collision with root package name */
    public boolean f957a;
    public boolean b;
    public Cursor c;
    public Context d;
    public int e;
    public ChangeObserver f;
    public DataSetObserver g;
    public CursorFilter h;
    public FilterQueryProvider i;

    public class ChangeObserver extends ContentObserver {
        public ChangeObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            CursorAdapter.this.e();
        }
    }

    public class MyDataSetObserver extends DataSetObserver {
        public MyDataSetObserver() {
        }

        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f957a = true;
            cursorAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f957a = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        b(context, cursor, z ? 1 : 2);
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void b(Context context, Cursor cursor, int i2) {
        boolean z = false;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.b = true;
        } else {
            this.b = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.c = cursor;
        this.f957a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f = new ChangeObserver();
            this.g = new MyDataSetObserver();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            ChangeObserver changeObserver = this.f;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public View c(Context context, Cursor cursor, ViewGroup viewGroup) {
        return d(context, cursor, viewGroup);
    }

    public void changeCursor(Cursor cursor) {
        Cursor f2 = f(cursor);
        if (f2 != null) {
            f2.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public abstract View d(Context context, Cursor cursor, ViewGroup viewGroup);

    public void e() {
        Cursor cursor;
        if (this.b && (cursor = this.c) != null && !cursor.isClosed()) {
            this.f957a = this.c.requery();
        }
    }

    public Cursor f(Cursor cursor) {
        Cursor cursor2 = this.c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.f;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.f;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.f957a = true;
            notifyDataSetChanged();
        } else {
            this.e = -1;
            this.f957a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public int getCount() {
        Cursor cursor;
        if (!this.f957a || (cursor = this.c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Cursor getCursor() {
        return this.c;
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f957a) {
            return null;
        }
        this.c.moveToPosition(i2);
        if (view == null) {
            view = c(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    public Filter getFilter() {
        if (this.h == null) {
            this.h = new CursorFilter(this);
        }
        return this.h;
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f957a || (cursor = this.c) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.c;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.f957a || (cursor = this.c) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.c.getLong(this.e);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f957a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.c.moveToPosition(i2)) {
            if (view == null) {
                view = d(this.d, this.c, viewGroup);
            }
            a(view, this.d, this.c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i2);
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.i;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.c;
    }
}
