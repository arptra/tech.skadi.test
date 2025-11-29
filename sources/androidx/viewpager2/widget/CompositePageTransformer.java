package androidx.viewpager2.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;

public final class CompositePageTransformer implements ViewPager2.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final List f1931a;

    public void a(View view, float f) {
        for (ViewPager2.PageTransformer a2 : this.f1931a) {
            a2.a(view, f);
        }
    }
}
