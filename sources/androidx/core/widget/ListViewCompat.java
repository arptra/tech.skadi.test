package androidx.core.widget;

import android.widget.ListView;

@Deprecated
public final class ListViewCompat {
    public static boolean a(ListView listView, int i) {
        return listView.canScrollList(i);
    }
}
