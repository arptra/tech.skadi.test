package androidx.databinding.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.ObservableList;
import java.util.List;

@RestrictTo
class ObservableListAdapter<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List f995a;
    public final Context b;
    public final int c;
    public final int d;
    public final int e;
    public final LayoutInflater f;

    /* renamed from: androidx.databinding.adapters.ObservableListAdapter$1  reason: invalid class name */
    class AnonymousClass1 extends ObservableList.OnListChangedCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ObservableListAdapter f996a;

        public void a(ObservableList observableList) {
            this.f996a.notifyDataSetChanged();
        }

        public void c(ObservableList observableList, int i, int i2) {
            this.f996a.notifyDataSetChanged();
        }

        public void d(ObservableList observableList, int i, int i2) {
            this.f996a.notifyDataSetChanged();
        }

        public void e(ObservableList observableList, int i, int i2, int i3) {
            this.f996a.notifyDataSetChanged();
        }

        public void f(ObservableList observableList, int i, int i2) {
            this.f996a.notifyDataSetChanged();
        }
    }

    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = i == 0 ? new TextView(this.b) : this.f.inflate(i, viewGroup, false);
        }
        int i3 = this.e;
        TextView textView = (TextView) (i3 == 0 ? view : view.findViewById(i3));
        Object obj = this.f995a.get(i2);
        textView.setText(obj instanceof CharSequence ? (CharSequence) obj : String.valueOf(obj));
        return view;
    }

    public int getCount() {
        return this.f995a.size();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return a(this.c, i, view, viewGroup);
    }

    public Object getItem(int i) {
        return this.f995a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.d, i, view, viewGroup);
    }
}
