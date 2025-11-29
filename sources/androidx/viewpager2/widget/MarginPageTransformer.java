package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public final class MarginPageTransformer implements ViewPager2.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final int f1933a;

    public MarginPageTransformer(int i) {
        Preconditions.f(i, "Margin must be non-negative");
        this.f1933a = i;
    }

    public void a(View view, float f) {
        ViewPager2 b = b(view);
        float f2 = ((float) this.f1933a) * f;
        if (b.getOrientation() == 0) {
            if (b.d()) {
                f2 = -f2;
            }
            view.setTranslationX(f2);
            return;
        }
        view.setTranslationY(f2);
    }

    public final ViewPager2 b(View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }
}
