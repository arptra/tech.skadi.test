package androidx.preference;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PreferenceViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f1692a;
    public ColorStateList b;
    public final SparseArray c;
    public boolean d;
    public boolean e;

    public PreferenceViewHolder(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.c = sparseArray;
        TextView textView = (TextView) view.findViewById(16908310);
        sparseArray.put(16908310, textView);
        sparseArray.put(16908304, view.findViewById(16908304));
        sparseArray.put(16908294, view.findViewById(16908294));
        int i = R.id.icon_frame;
        sparseArray.put(i, view.findViewById(i));
        sparseArray.put(16908350, view.findViewById(16908350));
        this.f1692a = view.getBackground();
        if (textView != null) {
            this.b = textView.getTextColors();
        }
    }

    public View a(int i) {
        View view = (View) this.c.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i);
        if (findViewById != null) {
            this.c.put(i, findViewById);
        }
        return findViewById;
    }

    public boolean b() {
        return this.d;
    }

    public boolean c() {
        return this.e;
    }

    public void d() {
        Drawable background = this.itemView.getBackground();
        Drawable drawable = this.f1692a;
        if (background != drawable) {
            ViewCompat.z0(this.itemView, drawable);
        }
        TextView textView = (TextView) a(16908310);
        if (textView != null && this.b != null && !textView.getTextColors().equals(this.b)) {
            textView.setTextColor(this.b);
        }
    }

    public void e(boolean z) {
        this.d = z;
    }

    public void f(boolean z) {
        this.e = z;
    }
}
