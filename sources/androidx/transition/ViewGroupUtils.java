package androidx.transition;

import android.view.ViewGroup;

class ViewGroupUtils {
    public static int a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildDrawingOrder(i);
    }

    public static ViewGroupOverlayImpl b(ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    public static void c(ViewGroup viewGroup, boolean z) {
        viewGroup.suppressLayout(z);
    }
}
