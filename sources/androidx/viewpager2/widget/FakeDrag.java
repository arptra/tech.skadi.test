package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

final class FakeDrag {

    /* renamed from: a  reason: collision with root package name */
    public final ViewPager2 f1932a;
    public final ScrollEventAdapter b;
    public final RecyclerView c;

    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f1932a = viewPager2;
        this.b = scrollEventAdapter;
        this.c = recyclerView;
    }

    public boolean a() {
        return this.b.g();
    }
}
