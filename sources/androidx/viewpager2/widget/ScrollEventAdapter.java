package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager2.OnPageChangeCallback f1935a;
    public final ViewPager2 b;
    public final RecyclerView c;
    public final LinearLayoutManager d;
    public int e;
    public int f;
    public ScrollEventValues g = new ScrollEventValues();
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    public static final class ScrollEventValues {

        /* renamed from: a  reason: collision with root package name */
        public int f1936a;
        public float b;
        public int c;

        public void a() {
            this.f1936a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }

    public ScrollEventAdapter(ViewPager2 viewPager2) {
        this.b = viewPager2;
        RecyclerView recyclerView = viewPager2.j;
        this.c = recyclerView;
        this.d = (LinearLayoutManager) recyclerView.getLayoutManager();
        l();
    }

    public final void a(int i2, float f2, int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f1935a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i2, f2, i3);
        }
    }

    public final void b(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f1935a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i2);
        }
    }

    public final void c(int i2) {
        if ((this.e != 3 || this.f != 0) && this.f != i2) {
            this.f = i2;
            ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f1935a;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.onPageScrollStateChanged(i2);
            }
        }
    }

    public final int d() {
        return this.d.findFirstVisibleItemPosition();
    }

    public double e() {
        o();
        ScrollEventValues scrollEventValues = this.g;
        return ((double) scrollEventValues.f1936a) + ((double) scrollEventValues.b);
    }

    public int f() {
        return this.f;
    }

    public boolean g() {
        return this.m;
    }

    public boolean h() {
        return this.f == 0;
    }

    public final boolean i() {
        int i2 = this.e;
        return i2 == 1 || i2 == 4;
    }

    public void j() {
        this.l = true;
    }

    public void k(int i2, boolean z) {
        this.e = z ? 2 : 3;
        boolean z2 = false;
        this.m = false;
        if (this.i != i2) {
            z2 = true;
        }
        this.i = i2;
        c(2);
        if (z2) {
            b(i2);
        }
    }

    public final void l() {
        this.e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    public void m(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f1935a = onPageChangeCallback;
    }

    public final void n(boolean z) {
        this.m = z;
        this.e = z ? 4 : 1;
        int i2 = this.i;
        if (i2 != -1) {
            this.h = i2;
            this.i = -1;
        } else if (this.h == -1) {
            this.h = d();
        }
        c(1);
    }

    public final void o() {
        int i2;
        ScrollEventValues scrollEventValues = this.g;
        int findFirstVisibleItemPosition = this.d.findFirstVisibleItemPosition();
        scrollEventValues.f1936a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.d.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.d.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.d.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.d.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.d.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.d.getOrientation() == 0) {
            i2 = (findViewByPosition.getLeft() - leftDecorationWidth) - this.c.getPaddingLeft();
            if (this.b.d()) {
                i2 = -i2;
            }
            height = width;
        } else {
            i2 = (findViewByPosition.getTop() - topDecorationHeight) - this.c.getPaddingTop();
        }
        int i3 = -i2;
        scrollEventValues.c = i3;
        if (i3 >= 0) {
            scrollEventValues.b = height == 0 ? 0.0f : ((float) i3) / ((float) height);
        } else if (new AnimateLayoutChangeDetector(this.d).d()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(scrollEventValues.c)}));
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        if (!(this.e == 1 && this.f == 1) && i2 == 1) {
            n(false);
        } else if (!i() || i2 != 2) {
            if (i() && i2 == 0) {
                o();
                if (!this.k) {
                    int i3 = this.g.f1936a;
                    if (i3 != -1) {
                        a(i3, 0.0f, 0);
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.g;
                    if (scrollEventValues.c == 0) {
                        int i4 = this.h;
                        int i5 = scrollEventValues.f1936a;
                        if (i4 != i5) {
                            b(i5);
                        }
                    }
                }
                c(0);
                l();
            }
            if (this.e == 2 && i2 == 0 && this.l) {
                o();
                ScrollEventValues scrollEventValues2 = this.g;
                if (scrollEventValues2.c == 0) {
                    int i6 = this.i;
                    int i7 = scrollEventValues2.f1936a;
                    if (i6 != i7) {
                        if (i7 == -1) {
                            i7 = 0;
                        }
                        b(i7);
                    }
                    c(0);
                    l();
                }
            }
        } else if (this.k) {
            c(2);
            this.j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r5 < 0) == r3.b.d()) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.k = r4
            r3.o()
            boolean r0 = r3.j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x0037
            r3.j = r2
            if (r6 > 0) goto L_0x001f
            if (r6 != 0) goto L_0x0029
            if (r5 >= 0) goto L_0x0016
            r5 = r4
            goto L_0x0017
        L_0x0016:
            r5 = r2
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.b
            boolean r6 = r6.d()
            if (r5 != r6) goto L_0x0029
        L_0x001f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.g
            int r6 = r5.c
            if (r6 == 0) goto L_0x0029
            int r5 = r5.f1936a
            int r5 = r5 + r4
            goto L_0x002d
        L_0x0029:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.g
            int r5 = r5.f1936a
        L_0x002d:
            r3.i = r5
            int r6 = r3.h
            if (r6 == r5) goto L_0x0045
            r3.b(r5)
            goto L_0x0045
        L_0x0037:
            int r5 = r3.e
            if (r5 != 0) goto L_0x0045
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.g
            int r5 = r5.f1936a
            if (r5 != r1) goto L_0x0042
            r5 = r2
        L_0x0042:
            r3.b(r5)
        L_0x0045:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.g
            int r6 = r5.f1936a
            if (r6 != r1) goto L_0x004c
            r6 = r2
        L_0x004c:
            float r0 = r5.b
            int r5 = r5.c
            r3.a(r6, r0, r5)
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.g
            int r6 = r5.f1936a
            int r0 = r3.i
            if (r6 == r0) goto L_0x005d
            if (r0 != r1) goto L_0x006b
        L_0x005d:
            int r5 = r5.c
            if (r5 != 0) goto L_0x006b
            int r5 = r3.f
            if (r5 == r4) goto L_0x006b
            r3.c(r2)
            r3.l()
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
