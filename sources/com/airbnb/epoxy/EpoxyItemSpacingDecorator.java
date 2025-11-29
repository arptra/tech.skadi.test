package com.airbnb.epoxy;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EpoxyItemSpacingDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f2286a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public EpoxyItemSpacingDecorator() {
        this(0);
    }

    public static boolean c(int i2, GridLayoutManager.SpanSizeLookup spanSizeLookup, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 <= i2; i5++) {
            i4 += spanSizeLookup.getSpanSize(i5);
            if (i4 > i3) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(int i2, int i3, GridLayoutManager.SpanSizeLookup spanSizeLookup, int i4) {
        int i5 = 0;
        for (int i6 = i3 - 1; i6 >= i2; i6--) {
            i5 += spanSizeLookup.getSpanSize(i6);
            if (i5 > i4) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(RecyclerView.LayoutManager layoutManager, boolean z) {
        boolean z2 = false;
        boolean z3 = (layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).getReverseLayout();
        if (layoutManager.getLayoutDirection() == 1) {
            z2 = true;
        }
        return (!z || !z2) ? z3 : !z3;
    }

    public final void a(RecyclerView recyclerView, int i2, RecyclerView.LayoutManager layoutManager) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        boolean z = false;
        this.d = i2 == 0;
        this.e = i2 == itemCount + -1;
        this.c = layoutManager.canScrollHorizontally();
        this.b = layoutManager.canScrollVertically();
        boolean z2 = layoutManager instanceof GridLayoutManager;
        this.f = z2;
        if (z2) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            int spanSize = spanSizeLookup.getSpanSize(i2);
            int spanCount = gridLayoutManager.getSpanCount();
            int spanIndex = spanSizeLookup.getSpanIndex(i2, spanCount);
            this.g = spanIndex == 0;
            this.h = spanIndex + spanSize == spanCount;
            boolean c2 = c(i2, spanSizeLookup, spanCount);
            this.i = c2;
            if (!c2 && d(i2, itemCount, spanSizeLookup, spanCount)) {
                z = true;
            }
            this.j = z;
        }
    }

    public int b() {
        return this.f2286a;
    }

    public void e(int i2) {
        this.f2286a = i2;
    }

    public final boolean g() {
        return this.f ? (this.c && !this.h) || (this.b && !this.j) : this.b && !this.e;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            a(recyclerView, childAdapterPosition, layoutManager);
            boolean h2 = h();
            boolean i2 = i();
            boolean j2 = j();
            boolean g2 = g();
            if (!f(layoutManager, this.c)) {
                boolean z = i2;
                i2 = h2;
                h2 = z;
            } else if (!this.c) {
                boolean z2 = i2;
                i2 = h2;
                h2 = z2;
                boolean z3 = g2;
                g2 = j2;
                j2 = z3;
            }
            int i3 = this.f2286a / 2;
            rect.right = h2 ? i3 : 0;
            rect.left = i2 ? i3 : 0;
            rect.top = j2 ? i3 : 0;
            if (!g2) {
                i3 = 0;
            }
            rect.bottom = i3;
        }
    }

    public final boolean h() {
        return this.f ? (this.c && !this.i) || (this.b && !this.g) : this.c && !this.d;
    }

    public final boolean i() {
        return this.f ? (this.c && !this.j) || (this.b && !this.h) : this.c && !this.e;
    }

    public final boolean j() {
        return this.f ? (this.c && !this.g) || (this.b && !this.i) : this.b && !this.d;
    }

    public EpoxyItemSpacingDecorator(int i2) {
        e(i2);
    }
}
