package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayoutManager f1934a;
    public ViewPager2.PageTransformer b;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f1934a = linearLayoutManager;
    }

    public ViewPager2.PageTransformer a() {
        return this.b;
    }

    public void b(ViewPager2.PageTransformer pageTransformer) {
        this.b = pageTransformer;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.b != null) {
            float f2 = -f;
            int i3 = 0;
            while (i3 < this.f1934a.getChildCount()) {
                View childAt = this.f1934a.getChildAt(i3);
                if (childAt != null) {
                    this.b.a(childAt, ((float) (this.f1934a.getPosition(childAt) - i)) + f2);
                    i3++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i3), Integer.valueOf(this.f1934a.getChildCount())}));
                }
            }
        }
    }

    public void onPageSelected(int i) {
    }
}
