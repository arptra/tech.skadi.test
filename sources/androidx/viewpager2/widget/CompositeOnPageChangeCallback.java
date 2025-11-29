package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    public final List f1930a;

    public CompositeOnPageChangeCallback(int i) {
        this.f1930a = new ArrayList(i);
    }

    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f1930a.add(onPageChangeCallback);
    }

    public void b(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f1930a.remove(onPageChangeCallback);
    }

    public final void c(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    public void onPageScrollStateChanged(int i) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageScrollStateChanged : this.f1930a) {
                onPageScrollStateChanged.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            c(e);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageScrolled : this.f1930a) {
                onPageScrolled.onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            c(e);
        }
    }

    public void onPageSelected(int i) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageSelected : this.f1930a) {
                onPageSelected.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            c(e);
        }
    }
}
