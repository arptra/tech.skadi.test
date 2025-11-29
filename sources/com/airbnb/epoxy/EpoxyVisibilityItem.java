package com.airbnb.epoxy;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0015J'\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u0015J\u001d\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010!J\u0019\u0010#\u001a\u00020\n2\b\b\u0001\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010!R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b'\u0010,R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010+R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010+R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010+R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010+R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010+R\u0016\u00104\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u00103R\u0016\u00105\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u00103R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u00103R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u00103R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010+R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010:¨\u0006@"}, d2 = {"Lcom/airbnb/epoxy/EpoxyVisibilityItem;", "", "", "adapterPosition", "<init>", "(Ljava/lang/Integer;)V", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "parent", "", "detachEvent", "m", "(Landroid/view/View;Landroid/view/ViewGroup;Z)Z", "newAdapterPosition", "", "k", "(I)V", "Lcom/airbnb/epoxy/EpoxyViewHolder;", "epoxyHolder", "f", "(Lcom/airbnb/epoxy/EpoxyViewHolder;Z)V", "c", "thresholdPercentage", "e", "(Lcom/airbnb/epoxy/EpoxyViewHolder;ZI)V", "d", "visibilityChangedEnabled", "b", "(Lcom/airbnb/epoxy/EpoxyViewHolder;Z)Z", "offsetPosition", "l", "j", "()Z", "h", "i", "(I)Z", "g", "Landroid/graphics/Rect;", "a", "Landroid/graphics/Rect;", "localVisibleRect", "<set-?>", "I", "()I", "height", "width", "visibleHeight", "visibleWidth", "viewportHeight", "viewportWidth", "Z", "partiallyVisible", "fullyVisible", "visible", "focusedVisible", "viewVisibility", "n", "Ljava/lang/Integer;", "lastVisibleHeightNotified", "o", "lastVisibleWidthNotified", "p", "lastVisibilityNotified", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
@VisibleForTesting
public final class EpoxyVisibilityItem {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f2301a = new Rect();
    public int b = -1;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m = 8;
    public Integer n;
    public Integer o;
    public Integer p;

    public EpoxyVisibilityItem(Integer num) {
        if (num != null) {
            k(num.intValue());
        }
    }

    public final int a() {
        return this.b;
    }

    public final boolean b(EpoxyViewHolder epoxyViewHolder, boolean z) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "epoxyHolder");
        int i2 = this.e;
        Integer num = this.n;
        if (num != null && i2 == num.intValue()) {
            int i3 = this.f;
            Integer num2 = this.o;
            if (num2 != null && i3 == num2.intValue()) {
                int i4 = this.m;
                Integer num3 = this.p;
                if (num3 != null && i4 == num3.intValue()) {
                    return false;
                }
            }
        }
        if (z) {
            if (this.m == 8) {
                epoxyViewHolder.h(0.0f, 0.0f, 0, 0);
            } else {
                int i5 = this.e;
                float f2 = (100.0f / ((float) this.c)) * ((float) i5);
                float f3 = 100.0f / ((float) this.d);
                int i6 = this.f;
                epoxyViewHolder.h(f2, f3 * ((float) i6), i5, i6);
            }
        }
        this.n = Integer.valueOf(this.e);
        this.o = Integer.valueOf(this.f);
        this.p = Integer.valueOf(this.m);
        return true;
    }

    public final void c(EpoxyViewHolder epoxyViewHolder, boolean z) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "epoxyHolder");
        boolean z2 = this.l;
        boolean z3 = !z && h();
        this.l = z3;
        if (z3 == z2) {
            return;
        }
        if (z3) {
            epoxyViewHolder.i(2);
        } else {
            epoxyViewHolder.i(3);
        }
    }

    public final void d(EpoxyViewHolder epoxyViewHolder, boolean z) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "epoxyHolder");
        boolean z2 = this.j;
        boolean z3 = !z && g();
        this.j = z3;
        if (z3 != z2 && z3) {
            epoxyViewHolder.i(4);
        }
    }

    public final void e(EpoxyViewHolder epoxyViewHolder, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "epoxyHolder");
        boolean z2 = this.i;
        boolean z3 = !z && i(i2);
        this.i = z3;
        if (z3 == z2) {
            return;
        }
        if (z3) {
            epoxyViewHolder.i(5);
        } else {
            epoxyViewHolder.i(6);
        }
    }

    public final void f(EpoxyViewHolder epoxyViewHolder, boolean z) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "epoxyHolder");
        boolean z2 = this.k;
        boolean z3 = !z && j();
        this.k = z3;
        if (z3 == z2) {
            return;
        }
        if (z3) {
            epoxyViewHolder.i(0);
        } else {
            epoxyViewHolder.i(1);
        }
    }

    public final boolean g() {
        return this.m == 0 && this.e == this.c && this.f == this.d;
    }

    public final boolean h() {
        int i2 = (this.g * this.h) / 2;
        int i3 = this.c * this.d;
        int i4 = this.e * this.f;
        return this.m == 0 && (i3 < i2 ? i3 == i4 : i4 >= i2);
    }

    public final boolean i(int i2) {
        if (i2 == 0) {
            return j();
        }
        return this.m == 0 && (((float) (this.e * this.f)) / ((float) (this.c * this.d))) * ((float) 100) >= ((float) i2);
    }

    public final boolean j() {
        return this.m == 0 && this.e > 0 && this.f > 0;
    }

    public final void k(int i2) {
        this.j = false;
        this.k = false;
        this.l = false;
        this.b = i2;
        this.n = null;
        this.o = null;
        this.p = null;
    }

    public final void l(int i2) {
        this.b += i2;
    }

    public final boolean m(View view, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f2301a.setEmpty();
        boolean z2 = view.getLocalVisibleRect(this.f2301a) && !z;
        this.c = view.getHeight();
        this.d = view.getWidth();
        this.g = viewGroup.getHeight();
        this.h = viewGroup.getWidth();
        this.e = z2 ? this.f2301a.height() : 0;
        this.f = z2 ? this.f2301a.width() : 0;
        this.m = view.getVisibility();
        return this.c > 0 && this.d > 0;
    }
}
